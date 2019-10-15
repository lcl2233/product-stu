package org.bomb.duapp.service;

import org.bomb.duapp.entity.OrderInfo;
import org.bomb.duapp.mapper.OrderMapper;
import org.bomb.duapp.query.OrderInfoQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderInfo> queryOrdersByUserId(Long userId, Integer index, Integer pageSize) {
        return orderMapper.queryOrdersByUserId(userId,(index - 1)*pageSize, pageSize);
    }

    @Override
    public List<OrderInfo> queryOrdersByOrderId(Long orderId, Integer index, Integer pageSize) {
        return orderMapper.queryOrdersByOrderId(orderId,(index - 1)*pageSize, pageSize);
    }

    @Override
    public List<OrderInfo> queryOrdersByMore(Long userId, Long orderId) {
        return orderMapper.queryOrdersByMore(userId, orderId);
    }

    @Override
    public List<OrderInfo> queryOrderInfo(OrderInfoQuery orderInfoQuery) {
        return orderMapper.queryOrderInfo(orderInfoQuery);
    }

    @Override
    public OrderInfo addOrder(OrderInfo orderInfo) {
        orderMapper.addOrder(orderInfo);
        return orderInfo;
    }

    @Override
    public OrderInfo updateOrder(OrderInfo orderInfo) {
        orderMapper.updateOrder(orderInfo);
        return orderInfo;
    }

    @Override
    public Boolean delete(Long userId, Long orderId) {
        orderMapper.delete(userId, orderId);
        return true;
    }
}