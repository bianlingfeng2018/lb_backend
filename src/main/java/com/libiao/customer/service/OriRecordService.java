package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestOriRecord;
import com.libiao.customer.model.ori.OriRecordDetailReq;
import com.libiao.customer.model.ori.OriRecordDetailVO;
import com.libiao.customer.model.ori.OriRecordListReq;

public interface OriRecordService {
    PageInfo<TestOriRecord> list(OriRecordListReq req);

    OriRecordDetailVO detail(OriRecordDetailReq req);
}
