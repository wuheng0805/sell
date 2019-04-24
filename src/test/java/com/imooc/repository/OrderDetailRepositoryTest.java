package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
/**
 * 订单详情repository测试
 */
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("12345678");
        orderDetail.setOrderId("1111111");
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductId("1112345");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(9.9));
        orderDetail.setProductQuantity(3);
        OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findDetailByOrderId() throws Exception {
        List<OrderDetail> orderDetailList=repository.findDetailByOrderId("1111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}
