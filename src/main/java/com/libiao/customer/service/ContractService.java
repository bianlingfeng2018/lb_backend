package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.model.client.contract.*;
import org.springframework.web.multipart.MultipartFile;

public interface ContractService {
    PageInfo<ClientContractListVO> list(ClientContractListReq req);

    void addContract(AddContractReq req, MultipartFile file);


    ClientContractDetailVO detail(ContractDetailReq req);

    void modify(ModifyContractReq req, MultipartFile file);
}
