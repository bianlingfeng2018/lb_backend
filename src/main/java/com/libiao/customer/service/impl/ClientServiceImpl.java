package com.libiao.customer.service.impl;

import static com.libiao.customer.util.DateUtil.addDays;
import static com.libiao.customer.util.DateUtil.getSDF;
import static com.libiao.customer.util.DateUtil.getSdfTime;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_CLIENT;

import com.alibaba.fastjson.JSONObject;
import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.model.PageVO;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.dal.model.UserExt;
import com.libiao.customer.repository.ClientRepository;
import com.libiao.customer.repository.RoleRepository;
import com.libiao.customer.repository.TraceHistoryRepository;
import com.libiao.customer.repository.UserRepository;
import com.libiao.customer.service.AddrService;
import com.libiao.customer.service.ClientService;
import com.libiao.customer.service.UserBizService;
import com.libiao.customer.service.UserRolePermissionService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.WebUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.exception.LibiaoException;
import com.libiao.customer.util.model.ResponseVO;
import com.libiao.customer.util.poi.POIUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

  final private ClientRepository clientRepository;

  final private UserRepository userRepository;

  final private UserBizService userBizService;

  final private UserRolePermissionService userRolePermissionService;

  final private RoleRepository roleRepository;

  final private TraceHistoryRepository traceHistoryRepository;

  private final AddrService addrService;

  public ClientServiceImpl(ClientRepository clientRepository, UserRepository userRepository,
      UserBizService userBizService, UserRolePermissionService userRolePermissionService,
      RoleRepository roleRepository, TraceHistoryRepository traceHistoryRepository,
      AddrService addrService) {
    this.clientRepository = clientRepository;
    this.userRepository = userRepository;
    this.userBizService = userBizService;
    this.userRolePermissionService = userRolePermissionService;
    this.roleRepository = roleRepository;
    this.traceHistoryRepository = traceHistoryRepository;
    this.addrService = addrService;
  }

  @Override
  public ResponseVO<List<Client>> getAllClient() {
    try {
      List<Client> clients = clientRepository.selectAll();
      return ResponseUtil.success(clients);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<PageVO<Client>> getMyClientByPage(int pageNo, int pageSize, ClientParamVO vo) {
    try {
      refineVO(vo);
      String userName = WebUtil.getAccessToken().getUsername();
      UserExt loginUserExt = userRepository.selectByUsername(userName);
      PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<Client> clients = clientRepository.selectByTraceUserId(loginUserExt.getId(), vo);
      PageInfo<Client> pageInfo = new PageInfo<>(clients);
      return ResponseUtil.success(pageInfo);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<PageVO<Client>> getPublicClientComPage(int pageNo, int pageSize,
      ClientParamVO vo) {
    try {
      refineVO(vo);
      PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<Client> clients = clientRepository.selectByTraceUserId(null, vo);
      PageInfo<Client> pageInfo = new PageInfo<>(clients);
      return ResponseUtil.success(pageInfo);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<PageVO<Client>> getAllClientComPage(int pageNo, int pageSize,
      ClientParamVO vo) {
    try {
      refineVO(vo);
      PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<Client> clients = clientRepository.selectAllByCondition(vo);
      PageInfo<Client> pageInfo = new PageInfo<>(clients);
      return ResponseUtil.success(pageInfo);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseEntity<?> exportAllClientCom(ClientParamVO vo) {
    try {
      refineVO(vo);
      List<Client> clients = clientRepository.selectAllByCondition(vo);
      return getResponseEntity(clients);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<?> exportMyClientCom(ClientParamVO vo) {
    try {
      refineVO(vo);
      String userName = WebUtil.getAccessToken().getUsername();
      UserExt loginUserExt = userRepository.selectByUsername(userName);
      List<Client> clients = clientRepository.selectByTraceUserId(loginUserExt.getId(), vo);
      return getResponseEntity(clients);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<?> exportPubClientComPage(ClientParamVO vo) {
    try {
      refineVO(vo);
      List<Client> clients = clientRepository.selectByTraceUserId(null, vo);
      return getResponseEntity(clients);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseVO<?> getAddressByCodeAndType(String type, String code) {
    try {
      log.info("type = {}, code = {}", type, code);
      List<Object> list = Lists.newArrayList();
      if (Objects.equals("province", type)) {
        List<TfArea> addrList = addrService.findAllProvince();
        list = addrList.stream()
            .map((addr) -> new Province(addr.getName(), String.valueOf(addr.getId()),
                addr.getMergerName(), addr.getPinyin())).collect(Collectors.toList());
      } else if (Objects.equals("city", type)) {
        List<TfArea> addrList = addrService.findAllCityByProvinceId(code);
        list = addrList.stream()
            .map((addr) -> new City(addr.getName(), String.valueOf(addr.getId()),
                addr.getMergerName(), addr.getPinyin())).collect(Collectors.toList());
      } else if (Objects.equals("area", type)) {
        List<TfArea> addrList = addrService.findAllAreaByCityId(code);
        list = addrList.stream()
            .map((addr) -> new Area(addr.getName(), String.valueOf(addr.getId()),
                addr.getMergerName(), addr.getPinyin())).collect(Collectors.toList());
      } else {
        log.warn("Unknown type of address.");
      }
      return ResponseUtil.success(list);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> getFullAddressByCode(String code) {
    try {
      log.info("address code = {}", code);
      AddrVO vo = null;
      if (StringUtils.isNotEmpty(code)) {
        String[] split = code.split(",");
        if (ArrayUtils.isNotEmpty(split) && split.length == 3) {
          vo = new AddrVO(split[0], split[1], split[2]);
        }
      }
      return ResponseUtil.success(vo);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> transferClient(Client client, Long userId) {
    try {
      doTransferClient(client, userId);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("msg", "转移客户成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }


  @Override
  public ResponseVO<?> checkClientNameExist(ClientVO clientVO) {
    try {
      Long id = clientVO.getId();
      Client findByName = clientRepository.selectByName(clientVO.getName());
      if (id == null) {
        // 创建客户的情况
        if (Objects.nonNull(findByName)) {
          return ResponseUtil.success(true);
        }
      } else {
        // 修改客户的情况
        if (Objects.nonNull(findByName) && !findByName.getId().equals(id)) {
          return ResponseUtil.success(true);
        }
      }
      return ResponseUtil.success(false);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> checkContactNameExist(UserExt userExt) {
    try {
      boolean exist = existContactName(userExt);
      return ResponseUtil.success(exist);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> checkContactPhoneNumExist(UserExt userExt) {
    try {
      boolean exist = existContactPhoneNum(userExt);
      return ResponseUtil.success(exist);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<List<UserExt>> getContactListByClientId(Long id) {
    try {
      List<UserExt> contactList = userRepository.selectByClientId(id);
      return ResponseUtil.success(contactList);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  @Transactional
  public ResponseVO<?> updateClientCom(ClientVO clientVO) {
//    try {
    Client find = clientRepository.selectById(clientVO.getId());
    if (Objects.isNull(find)) {
      throw new RuntimeException("客户不存在，更新失败");
    }
    Client findByName = clientRepository.selectByName(clientVO.getName());
    if (Objects.nonNull(findByName) && !findByName.getId().equals(clientVO.getId())) {
      throw new RuntimeException("客户名" + findByName.getName() + "已存在，更新失败");
    }
    int update = clientRepository.updateByPrimaryKey(clientVO);
    // 更新客户联系人列表
    List<UserExt> contactList = clientVO.getContactList();
    for (UserExt userExt : contactList) {
      updateUser(find, userExt);
    }
    JSONObject result = new JSONObject();
    result.put("msg", "更新成功");
    return ResponseUtil.success(result);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
//    }
  }

  @Override
  @Transactional
  public ResponseVO<?> saveClientCom(ClientVO clientVO) {
//    try {
    Client find = clientRepository.selectByName(clientVO.getName());
    if (Objects.nonNull(find)) {
//        return ResponseUtil.error(404, "客户已存在，新增失败");
      throw new RuntimeException("客户已存在，新增失败");
    }
    int insert = clientRepository.insertClient(clientVO);
    // 更新客户联系人列表
    List<UserExt> contactList = clientVO.getContactList();
    for (UserExt userExt : contactList) {
      updateUser(clientVO, userExt);
    }

    // 锁定客户
    doLockClient(clientVO);

    JSONObject result = new JSONObject();
    result.put("msg", "新增成功");
    return ResponseUtil.success(result);
//    } catch (Exception e) {
//      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
//    }
  }

  @Override
  public ResponseVO<?> getClientById(Long id) {
    try {
      Client client = clientRepository.selectById(id);
      List<UserExt> contactList = userRepository.selectByClientId(id);
      ClientVO vo = new ClientVO();
      BeanUtils.copyProperties(client, vo);
      vo.setContactList(contactList);
      String addr = client.getAddr();
      String addrDesc = getAddrDesc(addr);
      JSONObject jsonObject = (JSONObject) JSONObject.toJSON(vo);
      jsonObject.put("assoCom", JSONObject.parse(vo.getAssoCom()));
      jsonObject.put("assoInvoice", JSONObject.parse(vo.getAssoInvoice()));
      jsonObject.put("addrDesc", addrDesc);
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> deleteById(Long id) {
    try {
      int del = clientRepository.deleteById(id);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("msg", "删除成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> unlockClient(Client client) {
    try {
      // 更新跟进历史
      String userName = WebUtil.getAccessToken().getUsername();
      UserExt loginUserExt = userRepository.selectByUsername(userName);
      Date date = new Date();
      Date protectDate = addDays(date, 30);
      String protectedDays = getSDF().format(protectDate);
      String lastTraceDate = getSDF().format(date);
      String lastTraceDateTime = getSdfTime().format(date);
      traceHistoryRepository.insertTraceHistory(
          new TraceHistory(null, client.getId(), loginUserExt.getId(), loginUserExt.getNickname(),
              "放出", lastTraceDateTime, protectedDays));
      // 更新客户跟进人
      client.setTraceUserId(null);
      client.setLastTraceUser(loginUserExt.getUsername());
      client.setReserveDays("30");
      client.setInvoiceName(lastTraceDate);
      int i = clientRepository.updateByPrimaryKey(client);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("msg", "放出客户成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> lockClient(Client client) {
    try {
      doLockClient(client);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("msg", "锁定客户成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> getClientTraceHistory(Long id) {
    try {
      List<TraceHistory> traceHistoryList = traceHistoryRepository.findAllByClientId(id);
      return ResponseUtil.success(traceHistoryList);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  private void updateUser(Client client, UserExt userExt) {
    Role role = roleRepository.selectByRoleName(ROLE_CLIENT);
    userExt.setRole(role);
    userExt.setComId(client.getId());
    if (userExt.getId() == null) {
      // 新建用户
      if (StringUtils.isEmpty(userExt.getPassword())) {
        userExt.setPassword("123456"); // 初始密码
      }
      userExt.setGmtCreate(new Date());
      userExt.setGmtModify(new Date());
      UserExt findByUserNameExt = userRepository.selectByUsername(userExt.getUsername());
      if (Objects.nonNull(findByUserNameExt)) {
        throw new RuntimeException("用户名已存在，新增失败");
      }
      List<UserExt> findByUserPhoneNumExt = userRepository.selectByPhoneNum(userExt.getPhoneNum());
      if (!CollectionUtils.isEmpty(findByUserPhoneNumExt)) {
        throw new RuntimeException("手机号" + userExt.getPhoneNum() + "已存在，新增失败");
      }
      int affectedRows = userRepository.insert(userExt);
    } else {
      // 更新用户
      UserExt userExtById = userRepository.selectByPrimaryKey(userExt.getId());
      if (Objects.isNull(userExtById)) {
        throw new RuntimeException("用户不存在，更新失败");
      }
      UserExt findByUserNameExt = userRepository.selectByUsername(userExt.getUsername());
      if (Objects.nonNull(findByUserNameExt) && !findByUserNameExt.getId().equals(userExtById.getId())) {
        throw new RuntimeException("登陆名" + findByUserNameExt.getUsername() + "已存在，更新失败");
      }
      validatePhoneNum(userExt, userExtById);
      userExt.setGmtModify(new Date());
      userRepository.updateByPrimaryKey(userExt);
    }
  }

  private void validatePhoneNum(UserExt userExt, UserExt userExtById) {
    List<UserExt> findByUserPhoneNumExt = userRepository.selectByPhoneNum(userExt.getPhoneNum());
    if (!CollectionUtils.isEmpty(findByUserPhoneNumExt)) {
      if (findByUserPhoneNumExt.size() == 1) {
        if (!findByUserPhoneNumExt.get(0).getId().equals(userExtById.getId())) {
          throw new RuntimeException("手机号" + userExt.getPhoneNum() + "已存在，更新失败");
        }
      } else {
        throw new RuntimeException("手机号" + userExt.getPhoneNum() + "已存在，更新失败");
      }
    }
  }

  private void doTransferClient(Client client, Long userId) {
    // 更新跟进历史
    UserExt transUserExt = userRepository.selectByPrimaryKey(userId);
    Date date = new Date();
    Date protectDate = addDays(date, 30);
    String protectedDays = getSDF().format(protectDate);
    String lastTraceDate = getSDF().format(date);
    String lastTraceDateTime = getSdfTime().format(date);
    traceHistoryRepository.insertTraceHistory(
        new TraceHistory(null, client.getId(), transUserExt.getId(), transUserExt.getNickname(),
            "转移", lastTraceDateTime, protectedDays));
    // 更新客户跟进人
    client.setTraceUserId(userId);
    client.setLastTraceUser(transUserExt.getUsername());
    client.setReserveDays("30");
    client.setInvoiceName(lastTraceDate);
    int i = clientRepository.updateByPrimaryKey(client);
  }

  private void doLockClient(Client client) {
    // 更新跟进历史
    String userName = WebUtil.getAccessToken().getUsername();
    UserExt loginUserExt = userRepository.selectByUsername(userName);
    Date date = new Date();
    Date protectDate = addDays(date, 30);
    String protectedDays = getSDF().format(protectDate);
    String lastTraceDate = getSDF().format(date);
    String lastTraceDateTime = getSdfTime().format(date);
    traceHistoryRepository.insertTraceHistory(
        new TraceHistory(null, client.getId(), loginUserExt.getId(), loginUserExt.getNickname(),
            "锁定", lastTraceDateTime, protectedDays));
    // 更新客户跟进人
    client.setTraceUserId(loginUserExt.getId());
    client.setLastTraceUser(loginUserExt.getUsername());
    client.setReserveDays("30");
    client.setInvoiceName(lastTraceDate);
    int i = clientRepository.updateByPrimaryKey(client);
  }

  private static void refineVO(ClientParamVO vo) {
    vo.setCnameOrAbbr("%" + vo.getCnameOrAbbr() + "%");
    vo.setIndustry("%" + vo.getIndustry() + "%");
    vo.setStatus("%" + vo.getStatus() + "%");
    vo.setType("%" + vo.getType() + "%");
    vo.setSource("%" + vo.getSource() + "%");
  }

  private static ResponseEntity<byte[]> getResponseEntity(List<Client> clients) throws IOException {
    XSSFWorkbook workbook = POIUtil.buildWorkbook(clients);
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    workbook.write(os);
    byte[] bytes = os.toByteArray();

    // 创建springframework的HttpHeaders对象
    HttpHeaders headers = new HttpHeaders();
    // 下载显示的文件名，解决中文名称乱码问题
    String downloadFileName = new String("export.xlsx".getBytes("UTF-8"), "iso-8859-1");
    // 通知浏览器以attachment（下载方式）打开图片
    headers.setContentDispositionFormData("attachment", downloadFileName);
    // application/octet-stream ： 二进制流数据（最常见的文件下载）。
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    // 201 HttpStatus.CREATED
    return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);
  }

  private String getAddrDesc(String addr) {
    String addrDesc = null;
    if (addr != null && addr.contains(",")) {
      String[] split = addr.split(",");
      if (split.length == 3) {
        TfArea find = addrService.findAreaById(split[2]);
        addrDesc = find.getMergerName();
      }
    }
    return addrDesc;
  }

  private boolean existContactName(UserExt userExt) {
    Long id = userExt.getId();
    if (id == null) {
      // 新建用户
      UserExt findByUserNameExt = userRepository.selectByUsername(userExt.getUsername());
      if (Objects.nonNull(findByUserNameExt)) {
        return true;
      }
    } else {
      // 更新用户
      UserExt findByUserNameExt = userRepository.selectByUsername(userExt.getUsername());
      if (Objects.nonNull(findByUserNameExt) && !findByUserNameExt.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  private boolean existContactPhoneNum(UserExt userExt) {
    Long id = userExt.getId();
    if (id == null) {
      // 新建用户
      List<UserExt> findByUserPhoneNumExt = userRepository.selectByPhoneNum(userExt.getPhoneNum());
      if (!CollectionUtils.isEmpty(findByUserPhoneNumExt)) {
        return true;
      }
    } else {
      // 更新用户
      List<UserExt> findByUserPhoneNumExt = userRepository.selectByPhoneNum(userExt.getPhoneNum());
      if (!CollectionUtils.isEmpty(findByUserPhoneNumExt)) {
        if (findByUserPhoneNumExt.size() == 1) {
          if (!findByUserPhoneNumExt.get(0).getId().equals(id)) {
            return true;
          }
        } else {
          return true;
        }
      }
    }
    return false;
  }

}
