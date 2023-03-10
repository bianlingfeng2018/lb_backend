package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.User;
import com.libiao.customer.dal.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int insert(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int insertSelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    List<User> selectByExampleWithBLOBs(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("row") User row, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int updateByExample(@Param("row") User row, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int updateByPrimaryKeySelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Wed Dec 28 14:31:01 CST 2022
     */
    int updateByPrimaryKey(User row);
}