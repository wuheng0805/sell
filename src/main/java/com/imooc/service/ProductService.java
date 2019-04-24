package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品Service
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();
    /**
     * 分页查所有
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);
    /**添加保存商品 */
    ProductInfo save(ProductInfo productInfo);
    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
