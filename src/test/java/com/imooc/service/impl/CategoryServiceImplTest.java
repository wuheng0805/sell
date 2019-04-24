package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
/**
 * 类目测试
 */
public class CategoryServiceImplTest {
@Autowired
private  CategoryServiceImpl categoryService;
    @Test
    public void findOne() {
        ProductCategory productCategory=categoryService.findOne(1);
//        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
        log.info(productCategory.toString());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList=categoryService.findAll();
//        Assert.assertNotEquals(0,productCategoryList.size());
        for(int i=0;i<productCategoryList.size();i++){
            ProductCategory p1=productCategoryList.get(i);
            log.info(p1.toString());
        }
    }

    @Test
    public void findByCategoryTypeIn() {
     List<ProductCategory> findCategoryType=categoryService.findByCategoryTypeIn(Arrays.asList(1,3,4,6,7));
//     Assert.assertNotEquals(0,findCategoryType.size());
     for(int i=0;i<findCategoryType.size();i++){
         ProductCategory p1=findCategoryType.get(i);
         log.info(p1.toString());
     }
    }

    @Test
    public void save() {
        ProductCategory productCategory=new ProductCategory("女孩最爱",11);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}