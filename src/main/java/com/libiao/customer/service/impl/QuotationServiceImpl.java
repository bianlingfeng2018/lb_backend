package com.libiao.customer.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.constant.QuotationEnum;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.BaseNameReq;
import com.libiao.customer.model.quotation.*;
import com.libiao.customer.service.BillOutService;
import com.libiao.customer.service.QuotationService;
import com.libiao.customer.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private TestQuotationMapper testQuotationMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private BasicTestItemMapper basicTestItemMapper;
    @Autowired
    private TestQuotationGoodsMapper testQuotationGoodsMapper;
    @Autowired
    private TestQuotationItemMapper testQuotationItemMapper;
    @Autowired
    private SystemParameterMapper systemParameterMapper;
    @Autowired
    private MallGoodsMapper mallGoodsMapper;
    @Autowired
    private QuotationMapperExt quotationMapperExt;
    @Autowired
    private CustomerBillMapper customerBillMapper;
    @Autowired
    private TestApplicationFormMapper testApplicationFormMapper;
    @Autowired
    private BillOutService billOutService;

    @Override
    public PageInfo<TestQuotation> list(QuotationListReq req) {
        PageInfo<TestQuotation> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        req.setQuotationNum(LikeUtil.totalLike(req.getQuotationNum()));
        req.setClientName(LikeUtil.totalLike(req.getClientName()));
        req.setTradeName(LikeUtil.totalLike(req.getTradeName()));

        final List<TestQuotation> quotations = quotationMapperExt.getQuotationList(req);
        page = new PageInfo<>(quotations);
        return page;
    }

    @Override
    @Transactional
    public void create(CreateQuotationReq req) {
        //????????????????????????
        Map<Integer, Integer> itemMap = new HashMap<>();
        Map<Long, List<QuotaGoodsItemVO>> goodsMap = new HashMap<>();
        int trans_amount = 0;
        for (CreateQuotaGoodsReqVO goods : req.getGoods()) {
            trans_amount += goods.getTestPrice();
            for (QuotaGoodsItemVO item : goods.getItems()) {
                itemMap.put(item.getItemId(), item.getQuantity());
            }
            goodsMap.put(goods.getGoodsId(), goods.getItems());
        }
        //???????????????????????????
        final Set<Integer> itemIds = itemMap.keySet();
        final BasicTestItemExample basicTestItemExample = new BasicTestItemExample();
        basicTestItemExample.createCriteria().andIdIn(new ArrayList<>(itemIds));
        final List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(basicTestItemExample);
        int amount = 0;
        Map<Integer, BasicTestItem> dbItemMap = new HashMap<>();
        for (BasicTestItem item : basicTestItems) {
            amount += item.getPrice() * itemMap.get(item.getId());
            dbItemMap.put(item.getId(), item);
        }

        //????????????????????????????????????????????? ??????/???????????? = ??????
        final BigDecimal discount = new BigDecimal(trans_amount).multiply(new BigDecimal(100))
                .divide(new BigDecimal(amount), 0, RoundingMode.HALF_UP);
        int dis = discount.intValue();
        TestQuotation record = new TestQuotation();
        BeanCopyUtil.copy(req, record);
        record.setDiscount(String.valueOf(dis));
        //??????????????????
        String quotNo = redisUtil.getNo(req.getUser().getCity(), DateUtils.getDate("yyMMdd"));
        record.setQuotationNum(quotNo);
        record.setUserId(req.getUser().getId());
        record.setUserOrgNo(req.getUser().getOrgNo());
        record.setPayStatus(QuotationEnum.PRICE_CHECK.getCode());
        record.setClientNum(req.getClientNum());
        if (dis < req.getUser().getDiscount()) {
            //????????????????????????
            record.setState(QuotationEnum.PRICE_CHECK.getCode());
            record.setStep(QuotationEnum.STEP_QUOT_CHECK.getCode());
        } else {
            //?????????????????????????????????
            record.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            if (req.getPayType() == 0) {//??????

                //??????????????????????????????????????????????????????
                final boolean result = billOutService.creditRecord(record);
                if (result) {
                    //????????????
                    record.setState(QuotationEnum.CREDIT.getCode());
                } else {
                    //????????????
                    record.setState(QuotationEnum.NOT_PAID.getCode());
                }
            } else {//?????????????????????????????????
                record.setState(QuotationEnum.NOT_PAID.getCode());
            }
        }

        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andIdIn(new ArrayList<>(goodsMap.keySet()));
        List<MallGoods> goodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
        List<TestQuotationGoods> testQuotationGoodsList = new ArrayList<>();
        List<TestQuotationItem> testQuotationItemList = new ArrayList<>();
        for (MallGoods mallGoods : goodsList) {
            TestQuotationGoods testQuotationGoods = new TestQuotationGoods();
            testQuotationGoods.setGoodsId(mallGoods.getId());
            testQuotationGoods.setGoodsName(mallGoods.getGoodsName());
            testQuotationGoods.setHsCode(mallGoods.getHscode());
            testQuotationGoods.setMaterial(mallGoods.getMaterial());
            testQuotationGoods.setExportCountry(mallGoods.getExport());
            testQuotationGoods.setStandard(mallGoods.getStandard());
            testQuotationGoods.setTestPeriod(req.getGoods().get(0).getTestPeriod());
            testQuotationGoods.setSampleNum(req.getGoods().get(0).getSampleNum());
            testQuotationGoods.setService(req.getGoods().get(0).getService());
            testQuotationGoods.setAmount(req.getGoods().get(0).getTestPrice());
            testQuotationGoods.setQuotationNum(quotNo);
            StringBuilder sb = new StringBuilder();
            for (Byte str : req.getGoods().get(0).getReportTypes()) {
                sb.append(str).append(",");
            }
            String result3 = sb.deleteCharAt(sb.length() - 1).toString();
            testQuotationGoods.setReprotType(result3);
            //testQuotationGoods.setOrgPrice(Integer.parseInt(mallGoods.getPrice()));

            testQuotationGoods.setReportAmt(calReportAmt(result3));
            //??????????????????????????????
            testQuotationGoodsList.add(testQuotationGoods);

            final List<QuotaGoodsItemVO> quotaGoodsItemVOS = goodsMap.get(mallGoods.getId());

            //??????????????????
            for (QuotaGoodsItemVO quotaGoodsItemVO : quotaGoodsItemVOS) {
                final BasicTestItem basicTestItem = dbItemMap.get(quotaGoodsItemVO.getItemId());
                TestQuotationItem testQuotationItem = new TestQuotationItem();
                testQuotationItem.setTestItem(basicTestItem.getName());
                testQuotationItem.setItemId(basicTestItem.getId());
                testQuotationItem.setTestQuotationGoodsId(mallGoods.getId());
                testQuotationItem.setTestQuotationNum(quotNo);
                testQuotationItem.setTestItem(basicTestItem.getName());
                testQuotationItem.setQuantity(quotaGoodsItemVO.getQuantity());
                testQuotationItem.setUnitPrice(basicTestItem.getPrice());
                testQuotationItem.setSampleQty(Integer.parseInt(basicTestItem.getQuantity()));
                int amt = basicTestItem.getPrice() * quotaGoodsItemVO.getQuantity();
                testQuotationItem.setAmountRmb(amt);
                testQuotationItemList.add(testQuotationItem);
            }
        }


        final Long serviceId = quotationMapperExt.getServiceId();
        record.setServiceId(serviceId);


        //???????????????
        testQuotationMapper.insertSelective(record);

        //?????????????????????????????????
        for (TestQuotationGoods testQuotationGoods : testQuotationGoodsList) {
            testQuotationGoodsMapper.insertSelective(testQuotationGoods);
        }
        //????????????????????????????????????
        for (TestQuotationItem testQuotationItem : testQuotationItemList) {
            testQuotationItemMapper.insertSelective(testQuotationItem);
        }
    }

    //?????????????????????????????????????????????????????????
    @Override
    @Transactional
    public void modify(ModifyQuotationReq req) {
        final TestQuotationExample testQuotationExample = new TestQuotationExample();
        testQuotationExample.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(testQuotationExample);
        if (testQuotations == null) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "??????????????????");
        }
        final TestQuotation testQuotation = testQuotations.get(0);
        if (testQuotation.getState() != QuotationEnum.STEP_QUOT_CHECK.getCode()) {
            throw new ServiceException(HttpStatus.NOT_ACCEPTABLE, "????????????????????????");
        }
        //?????????????????????

        //????????????????????????
        Map<Integer, Integer> itemMap = new HashMap<>();
        Map<Long, List<QuotaGoodsItemVO>> goodsMap = new HashMap<>();
        int trans_amount = 0;
        for (CreateQuotaGoodsReqVO goods : req.getGoods()) {
            trans_amount += goods.getTestPrice();
            for (QuotaGoodsItemVO item : goods.getItems()) {
                itemMap.put(item.getItemId(), item.getQuantity());
            }
            goodsMap.put(goods.getGoodsId(), goods.getItems());
        }
        //???????????????????????????
        final Set<Integer> itemIds = itemMap.keySet();
        final BasicTestItemExample basicTestItemExample = new BasicTestItemExample();
        basicTestItemExample.createCriteria().andIdIn(new ArrayList<>(itemIds));
        final List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(basicTestItemExample);
        int amount = 0;
        Map<Integer, BasicTestItem> dbItemMap = new HashMap<>();
        for (BasicTestItem item : basicTestItems) {
            amount += item.getPrice() * itemMap.get(item.getId());
            dbItemMap.put(item.getId(), item);
        }
        //????????????????????????????????????????????? ??????/???????????? = ??????
        final BigDecimal discount = new BigDecimal(trans_amount).multiply(new BigDecimal(100)).divide(new BigDecimal(amount), 0, RoundingMode.HALF_UP);
        int dis = discount.intValue();
        TestQuotation record = new TestQuotation();
        BeanCopyUtil.copy(req, record);
        record.setId(testQuotation.getId());
        record.setDiscount(String.valueOf(dis));
        if (dis < req.getUser().getDiscount()) {
            //????????????????????????
            record.setState(QuotationEnum.PRICE_CHECK.getCode());
            record.setStep(QuotationEnum.STEP_QUOT_CHECK.getCode());
        } else {
            //?????????????????????????????????
            record.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            if (req.getPayType() == 0) {//??????
                record.setState(QuotationEnum.CREDIT.getCode());
            } else {//?????????????????????????????????
                record.setState(QuotationEnum.NOT_PAID.getCode());
            }
        }

        //??????????????????

        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andIdIn(new ArrayList<>(goodsMap.keySet()));
        List<MallGoods> goodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
        List<TestQuotationGoods> testQuotationGoodsList = new ArrayList<>();
        List<TestQuotationItem> testQuotationItemList = new ArrayList<>();
        for (MallGoods mallGoods : goodsList) {
            TestQuotationGoods testQuotationGoods = new TestQuotationGoods();
            testQuotationGoods.setGoodsId(mallGoods.getId());
            testQuotationGoods.setGoodsName(mallGoods.getGoodsName());
            testQuotationGoods.setHsCode(mallGoods.getHscode());
            testQuotationGoods.setMaterial(mallGoods.getMaterial());
            testQuotationGoods.setExportCountry(mallGoods.getExport());
            testQuotationGoods.setStandard(mallGoods.getStandard());
            testQuotationGoods.setTestPeriod(req.getGoods().get(0).getTestPeriod());
            testQuotationGoods.setSampleNum(req.getGoods().get(0).getSampleNum());
            testQuotationGoods.setService(req.getGoods().get(0).getService());
            testQuotationGoods.setAmount(req.getGoods().get(0).getTestPrice());
            testQuotationGoods.setQuotationNum(testQuotation.getQuotationNum());
            StringBuilder sb = new StringBuilder();
            for (Byte str : req.getGoods().get(0).getReportTypes()) {
                sb.append(str).append(",");
            }
            String result3 = sb.deleteCharAt(sb.length() - 1).toString();
            testQuotationGoods.setReprotType(result3);
            //testQuotationGoods.setOrgPrice(Integer.parseInt(mallGoods.getPrice()));

            testQuotationGoods.setReportAmt(calReportAmt(result3));
            //??????????????????????????????
            testQuotationGoodsList.add(testQuotationGoods);

            final List<QuotaGoodsItemVO> quotaGoodsItemVOS = goodsMap.get(mallGoods.getId());

            //??????????????????
            for (QuotaGoodsItemVO quotaGoodsItemVO : quotaGoodsItemVOS) {
                final BasicTestItem basicTestItem = dbItemMap.get(quotaGoodsItemVO.getItemId());
                TestQuotationItem testQuotationItem = new TestQuotationItem();
                testQuotationItem.setItemId(basicTestItem.getId());
                testQuotationItem.setTestItem(basicTestItem.getName());
                testQuotationItem.setTestQuotationGoodsId(mallGoods.getId());
                testQuotationItem.setTestQuotationNum(testQuotation.getQuotationNum());
                testQuotationItem.setTestItem(basicTestItem.getName());
                testQuotationItem.setQuantity(quotaGoodsItemVO.getQuantity());
                testQuotationItem.setUnitPrice(basicTestItem.getPrice());
                testQuotationItem.setSampleQty(Integer.parseInt(basicTestItem.getQuantity()));
                int amt = basicTestItem.getPrice() * quotaGoodsItemVO.getQuantity();
                testQuotationItem.setAmountRmb(amt);
                testQuotationItemList.add(testQuotationItem);
            }

        }
        //???????????????
        testQuotationMapper.updateByPrimaryKeySelective(record);

        final TestQuotationGoodsExample testQuotationGoodsExample = new TestQuotationGoodsExample();
        testQuotationGoodsExample.createCriteria().andQuotationNumEqualTo(testQuotation.getQuotationNum());
        testQuotationGoodsMapper.deleteByExample(testQuotationGoodsExample);
        //?????????????????????????????????
        for (TestQuotationGoods testQuotationGoods : testQuotationGoodsList) {
            testQuotationGoodsMapper.insertSelective(testQuotationGoods);
        }
        final TestQuotationItemExample testQuotationItemExample = new TestQuotationItemExample();
        testQuotationItemExample.createCriteria().andTestQuotationNumEqualTo(testQuotation.getQuotationNum());
        testQuotationItemMapper.deleteByExample(testQuotationItemExample);
        //????????????????????????????????????
        for (TestQuotationItem testQuotationItem : testQuotationItemList) {
            testQuotationItemMapper.insertSelective(testQuotationItem);
        }
    }

    @Override
    @Transactional
    public void examine(ExamineQuotationReq req) {
        final TestQuotationExample testQuotationExample = new TestQuotationExample();
        testQuotationExample.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(testQuotationExample);
        if (testQuotations == null) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "??????????????????");
        }
        final TestQuotation testQuotation = testQuotations.get(0);
        if (testQuotation.getState() != QuotationEnum.PRICE_CHECK.getCode()) {
            throw new ServiceException(HttpStatus.NOT_ACCEPTABLE, "????????????????????????");
        }
        //????????????????????????
        TestQuotation update = new TestQuotation();
        update.setId(testQuotation.getId());
        update.setAuditId(req.getUser().getId());
        update.setAuditName(req.getUser().getNickname());

        if (0 == req.getCheckResult()) {//????????????
            update.setAuditReason(req.getReason());
            update.setState(QuotationEnum.PRICE_REFUSE.getCode());

        } else {
            update.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            if (testQuotation.getPayType() == 0) {//??????
                //??????????????????????????????????????????????????????
                final boolean result = billOutService.creditRecord(testQuotation);
                if (result) {
                    //????????????
                    update.setState(QuotationEnum.CREDIT.getCode());
                } else {
                    //????????????
                    update.setState(QuotationEnum.NOT_PAID.getCode());
                }
            } else {//?????????????????????????????????
                update.setState(QuotationEnum.NOT_PAID.getCode());
            }
        }
        testQuotationMapper.updateByPrimaryKeySelective(update);
    }

    /**
     * ???????????????
     *
     * @param req
     */
    @Override
    @Transactional
    public void addQuot(AddQuotationReq req) {
        final TestQuotationExample testQuotationExample = new TestQuotationExample();
        testQuotationExample.createCriteria().andQuotationNumEqualTo(req.getOrgQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(testQuotationExample);
        if (testQuotations == null) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "?????????????????????");
        }
        final TestQuotation testQuotation = testQuotations.get(0);

        //????????????????????????
        Map<Integer, Integer> itemMap = new HashMap<>();
        Map<Long, List<QuotaGoodsItemVO>> goodsMap = new HashMap<>();
        int trans_amount = 0;
        for (CreateQuotaGoodsReqVO goods : req.getGoods()) {
            trans_amount += goods.getTestPrice();
            for (QuotaGoodsItemVO item : goods.getItems()) {
                itemMap.put(item.getItemId(), item.getQuantity());
            }
            goodsMap.put(goods.getGoodsId(), goods.getItems());
        }
        //???????????????????????????
        final Set<Integer> itemIds = itemMap.keySet();
        final BasicTestItemExample basicTestItemExample = new BasicTestItemExample();
        basicTestItemExample.createCriteria().andIdIn(new ArrayList<>(itemIds));
        final List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(basicTestItemExample);
        int amount = 0;
        Map<Integer, BasicTestItem> dbItemMap = new HashMap<>();
        for (BasicTestItem item : basicTestItems) {
            amount += item.getPrice() * itemMap.get(item.getId());
            dbItemMap.put(item.getId(), item);
        }
        //????????????????????????????????????????????? ??????/???????????? = ??????
        final BigDecimal discount = new BigDecimal(trans_amount).multiply(new BigDecimal(100)).divide(new BigDecimal(amount)).setScale(0, RoundingMode.HALF_UP);
        int dis = discount.intValue();
        TestQuotation record = new TestQuotation();
        BeanCopyUtil.copy(testQuotation, record);
        record.setType(req.getType());
        String quotNo = testQuotation.getQuotationNum();
        TestQuotationExample example = new TestQuotationExample();
        example.createCriteria().andOrgQuotationNumEqualTo(req.getOrgQuotationNum()).andTypeEqualTo(req.getType());
        final long l = testQuotationMapper.countByExample(example);
        //String no = String.format("%02d",l);
        if (2 == req.getType()) {//??????
            record.setTradeName(record.getTradeName() + "??????");
            //??????????????????
            quotNo = testQuotation.getQuotationNum() + "-a" + l;
        } else if (3 == req.getPayType()) {//??????
            record.setTradeName(record.getTradeName() + "??????");
            //??????????????????
            quotNo = testQuotation.getQuotationNum() + "-r" + l;
        }
        record.setOrgQuotationNum(req.getOrgQuotationNum());
        record.setDiscount(String.valueOf(dis));
        if (dis < req.getUser().getDiscount()) {
            //????????????????????????
            record.setState(QuotationEnum.PRICE_CHECK.getCode());
            record.setStep(QuotationEnum.STEP_QUOT_CHECK.getCode());
        } else {
            //?????????????????????????????????
            record.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            if (req.getPayType() == 0) {//??????
                record.setState(QuotationEnum.CREDIT.getCode());
            } else {//?????????????????????????????????
                record.setState(QuotationEnum.NOT_PAID.getCode());
            }
        }
        record.setQuotationNum(quotNo);

        MallGoodsExample mallGoodsExample = new MallGoodsExample();
        mallGoodsExample.createCriteria().andIdIn(new ArrayList<>(goodsMap.keySet()));
        List<MallGoods> goodsList = mallGoodsMapper.selectByExample(mallGoodsExample);
        List<TestQuotationGoods> testQuotationGoodsList = new ArrayList<>();
        List<TestQuotationItem> testQuotationItemList = new ArrayList<>();
        for (MallGoods mallGoods : goodsList) {
            TestQuotationGoods testQuotationGoods = new TestQuotationGoods();
            testQuotationGoods.setGoodsId(mallGoods.getId());
            testQuotationGoods.setGoodsName(mallGoods.getGoodsName());
            testQuotationGoods.setHsCode(mallGoods.getHscode());
            testQuotationGoods.setMaterial(mallGoods.getMaterial());
            testQuotationGoods.setExportCountry(mallGoods.getExport());
            testQuotationGoods.setStandard(mallGoods.getStandard());
            testQuotationGoods.setTestPeriod(req.getGoods().get(0).getTestPeriod());
            testQuotationGoods.setSampleNum(req.getGoods().get(0).getSampleNum());
            testQuotationGoods.setService(req.getGoods().get(0).getService());
            testQuotationGoods.setAmount(req.getGoods().get(0).getTestPrice());
            testQuotationGoods.setQuotationNum(quotNo);
            StringBuilder sb = new StringBuilder();
            for (Byte str : req.getGoods().get(0).getReportTypes()) {
                sb.append(str).append(",");
            }
            String result3 = sb.deleteCharAt(sb.length() - 1).toString();
            testQuotationGoods.setReprotType(result3);
            //testQuotationGoods.setOrgPrice(Integer.parseInt(mallGoods.getPrice()));

            testQuotationGoods.setReportAmt(calReportAmt(result3));
            //??????????????????????????????
            testQuotationGoodsList.add(testQuotationGoods);

            final List<QuotaGoodsItemVO> quotaGoodsItemVOS = goodsMap.get(mallGoods.getId());

            //??????????????????
            for (QuotaGoodsItemVO quotaGoodsItemVO : quotaGoodsItemVOS) {
                final BasicTestItem basicTestItem = dbItemMap.get(quotaGoodsItemVO.getItemId());
                TestQuotationItem testQuotationItem = new TestQuotationItem();
                testQuotationItem.setTestItem(basicTestItem.getName());
                testQuotationItem.setItemId(basicTestItem.getId());
                testQuotationItem.setTestQuotationGoodsId(mallGoods.getId());
                testQuotationItem.setTestQuotationNum(quotNo);
                testQuotationItem.setTestItem(basicTestItem.getName());
                testQuotationItem.setQuantity(quotaGoodsItemVO.getQuantity());
                testQuotationItem.setUnitPrice(basicTestItem.getPrice());
                testQuotationItem.setSampleQty(Integer.parseInt(basicTestItem.getQuantity()));
                int amt = basicTestItem.getPrice() * quotaGoodsItemVO.getQuantity();
                testQuotationItem.setAmountRmb(amt);
                testQuotationItemList.add(testQuotationItem);
            }

        }
        //???????????????
        testQuotationMapper.insertSelective(record);

        //?????????????????????????????????
        for (TestQuotationGoods testQuotationGoods : testQuotationGoodsList) {
            testQuotationGoodsMapper.insertSelective(testQuotationGoods);
        }
        //????????????????????????????????????
        for (TestQuotationItem testQuotationItem : testQuotationItemList) {
            testQuotationItemMapper.insertSelective(testQuotationItem);
        }
    }

    @Override
    public QuotationDetailVO detail(QuotationDetailReq req) {
        final TestQuotationExample testQuotationExample = new TestQuotationExample();
        testQuotationExample.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(testQuotationExample);
        if (testQuotations == null) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "??????????????????");
        }
        final TestQuotation testQuotation = testQuotations.get(0);
        QuotationDetailVO vo = BeanCopyUtil.copy(testQuotation, QuotationDetailVO.class);
        //??????goods
        TestQuotationGoodsExample example = new TestQuotationGoodsExample();
        example.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotationGoods> testQuotationGoods = testQuotationGoodsMapper.selectByExample(example);
        List<QuotaGoodsVO> goodsVOList = new ArrayList<>();

        //??????????????????????????????
        TestQuotationExample aExample = new TestQuotationExample();
        aExample.createCriteria().andOrgQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> arList = testQuotationMapper.selectByExample(aExample);
        List<String> addList = new ArrayList<>();
        List<String> repList = new ArrayList<>();
        Map<String, TestQuotation> map = new HashMap<>();
        if (arList != null) {
            for (TestQuotation quotation : arList) {
                map.put(quotation.getQuotationNum(), quotation);
                if (quotation.getType() == 2) {
                    addList.add(quotation.getQuotationNum());
                }
                if (quotation.getType() == 3) {
                    repList.add(quotation.getQuotationNum());
                }
            }
        }

        //??????items
        for (TestQuotationGoods testQuotationGood : testQuotationGoods) {
            final TestQuotationItemExample testQuotationItemExample = new TestQuotationItemExample();
            testQuotationItemExample.createCriteria().andTestQuotationNumEqualTo(req.getQuotationNum())
                    .andTestQuotationGoodsIdEqualTo(testQuotationGood.getGoodsId());
            final List<TestQuotationItem> testQuotationItemList = testQuotationItemMapper.selectByExample(testQuotationItemExample);
            QuotaGoodsVO quotaGoodsVO = new QuotaGoodsVO();
            BeanCopyUtil.copy(testQuotationGood, quotaGoodsVO);
            final String[] split = testQuotationGood.getReprotType().split(",");
            List<Byte> list = new ArrayList<>();
            for (String s : split) {
                list.add(Byte.parseByte(s));
            }
            quotaGoodsVO.setReportTypes(list);
            List<QuotaDetailItemVO> itemVOList = new ArrayList<>();
            //????????????item
            for (TestQuotationItem testQuotationItem : testQuotationItemList) {
                QuotaDetailItemVO itemVO = new QuotaDetailItemVO();
                BeanCopyUtil.copy(testQuotationItem, itemVO);
                itemVOList.add(itemVO);
            }
            quotaGoodsVO.setItems(itemVOList);
            goodsVOList.add(quotaGoodsVO);
            if (!CollectionUtils.isEmpty(addList)) {
                TestQuotationGoodsExample aaExample = new TestQuotationGoodsExample();
                aaExample.createCriteria().andQuotationNumIn(addList).andGoodsIdEqualTo(testQuotationGood.getGoodsId());
                final List<TestQuotationGoods> addGoods = testQuotationGoodsMapper.selectByExample(aaExample);
                if (!CollectionUtils.isEmpty(addGoods)) {
                    List<AdditionalQuotationVO> aList = new ArrayList<>();
                    for (TestQuotationGoods ag : addGoods) {
                        AdditionalQuotationVO addiVo = new AdditionalQuotationVO();
                        //???????????????item
                        TestQuotationItemExample aItemExample = new TestQuotationItemExample();
                        aItemExample.createCriteria().andTestQuotationNumEqualTo(ag.getQuotationNum()).andTestQuotationGoodsIdEqualTo(ag.getGoodsId());
                        final List<TestQuotationItem> aItemList = testQuotationItemMapper.selectByExample(aItemExample);
                        List<QuotaDetailItemVO> aItemVOList = new ArrayList<>();
                        for (TestQuotationItem testQuotationItem : aItemList) {
                            QuotaDetailItemVO itemVO = new QuotaDetailItemVO();
                            BeanCopyUtil.copy(testQuotationItem, itemVO);
                            aItemVOList.add(itemVO);
                        }
                        final TestQuotation testQuotation1 = map.get(ag.getQuotationNum());
                        addiVo.setItems(aItemVOList);
                        addiVo.setTestPeriod(ag.getTestPeriod());
                        addiVo.setSampleNum(ag.getSampleNum());
                        addiVo.setQuotationNum(ag.getQuotationNum());
                        addiVo.setTotalCost(testQuotation1.getTotalCost());
                        aList.add(addiVo);
                    }
                    quotaGoodsVO.setAList(aList);
                }
            }

            if (!CollectionUtils.isEmpty(repList)) {
                TestQuotationGoodsExample aaExample = new TestQuotationGoodsExample();
                aaExample.createCriteria().andQuotationNumIn(repList).andGoodsIdEqualTo(testQuotationGood.getGoodsId());
                final List<TestQuotationGoods> repGoods = testQuotationGoodsMapper.selectByExample(aaExample);
                if (!CollectionUtils.isEmpty(repGoods)) {
                    List<AdditionalQuotationVO> rList = new ArrayList<>();
                    for (TestQuotationGoods rg : repGoods) {
                        AdditionalQuotationVO repVO = new AdditionalQuotationVO();
                        //???????????????item
                        TestQuotationItemExample aItemExample = new TestQuotationItemExample();
                        aaExample.createCriteria().andQuotationNumEqualTo(rg.getQuotationNum()).andGoodsIdEqualTo(rg.getGoodsId());
                        final List<TestQuotationItem> aItemList = testQuotationItemMapper.selectByExample(aItemExample);
                        List<QuotaDetailItemVO> aItemVOList = new ArrayList<>();
                        for (TestQuotationItem testQuotationItem : aItemList) {
                            QuotaDetailItemVO itemVO = new QuotaDetailItemVO();
                            BeanCopyUtil.copy(testQuotationItem, itemVO);
                            aItemVOList.add(itemVO);
                        }
                        final TestQuotation testQuotation1 = map.get(rg.getQuotationNum());
                        repVO.setItems(aItemVOList);
                        repVO.setTestPeriod(rg.getTestPeriod());
                        repVO.setSampleNum(rg.getSampleNum());
                        repVO.setQuotationNum(rg.getQuotationNum());
                        repVO.setTotalCost(testQuotation1.getTotalCost());
                        rList.add(repVO);
                    }
                    quotaGoodsVO.setRList(rList);
                }
            }

            TestApplicationFormExample appExample = new TestApplicationFormExample();
            appExample.createCriteria().andQuotationNumEqualTo(req.getQuotationNum()).andGoodsIdEqualTo(testQuotationGood.getGoodsId());
            final List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(appExample);
            quotaGoodsVO.setApplied(!CollectionUtils.isEmpty(testApplicationForms));
        }


        vo.setGoods(goodsVOList);

        return vo;
    }

    //????????????
    @Override
    public void upload(AddQuotationBillReq req) {

        TestQuotationExample example = new TestQuotationExample();
        example.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testQuotations)) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "??????????????????");
        }
        TestQuotation testQuotation = testQuotations.get(0);

        CustomerBill record = new CustomerBill();

        record.setTradeId(req.getQuotationNum());
        record.setClientId(testQuotation.getClientNum());
        record.setOrderAmt(testQuotation.getTotalTestAmt());
        record.setIncomeAmt(req.getIncomeAmt());
        record.setBillPath(req.getBillPath());
        record.setUploadTime(new Date());
        record.setStatus((byte) 0);
        record.setSettleAmt(0);
        record.setOperUser(req.getUser().getNickname());
        record.setOperTime(new Date());
        customerBillMapper.insertSelective(record);

    }

    /*public QuotationDetailVO convert(TestQuotation testQuotation){
        QuotationDetailVO vo = BeanCopyUtil.copy(testQuotation, QuotationDetailVO.class);
        //??????goods
        TestQuotationGoodsExample example = new TestQuotationGoodsExample();
        example.createCriteria().andQuotationNumEqualTo(testQuotation.getQuotationNum());
        final List<TestQuotationGoods> testQuotationGoods = testQuotationGoodsMapper.selectByExample(example);
        List<QuotaGoodsVO> goodsVOList = new ArrayList<>();
        //??????items
        for (TestQuotationGoods testQuotationGood : testQuotationGoods) {
            final TestQuotationItemExample testQuotationItemExample = new TestQuotationItemExample();
            testQuotationItemExample.createCriteria().andTestQuotationNumEqualTo(testQuotation.getQuotationNum())
                    .andTestQuotationGoodsIdEqualTo(testQuotationGood.getGoodsId());
            final List<TestQuotationItem> testQuotationItemList = testQuotationItemMapper.selectByExample(testQuotationItemExample);
            QuotaGoodsVO quotaGoodsVO = new QuotaGoodsVO();
            BeanCopyUtil.copy(testQuotationGood,quotaGoodsVO);
            final String[] split = testQuotationGood.getReprotType().split(",");
            List<Byte> list = new ArrayList<>();
            for (String s : split) {
                list.add(Byte.parseByte(s));
            }
            quotaGoodsVO.setReportTypes(list);
            List<QuotaDetailItemVO> itemVOList = new ArrayList<>();
            //????????????item
            for (TestQuotationItem testQuotationItem : testQuotationItemList) {
                QuotaDetailItemVO itemVO = new QuotaDetailItemVO();
                BeanCopyUtil.copy(testQuotationItem,itemVO);
                itemVOList.add(itemVO);
            }
            quotaGoodsVO.setItems(itemVOList);
            goodsVOList.add(quotaGoodsVO);
        }
        vo.setGoods(goodsVOList);
        return vo;
    }*/


    private int calReportAmt(String report) {
        if (report.contains("1") || report.contains("2")) {
            if (report.contains("3") || report.contains("4")) {
                return 10000;
            }
        }
        return 0;
    }

    @Override
    public String getRate() {
        return systemParameterMapper.selectByPrimaryKey("TAX_RATE").getParamValue();
    }

    @Override
    public List<QuotationNameVO> getQuotationByName(BaseNameReq req) {
        List<QuotationNameVO> voList = new ArrayList<>();
        if (StringUtils.isEmpty(req.getName())) return voList;
        TestQuotationExample example = new TestQuotationExample();
        example.createCriteria().andTradeNameLike("%" + req.getName() + "%");
        List<TestQuotation> quotations = testQuotationMapper.selectByExample(example);
        if (quotations.isEmpty()) return voList;
        quotations.forEach(quotation->{
            QuotationNameVO vo = new QuotationNameVO();
            vo.setTradeId(quotation.getQuotationNum());
            vo.setTradeName(quotation.getTradeName());
            voList.add(vo);
        });
        return voList;
    }
}
