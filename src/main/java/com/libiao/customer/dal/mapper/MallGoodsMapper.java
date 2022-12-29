package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.MallGoods;
import com.libiao.customer.dal.model.MallGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    long countByExample(MallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int deleteByExample(MallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int insert(MallGoods row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int insertSelective(MallGoods row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    List<MallGoods> selectByExampleWithBLOBs(MallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    List<MallGoods> selectByExample(MallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    MallGoods selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int updateByExampleSelective(@Param("row") MallGoods row, @Param("example") MallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("row") MallGoods row, @Param("example") MallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int updateByExample(@Param("row") MallGoods row, @Param("example") MallGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int updateByPrimaryKeySelective(MallGoods row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(MallGoods row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_goods
     *
     * @mbg.generated Thu Dec 29 09:41:46 CST 2022
     */
    int updateByPrimaryKey(MallGoods row);
}