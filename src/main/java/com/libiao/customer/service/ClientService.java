package com.libiao.customer.service;

import com.libiao.customer.controller.PageVO;
import com.libiao.customer.dal.model.Client;
import com.libiao.customer.dal.model.ClientParamVO;
import com.libiao.customer.dal.model.ClientVO;
import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ClientService {

  ResponseVO<List<Client>> getAllClient();

  ResponseVO<PageVO<Client>> getMyClientByPage(int pageNo, int pageSize, ClientParamVO vo);

  ResponseVO<List<UserExt>> getContactListByClientId(Long id);

  ResponseVO<?> updateClientCom(ClientVO client);

  ResponseVO<?> saveClientCom(ClientVO clientVO);

  ResponseVO<?> getClientById(Long id);

  ResponseVO<?> deleteById(Long id);

  ResponseVO<?> unlockClient(Client id);

  ResponseVO<?> lockClient(Client id);

  ResponseVO<PageVO<Client>> getPublicClientComPage(int pageNum, int pageSize, ClientParamVO vo);

  ResponseVO<?> getClientTraceHistory(Long id);

  ResponseVO<PageVO<Client>> getAllClientComPage(int pageNum, int pageSize, ClientParamVO vo);

  ResponseEntity<?> exportAllClientCom(ClientParamVO vo);

  ResponseEntity<?> exportMyClientCom(ClientParamVO vo);

  ResponseEntity<?> exportPubClientComPage(ClientParamVO vo);

  ResponseVO<?> getAddressByCodeAndType(String type, String code);

  ResponseVO<?> getFullAddressByCode(String code);

  ResponseVO<?> transferClient(Client client, Long userId);

  ResponseVO<?> checkClientNameExist(ClientVO clientVO);

  ResponseVO<?> checkContactNameExist(UserExt userExt);

  ResponseVO<?> checkContactPhoneNumExist(UserExt userExt);
}
