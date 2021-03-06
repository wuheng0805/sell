package com.imooc.dto;

import lombok.Data;

/**
 * 库存购物车
 */
@Data
public class CartDTO {
    /**商品Id. */
    private String productId;
    /**数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
