package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.CertificationMapper;
import com.libiao.customer.dal.model.Certification;
import com.libiao.customer.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CertificationReposityImpl implements CertificationRepository {

    @Autowired
    private CertificationMapper certificationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return certificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Certification row) {
        if(row.getGmtCreate() == null){
            Date now = new Date();
            row.setGmtCreate(now);
            row.setGmtModify(now);
        }
        row.setIsAvailable(0); // 0 表示可用
        return certificationMapper.insert(row);
    }

    @Override
    public Certification selectByPrimaryKey(Long id) {
        return certificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Certification> selectAll() {
        return certificationMapper.selectAll();
    }


    @Override
    public int updateByPrimaryKey(Certification row) {
        return certificationMapper.updateByPrimaryKey(row);
    }

    @Override
    public List<Certification> selectAllByUsername(String username) {
        return certificationMapper.selectAllByUsername(username);
    }

    @Override
    public List<Certification> selectByEncryptionKey(String encryptionKey) {
        return certificationMapper.selectByEncryptionKey(encryptionKey);
    }
}
