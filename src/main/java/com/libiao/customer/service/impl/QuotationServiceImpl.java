package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.constant.QuotationEnum;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.quotation.CreateQuotaGoodsReqVO;
import com.libiao.customer.model.quotation.CreateQuotationReq;
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
        int trans_amount = 0;
        for (CreateQuotaGoodsReqVO goods : req.getGoods()) {
            trans_amount += goods.getTestPrice();
            goods.getItems().forEach(item->{
                //项目
                itemMap.put(item.getItemId(), item.getQuantity());
            });
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
        redisUtil.getNo(DateUtils.getDate("yyyyMMdd"));

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
