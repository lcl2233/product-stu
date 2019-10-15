package org.bomb.duapp.mapper;

import org.apache.ibatis.annotations.Param;
import org.bomb.duapp.entity.OrderInfo;
import org.bomb.duapp.query.OrderInfoQuery;

import java.util.List;

public interface OrderMapper {
    // 根据用户ID查询 关联数据
    List<OrderInfo> queryOrdersByUserId(@Param("userId") Long userId, @Param("index") Integer index, @Param("pageSize") Integer pageSize);

    // 根据订单ID查询 关联数据
    List<OrderInfo> queryOrdersByOrderId(@Param("orderId") Long orderId, @Param("index") Integer index, @Param("pageSize") Integer pageSize);

    // 查询大于userId并且大于orderId的数据，判断大于是否全路由
    List<OrderInfo> queryOrdersByMore(@Param("userId") Long userId, @Param("orderId") Long orderId);

    // 通过订单号查询订单信息
    List<OrderInfo> queryOrderInfo(OrderInfoQuery orderInfoQuery);

    // 插入订单信息
    void addOrder(OrderInfo orderInfo);

    //更新订单信息
    void updateOrder(OrderInfo orderInfo);

    //删除订单信息
    void delete(@Param("userId") Long userId, @Param("orderId") Long orderId);
}
