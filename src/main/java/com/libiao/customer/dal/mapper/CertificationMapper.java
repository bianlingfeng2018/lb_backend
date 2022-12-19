package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.Certification;

import java.util.List;

public interface CertificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Certification row);

    Certification selectByPrimaryKey(Long id);

    List<Certification> selectAll();

    int updateByPrimaryKey(Certification row);

    List<Certification> selectAllByUsername(String username);

    List<Certification> selectByEncryptionKey(String encryptionKey); // 根据密钥查找，因为不是主键，所以这个返回结果为list

}