package com.imooc.repository;


import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *商品分类Repository
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
   List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
