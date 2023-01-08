package com.libiao.customer.util;

import com.libiao.customer.model.PageVO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PageUtil {

  public static <T> PageVO<T> createPageVO(int pageNo, int pageSize, int totalPages,
      long totalElements, List<T> data) {
    PageVO<T> pageVO = new PageVO<>();
    pageVO.setData(data);
    pageVO.setPageNo(pageNo);
    pageVO.setPageSize(pageSize);
    pageVO.setTotalPage(totalPages);
    pageVO.setTotalCount(totalElements);
    return pageVO;
  }
}
