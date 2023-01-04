package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.CheckCompany;
import com.libiao.customer.dal.model.CheckCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckCompanyMapper {
    long countByExample(CheckCompanyExample example);

    int deleteByExample(CheckCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CheckCompany row);

    int insertSelective(CheckCompany row);

    List<CheckCompany> selectByExample(CheckCompanyExample example);

    CheckCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CheckCompany row, @Param("example") CheckCompanyExample example);

    int updateByExample(@Param("row") CheckCompany row, @Param("example") CheckCompanyExample example);

    int updateByPrimaryKeySelective(CheckCompany row);

    int updateByPrimaryKey(CheckCompany row);
}