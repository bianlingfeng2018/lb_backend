package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.CheckCompany;
import com.libiao.customer.model.org.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrgService {
    void createOrg(CreateOrgReq req);

    //编辑
    void modify(ModifyOrgReq req);

    PageInfo<OrgListVO> list(SubOrgListReq req);

    OrgComboVO selectAll();

    ResponseEntity<List<CheckCompany>> getAllCheckCompany();

}
