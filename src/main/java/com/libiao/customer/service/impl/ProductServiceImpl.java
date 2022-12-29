package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.BasePageReq;
import com.libiao.customer.model.product.AddGoodsReq;
import com.libiao.customer.model.product.BasicItemVO;
import com.libiao.customer.model.product.GoodsListReq;
import com.libiao.customer.model.product.GoodsVO;
import com.libiao.customer.service.ProductService;
import com.libiao.customer.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private BasicTestItemMapper basicTestItemMapper;
    @Autowired
    private ProductMapperExt productMapperExt;
    @Autowired
    private MallGoodsMapper mallGoodsMapper;
    @Autowired
    private GoodsItemMapper goodsItemMapper;
    @Autowired
    private BasicCountryMapper basicCountryMapper;

    @Override
    public List<BasicTestItem> getBasicTestItemList(){
        List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(new BasicTestItemExample());
        return basicTestItems;
    }

    @Override
    public List<GoodsVO> getProductList(GoodsListReq req){
        if (StringUtils.hasLength(req.getGoodsName())){
            req.setGoodsName("%"+req.getGoodsName()+"%");
        }
        if (StringUtils.hasLength(req.getHsCode())){
            req.setHsCode("%"+req.getHsCode()+"%");
        }
        if (StringUtils.hasLength(req.getStandard())){
            req.setStandard("%"+req.getStandard()+"%");
        }
        List<GoodsVO> goodsList = productMapperExt.getGoodsList(req);
        return goodsList;
    }

    @Override
    public void createProduct(AddGoodsReq req){
        MallGoods record = new MallGoods();
        BeanCopyUtil.copy(req,record);

        mallGoodsMapper.insertSelective(record);

        List<BasicItemVO> items = req.getItems();
        for (BasicItemVO item : items) {
            GoodsItem row = new GoodsItem();
            row.setGoodsId(record.getId());
            row.setItemId(item.getId());
            goodsItemMapper.insertSelective(row);
        }
    }

    @Override
    public PageInfo<BasicCountry> countryList(BasePageReq req){
        PageInfo<BasicCountry> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        final List<BasicCountry> basicCountries = basicCountryMapper.selectByExample(new BasicCountryExample());
        page = new PageInfo<>(basicCountries);
        return page;
    }
}
