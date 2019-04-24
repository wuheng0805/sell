package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)   //当对象为null的时候，不返回
public class OrderDTO {
    /**订单id.  */
    private String  orderId;
    /** 买家名字. */
    private String buyerName;
    /** 买家手机号 .*/
    private String buyerPhone;
    /** 买家地址. */
    private String buyerAddress;
    /** 买家微信Opneid. */
    private  String  buyerOpenid;
    /** 订单总金额. */
    private BigDecimal orderAmount;
    /** 订单状态,默认为新下单. */
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    /** 支付状态. */
    private  Integer payStatus= PayStatusEnum.WAIT.getCode();
    /** 创建时间 . */
    @JsonSerialize(using = Date2LongSerializer.class)  //后端Date类型默认返回给前端是long类型，为毫秒级别，转换成秒
    private Date createTime;
    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    List<OrderDetail> orderDetailList;    //如果为空默认返回格式是什么，比如空数组，这个得看前后端商量的格式为准
}
