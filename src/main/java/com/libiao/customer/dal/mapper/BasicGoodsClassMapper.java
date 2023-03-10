package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicGoodsClass;
import com.libiao.customer.dal.model.BasicGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasicGoodsClassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    long countByExample(BasicGoodsClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    int deleteByExample(BasicGoodsClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    int insert(BasicGoodsClass row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    int insertSelective(BasicGoodsClass row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    List<BasicGoodsClass> selectByExample(BasicGoodsClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    BasicGoodsClass selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    int updateByExampleSelective(@Param("row") BasicGoodsClass row, @Param("example") BasicGoodsClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    int updateByExample(@Param("row") BasicGoodsClass row, @Param("example") BasicGoodsClassExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    int updateByPrimaryKeySelective(BasicGoodsClass row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic_goods_class
     *
     * @mbg.generated Fri Jan 06 16:36:53 CST 2023
     */
    int updateByPrimaryKey(BasicGoodsClass row);
}