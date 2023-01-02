package com.libiao.customer.dal.mapper;

import com.libiao.customer.model.client.contract.ClientContractListReq;
import com.libiao.customer.model.client.contract.ClientContractListVO;

import java.util.List;

public interface ClientContractMapperExt {

    List<ClientContractListVO> getClientContractList(ClientContractListReq req);

}