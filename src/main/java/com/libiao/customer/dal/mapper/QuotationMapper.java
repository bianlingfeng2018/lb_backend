package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.Quotation;
import java.util.List;

public interface QuotationMapper {
    int deleteByPrimaryKey(String quotationId);

    int insert(Quotation row);

    Quotation selectByPrimaryKey(String quotationId);

    List<Quotation> selectAll();

    int updateByPrimaryKey(Quotation row);
}