package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.work.*;
import com.libiao.customer.service.WorkService;
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
public class WorkServiceImpl implements WorkService {

    //工作单列表
    @Autowired
    private TestWorkOrderMapper testWorkOrderMapper;
    @Autowired
    private TestWorkOrderItemMapper testWorkOrderItemMapper;
    @Autowired
    private TestWorkOrderSampleMapper testWorkOrderSampleMapper;
    @Autowired
    private TestApplicationFormMapper testApplicationFormMapper;
    @Autowired
    private TestApplicationSampleMapper testApplicationSampleMapper;
    @Autowired
    private TestApplicationItemMapper testApplicationItemMapper;
    @Autowired
    private CheckCompanyMapper checkCompanyMapper;
    @Autowired
    private TestInfoMapperExt testInfoMapperExt;
    @Autowired
    private TestOriRecordMapper testOriRecordMapper;
    @Autowired
    private LabInfoMapper labInfoMapper;
    @Autowired
    private DeviceItemRelMapper deviceItemRelMapper;
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    @Autowired
    private TestSubItemMapper testSubItemMapper;
    @Autowired
    private TestRecordSubItemMapper testRecordSubItemMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public PageInfo<TestWorkOrder> list(WorkOrderListReq req){
        TestWorkOrderExample testWorkOrderExample = new TestWorkOrderExample();
        TestWorkOrderExample.Criteria criteria = testWorkOrderExample.createCriteria();
        if (StringUtils.hasLength(req.getWorkOrderNum())){
            criteria.andWorkOrderNumLike(LikeUtil.totalLike(req.getWorkOrderNum()));
        }
        if (StringUtils.hasLength(req.getComName())){
            criteria.andComNameLike(LikeUtil.totalLike(req.getComName()));
        }
        if (req.getSubContract() != null){
            criteria.andSubContractEqualTo(req.getSubContract());
        }
        if (req.getStatus() != null){
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (StringUtils.hasLength(req.getOrderDateStart()) && StringUtils.hasLength(req.getOrderDateEnd())){
            criteria.andOrderDateBetween(DateUtils.stringToDate(req.getOrderDateStart(),"yyyy-MM-dd"),
                    DateUtils.stringToDate(req.getOrderDateEnd(),"yyyy-MM-dd"));
        }
        if (StringUtils.hasLength(req.getPlanDateStart()) && StringUtils.hasLength(req.getPlanDateEnd())){
            criteria.andPlanDateBetween(DateUtils.stringToDate(req.getPlanDateStart(),"yyyy-MM-dd"),
                    DateUtils.stringToDate(req.getPlanDateEnd(),"yyyy-MM-dd"));
        }
        if (StringUtils.hasLength(req.getQuotationNum())){
            criteria.andQuotationNumEqualTo(req.getQuotationNum());
        }
        PageInfo<TestWorkOrder> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        List<TestWorkOrder> testWorkOrders = testWorkOrderMapper.selectByExample(testWorkOrderExample);
        page = new PageInfo<>(testWorkOrders);
        return page;
    }

    //工作单
    @Override
    public WorkOrderVO detail(WorkOrderDetailReq req){
        WorkOrderVO vo = new WorkOrderVO();
        TestWorkOrder testWorkOrder = testWorkOrderMapper.selectByPrimaryKey(req.getId());
        BeanCopyUtil.copy(testWorkOrder,vo);
        TestWorkOrderItemExample example = new TestWorkOrderItemExample();
        example.createCriteria().andTestWorkOrderIdEqualTo(req.getId());
        List<TestWorkOrderItem> testWorkOrderItems = testWorkOrderItemMapper.selectByExample(example);
        List<WorkOrderItemVO> itemVOList = new ArrayList<>(testWorkOrderItems.size());
        testWorkOrderItems.forEach(item->itemVOList.add(BeanCopyUtil.copy(item,WorkOrderItemVO.class)));
        vo.setItemList(itemVOList);
        TestWorkOrderSampleExample sampleExample = new TestWorkOrderSampleExample();
        sampleExample.createCriteria().andTestWorkOrderIdEqualTo(req.getId());
        List<TestWorkOrderSample> testWorkOrderSamples = testWorkOrderSampleMapper.selectByExample(sampleExample);
        List<String> fileList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(testWorkOrderSamples)){
            testWorkOrderSamples.forEach(sample->fileList.add(sample.getFileName()));
        }
        vo.setFileNameList(fileList);
        return vo;
    }

    //确认工作单
    @Override
    @Transactional
    public void confirm(ConfirmWorkOrderReq req){

        TestWorkOrder testWorkOrder = testWorkOrderMapper.selectByPrimaryKey(req.getId());
        if (testWorkOrder == null || 0 != testWorkOrder.getStatus()){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"工作单不存在或者状态不正确");
        }
        TestWorkOrder record = new TestWorkOrder();
        record.setId(req.getId());
        record.setStatus((byte) 1);
        record.setConfirmId(req.getUser().getId());
        testWorkOrderMapper.updateByPrimaryKeySelective(record);

        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(testWorkOrder.getApplicationNum());
        List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(example);
        TestApplicationForm testApplicationForm = testApplicationForms.get(0);

        TestWorkOrderSample sample = new TestWorkOrderSample();
        sample.setTestWorkOrderId(req.getId());
        sample.setFileName(req.getFileName());
        testWorkOrderSampleMapper.insertSelective(sample);

        List<LabInfo> labInfos = labInfoMapper.selectByExample(new LabInfoExample());
        Map<Integer, LabInfo> labMap = labInfos.stream().collect(Collectors.toMap(LabInfo::getId, lab -> lab));

        String dateStr = DateUtils.getCurrentTime("yyyyMMdd");
        //拆分原始记录单
        TestWorkOrderItemExample itemExample = new TestWorkOrderItemExample();
        List<TestWorkOrderItem> testWorkOrderItems = testWorkOrderItemMapper.selectByExample(itemExample);
        for (TestWorkOrderItem testWorkOrderItem : testWorkOrderItems) {

            //创建原始记录单
            String oriRecordNo = redisUtil.getOriRecordNo(dateStr);
            TestOriRecord row = new TestOriRecord();
            row.setRecordNum(oriRecordNo);
            row.setWorkOrderNum(testWorkOrder.getWorkOrderNum());
            row.setQuotationNum(testWorkOrder.getQuotationNum());
            row.setApplicationNum(testWorkOrder.getApplicationNum());
            row.setTestCom(testWorkOrder.getComName());
            row.setTestComId(testWorkOrder.getTestComId());
            row.setTestLabId(testWorkOrderItem.getLabId());
            String labName = labMap.get(testWorkOrderItem.getLabId()).getLabName();
            row.setTestLab(labName);
            row.setTestItem(testWorkOrderItem.getTestItem());
            row.setTestItemId(testWorkOrderItem.getTestItemId());
            //去找到关联设备
            DeviceItemRelExample deviceExample = new DeviceItemRelExample();
            deviceExample.createCriteria().andItemIdEqualTo(testWorkOrderItem.getTestItemId());
            List<DeviceItemRel> deviceItemRels = deviceItemRelMapper.selectByExample(deviceExample);
            StringBuilder name = new StringBuilder();
            StringBuilder no = new StringBuilder();
            for (DeviceItemRel deviceItemRel : deviceItemRels) {
                DeviceInfo deviceInfo = deviceInfoMapper.selectByPrimaryKey(deviceItemRel.getDeviceId());
                name.append(deviceInfo.getDeviceName()).append(",");
                no.append(deviceInfo.getDeviceNo()).append(",");
            }
            row.setTestDeviceName(name.deleteCharAt(name.length()-1).toString());
            row.setTestDeviceNo(no.deleteCharAt(no.length()-1).toString());
            row.setTestMethod(testWorkOrderItem.getTestItemMethod());
            row.setTestCase(testWorkOrderItem.getTestItemCase());
            row.setCreateTime(new Date());
            row.setPlanDate(testWorkOrder.getPlanDate());
            row.setStatus((byte) 0);
            row.setSampleDate(testApplicationForm.getSampleDate());
            testOriRecordMapper.insertSelective(row);
            //确认是否存在测试子项目，存在则记录子项目单
            TestSubItemExample subExample = new TestSubItemExample();
            subExample.createCriteria().andTestItemEqualTo(testWorkOrderItem.getTestItem());
            List<TestSubItem> testSubItems = testSubItemMapper.selectByExample(subExample);
            if (!CollectionUtils.isEmpty(testSubItems)){
                for (TestSubItem testSubItem : testSubItems) {
                    //插入测试子项目
                    TestRecordSubItem subRow = new TestRecordSubItem();
                    subRow.setOriRecordId(row.getId());
                    subRow.setSubTestItem(testSubItem.getSubTestItem());
                    subRow.setCas(testSubItem.getCas());
                    subRow.setLimitValue(testSubItem.getLimitValue());
                    subRow.setUnit(testSubItem.getUnit());
                    testRecordSubItemMapper.insert(subRow);
                }
            }
        }
    }

    //删除工作单
    @Override
    @Transactional
    public void delete(WorkOrderDetailReq req){

        TestWorkOrder testWorkOrder = testWorkOrderMapper.selectByPrimaryKey(req.getId());
        if (testWorkOrder == null || 1 == testWorkOrder.getStatus()){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"工作单不存在或者状态不正确");
        }

        testWorkOrderMapper.deleteByPrimaryKey(req.getId());

        TestWorkOrderItemExample example = new TestWorkOrderItemExample();
        example.createCriteria().andTestWorkOrderIdEqualTo(req.getId());
        testWorkOrderItemMapper.deleteByExample(example);

        TestWorkOrderSampleExample sampleExample = new TestWorkOrderSampleExample();
        sampleExample.createCriteria().andTestWorkOrderIdEqualTo(req.getId());
        testWorkOrderSampleMapper.deleteByExample(sampleExample);

        //将申请单的状态修改为“评审通过”（可重新创建工作单）

        TestApplicationForm appUpdate = new TestApplicationForm();
        appUpdate.setContractStatus((byte) 1);
        TestApplicationFormExample appExample = new TestApplicationFormExample();
        appExample.createCriteria().andApplicationNumEqualTo(testWorkOrder.getApplicationNum());
        testApplicationFormMapper.updateByExampleSelective(appUpdate,appExample);
    }

    /**
     * 手动创建工作单
     *
     */
    @Override
    @Transactional
    public void createWorkOrder(CreateWorkOrderListReq req){

        TestApplicationFormExample appExample = new TestApplicationFormExample();
        appExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(appExample);
        TestApplicationForm testApplicationForm = testApplicationForms.get(0);
        if (1 != testApplicationForm.getContractStatus()) {
            throw new ServiceException(HttpStatus.BAD_REQUEST,"申请单状态不正确");
        }

        TestApplicationSampleExample sampleExample = new TestApplicationSampleExample();
        sampleExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        List<TestApplicationSample> testApplicationSamples = testApplicationSampleMapper.selectByExample(sampleExample);
        Map<Long, TestApplicationSample> sampleMap = testApplicationSamples.stream().collect(Collectors.toMap(TestApplicationSample::getId, sp -> sp));

        TestApplicationItemExample itemExample = new TestApplicationItemExample();
        itemExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        List<TestApplicationItem> testApplicationItems = testApplicationItemMapper.selectByExample(itemExample);
        Map<Integer, TestApplicationItem> itemMap = testApplicationItems.stream().collect(Collectors.toMap(TestApplicationItem::getTestItemId, tt->tt));

        for (CreateWorkOrderVO createWorkOrderVO : req.getOrderList()) {
            //创建工作单

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
            record.setTestComId(createWorkOrderVO.getTestComId());
            record.setComName(createWorkOrderVO.getComName());
            record.setSubContract(createWorkOrderVO.getSubContract());
            record.setClientName(testApplicationForm.getApplicationName());
            record.setSampleStatus(testApplicationForm.getSampleStatus());

            testWorkOrderMapper.insertSelective(record);

            for (CreateWorkOrderItemVO item : createWorkOrderVO.getTestItemList()) {

                TestApplicationItem testApplicationItem = itemMap.get(item.getTestItemId());
                TestApplicationSample testApplicationSample = sampleMap.get(testApplicationItem.getAppSampleId());

                TestWorkOrderItem sampleRow = new TestWorkOrderItem();
                sampleRow.setTestWorkOrderId(record.getId());
                sampleRow.setSampleLocation(testApplicationSample.getSampleName());
                sampleRow.setSampleModel(testApplicationSample.getSampleModel());
                sampleRow.setSampleMaterial(testApplicationSample.getSampleMaterial());
                sampleRow.setSampleDesc(testApplicationSample.getSampleDescription());
                sampleRow.setTestItem(testApplicationItem.getItemName());
                sampleRow.setTestItemId(testApplicationItem.getTestItemId());
                sampleRow.setTestItemMethod(testApplicationItem.getTestMethod());
                sampleRow.setTestItemCase(testApplicationItem.getTestCase());
                sampleRow.setRemark(testApplicationItem.getRemark());
                sampleRow.setLabId(item.getLabId());
                testWorkOrderItemMapper.insertSelective(sampleRow);
            }
        }
    }

    @Override
    public List<CheckCompany> comList(CheckComListReq req){
        CheckCompanyExample example = new CheckCompanyExample();
        example.createCriteria().andComNameLike(LikeUtil.totalLike(req.getComName()));
        List<CheckCompany> checkCompanies = checkCompanyMapper.selectByExample(example);
        return checkCompanies;
    }

    //获得该公司下的能测试的，这个测试项目
    @Override
    public List<CheckItemVO> getComCheckItemList(CheckItemReq req){
        return testInfoMapperExt.getComCheckItemList(req);
    }

}
