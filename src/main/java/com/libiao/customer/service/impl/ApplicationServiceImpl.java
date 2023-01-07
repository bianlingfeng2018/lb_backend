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
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    private TestWorkOrderMapper testWorkOrderMapper;
    @Autowired
    private TestWorkOrderItemMapper testWorkOrderItemMapper;
    @Autowired
    private TestWorkOrderSampleMapper testWorkOrderSampleMapper;

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

    @Override
    @Transactional
    public void confirm(ApplicationDetailReq req){
        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        final List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testApplicationForms)){
            throw new ServiceException(HttpStatus.NOT_FOUND,"申请单未找到");
        }
        final TestApplicationForm testApplicationForm = testApplicationForms.get(0);
        if (testApplicationForm.getContractStatus() != 1){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"申请单状态不正确");
        }

        //找到申请单后，
        //根据申请单下属的测试项目来进行拆分
        TestApplicationItemExample itemExample = new TestApplicationItemExample();
        itemExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        final List<TestApplicationItem> testApplicationItems = testApplicationItemMapper.selectByExample(itemExample);

        List<SplitInfo> split = split(testApplicationItems, testApplicationForm.getService());
        if (CollectionUtils.isEmpty(split)){
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR,"工作拆单异常，请检查基础信息");
        }

        Map<Integer, List<SplitInfo>> comMap = split.stream().collect(Collectors.groupingBy(SplitInfo::getId));
        for (Map.Entry<Integer, List<SplitInfo>> comEntry : comMap.entrySet()) {
            List<SplitInfo> splits = comEntry.getValue();
            List<Integer> sItems = new ArrayList<>();
            int maxPeriod = 0;
            for (SplitInfo splitInfo : splits) {
                sItems.add(splitInfo.getItemId());
                maxPeriod = maxPeriod > splitInfo.getPeriod() ? maxPeriod:splitInfo.getPeriod();
            }
            Map<Integer, SplitInfo> splitMap = splits.stream().collect(Collectors.toMap(SplitInfo::getItemId, s -> s));
            //进行拆单
            TestWorkOrder record = new TestWorkOrder();
            //工作单编号：LTI+T/I/C+W+年份后两位+月份+日+ （A-Z）+ 三位
            String workOrderNum = redisUtil.getWorkNo(DateUtils.getDate("yyyyMMdd"));
            record.setWorkOrderNum(workOrderNum);
            record.setQuotationNum(testApplicationForm.getQuotationNum());
            record.setApplicationNum(testApplicationForm.getApplicationNum());
            Calendar instance = Calendar.getInstance();
            record.setCreateTime(instance.getTime());

            instance.add(Calendar.DATE,1);
            record.setPlanDate(instance.getTime());

            //TODO 开单日期

            record.setService(testApplicationForm.getService());
            record.setTestComId(comEntry.getKey());
            record.setComName(splits.get(0).getComName());
            record.setSubContract(splits.get(0).getSubContract());
            record.setClientName(testApplicationForm.getApplicationName());
            record.setSampleStatus(testApplicationForm.getSampleStatus());

            testWorkOrderMapper.insertSelective(record);
            //确认该工作单涉及的item所涉及的样品

            TestApplicationItemExample iExample = new TestApplicationItemExample();
            iExample.createCriteria().andTestItemIdIn(sItems).andApplicationNumEqualTo(testApplicationForm.getApplicationNum());
            List<TestApplicationItem> appItemsList = testApplicationItemMapper.selectByExample(iExample);
            //有了样本ID
            Map<Long, List<TestApplicationItem>> collect = appItemsList.stream().collect(Collectors.groupingBy(TestApplicationItem::getAppSampleId));
            //插入工作单样本信息
            for (Map.Entry<Long, List<TestApplicationItem>> sample : collect.entrySet()) {
                //查询样本信息
                TestApplicationSample testApplicationSample = testApplicationSampleMapper.selectByPrimaryKey(sample.getKey());

                TestWorkOrderItem sampleRow = new TestWorkOrderItem();
                sampleRow.setTestWorkOrderId(record.getId());
                sampleRow.setSampleLocation(testApplicationSample.getSampleName());
                sampleRow.setSampleModel(testApplicationSample.getSampleModel());
                sampleRow.setSampleMaterial(testApplicationSample.getSampleMaterial());
                sampleRow.setSampleDesc(testApplicationSample.getSampleDescription());

                for (TestApplicationItem testApplicationItem : sample.getValue()) {

                    SplitInfo splitInfo = splitMap.get(testApplicationItem.getTestItemId());

                    sampleRow.setTestItem(testApplicationItem.getItemName());
                    sampleRow.setTestItemId(testApplicationItem.getTestItemId());
                    sampleRow.setTestItemMethod(testApplicationItem.getTestMethod());
                    sampleRow.setTestItemCase(testApplicationItem.getTestCase());
                    sampleRow.setRemark(testApplicationItem.getRemark());
                    sampleRow.setLabId(splitInfo.getLabId());
                    testWorkOrderItemMapper.insertSelective(sampleRow);
                }
            }

            TestApplicationForm update = new TestApplicationForm();
            update.setId(testApplicationForm.getId());
            update.setContractStatus((byte) 3);
            update.setSampleDate(new Date());
            testApplicationFormMapper.updateByPrimaryKeySelective(update);
        }
    }

    //拆工作单
    public List<SplitInfo> split(List<TestApplicationItem> testApplicationItems, Byte service){
        Set<Integer> itemSet = testApplicationItems.stream().map(TestApplicationItem::getTestItemId).collect(Collectors.toSet());
        final List<SplitInfo> totalSplitInfo = testInfoMapperExt.getTotalSplitInfo();
        Map<Integer,List<SplitInfo>> selfSpMap = new HashMap<>();//直属
        Map<Integer,List<SplitInfo>> otherSpMap = new HashMap<>();//分包商
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
        List<SplitInfo> comIds = new ArrayList<>();

        //先找直属的。
        if (selfSet.containsAll(itemSet)){
            //完全走直属的
            //
            //算法
            //第一轮：筛选公司，找到能测的所有集合，如果全包含，挑选结束
            for (Map.Entry<Integer, List<SplitInfo>> spEntry : selfSpMap.entrySet()) {
                Set<Integer> spSet = spEntry.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                if (spSet.containsAll(itemSet)){
                    //返回公司ID
                    //comIds.add(spEntry.getKey());
                    for (SplitInfo splitInfo : spEntry.getValue()) {
                        if (itemSet.contains(splitInfo.getItemId())){
                            comIds.add(splitInfo);
                        }
                    }
                    return comIds;
                }
            }
            //
            //第二轮：重新筛选一家公司，在从剩下的公司中，找到需要最少的公司组合。组合为2筛选结束
            for (Map.Entry<Integer, List<SplitInfo>> spEntry : selfSpMap.entrySet()) {
                Set<Integer> spSet = spEntry.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                //获取剩余的
                Set<Integer> otherSet = itemSet.stream().filter(f -> !spSet.contains(f)).collect(Collectors.toSet());
                for (Map.Entry<Integer, List<SplitInfo>> subSpSet : selfSpMap.entrySet()) {
                    Set<Integer> sss = subSpSet.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                    if (sss.containsAll(otherSet)){
                        //返回2个公司ID
                        /*comIds.add(spEntry.getKey());
                        comIds.add(subSpSet.getKey());*/
                        for (SplitInfo splitInfo : spEntry.getValue()) {
                            if (spSet.contains(splitInfo.getItemId())){
                                comIds.add(splitInfo);
                            }
                        }
                        for (SplitInfo splitInfo : subSpSet.getValue()) {
                            if (otherSet.contains(splitInfo.getItemId())){
                                comIds.add(splitInfo);
                            }
                        }
                        return comIds;
                    }
                }
            }
            //
            //第三轮，修改算法用itemSet来匹配递归
            //先排序 ,公司 和 所匹配到的项目多少
            List<ComMatch> matches = new ArrayList<>();
            for (Map.Entry<Integer, List<SplitInfo>> spEntry : selfSpMap.entrySet()) {
                Set<Integer> spSet = spEntry.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                //获取交集
                int size = spSet.stream().filter(itemSet::contains).collect(Collectors.toSet()).size();
                matches.add(new ComMatch(size, spEntry.getKey()));
            }
            //排序后递归
            matches.sort(Comparator.comparingInt(o -> o.size));
            //每次将itemSet中的去掉一点。
            Set<Integer> tempItemSet = itemSet;
            for (ComMatch match : matches) {
                List<SplitInfo> splitInfos = selfSpMap.get(match.getId());
                Set<Integer> sSet = splitInfos.stream().map(SplitInfo::getItemId).collect(Collectors.toSet());

                for (SplitInfo splitInfo : splitInfos) {
                    if (tempItemSet.contains(splitInfo.getItemId())){
                        comIds.add(splitInfo);
                    }
                }

                tempItemSet = tempItemSet.stream().filter(f->!sSet.contains(f)).collect(Collectors.toSet());
                if (CollectionUtils.isEmpty(tempItemSet)){
                    return comIds;
                }
            }

        }else {
            //直属的
            final Set<Integer> sLabSet = itemSet.stream().filter(selfSet::contains).collect(Collectors.toSet());

            List<ComMatch> matches = new ArrayList<>();
            for (Map.Entry<Integer, List<SplitInfo>> spEntry : selfSpMap.entrySet()) {
                Set<Integer> spSet = spEntry.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                //获取交际值
                int size = spSet.stream().filter(itemSet::contains).collect(Collectors.toSet()).size();
                matches.add(new ComMatch(size, spEntry.getKey()));
            }
            //排序后递归
            matches.sort(Comparator.comparingInt(o -> o.size));
            //每次将itemSet中的去掉一点。
            Set<Integer> tempItemSet = sLabSet;
            for (ComMatch match : matches) {
                List<SplitInfo> splitInfos = selfSpMap.get(match.getId());
                Set<Integer> sSet = splitInfos.stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                for (SplitInfo splitInfo : splitInfos) {
                    if (tempItemSet.contains(splitInfo.getItemId())){
                        comIds.add(splitInfo);
                    }
                }
                tempItemSet = tempItemSet.stream().filter(f->!sSet.contains(f)).collect(Collectors.toSet());
                if (CollectionUtils.isEmpty(tempItemSet)){
                    break;
                }
            }

            //分包的
            final Set<Integer> oLabSet = itemSet.stream().filter(f->!selfSet.contains(f)).collect(Collectors.toSet());
            Map<Integer,SplitInfo> map = new HashMap<>();
            if (service > 0){
                //按周期
                for (Map.Entry<Integer, List<SplitInfo>> oEntry : otherSpMap.entrySet()) {
                    for (SplitInfo splitInfo : oEntry.getValue()) {
                        if (oLabSet.contains(splitInfo.getItemId())){
                            SplitInfo ori = map.get(splitInfo.getItemId());
                            if (ori.getPeriod() > splitInfo.getPeriod()){
                                map.put(splitInfo.getItemId(),splitInfo);
                            }
                        }else {
                            map.put(splitInfo.getItemId(),splitInfo);
                        }
                    }
                }
            }else {
                //按价格
                for (Map.Entry<Integer, List<SplitInfo>> oEntry : otherSpMap.entrySet()) {
                    for (SplitInfo splitInfo : oEntry.getValue()) {
                        if (oLabSet.contains(splitInfo.getItemId())){
                            SplitInfo ori = map.get(splitInfo.getItemId());
                            if (ori.getPrice() > splitInfo.getPrice()){
                                map.put(splitInfo.getItemId(),splitInfo);
                            }
                        }else {
                            map.put(splitInfo.getItemId(),splitInfo);
                        }
                    }
                }
            }
            //获取集合后
            Map<Integer, List<SplitInfo>> collect = map.values().stream().collect(Collectors.groupingBy(SplitInfo::getId));
            for (List<SplitInfo> value : collect.values()) {
                comIds.addAll(value);
            }
        }
        return comIds;
    }

    static class ComMatch {
        private final int size;
        private final long id;

        public ComMatch(int size, long id) {
            this.size = size;
            this.id = id;
        }

        public int getSize() {
            return size;
        }

        public long getId() {
            return id;
        }
    }
}
