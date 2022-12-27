package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.DepartmentOrgMapper;
import com.libiao.customer.dal.mapper.OrgMapperExt;
import com.libiao.customer.dal.model.DepartmentOrg;
import com.libiao.customer.dal.model.DepartmentOrgExample;
import com.libiao.customer.model.org.*;
import com.libiao.customer.service.OrgService;
import com.libiao.customer.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private DepartmentOrgMapper departmentOrgMapper;
    @Autowired
    private OrgMapperExt orgMapperExt;

    public static final String TOP_ORG = "100";

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
    public PageInfo<OrgListVO> list(SubOrgListReq req){
        PageInfo<OrgListVO> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        final List<OrgListVO> subOrgList = orgMapperExt.getSubOrgList(req.getParentOrgNo());
        page = new PageInfo<>(subOrgList);
        return page;
    }

    @Override
    public OrgComboVO selectAll(){
        final List<DepartmentOrg> departmentOrgs = departmentOrgMapper.selectByExample(new DepartmentOrgExample());
        //把list转map
        final Map<String, List<DepartmentOrg>> collect = departmentOrgs.stream().collect(Collectors.groupingBy(DepartmentOrg::getParentOrgNo));
        //map递归为tree
        final List<DepartmentOrg> trunk = collect.get(TOP_ORG);
        List<OrgComboVO> rootList = new ArrayList<>();
        OrgComboVO root = new OrgComboVO();
        root.setOrgNo(TOP_ORG);
        root.setOrgName(TOP_ORG);
        if (trunk != null){
            trunk.forEach(org->{
                final OrgComboVO copy = BeanCopyUtil.copy(org, OrgComboVO.class);
                //查询copy下的子节点
                convert2Tree(copy,collect);
                rootList.add(copy);
            });
        }
        root.setSubOrgList(rootList);
        return root;
    }

    private void convert2Tree(OrgComboVO node, Map<String, List<DepartmentOrg>> map){
        if (node == null){
            return;
        }
        final List<DepartmentOrg> trunk = map.get(node.getOrgNo());
        if (CollectionUtils.isEmpty(trunk)){
            return;
        }
        List<OrgComboVO> leafList = new ArrayList<>();
        trunk.forEach(org->{
            final OrgComboVO copy = BeanCopyUtil.copy(org, OrgComboVO.class);
            //查询copy下的子节点
            convert2Tree(copy,map);
            leafList.add(copy);
        });
        node.setSubOrgList(leafList);
    }
}
