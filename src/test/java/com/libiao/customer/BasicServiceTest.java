package com.libiao.customer;

import com.libiao.customer.dal.model.BasicTestItem;
import com.libiao.customer.service.BasicService;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Lingfeng
 */
@SpringBootTest
@Slf4j
public class BasicServiceTest {

  @Autowired
  private BasicService basicService;

  @Test
  void testGetAllTestItems() {
    ResponseVO<?> allTestItems = basicService.getAllTestItems();
    Map<String, List<BasicTestItem>> data = (Map<String, List<BasicTestItem>>) allTestItems.getData();
    log.info(String.valueOf(data.size()));
  }
}
