package com.geekerstar.service;

import com.geekerstar.bo.SubmitOrderBO;
import com.geekerstar.pojo.OrderStatus;
import com.geekerstar.vo.OrderVO;

/**
 * @author geekerstar
 * date: 2019/11/23 14:27
 * description:
 */
public interface OrderService {

    /**
     * 用于创建订单相关信息
     * @param submitOrderBO
     */
    OrderVO createOrder(SubmitOrderBO submitOrderBO);

    /**
     * 修改订单状态
     * @param orderId
     * @param orderStatus
     */
    void updateOrderStatus(String orderId, Integer orderStatus);

    /**
     * 查询订单状态
     * @param orderId
     * @return
     */
    OrderStatus queryOrderStatusInfo(String orderId);

    /**
     * 关闭超时未支付订单
     */
    void closeOrder();

}
