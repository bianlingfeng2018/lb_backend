package com.libiao.customer.repository;

import com.libiao.customer.dal.model.Certification;

import java.util.List;

public interface CertificationRepository {

    int deleteByPrimaryKey(Long id);

    int insert(Certification row);

    Certification selectByPrimaryKey(Long id);

    List<Certification> selectAll();

    int updateByPrimaryKey(Certification row);

    List<Certification> selectAllByUsername(String username);

    List<Certification> selectByEncryptionKey(String encryptionKey);


}
