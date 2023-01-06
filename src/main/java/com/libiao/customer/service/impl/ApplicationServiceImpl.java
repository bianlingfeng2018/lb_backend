package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.application.*;
import com.libiao.customer.model.quotation.QuotaDetailItemVO;
import com.libiao.customer.service.ApplicationService;
import com.libiao.customer.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TestApplicationFormMapper testApplicationFormMapper;
    @Autowired
    private TestApplicationSampleMapper testApplicationSampleMapper;
    @Autowired
    private TestApplicationItemMapper testApplicationItemMapper;
    @Autowired
    private TestQuotationItemMapper testQuotationItemMapper;
    @Autowired
    private TestQuotationMapper testQuotationMapper;
    @Autowired
    private TestQuotationGoodsMapper testQuotationGoodsMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private TestInfoMapperExt testInfoMapperExt;

    @Override
    public PageInfo<TestApplicationForm> list(ApplicationListReq req){
        PageInfo<TestApplicationForm> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());

        TestApplicationFormExample testApplicationFormExample = new TestApplicationFormExample();
        TestApplicationFormExample.Criteria criteria = testApplicationFormExample.createCriteria();
        if (StringUtils.hasLength(req.getApplicationNum())){
            criteria.andApplicationNumLike("%"+req.getApplicationNum()+"%");
        }
        if (StringUtils.hasLength(req.getApplicationName())){
            criteria.andApplicationNameLike("%" + req.getApplicationName() + "%");
        }
        if (req.getSampleStatus() != null){
            criteria.andSampleStatusEqualTo(req.getSampleStatus());
        }
        if (req.getContractStatus() != null){
            criteria.andContractStatusEqualTo(req.getContractStatus());
        }
        if (StringUtils.hasLength(req.getQuotationNum())){
            criteria.andQuotationNumEqualTo(req.getQuotationNum());
        }
        List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(testApplicationFormExample);
        page = new PageInfo<>(testApplicationForms);
        return page;
    }

    //新增申请单
    @Override
    public void createApplication(AddApplicationReq req){

        TestQuotationExample example = new TestQuotationExample();
        example.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testQuotations)){
            throw new ServiceException(HttpStatus.NOT_FOUND,"对应的报价单不存在");
        }
        final TestQuotation testQuotation = testQuotations.get(0);
        //找到报价单对应的商品单
        TestQuotationGoodsExample goodExample = new TestQuotationGoodsExample();
        goodExample.createCriteria().andQuotationNumEqualTo(req.getQuotationNum()).andGoodsIdEqualTo(req.getGoodsId());
        final List<TestQuotationGoods> testQuotationGoods = testQuotationGoodsMapper.selectByExample(goodExample);
        final TestQuotationGoods testQuotationGoods1 = testQuotationGoods.get(0);


        TestApplicationForm record = new TestApplicationForm();
        BeanCopyUtil.copy(req,record);
        record.setApplicationName(testQuotation.getClientName());
        if (!StringUtils.hasLength(req.getReportTitleCn()) && !StringUtils.hasLength(req.getReportTitleEn())){
            final Client client = clientMapper.selectByPrimaryKey(testQuotation.getClientId());
            record.setReportTitleCn(client.getInvoiceName());
        }

        List<Integer> credentials = req.getCredentials();
        int credential = 0;
        if (!CollectionUtils.isEmpty(credentials)){
            for (Integer integer : credentials) {
                credential = credential | integer;
            }
        }
        //进行位运算
        record.setCredential(credential);
        //生成申请单号 LTI+T+年份后两位+月份+日+ （A-Z）
        String applicationNum = redisUtil.getAppNo(DateUtils.getDate("yyMMdd"));
        record.setApplicationNum(applicationNum);
        record.setApplyPerson(req.getUser().getNickname());
        record.setApplyPersonId(req.getUser().getId());
        record.setService(testQuotationGoods1.getService());
        testApplicationFormMapper.insertSelective(record);

        List<SampleTestReq> sampleList = req.getSampleList();
        if (CollectionUtils.isEmpty(sampleList)){
            return;
        }
        //添加多种样品
        for (SampleTestReq sampleTestReq : sampleList) {
            TestApplicationSample row = new TestApplicationSample();
            BeanCopyUtil.copy(sampleTestReq,row);
            row.setApplicationFormId(record.getId());
            row.setApplicationNum(applicationNum);
            testApplicationSampleMapper.insertSelective(row);
            //添加样品下的测试项目
            List<SampleItemReq> itemList = sampleTestReq.getItemList();
            if (CollectionUtils.isEmpty(itemList)){
                continue;
            }
            for (SampleItemReq sampleItemReq : itemList) {
                TestApplicationItem item = new TestApplicationItem();
                BeanCopyUtil.copy(sampleItemReq,item);
                item.setAppSampleId(row.getId());
                item.setApplicationNum(applicationNum);
                testApplicationItemMapper.insertSelective(item);
            }
        }
    }

    @Override
    public ApplicationDetailVO detail(ApplicationDetailReq req){
        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testApplicationForms)){
            throw new ServiceException(HttpStatus.NOT_FOUND,"申请单不存在");
        }
        TestApplicationForm testApplicationForm = testApplicationForms.get(0);
        ApplicationDetailVO vo = new ApplicationDetailVO();
        BeanCopyUtil.copy(testApplicationForm,vo);
        //转换资质
        Integer credential = testApplicationForm.getCredential();
        List<Integer> serviceString = CredentialByteUtil.getServiceString(credential);
        vo.setCredentials(serviceString);
        //查询其他样品信息
        TestApplicationSampleExample sampleExample = new TestApplicationSampleExample();
        sampleExample.createCriteria().andApplicationFormIdEqualTo(testApplicationForm.getId());
        List<TestApplicationSample> testApplicationSamples = testApplicationSampleMapper.selectByExample(sampleExample);
        if (CollectionUtils.isEmpty(testApplicationSamples)){
            return vo;
        }
        List<SampleTestReq> sampleTestList = new ArrayList<>();
        for (TestApplicationSample testApplicationSample : testApplicationSamples) {
            SampleTestReq row = new SampleTestReq();
            BeanCopyUtil.copy(testApplicationSample,row);
            //查询样品下面的项目
            TestApplicationItemExample itemExample = new TestApplicationItemExample();
            itemExample.createCriteria().andAppSampleIdEqualTo(testApplicationSample.getId());
            List<TestApplicationItem> testApplicationItems = testApplicationItemMapper.selectByExample(itemExample);
            if (!CollectionUtils.isEmpty(testApplicationSamples)){
                List<SampleItemReq> list = new ArrayList<>();
                for (TestApplicationItem testApplicationItem : testApplicationItems) {
                    SampleItemReq item = new SampleItemReq();
                    BeanCopyUtil.copy(testApplicationItem,item);
                    list.add(item);
                }
                row.setItemList(list);
            }
            sampleTestList.add(row);
        }
        vo.setSampleList(sampleTestList);

        TestQuotationItemExample quotItemExample = new TestQuotationItemExample();
        quotItemExample.createCriteria().andTestQuotationNumEqualTo(testApplicationForm.getQuotationNum());
        final List<TestQuotationItem> testQuotationItemList = testQuotationItemMapper.selectByExample(quotItemExample);
        List<QuotaDetailItemVO> itemVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(testQuotationItemList)){
            for (TestQuotationItem testQuotationItem : testQuotationItemList) {
                itemVOList.add(BeanCopyUtil.copy(testQuotationItem,QuotaDetailItemVO.class));
            }
        }
        vo.setItems(itemVOList);
        return vo;
    }

    @Override
    public void modify(ModifyApplicationReq req){
        //找到原来的申请单


        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        final List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testApplicationForms)){
            throw new ServiceException(HttpStatus.NOT_FOUND,"原申请单未找到");
        }
        final TestApplicationForm testApplicationForm = testApplicationForms.get(0);

        TestApplicationForm record = new TestApplicationForm();
        BeanCopyUtil.copy(req,record);
        record.setId(testApplicationForm.getId());
        List<Integer> credentials = req.getCredentials();
        int credential = 0;
        if (!CollectionUtils.isEmpty(credentials)){
            for (Integer integer : credentials) {
                credential = credential | integer;
            }
        }
        //进行位运算
        record.setCredential(credential);

        testApplicationFormMapper.updateByPrimaryKeySelective(record);

        List<SampleTestReq> sampleList = req.getSampleList();
        //删除下属的sample
        TestApplicationSampleExample sampleExample = new TestApplicationSampleExample();
        sampleExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        testApplicationSampleMapper.deleteByExample(sampleExample);
        //删除item
        TestApplicationItemExample itemExample = new TestApplicationItemExample();
        itemExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        testApplicationItemMapper.deleteByExample(itemExample);

        //application_id
        if (CollectionUtils.isEmpty(sampleList)){
            return;
        }
        //添加多种样品
        for (SampleTestReq sampleTestReq : sampleList) {
            TestApplicationSample row = new TestApplicationSample();
            BeanCopyUtil.copy(sampleTestReq,row);
            row.setApplicationFormId(record.getId());
            row.setApplicationNum(req.getApplicationNum());
            testApplicationSampleMapper.insertSelective(row);
            //添加样品下的测试项目
            List<SampleItemReq> itemList = sampleTestReq.getItemList();
            if (CollectionUtils.isEmpty(itemList)){
                continue;
            }
            for (SampleItemReq sampleItemReq : itemList) {
                TestApplicationItem item = new TestApplicationItem();
                BeanCopyUtil.copy(sampleItemReq,item);
                item.setAppSampleId(row.getId());
                item.setApplicationNum(req.getApplicationNum());
                testApplicationItemMapper.insertSelective(item);
            }
        }

    }

    @Override
    public void review(ReviewApplicationReq req){
        TestApplicationForm record = new TestApplicationForm();
        record.setReviewRemark(req.getReason());
        record.setReviewTime(new Date());
        record.setContractStatus(req.getReviewResult());
        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        testApplicationFormMapper.updateByExampleSelective(record,example);
    }

    public void confirm(ApplicationDetailReq req){
        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        final List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testApplicationForms)){
            throw new ServiceException(HttpStatus.NOT_FOUND,"申请单未找到");
        }
        final TestApplicationForm testApplicationForm = testApplicationForms.get(0);

        //找到申请单后，
        //根据申请单下属的测试项目来进行拆分
        TestApplicationItemExample itemExample = new TestApplicationItemExample();
        itemExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        final List<TestApplicationItem> testApplicationItems = testApplicationItemMapper.selectByExample(itemExample);





    }

    //拆工作单
    public void split(List<TestApplicationItem> testApplicationItems, Byte service){
        Set<Integer> itemSet = testApplicationItems.stream().map(TestApplicationItem::getTestItemId).collect(Collectors.toSet());
        final List<SplitInfo> totalSplitInfo = testInfoMapperExt.getTotalSplitInfo();
        Map<Long,List<SplitInfo>> selfSpMap = new HashMap<>();//直属
        Map<Long,List<SplitInfo>> otherSpMap = new HashMap<>();//分包商
        Set<Integer> selfSet = new HashSet<>();

        //1根据测试项目和资质条件，匹配满足条件的公司：测试项目,对应公司
        //2对应公司为内部公司，直接确认测试项目与内部公司的对应关系
        //3检测项目与外部检测公司做排序（按周期或价格排序)
        //4选择每个项目排序最前的的记录，按公司分组；

        for (SplitInfo splitInfo : totalSplitInfo) {
            if (splitInfo.getSubContract() == 0){
                selfSet.add(splitInfo.getItemId());
                if (selfSpMap.containsKey(splitInfo.getId())){
                    selfSpMap.get(splitInfo.getId()).add(splitInfo);
                }else {
                    List<SplitInfo> list = new ArrayList<>();
                    list.add(splitInfo);
                    selfSpMap.put(splitInfo.getId(),list);
                }
            }else {
                if (otherSpMap.containsKey(splitInfo.getId())){
                    otherSpMap.get(splitInfo.getId()).add(splitInfo);
                }else {
                    List<SplitInfo> list = new ArrayList<>();
                    list.add(splitInfo);
                    otherSpMap.put(splitInfo.getId(),list);
                }
            }
        }

        //先找直属的。
        if (selfSet.containsAll(itemSet)){
            //完全走直属的
            //
            //算法
            //第一轮：筛选公司，找到能测的所有集合，如果全包含，挑选结束
            //
            //第二轮：重新筛选一家公司，在从剩下的公司中，找到需要最少的公司组合。组合为2筛选结束
            //
            //第三轮，递归调用，找到符合组合的，即结束。

        }else {
            //直属的
            final Set<Integer> sLabSet = itemSet.stream().filter(selfSet::contains).collect(Collectors.toSet());
            //分包的
            final Set<Integer> oLabSet = itemSet.stream().filter(f->!selfSet.contains(f)).collect(Collectors.toSet());
        }



    }
}
