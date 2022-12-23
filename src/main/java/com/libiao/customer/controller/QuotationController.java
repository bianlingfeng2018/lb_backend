package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.Quotation;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.quotation.QuotationListReq;
import com.libiao.customer.model.quotation.QuotationListVO;
import com.libiao.customer.service.QuotationService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("quotation")
@Api(tags = "报价单接口")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping("list")
    public ResponseEntity<ListResponseVO<QuotationListVO>> list(@RequestBody QuotationListReq req){
        final PageInfo<Quotation> list = quotationService.list(req);
        List<QuotationListVO> voList = new ArrayList<>();
        list.getList().forEach(db->voList.add(BeanCopyUtil.copy(db,QuotationListVO.class)));
        return ResponseUtil.getListResponseVO(voList,list.getTotal());
    }

}
