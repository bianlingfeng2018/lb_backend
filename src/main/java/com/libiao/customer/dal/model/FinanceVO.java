package com.libiao.customer.dal.model;

import com.libiao.customer.util.FileVO;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinanceVO extends Finance {

  private List<FileVO> imageList;
  private List<FileVO> pdfList;
}