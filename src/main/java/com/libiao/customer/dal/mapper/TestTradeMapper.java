package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestTrade;
import java.util.List;

public interface TestTradeMapper {

    /**
     * 删除检测交易
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入检测交易
     * @param row
     * @return
     */
    int insert(TestTrade row);

    /**
     * 根据检测交易ID选择检测交易
     * @param id
     * @return
     */
    TestTrade selectByPrimaryKey(Long id);

    /**
     * 选择所有检测交易
     * @return
     */
    List<TestTrade> selectAll();

    /**
     * 根据检测交易的id，更新检测交易
     * @param row
     * @return
     */
    int updateByPrimaryKey(TestTrade row);

    /**
     * 通过负责人，查询所有的检测交易
     * @param owner
     * @return
     */
    List<TestTrade> selectAllByOwner(String owner);
}