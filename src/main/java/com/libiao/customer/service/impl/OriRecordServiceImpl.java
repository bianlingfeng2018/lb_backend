package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestOriRecordMapper;
import com.libiao.customer.dal.mapper.TestRecordSubItemMapper;
import com.libiao.customer.dal.model.TestOriRecord;
import com.libiao.customer.dal.model.TestOriRecordExample;
import com.libiao.customer.dal.model.TestRecordSubItem;
import com.libiao.customer.dal.model.TestRecordSubItemExample;
import com.libiao.customer.model.ori.*;
import com.libiao.customer.service.OriRecordService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.LikeUtil;
import com.libiao.customer.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Override
    public void review(ReviewOriRecordReq req){
        final TestOriRecord testOriRecord = testOriRecordMapper.selectByPrimaryKey(req.getId());
        if (testOriRecord == null || 1 != testOriRecord.getStatus()){
            throw new ServiceException(HttpStatus.NOT_FOUND,"原始记录单未找到，或状态不正确");
        }
        TestOriRecord update = new TestOriRecord();
        update.setId(req.getId());
        update.setStatus(req.getStatus());
        update.setReviewId(req.getUser().getId());
        update.setReviewName(req.getUser().getNickname());
        update.setReviewReason(req.getReviewReason());
        testOriRecordMapper.updateByPrimaryKeySelective(update);
    }
}
