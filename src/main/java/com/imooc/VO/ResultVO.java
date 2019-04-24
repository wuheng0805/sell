package com.imooc.VO;

import lombok.Data;

/**
 * 所有商品分类信息VO
 * @param <T>
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码.
     */
    private Integer code;
    /** 提示信息. */
    private String
    /** 具体内容 .*/msg;
    private T data;
}
