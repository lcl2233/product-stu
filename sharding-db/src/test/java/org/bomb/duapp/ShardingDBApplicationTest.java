package org.bomb.duapp;

import org.bomb.duapp.sharding.entity.OrderInfo;
import org.bomb.duapp.sharding.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingDBApplicationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShardingDBApplicationTest.class);

    @Resource(name = "orderService")
    OrderService orderService;

    @Test
    public void testInsertOrderInfo() {
//        for (int i = 1; i <= 16000; i++) {
//            long userId = i;
//            long orderId = i;
//            OrderInfo orderInfo = new OrderInfo();
//            orderInfo.setUserName("bomb");
//            orderInfo.setUserId(userId);
//            orderInfo.setOrderId(orderId);
//            orderService.addOrder(orderInfo);
//        }

        for (int i = 1; i <= 40; i++ ) {
            for (int j = 1; j <= 400; j++) {
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setUserName("bomb");
                orderInfo.setUserId(Long.valueOf(i));
                orderInfo.setOrderId(Long.valueOf(j));
                orderService.addOrder(orderInfo);
            }
        }
    }
}
