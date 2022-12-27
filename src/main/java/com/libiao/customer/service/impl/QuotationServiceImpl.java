package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.constant.QuotationEnum;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.quotation.CreateQuotaGoodsReqVO;
import com.libiao.customer.model.quotation.CreateQuotationReq;
import com.libiao.customer.model.quotation.QuotaGoodsItemVO;
import com.libiao.customer.model.quotation.QuotationListReq;
import com.libiao.customer.service.QuotationService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.DateUtils;
import com.libiao.customer.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

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


    public void create(CreateQuotationReq req){
        //获取所有测试项目
        Map<Integer,Integer> itemMap = new HashMap<>();
        Map<Long,List<Integer>> goodsMap = new HashMap<>();
        int trans_amount = 0;
        for (CreateQuotaGoodsReqVO goods : req.getGoods()) {
            trans_amount += goods.getTestPrice();
            List<Integer> itemsIds = new ArrayList<>();
            for (QuotaGoodsItemVO item : goods.getItems()) {
                itemMap.put(item.getItemId(), item.getQuantity());
                itemsIds.add(item.getItemId());
            }
            goodsMap.put(goods.getGoodsId(),itemsIds);
        }
        //计算折扣前的总金额
        final Set<Integer> itemIds = itemMap.keySet();
        final BasicTestItemExample basicTestItemExample = new BasicTestItemExample();
        basicTestItemExample.createCriteria().andIdIn(new ArrayList<>(itemIds));
        final List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(basicTestItemExample);
        int amount = 0;
        for (BasicTestItem item : basicTestItems) {
            amount += item.getPrice() * itemMap.get(item.getId());
        }
        //然后再对比实际的金额来计算折扣 报价/基本售价 = 折扣
        final BigDecimal discount = new BigDecimal(trans_amount).multiply(new BigDecimal(100)).divide(new BigDecimal(amount)).setScale(0, RoundingMode.HALF_UP);
        int dis = discount.intValue();
        TestQuotation record = new TestQuotation();
        BeanCopyUtil.copy(req,record);
        record.setDiscount(String.valueOf(dis));
        if (dis < req.getUser().getDiscount()){
            //状态设置为待审核
            record.setState(QuotationEnum.STEP_QUOT_CHECK.getCode());
            record.setStep(QuotationEnum.STEP_QUOT_CHECK.getCode());
        }else {
            //状态设置为报价审核通过
            record.setState(QuotationEnum.STEP_QUOT_CHECKED.getCode());
            record.setStep(QuotationEnum.STEP_QUOT_CHECKED.getCode());
        }

        //生产报价单号
        String quotNo = redisUtil.getNo(DateUtils.getDate("yyyyMMdd"));
        record.setQuotationNum(quotNo);

        MallGoods mallGoods = mallGoodsMapper.selectByPrimaryKey(1L);
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

        StringBuilder sb = new StringBuilder();
        for(Integer str : req.getGoods().get(0).getReportTypes()){
            sb.append(str).append(",");
        }
        String result3 = sb.deleteCharAt(sb.length()-1).toString();
        testQuotationGoods.setReprotType(result3);
        testQuotationGoods.setOrgPrice(Integer.parseInt(mallGoods.getPrice()));
        //TODO 根据勾选的报告类型添加报告费
        testQuotationGoods.setReportAmt(0);
        //对应下属测试项目组装
        //
        //quotation_idbigint(20) unsigned NOT NULL
        //goods_idbigint(20) NOT NULL
        //goods_namevarchar(100) NULL产品名称
        //hs_codevarchar(100) NULL
        //materialvarchar(100) NULL材质
        //export_countryvarchar(100) NULL出口国
        //standardvarchar(100) NULL检测标准
        //test_periodint(11) NULL测试周期
        //sample_numvarchar(100) NULL样品数量
        //servicetinyint(4) NULL0普通 1加急 2特级
        //amountint(11) NULL费用
        //reprot_typevarchar(100) NULL报告类型
        //org_priceint(11) NULL定价
        //discountint(11) NULL折扣
        //report_amtint(11) NULL报告费

        //插入报价单
        testQuotationMapper.insert(record);




        /*//插入报价单下属商品
        testQuotationGoodsMapper.insert(goods);

        //插入报价单下属测试项
        testQuotationItemMapper.insert(itmes);*/

    }

    @Override
    public String getRate(){
        return systemParameterMapper.selectByPrimaryKey("TAX_RATE").getParamValue();
    }
}
