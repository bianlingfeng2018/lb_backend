package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestOriRecord;
import com.libiao.customer.model.ori.*;

public interface OriRecordService {
    PageInfo<TestOriRecord> list(OriRecordListReq req);

    OriRecordDetailVO detail(OriRecordDetailReq req);

    void review(ReviewOriRecordReq req);

    //更新原始记录单，首先获取测试类型和对应的参数
    //根据test_item_id
    TestItemInfoVO testInfo(TestItemInfoReq req);

    void upload(UploadTestResultReq req);
}
