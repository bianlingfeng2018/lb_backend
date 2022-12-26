package com.libiao.customer.service.impl;

import com.libiao.customer.dal.mapper.DepartmentOrgMapper;
import com.libiao.customer.dal.mapper.OrgMapperExt;
import com.libiao.customer.dal.model.DepartmentOrg;
import com.libiao.customer.dal.model.DepartmentOrgExample;
import com.libiao.customer.model.org.CreateOrgReq;
import com.libiao.customer.model.org.ModifyOrgReq;
import com.libiao.customer.model.org.OrgListVO;
import com.libiao.customer.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private DepartmentOrgMapper departmentOrgMapper;
    @Autowired
    private OrgMapperExt orgMapperExt;

    @Override
    public void createOrg(CreateOrgReq req){
        String orgNoStr;
        DepartmentOrgExample example = new DepartmentOrgExample();
        example.createCriteria().andParentOrgNoEqualTo(req.getParentOrgNo());
        example.setOrderByClause("org_no desc limit 1");
        final List<DepartmentOrg> departmentOrgs = departmentOrgMapper.selectByExample(example);
        if (departmentOrgs != null){
            final String orgNo = departmentOrgs.get(0).getOrgNo();
            long newOrgNo = Long.parseLong(orgNo) + 1;
            orgNoStr = String.valueOf(newOrgNo);
        }else {
            orgNoStr = req.getParentOrgNo() + "001";
        }
        DepartmentOrg record = new DepartmentOrg();
        record.setOrgNo(orgNoStr);
        record.setCreateBy(req.getUser().getId());
        record.setParentOrgNo(req.getParentOrgNo());
        record.setOrgName(req.getOrgName());
        departmentOrgMapper.insertSelective(record);
    }

    //编辑
    @Override
    public void modify(ModifyOrgReq req){
        DepartmentOrg record = new DepartmentOrg();
        record.setOrgNo(req.getOrgNo());
        record.setOrgName(req.getOrgName());
        record.setPersonInCharge(req.getPersonInCharge());
        departmentOrgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<OrgListVO> list(String parentOrgNo){
        return orgMapperExt.getSubOrgList(parentOrgNo);
    }
}
