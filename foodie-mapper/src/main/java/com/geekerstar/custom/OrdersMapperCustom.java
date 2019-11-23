package com.geekerstar.custom;

import com.geekerstar.pojo.OrderStatus;
import com.geekerstar.vo.MyOrdersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author geekerstar
 * date: 2019/11/23 19:10
 * description:
 */
public interface OrdersMapperCustom {
    List<MyOrdersVO> queryMyOrders(@Param("paramsMap") Map<String, Object> map);

    int getMyOrderStatusCounts(@Param("paramsMap") Map<String, Object> map);

    List<OrderStatus> getMyOrderTrend(@Param("paramsMap") Map<String, Object> map);
}
