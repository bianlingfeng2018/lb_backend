package com.libiao.customer.service.impl;

import com.libiao.customer.dal.mapper.BasicTestItemMapper;
import com.libiao.customer.dal.mapper.MallGoodsMapper;
import com.libiao.customer.dal.mapper.ProductMapperExt;
import com.libiao.customer.dal.model.BasicTestItem;
import com.libiao.customer.dal.model.BasicTestItemExample;
import com.libiao.customer.dal.model.MallGoods;
import com.libiao.customer.model.product.AddGoodsReq;
import com.libiao.customer.model.product.BasicItemVO;
import com.libiao.customer.model.product.GoodsVO;
import com.libiao.customer.service.ProductService;
import com.libiao.customer.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private BasicTestItemMapper basicTestItemMapper;
    @Autowired
    private ProductMapperExt productMapperExt;
    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    @Override
    public List<BasicTestItem> getBasicTestItemList(){
        List<BasicTestItem> basicTestItems = basicTestItemMapper.selectByExample(new BasicTestItemExample());
        return basicTestItems;
    }

    @Override
    public List<GoodsVO> getProductList(){
        List<GoodsVO> goodsList = productMapperExt.getGoodsList();
        return goodsList;
    }

    public void createProduct(AddGoodsReq req){
        MallGoods record = new MallGoods();
        BeanCopyUtil.copy(req,record);
        //TODO 这里还需要生成逐渐
        mallGoodsMapper.insertSelective(record);

        List<BasicItemVO> items = req.getItems();


    }
}
