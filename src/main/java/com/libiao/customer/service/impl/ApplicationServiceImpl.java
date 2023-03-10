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

    //???????????????
    @Override
    public void createApplication(AddApplicationReq req){

        TestQuotationExample example = new TestQuotationExample();
        example.createCriteria().andQuotationNumEqualTo(req.getQuotationNum());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testQuotations)){
            throw new ServiceException(HttpStatus.NOT_FOUND,"???????????????????????????");
        }
        final TestQuotation testQuotation = testQuotations.get(0);
        //?????????????????????????????????
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
        //???????????????
        record.setCredential(credential);
        //?????????????????? LTI+T+???????????????+??????+???+ ???A-Z???
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
        //??????????????????
        for (SampleTestReq sampleTestReq : sampleList) {
            TestApplicationSample row = new TestApplicationSample();
            BeanCopyUtil.copy(sampleTestReq,row);
            row.setApplicationFormId(record.getId());
            row.setApplicationNum(applicationNum);
            testApplicationSampleMapper.insertSelective(row);
            //??????????????????????????????
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
            throw new ServiceException(HttpStatus.NOT_FOUND,"??????????????????");
        }
        TestApplicationForm testApplicationForm = testApplicationForms.get(0);
        ApplicationDetailVO vo = new ApplicationDetailVO();
        BeanCopyUtil.copy(testApplicationForm,vo);
        //????????????
        Integer credential = testApplicationForm.getCredential();
        List<Integer> serviceString = CredentialByteUtil.getServiceString(credential);
        vo.setCredentials(serviceString);
        //????????????????????????
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
            //???????????????????????????
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
        //????????????????????????


        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        final List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testApplicationForms)){
            throw new ServiceException(HttpStatus.NOT_FOUND,"?????????????????????");
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
        //???????????????
        record.setCredential(credential);

        testApplicationFormMapper.updateByPrimaryKeySelective(record);

        List<SampleTestReq> sampleList = req.getSampleList();
        //???????????????sample
        TestApplicationSampleExample sampleExample = new TestApplicationSampleExample();
        sampleExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        testApplicationSampleMapper.deleteByExample(sampleExample);
        //??????item
        TestApplicationItemExample itemExample = new TestApplicationItemExample();
        itemExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        testApplicationItemMapper.deleteByExample(itemExample);

        //application_id
        if (CollectionUtils.isEmpty(sampleList)){
            return;
        }
        //??????????????????
        for (SampleTestReq sampleTestReq : sampleList) {
            TestApplicationSample row = new TestApplicationSample();
            BeanCopyUtil.copy(sampleTestReq,row);
            row.setApplicationFormId(record.getId());
            row.setApplicationNum(req.getApplicationNum());
            testApplicationSampleMapper.insertSelective(row);
            //??????????????????????????????
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
            throw new ServiceException(HttpStatus.NOT_FOUND,"??????????????????");
        }
        final TestApplicationForm testApplicationForm = testApplicationForms.get(0);
        if (testApplicationForm.getContractStatus() != 1){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"????????????????????????");
        }

        //?????????????????????
        //???????????????????????????????????????????????????
        TestApplicationItemExample itemExample = new TestApplicationItemExample();
        itemExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        final List<TestApplicationItem> testApplicationItems = testApplicationItemMapper.selectByExample(itemExample);

        List<SplitInfo> split = split(testApplicationItems, testApplicationForm.getService());
        if (CollectionUtils.isEmpty(split)){
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR,"??????????????????????????????????????????");
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
            //????????????
            TestWorkOrder record = new TestWorkOrder();
            //??????????????????LTI+T/I/C+W+???????????????+??????+???+ ???A-Z???+ ??????
            String workOrderNum = redisUtil.getWorkNo(DateUtils.getDate("yyyyMMdd"));
            record.setWorkOrderNum(workOrderNum);
            record.setQuotationNum(testApplicationForm.getQuotationNum());
            record.setApplicationNum(testApplicationForm.getApplicationNum());
            Calendar instance = Calendar.getInstance();
            record.setCreateTime(instance.getTime());

            instance.add(Calendar.DATE,maxPeriod);
            record.setPlanDate(instance.getTime());
            record.setCreateName(testApplicationForm.getApplyPerson());
            record.setOrderDate(new Date());
            record.setService(testApplicationForm.getService());
            record.setTestComId(comEntry.getKey());
            record.setComName(splits.get(0).getComName());
            record.setSubContract(splits.get(0).getSubContract());
            record.setClientName(testApplicationForm.getApplicationName());
            record.setSampleStatus(testApplicationForm.getSampleStatus());

            testWorkOrderMapper.insertSelective(record);
            //???????????????????????????item??????????????????

            TestApplicationItemExample iExample = new TestApplicationItemExample();
            iExample.createCriteria().andTestItemIdIn(sItems).andApplicationNumEqualTo(testApplicationForm.getApplicationNum());
            List<TestApplicationItem> appItemsList = testApplicationItemMapper.selectByExample(iExample);
            //????????????ID
            Map<Long, List<TestApplicationItem>> collect = appItemsList.stream().collect(Collectors.groupingBy(TestApplicationItem::getAppSampleId));
            //???????????????????????????
            for (Map.Entry<Long, List<TestApplicationItem>> sample : collect.entrySet()) {
                //??????????????????
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

    //????????????
    public List<SplitInfo> split(List<TestApplicationItem> testApplicationItems, Byte service){
        Set<Integer> itemSet = testApplicationItems.stream().map(TestApplicationItem::getTestItemId).collect(Collectors.toSet());
        final List<SplitInfo> totalSplitInfo = testInfoMapperExt.getTotalSplitInfo();
        Map<Integer,List<SplitInfo>> selfSpMap = new HashMap<>();//??????
        Map<Integer,List<SplitInfo>> otherSpMap = new HashMap<>();//?????????
        Set<Integer> selfSet = new HashSet<>();

        //1??????????????????????????????????????????????????????????????????????????????,????????????
        //2????????????????????????????????????????????????????????????????????????????????????
        //3?????????????????????????????????????????????????????????????????????)
        //4???????????????????????????????????????????????????????????????

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

        //??????????????????
        if (selfSet.containsAll(itemSet)){
            //??????????????????
            //
            //??????
            //???????????????????????????????????????????????????????????????????????????????????????
            for (Map.Entry<Integer, List<SplitInfo>> spEntry : selfSpMap.entrySet()) {
                Set<Integer> spSet = spEntry.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                if (spSet.containsAll(itemSet)){
                    //????????????ID
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
            //???????????????????????????????????????????????????????????????????????????????????????????????????????????????2????????????
            for (Map.Entry<Integer, List<SplitInfo>> spEntry : selfSpMap.entrySet()) {
                Set<Integer> spSet = spEntry.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                //???????????????
                Set<Integer> otherSet = itemSet.stream().filter(f -> !spSet.contains(f)).collect(Collectors.toSet());
                for (Map.Entry<Integer, List<SplitInfo>> subSpSet : selfSpMap.entrySet()) {
                    Set<Integer> sss = subSpSet.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                    if (sss.containsAll(otherSet)){
                        //??????2?????????ID
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
            //???????????????????????????itemSet???????????????
            //????????? ,?????? ??? ???????????????????????????
            List<ComMatch> matches = new ArrayList<>();
            for (Map.Entry<Integer, List<SplitInfo>> spEntry : selfSpMap.entrySet()) {
                Set<Integer> spSet = spEntry.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                //????????????
                int size = spSet.stream().filter(itemSet::contains).collect(Collectors.toSet()).size();
                matches.add(new ComMatch(size, spEntry.getKey()));
            }
            //???????????????
            matches.sort(Comparator.comparingInt(o -> o.size));
            //?????????itemSet?????????????????????
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
            //?????????
            final Set<Integer> sLabSet = itemSet.stream().filter(selfSet::contains).collect(Collectors.toSet());

            List<ComMatch> matches = new ArrayList<>();
            for (Map.Entry<Integer, List<SplitInfo>> spEntry : selfSpMap.entrySet()) {
                Set<Integer> spSet = spEntry.getValue().stream().map(SplitInfo::getItemId).collect(Collectors.toSet());
                //???????????????
                int size = spSet.stream().filter(itemSet::contains).collect(Collectors.toSet()).size();
                matches.add(new ComMatch(size, spEntry.getKey()));
            }
            //???????????????
            matches.sort(Comparator.comparingInt(o -> o.size));
            //?????????itemSet?????????????????????
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

            //?????????
            final Set<Integer> oLabSet = itemSet.stream().filter(f->!selfSet.contains(f)).collect(Collectors.toSet());
            Map<Integer,SplitInfo> map = new HashMap<>();
            if (service > 0){
                //?????????
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
                //?????????
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
            //???????????????
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
