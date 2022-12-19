package com.libiao.customer.repository;

import com.libiao.customer.dal.model.Client;
import com.libiao.customer.dal.model.ClientParamVO;
import java.util.List;

public interface ClientRepository {

  List<Client> selectAll();

  int updateByPrimaryKey(Client client);

  int insertClient(Client client);

  Client selectByName(String name);

  Client selectById(Long id);

  int deleteById(Long id);

  int unlockClientById(Long id);

  int lockClientById(Long id, Long userId);

  List<Client> selectByTraceUserId(Long traceUserId, ClientParamVO vo);

  List<Client> selectAllByCondition(ClientParamVO vo);
}
