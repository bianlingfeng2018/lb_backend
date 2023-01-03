package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestOriRecordMapper;
import com.libiao.customer.dal.mapper.TestRecordSubItemMapper;
import com.libiao.customer.dal.model.TestOriRecord;
import com.libiao.customer.dal.model.TestOriRecordExample;
import com.libiao.customer.dal.model.TestRecordSubItem;
import com.libiao.customer.dal.model.TestRecordSubItemExample;
import com.libiao.customer.model.ori.OriRecordDetailReq;
import com.libiao.customer.model.ori.OriRecordDetailVO;
import com.libiao.customer.model.ori.OriRecordListReq;
import com.libiao.customer.model.ori.OriRecordSubItemVO;
import com.libiao.customer.service.OriRecordService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.LikeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class OriRecordServiceImpl implements OriRecordService {

    @Autowired
    private TestOriRecordMapper testOriRecordMapper;
    @Autowired
    private TestRecordSubItemMapper testRecordSubItemMapper;

    @Override
    public PageInfo<TestOriRecord> list(OriRecordListReq req){
        PageInfo<TestOriRecord> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        TestOriRecordExample example = new TestOriRecordExample();
        final TestOriRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasLength(req.getRecordNum())){
            criteria.andRecordNumLike(LikeUtil.totalLike(req.getRecordNum()));
        }
        if (req.getStatus() != null){
            criteria.andStatusEqualTo(req.getStatus());
        }
        final List<TestOriRecord> testOriRecords = testOriRecordMapper.selectByExample(example);
        page = new PageInfo<>(testOriRecords);
        return page;
    }

    @Override
    public OriRecordDetailVO detail(OriRecordDetailReq req){
        OriRecordDetailVO vo = new OriRecordDetailVO();
        final TestOriRecord testOriRecord = testOriRecordMapper.selectByPrimaryKey(req.getId());
        BeanCopyUtil.copy(testOriRecord,vo);
        //查找子项目
        TestRecordSubItemExample example = new TestRecordSubItemExample();
        example.createCriteria().andOriRecordIdEqualTo(req.getId());
        final List<TestRecordSubItem> testRecordSubItems = testRecordSubItemMapper.selectByExample(example);
        List<OriRecordSubItemVO> subItemVOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(testRecordSubItems)){
            testRecordSubItems.forEach(sub->subItemVOS.add(BeanCopyUtil.copy(sub,OriRecordSubItemVO.class)));
        }
        vo.setSubList(subItemVOS);
        return vo;
    }
}
