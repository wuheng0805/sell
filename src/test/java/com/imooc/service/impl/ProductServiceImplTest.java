package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 商品测试
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {
@Autowired
private  ProductServiceImpl productService;
    @Test
    public void findOne() {
        ProductInfo productInfo=productService.findOne("123456");
        log.info(productInfo.toString());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList=productService.findUpAll();
        for(ProductInfo p:productInfoList){
            log.info(p.toString());
        }
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo> productInfoList=productService.findAll(request);
        log.info(productInfoList.getTotalElements()+"");
    }

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("1234");
        productInfo.setProductName("蛋炒饭");
        productInfo.setProductPrice(new BigDecimal(13));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("有蛋");
        productInfo.setProductIcon("http://xxxoooo.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result=productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}