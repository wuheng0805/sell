package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情Repository
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    /** 通过orderid查看订单详情. */
    List<OrderDetail> findDetailByOrderId(String orderId);
}
