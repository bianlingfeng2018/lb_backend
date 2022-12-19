package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.Client;
import com.libiao.customer.dal.model.ClientParamVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientMapper {

  int deleteByPrimaryKey(Long id);

  int insert(Client row);

  Client selectByPrimaryKey(Long id);

  List<Client> selectAll();

  int updateByPrimaryKey(Client row);

  Client selectByName(@Param("name") String name);

  int unlockClientById(@Param("id") Long id);

  int lockClientById(@Param("id") Long id, @Param("uid") Long userId);

  List<Client> selectByTraceUserId(@Param("uid") Long traceUserId, @Param("vo") ClientParamVO vo);

  List<Client> selectByTraceUserIdIsNull(ClientParamVO vo);

  List<Client> selectAllByCondition(ClientParamVO vo);
}