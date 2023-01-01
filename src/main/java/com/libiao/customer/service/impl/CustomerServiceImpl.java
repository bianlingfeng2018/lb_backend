package com.libiao.customer.service.impl;

import com.libiao.customer.dal.mapper.ClientMapper;
import com.libiao.customer.dal.model.Client;
import com.libiao.customer.dal.model.ClientExample;
import com.libiao.customer.model.client.ClientSimpleReq;
import com.libiao.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> getClientByName(ClientSimpleReq req){
        ClientExample clientExample = new ClientExample();
        if (StringUtils.hasLength(req.getClientName())){
            clientExample.createCriteria().andNameLike("%"+req.getClientName()+"%");
        }
        List<Client> clients = clientMapper.selectByExample(clientExample);
        return clients;
    }
}
