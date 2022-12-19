package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.ClientMapper;
import com.libiao.customer.dal.model.Client;
import com.libiao.customer.dal.model.ClientParamVO;
import com.libiao.customer.repository.ClientRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

  final
  ClientMapper clientMapper;

  public ClientRepositoryImpl(ClientMapper clientMapper) {
    this.clientMapper = clientMapper;
  }

  @Override
  public List<Client> selectAll() {
    return clientMapper.selectAll();
  }

  @Override
  public int updateByPrimaryKey(Client client) {
    return clientMapper.updateByPrimaryKey(client);
  }

  @Override
  public int insertClient(Client client) {
    return clientMapper.insert(client);
  }

  @Override
  public Client selectByName(String name) {
    return clientMapper.selectByName(name);
  }

  @Override
  public Client selectById(Long id) {
    return clientMapper.selectByPrimaryKey(id);
  }

  @Override
  public int deleteById(Long id) {
    return clientMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int unlockClientById(Long id) {
    return clientMapper.unlockClientById(id);
  }

  @Override
  public int lockClientById(Long id, Long userId) {
    return clientMapper.lockClientById(id, userId);
  }

  @Override
  public List<Client> selectByTraceUserId(Long traceUserId, ClientParamVO vo) {
    if (traceUserId == null) {
      return clientMapper.selectByTraceUserIdIsNull(vo);
    }
    return clientMapper.selectByTraceUserId(traceUserId, vo);
  }

  @Override
  public List<Client> selectAllByCondition(ClientParamVO vo) {
    return clientMapper.selectAllByCondition(vo);
  }
}
