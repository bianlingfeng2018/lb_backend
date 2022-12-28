package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.constant.QuotationEnum;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.quotation.*;
import com.libiao.customer.service.QuotationService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.DateUtils;
import com.libiao.customer.util.RedisUtil;
import com.libiao.customer.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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




    @Override
    public PageInfo<TestQuotation> list(QuotationListReq req){
        PageInfo<TestQuotation> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        TestQuotationExample example = new TestQuotationExample();
        final TestQuotationExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasLength(req.getQuotationNum())){
            criteria.andQuotationNumEqualTo(req.getQuotationNum());
        }
        if (StringUtils.hasLength(req.getClientName())){
            criteria.andClientNameEqualTo(req.getClientName());
        }
        if (StringUtils.hasLength(req.getTradeName())){
            criteria.andTradeNameEqualTo(req.getTradeName());
        }
        if (Objects.nonNull(req.getPayStatus())){
            criteria.andPayStatusEqualTo(req.getPayStatus());
        }
        if (Objects.nonNull(req.getStep())){
            criteria.andStepEqualTo(req.getStep());
        }

        final List<TestQuotation> quotations = testQuotationMapper.selectByExample(example);
        page = new PageInfo<>(quotations);
        return page;
    }

    //基础是检测项目，商品是相关检测项的合集。实际报价单中仅体现到商品和检测项。设计稿没有套餐，不做。

    @Override
    @Transactional
    public void create(CreateQuotationReq req){
        //获取所有测试项目
        Map<Integer,Integer> itemMap = new HashMap<>();
        Map<Long,List<QuotaGoodsItemVO>> goodsMap = new HashMap<>();
        int trans_amount = 0;
        for (CreateQuotaGoodsReqVO goods : req.getGoods()) {
            trans_amount += goods.getTestPrice();
            //List<Integer> itemsIds = new ArrayList<>();
            for (QuotaGoodsItemVO item : goods.getItems()) {
                itemMap.put(item.getItemId(), item.getQuantity());
                //itemsIds.add(item.getItemId());
            }
            goodsMap.put(goods.getGoodsId(),goods.getItems());
        }
        //计算折扣前的总金额
        final Set<Integer> itemIds = itemMap.keySet();
        final BasicTestItemExample basicTestItemExample = new BasicTestItemExample();
        basicTestItemExample.createCriteria().andIdIn(new ArrayList<>(itemIds));
        final List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(basicTestItemExample);
        int amount = 0;
        Map<Integer,BasicTestItem> dbItemMap = new HashMap<>();
        for (BasicTestItem item : basicTestItems) {
            amount += item.getPrice() * itemMap.get(item.getId());
            dbItemMap.put(item.getId(),item);
        }
        //然后再对比实际的金额来计算折扣 报价/基本售价 = 折扣
        final BigDecimal discount = new BigDecimal(trans_amount).multiply(new BigDecimal(100)).divide(new BigDecimal(amount)).setScale(0, RoundingMode.HALF_UP);
        int dis = discount.intValue();
        TestQuotation record = new TestQuotation();
        BeanCopyUtil.copy(req,record);
        record.setDiscount(String.valueOf(dis));
        if (dis < req.getUser().getDiscount()){
            //状态设置为待审核
            record.setState(QuotationEnum.PRICE_CHECK.getCode());
            record.setStep(QuotationEnum.STEP_QUOT_CHECK.getCode());
        }else {
            //状态设置为报价审核通过
            record.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            if (req.getPayType() == 0) {//挂账
                record.setState(QuotationEnum.CREDIT.getCode());
            }else {//未支付，待上传支付凭证
                record.setState(QuotationEnum.NOT_PAID.getCode());
            }
        }

        //生产报价单号
        String quotNo = redisUtil.getNo(DateUtils.getDate("yyyyMMdd"));
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
            for(Byte str : req.getGoods().get(0).getReportTypes()){
                sb.append(str).append(",");
            }
            String result3 = sb.deleteCharAt(sb.length()-1).toString();
            testQuotationGoods.setReprotType(result3);
            testQuotationGoods.setOrgPrice(Integer.parseInt(mallGoods.getPrice()));

            testQuotationGoods.setReportAmt(calReportAmt(result3));
            //对应下属测试项目组装
            testQuotationGoodsList.add(testQuotationGoods);
            //TODO 邮费计算
            final List<QuotaGoodsItemVO> quotaGoodsItemVOS = goodsMap.get(mallGoods.getId());

            //组装测试项目
            for (QuotaGoodsItemVO quotaGoodsItemVO : quotaGoodsItemVOS) {
                final BasicTestItem basicTestItem = dbItemMap.get(quotaGoodsItemVO.getItemId());
                TestQuotationItem testQuotationItem = new TestQuotationItem();
                testQuotationItem.setTestItem(basicTestItem.getName());
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

        //插入报价单
        testQuotationMapper.insert(record);

        //批量插入报价单下属商品
        for (TestQuotationGoods testQuotationGoods : testQuotationGoodsList) {
            testQuotationGoodsMapper.insert(testQuotationGoods);
        }
        //批量插入报价单下属测试项
        for (TestQuotationItem testQuotationItem : testQuotationItemList) {
            testQuotationItemMapper.insert(testQuotationItem);
        }
    }

    //编辑报价单，只有未审核的报价单可以编辑
    @Override
    @Transactional
    public void modify(ModifyQuotationReq req){
        final TestQuotationExample testQuotationExample = new TestQuotationExample();
        testQuotationExample.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(testQuotationExample);
        if (testQuotations == null){
            throw new ServiceException(HttpStatus.NOT_FOUND,"报价单不存在");
        }
        final TestQuotation testQuotation = testQuotations.get(0);
        if (testQuotation.getState() != QuotationEnum.STEP_QUOT_CHECK.getCode()){
            throw new ServiceException(HttpStatus.NOT_ACCEPTABLE,"报价单状态不正确");
        }
        //通过后进行更新

        //获取所有测试项目
        Map<Integer,Integer> itemMap = new HashMap<>();
        Map<Long,List<QuotaGoodsItemVO>> goodsMap = new HashMap<>();
        int trans_amount = 0;
        for (CreateQuotaGoodsReqVO goods : req.getGoods()) {
            trans_amount += goods.getTestPrice();
            for (QuotaGoodsItemVO item : goods.getItems()) {
                itemMap.put(item.getItemId(), item.getQuantity());
            }
            goodsMap.put(goods.getGoodsId(),goods.getItems());
        }
        //计算折扣前的总金额
        final Set<Integer> itemIds = itemMap.keySet();
        final BasicTestItemExample basicTestItemExample = new BasicTestItemExample();
        basicTestItemExample.createCriteria().andIdIn(new ArrayList<>(itemIds));
        final List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(basicTestItemExample);
        int amount = 0;
        Map<Integer,BasicTestItem> dbItemMap = new HashMap<>();
        for (BasicTestItem item : basicTestItems) {
            amount += item.getPrice() * itemMap.get(item.getId());
            dbItemMap.put(item.getId(),item);
        }
        //然后再对比实际的金额来计算折扣 报价/基本售价 = 折扣
        final BigDecimal discount = new BigDecimal(trans_amount).multiply(new BigDecimal(100)).divide(new BigDecimal(amount)).setScale(0, RoundingMode.HALF_UP);
        int dis = discount.intValue();
        TestQuotation record = new TestQuotation();
        BeanCopyUtil.copy(req,record);
        record.setId(testQuotation.getId());
        record.setDiscount(String.valueOf(dis));
        if (dis < req.getUser().getDiscount()){
            //状态设置为待审核
            record.setState(QuotationEnum.PRICE_CHECK.getCode());
            record.setStep(QuotationEnum.STEP_QUOT_CHECK.getCode());
        }else {
            //状态设置为报价审核通过
            record.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            if (req.getPayType() == 0) {//挂账
                record.setState(QuotationEnum.CREDIT.getCode());
            }else {//未支付，待上传支付凭证
                record.setState(QuotationEnum.NOT_PAID.getCode());
            }
        }

        //生产报价单号

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
            for(Byte str : req.getGoods().get(0).getReportTypes()){
                sb.append(str).append(",");
            }
            String result3 = sb.deleteCharAt(sb.length()-1).toString();
            testQuotationGoods.setReprotType(result3);
            testQuotationGoods.setOrgPrice(Integer.parseInt(mallGoods.getPrice()));

            testQuotationGoods.setReportAmt(calReportAmt(result3));
            //对应下属测试项目组装
            testQuotationGoodsList.add(testQuotationGoods);
            //TODO 邮费计算
            final List<QuotaGoodsItemVO> quotaGoodsItemVOS = goodsMap.get(mallGoods.getId());

            //组装测试项目
            for (QuotaGoodsItemVO quotaGoodsItemVO : quotaGoodsItemVOS) {
                final BasicTestItem basicTestItem = dbItemMap.get(quotaGoodsItemVO.getItemId());
                TestQuotationItem testQuotationItem = new TestQuotationItem();
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
        //插入报价单
        testQuotationMapper.updateByPrimaryKey(record);

        final TestQuotationGoodsExample testQuotationGoodsExample = new TestQuotationGoodsExample();
        testQuotationGoodsExample.createCriteria().andQuotationNumEqualTo(testQuotation.getQuotationNum());
        testQuotationGoodsMapper.deleteByExample(testQuotationGoodsExample);
        //批量插入报价单下属商品
        for (TestQuotationGoods testQuotationGoods : testQuotationGoodsList) {
            testQuotationGoodsMapper.insert(testQuotationGoods);
        }
        final TestQuotationItemExample testQuotationItemExample = new TestQuotationItemExample();
        testQuotationItemExample.createCriteria().andTestQuotationNumEqualTo(testQuotation.getQuotationNum());
        testQuotationItemMapper.deleteByExample(testQuotationItemExample);
        //批量插入报价单下属测试项
        for (TestQuotationItem testQuotationItem : testQuotationItemList) {
            testQuotationItemMapper.insert(testQuotationItem);
        }
    }

    @Override
    public void examine(ExamineQuotationReq req){
        final TestQuotationExample testQuotationExample = new TestQuotationExample();
        testQuotationExample.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(testQuotationExample);
        if (testQuotations == null){
            throw new ServiceException(HttpStatus.NOT_FOUND,"报价单不存在");
        }
        final TestQuotation testQuotation = testQuotations.get(0);
        if (testQuotation.getState() != QuotationEnum.PRICE_CHECK.getCode()){
            throw new ServiceException(HttpStatus.NOT_ACCEPTABLE,"报价单状态不正确");
        }
        //更新报价审核结果
        TestQuotation update = new TestQuotation();
        update.setId(testQuotation.getId());
        update.setAuditId(req.getUser().getId());
        update.setAuditName(req.getUser().getNickname());

        if (0 == req.getCheckResult()){//审核拒绝
            update.setAuditReason(req.getReason());
            update.setState(QuotationEnum.PRICE_REFUSE.getCode());

        }else {
            update.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            if (testQuotation.getPayType() == 0) {//挂账
                update.setState(QuotationEnum.CREDIT.getCode());
            }else {//未支付，待上传支付凭证
                update.setState(QuotationEnum.NOT_PAID.getCode());
            }
        }

    }

    /**
     * 加测报价单
     * @param req
     */
    @Override
    public void addQuot(AddQuotationReq req){
        final TestQuotationExample testQuotationExample = new TestQuotationExample();
        testQuotationExample.createCriteria().andQuotationNumEqualTo(req.getOrgQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(testQuotationExample);
        if (testQuotations == null){
            throw new ServiceException(HttpStatus.NOT_FOUND,"原报价单不存在");
        }
        final TestQuotation testQuotation = testQuotations.get(0);

        //获取所有测试项目
        Map<Integer,Integer> itemMap = new HashMap<>();
        Map<Long,List<QuotaGoodsItemVO>> goodsMap = new HashMap<>();
        int trans_amount = 0;
        for (CreateQuotaGoodsReqVO goods : req.getGoods()) {
            trans_amount += goods.getTestPrice();
            for (QuotaGoodsItemVO item : goods.getItems()) {
                itemMap.put(item.getItemId(), item.getQuantity());
            }
            goodsMap.put(goods.getGoodsId(),goods.getItems());
        }
        //计算折扣前的总金额
        final Set<Integer> itemIds = itemMap.keySet();
        final BasicTestItemExample basicTestItemExample = new BasicTestItemExample();
        basicTestItemExample.createCriteria().andIdIn(new ArrayList<>(itemIds));
        final List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(basicTestItemExample);
        int amount = 0;
        Map<Integer,BasicTestItem> dbItemMap = new HashMap<>();
        for (BasicTestItem item : basicTestItems) {
            amount += item.getPrice() * itemMap.get(item.getId());
            dbItemMap.put(item.getId(),item);
        }
        //然后再对比实际的金额来计算折扣 报价/基本售价 = 折扣
        final BigDecimal discount = new BigDecimal(trans_amount).multiply(new BigDecimal(100)).divide(new BigDecimal(amount)).setScale(0, RoundingMode.HALF_UP);
        int dis = discount.intValue();
        TestQuotation record = new TestQuotation();
        BeanCopyUtil.copy(testQuotation,record);
        record.setType(req.getType());
        String quotNo = testQuotation.getQuotationNum();
        TestQuotationExample example = new TestQuotationExample();
        example.createCriteria().andOrgquotationnumEqualTo(req.getOrgQuotationNum()).andTypeEqualTo(req.getType());
        final long l = testQuotationMapper.countByExample(example);
        //String no = String.format("%02d",l);
        if (2 == req.getType()){//加测
            record.setTradeName(record.getTradeName()+"加测");
            //生产报价单号
            quotNo = testQuotation.getQuotationNum()+"-a"+l;
        } else if (3 == req.getPayType()){//复测
            record.setTradeName(record.getTradeName()+"复测");
            //生产报价单号
            quotNo = testQuotation.getQuotationNum()+"-r"+l;
        }
        record.setDiscount(String.valueOf(dis));
        if (dis < req.getUser().getDiscount()){
            //状态设置为待审核
            record.setState(QuotationEnum.PRICE_CHECK.getCode());
            record.setStep(QuotationEnum.STEP_QUOT_CHECK.getCode());
        }else {
            //状态设置为报价审核通过
            record.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            if (req.getPayType() == 0) {//挂账
                record.setState(QuotationEnum.CREDIT.getCode());
            }else {//未支付，待上传支付凭证
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
            for(Byte str : req.getGoods().get(0).getReportTypes()){
                sb.append(str).append(",");
            }
            String result3 = sb.deleteCharAt(sb.length()-1).toString();
            testQuotationGoods.setReprotType(result3);
            testQuotationGoods.setOrgPrice(Integer.parseInt(mallGoods.getPrice()));

            testQuotationGoods.setReportAmt(calReportAmt(result3));
            //对应下属测试项目组装
            testQuotationGoodsList.add(testQuotationGoods);
            //TODO 邮费计算
            final List<QuotaGoodsItemVO> quotaGoodsItemVOS = goodsMap.get(mallGoods.getId());

            //组装测试项目
            for (QuotaGoodsItemVO quotaGoodsItemVO : quotaGoodsItemVOS) {
                final BasicTestItem basicTestItem = dbItemMap.get(quotaGoodsItemVO.getItemId());
                TestQuotationItem testQuotationItem = new TestQuotationItem();
                testQuotationItem.setTestItem(basicTestItem.getName());
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
        //插入报价单
        testQuotationMapper.insert(record);

        //批量插入报价单下属商品
        for (TestQuotationGoods testQuotationGoods : testQuotationGoodsList) {
            testQuotationGoodsMapper.insert(testQuotationGoods);
        }
        //批量插入报价单下属测试项
        for (TestQuotationItem testQuotationItem : testQuotationItemList) {
            testQuotationItemMapper.insert(testQuotationItem);
        }
    }

    @Override
    public QuotationDetailVO detail(QuotationDetailReq req){
        final TestQuotationExample testQuotationExample = new TestQuotationExample();
        testQuotationExample.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(testQuotationExample);
        if (testQuotations == null){
            throw new ServiceException(HttpStatus.NOT_FOUND,"原报价单不存在");
        }
        final TestQuotation testQuotation = testQuotations.get(0);
        QuotationDetailVO vo = BeanCopyUtil.copy(testQuotation, QuotationDetailVO.class);
        //获取goods
        TestQuotationGoodsExample example = new TestQuotationGoodsExample();
        example.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotationGoods> testQuotationGoods = testQuotationGoodsMapper.selectByExample(example);
        List<QuotaGoodsVO> goodsVOList = new ArrayList<>();
        //获取items
        for (TestQuotationGoods testQuotationGood : testQuotationGoods) {
            final TestQuotationItemExample testQuotationItemExample = new TestQuotationItemExample();
            testQuotationItemExample.createCriteria().andTestQuotationNumEqualTo(req.getQuotationNum())
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
            //开始组装item
            for (TestQuotationItem testQuotationItem : testQuotationItemList) {
                QuotaDetailItemVO itemVO = new QuotaDetailItemVO();
                BeanCopyUtil.copy(testQuotationItem,itemVO);
                itemVOList.add(itemVO);
            }
            quotaGoodsVO.setItems(itemVOList);
            goodsVOList.add(quotaGoodsVO);
        }
        vo.setGoods(goodsVOList);

        //获取加测

        //获取复测

        return vo;
    }



    private int calReportAmt(String report){
        if (report.contains("1") || report.contains("2")){
            if (report.contains("3") || report.contains("4")){
                return 10000;
            }}
        return 0;
    }

    @Override
    public String getRate(){
        return systemParameterMapper.selectByPrimaryKey("TAX_RATE").getParamValue();
    }
}
