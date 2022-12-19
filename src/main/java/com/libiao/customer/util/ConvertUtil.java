package com.libiao.customer.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Lingfeng
 */
public class ConvertUtil {

  public static <DO, VO> PageInfo<VO> DO2VO(PageInfo<DO> pageInfoPo, Function<DO, VO> convert) {
    Page<VO> page = new Page<>(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
    page.setTotal(pageInfoPo.getTotal());
    PageInfo<VO> voPageInfo = new PageInfo<>(page);
    if (pageInfoPo.getTotal() > 0) {
      List<VO> VOS = pageInfoPo.getList().stream().map(
          DO -> {
            return convert.apply(DO);
          }
      ).collect(Collectors.toList());
      voPageInfo.getList().addAll(VOS);
    }
    return voPageInfo;
  }


}
