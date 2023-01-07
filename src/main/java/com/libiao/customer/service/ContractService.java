package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.ClientContract;
import com.libiao.customer.model.client.contract.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface ContractService {
    PageInfo<ClientContractListVO> list(ClientContractListReq req);

    void addContract(AddContractReq req);

    ClientContract getClientByNum(String clietnNum);

    ClientContractDetailVO detail(ContractDetailReq req);

    void modify(ModifyContractReq req);

    void review(ReviewContractReq req);

    void download(String fileName, HttpServletResponse response);
}
