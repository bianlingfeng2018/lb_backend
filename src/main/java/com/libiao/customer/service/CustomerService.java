package com.libiao.customer.service;

import com.libiao.customer.dal.model.Client;
import com.libiao.customer.model.client.ClientSimpleReq;

import java.util.List;

public interface CustomerService {
    List<Client> getClientByName(ClientSimpleReq req);
    Client getClientByClientId(String clientId);
}
