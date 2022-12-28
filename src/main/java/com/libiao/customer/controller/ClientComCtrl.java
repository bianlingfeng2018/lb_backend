package com.libiao.customer.controller;

import com.libiao.customer.dal.model.Client;
import com.libiao.customer.dal.model.ClientParamVO;
import com.libiao.customer.dal.model.ClientVO;
import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.service.ClientService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClientComCtrl {

  private final ClientService clientService;

  public ClientComCtrl(ClientService clientService) {
    this.clientService = clientService;
  }

  @RequestMapping(value = "/api/cli-all-export", method = RequestMethod.GET)
  public ResponseEntity<?> exportAllClientCom(ClientParamVO vo) {
    return clientService.exportAllClientCom(vo);
  }

  @RequestMapping(value = "/api/cli-my-export", method = RequestMethod.GET)
  public ResponseEntity<?> exportMyClientCom(ClientParamVO vo) {
    return clientService.exportMyClientCom(vo);
  }

  @RequestMapping(value = "/api/cli-pub-export", method = RequestMethod.GET)
  public ResponseEntity<?> exportPubClientComPage(ClientParamVO vo) {
    return clientService.exportPubClientComPage(vo);
  }


  /**
   * 查询所有客户
   *
   * @param pageNum  当前页
   * @param pageSize 每页条数
   * @param vo       查询条件vo
   * @return
   */
  @RequestMapping(value = "/api/client-com-page-all", method = RequestMethod.GET)
  public ResponseVO<PageVO<Client>> getAllClientComPage(int pageNum, int pageSize,
      ClientParamVO vo) {
    return clientService.getAllClientComPage(pageNum, pageSize, vo);
  }


  /**
   * 查询我的客户
   *
   * @param pageNum  当前页
   * @param pageSize 每页条数
   * @return
   */
  @RequestMapping(value = "/api/client-com-page-my", method = RequestMethod.GET)
  public ResponseVO<PageVO<Client>> getClientComPageMy(int pageNum, int pageSize,
      ClientParamVO vo) {
    return clientService.getMyClientByPage(pageNum, pageSize, vo);
  }

  /**
   * 查询公共客户
   *
   * @param pageNum
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/api/client-com-page-pub", method = RequestMethod.GET)
  public ResponseVO<PageVO<Client>> getClientComPagePub(int pageNum, int pageSize,
      ClientParamVO vo) {
    return clientService.getPublicClientComPage(pageNum, pageSize, vo);
  }

  /**
   * 查询所有客户（公司）
   *
   * @return
   */
  @RequestMapping(value = "/api/client-com-list", method = RequestMethod.GET)
  public ResponseVO<List<Client>> getAllClientCom() {
    return clientService.getAllClient();
  }

  /**
   * 查询一个公司的所有联系人
   *
   * @param id 客户（公司）id
   * @return
   */
  @RequestMapping(value = "/api/contacts-by-com-id", method = RequestMethod.GET)
  public ResponseVO<List<UserExt>> getContactListByClientId(@RequestParam("id") Long id) {
    return clientService.getContactListByClientId(id);
  }

  @RequestMapping(value = "/api/client-com", method = RequestMethod.PUT)
  public ResponseVO<?> updateClientCom(@RequestBody ClientVO clientVO) {
    try {
      return clientService.updateClientCom(clientVO);
    } catch (RuntimeException e) {
      e.printStackTrace();
      return ResponseUtil.error(400, e.getMessage());
    }
  }

  @RequestMapping(value = "/api/client-com", method = RequestMethod.POST)
  public ResponseVO<?> saveClientCom(@RequestBody ClientVO clientVO) {
    try {
      return clientService.saveClientCom(clientVO);
    } catch (RuntimeException e) {
      e.printStackTrace();
      return ResponseUtil.error(400, e.getMessage());
    }
  }

  @RequestMapping(value = "/api/client-com/{id}", method = RequestMethod.DELETE)
  public ResponseVO<?> deleteClientCom(@PathVariable(value = "id") Long id) {
    return clientService.deleteById(id);
  }

  @RequestMapping(value = "/api/client-com-by-id", method = RequestMethod.GET)
  public ResponseVO<?> getClientComById(@RequestParam("id") Long id) {
    return clientService.getClientById(id);
  }

  /**
   * 放出客户
   *
   * @param client
   * @return
   */
  @RequestMapping(value = "/api/unlock-client", method = RequestMethod.POST)
  public ResponseVO<?> unlockClient(@RequestBody Client client) {
    return clientService.unlockClient(client);
  }

  /**
   * 锁定客户
   *
   * @param client
   * @return
   */
  @RequestMapping(value = "/api/lock-client", method = RequestMethod.POST)
  public ResponseVO<?> lockClient(@RequestBody Client client) {
    return clientService.lockClient(client);
  }

  @RequestMapping(value = "/api/trans-client", method = RequestMethod.POST)
  public ResponseVO<?> transferClient(@RequestBody Client client, @RequestParam("userId") Long userId) {
    return clientService.transferClient(client, userId);
  }

  /**
   * 获取客户跟进历史
   *
   * @param id 客户id
   * @return
   */
  @RequestMapping(value = "/api/client-trace-history", method = RequestMethod.GET)
  public ResponseVO<?> getClientTraceHistory(@RequestParam("id") Long id) {
    return clientService.getClientTraceHistory(id);
  }

  @RequestMapping(value = "/api/addr-by-code-and-type", method = RequestMethod.GET)
  public ResponseVO<?> getAddressByCodeAndType(@RequestParam("type") String type,
      @RequestParam("code") String code) {
    return clientService.getAddressByCodeAndType(type, code);
  }

  @RequestMapping(value = "/api/full-addr-by-code", method = RequestMethod.GET)
  public ResponseVO<?> getFullAddressByCode(@RequestParam("code") String code) {
    return clientService.getFullAddressByCode(code);
  }

  @RequestMapping(value = "/api/check-client-name-exist", method = RequestMethod.POST)
  public ResponseVO<?> checkClientNameExist(@RequestBody ClientVO clientVO) {
    return clientService.checkClientNameExist(clientVO);
  }

  @RequestMapping(value = "/api/check-contact-name-exist", method = RequestMethod.POST)
  public ResponseVO<?> checkContactNameExist(@RequestBody UserExt userExt) {
    return clientService.checkContactNameExist(userExt);
  }

  @RequestMapping(value = "/api/check-contact-phone-num-exist", method = RequestMethod.POST)
  public ResponseVO<?> checkContactPhoneNumExist(@RequestBody UserExt userExt) {
    return clientService.checkContactPhoneNumExist(userExt);
  }

}
