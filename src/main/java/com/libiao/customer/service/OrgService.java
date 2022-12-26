package com.libiao.customer.service;

import com.libiao.customer.model.org.CreateOrgReq;
import com.libiao.customer.model.org.ModifyOrgReq;
import com.libiao.customer.model.org.OrgListVO;

import java.util.List;

public interface OrgService {
    void createOrg(CreateOrgReq req);

    //编辑
    void modify(ModifyOrgReq req);

    List<OrgListVO> list(String parentOrgNo);
}
