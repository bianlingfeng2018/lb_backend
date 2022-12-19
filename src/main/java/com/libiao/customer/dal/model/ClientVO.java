package com.libiao.customer.dal.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientVO extends Client {

  /**
   * 客户联系人列表
   */
  private List<User> contactList;
}