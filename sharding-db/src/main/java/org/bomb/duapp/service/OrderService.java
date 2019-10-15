package org.bomb.duapp.service;

import org.bomb.duapp.entity.OrderInfo;
import org.bomb.duapp.query.OrderInfoQuery;

import java.util.List;

public interface OrderService {

    List<OrderInfo> queryOrdersByUserId(Long userId, Integer index, Integer pageSize);

    List<OrderInfo> queryOrdersByOrderId(Long orderId, Integer index, Integer pageSize);

    List<OrderInfo> queryOrdersByMore(Long userId, Long orderId);

    List<OrderInfo> queryOrderInfo(OrderInfoQuery orderInfoQuery);

    OrderInfo addOrder(OrderInfo orderInfo);

    OrderInfo updateOrder(OrderInfo orderInfo);

    Boolean delete(Long userId, Long orderId);
}
