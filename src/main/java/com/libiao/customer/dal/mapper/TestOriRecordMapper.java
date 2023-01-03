package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestOriRecord;
import com.libiao.customer.dal.model.TestOriRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestOriRecordMapper {
    long countByExample(TestOriRecordExample example);

    int deleteByExample(TestOriRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestOriRecord row);

    int insertSelective(TestOriRecord row);

    List<TestOriRecord> selectByExample(TestOriRecordExample example);

    TestOriRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestOriRecord row, @Param("example") TestOriRecordExample example);

    int updateByExample(@Param("row") TestOriRecord row, @Param("example") TestOriRecordExample example);

    int updateByPrimaryKeySelective(TestOriRecord row);

    int updateByPrimaryKey(TestOriRecord row);
}