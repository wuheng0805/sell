package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate  //动态更新更新时间字段
/** 订单Master对象 */
public class OrderMaster {
    /**订单id.  */
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /** 支付状态. */
    private  Integer payStatus= PayStatusEnum.WAIT.getCode();
    /** 创建时间 . */
    private Date createTime;
    /** 更新时间. */
    private Date updateTime;

}
