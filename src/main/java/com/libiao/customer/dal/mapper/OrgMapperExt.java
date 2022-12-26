package com.libiao.customer.dal.mapper;

import com.libiao.customer.model.org.OrgListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgMapperExt {

    List<OrgListVO> getSubOrgList(String orgNo);
}
