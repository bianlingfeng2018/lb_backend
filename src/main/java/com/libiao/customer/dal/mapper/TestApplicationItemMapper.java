package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestApplicationItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestApplicationItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestApplicationItem row);

    TestApplicationItem selectByPrimaryKey(Long id);

    List<TestApplicationItem> selectAll();

    List<TestApplicationItem> selectByTestApplicationFormId(Long testApplicationFormId);

    int updateByPrimaryKey(TestApplicationItem row);

    int batchInsert(@Param("testApplicationItemList") List<TestApplicationItem> testApplicationItemList);



}