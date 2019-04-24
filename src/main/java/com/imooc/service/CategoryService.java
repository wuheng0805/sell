package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * 商品分类Service
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);                           //根据分类id查找分类
    List<ProductCategory> findAll();                                                 //查找所有分类
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);      //通过类型id集合查找所有分类
    ProductCategory save(ProductCategory productCategory);     //添加分类

}
