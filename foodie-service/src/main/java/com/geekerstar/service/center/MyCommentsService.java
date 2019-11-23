package com.geekerstar.service.center;

import com.geekerstar.bo.center.OrderItemsCommentBO;
import com.geekerstar.pojo.OrderItems;
import com.geekerstar.util.PagedGridResult;

import java.util.List;

/**
 * @author geekerstar
 * date: 2019/11/23 20:31
 * description:
 */
public interface MyCommentsService {
    /**
     * 根据订单id查询关联的商品
     * @param orderId
     * @return
     */
    List<OrderItems> queryPendingComment(String orderId);

    /**
     * 保存用户的评论
     * @param orderId
     * @param userId
     * @param commentList
     */
    void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);


    /**
     * 我的评价查询 分页
     * @param userId
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize);
}
