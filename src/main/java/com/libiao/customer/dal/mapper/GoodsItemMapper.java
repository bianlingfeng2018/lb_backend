package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.GoodsItem;
import com.libiao.customer.dal.model.GoodsItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_item
     *
     * @mbg.generated Thu Dec 29 09:42:15 CST 2022
     */
    long countByExample(GoodsItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_item
     *
     * @mbg.generated Thu Dec 29 09:42:15 CST 2022
     */
    int deleteByExample(GoodsItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_item
     *
     * @mbg.generated Thu Dec 29 09:42:15 CST 2022
     */
    int deleteByPrimaryKey(@Param("goodsId") Long goodsId, @Param("itemId") Integer itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_item
     *
     * @mbg.generated Thu Dec 29 09:42:15 CST 2022
     */
    int insert(GoodsItem row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_item
     *
     * @mbg.generated Thu Dec 29 09:42:15 CST 2022
     */
    int insertSelective(GoodsItem row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_item
     *
     * @mbg.generated Thu Dec 29 09:42:15 CST 2022
     */
    List<GoodsItem> selectByExample(GoodsItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_item
     *
     * @mbg.generated Thu Dec 29 09:42:15 CST 2022
     */
    int updateByExampleSelective(@Param("row") GoodsItem row, @Param("example") GoodsItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_item
     *
     * @mbg.generated Thu Dec 29 09:42:15 CST 2022
     */
    int updateByExample(@Param("row") GoodsItem row, @Param("example") GoodsItemExample example);
}