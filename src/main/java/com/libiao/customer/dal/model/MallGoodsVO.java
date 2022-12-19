package com.libiao.customer.dal.model;

import com.libiao.customer.util.FileVO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Lingfeng
 */
@Getter
@Setter
public class MallGoodsVO extends MallGoods {
  private List<FileVO> imageList1;
  private List<FileVO> imageList2;
}
