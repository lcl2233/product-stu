package org.bomb.duapp.controller;

import org.bomb.duapp.entity.OrderInfo;
import org.bomb.duapp.query.OrderInfoQuery;
import org.bomb.duapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/sharding/orders/user/{userId}")
    public List<OrderInfo> queryOrdersByUserId(@PathVariable("userId") Long userId, Integer pageNo, Integer pageSize) {
        return orderService.queryOrdersByUserId(userId, pageNo, pageSize);
    }

    @GetMapping("/sharding/orders/order/{orderId}")
    public List<OrderInfo> queryOrdersByOrderId(@PathVariable("orderId") Long orderId, Integer pageNo, Integer pageSize) {
        return orderService.queryOrdersByOrderId(orderId, pageNo, pageSize);
    }

    @GetMapping("/sharding/orders/more")
    public List<OrderInfo> queryOrdersMore(Long userId, Long orderId) {
        return orderService.queryOrdersByMore(userId, orderId);
    }

    @PostMapping("/sharding/orders")
    public List<OrderInfo> queryOrderInfo(@RequestBody OrderInfoQuery orderInfoQuery) {
        return orderService.queryOrderInfo(orderInfoQuery.buildPage());
    }

    @PutMapping("/sharding/order")
    public OrderInfo addOrder(@RequestBody OrderInfo orderInfo) {
        return orderService.addOrder(orderInfo);
    }

    @PostMapping("/sharding/order")
    public OrderInfo updateOrder(@RequestBody OrderInfo orderInfo) {
        return orderService.updateOrder(orderInfo);
    }

    @DeleteMapping("/sharding/order")
    public Boolean deleteOrder(Long userId, Long orderId) {
        return orderService.delete(userId, orderId);
    }
}
