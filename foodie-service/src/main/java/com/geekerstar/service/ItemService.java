package com.geekerstar.service;

import com.geekerstar.pojo.Items;
import com.geekerstar.pojo.ItemsImg;
import com.geekerstar.pojo.ItemsParam;
import com.geekerstar.pojo.ItemsSpec;
import com.geekerstar.util.PagedGridResult;
import com.geekerstar.vo.CommentLevelCountsVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author geekerstar
 * date: 2019/11/20 19:20
 * description:
 */
@Service
public interface ItemService {

    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查询商品的评价等级数量
     * @param itemId
     */
    CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * 根据商品id查询商品的评价（分页）
     * @param itemId
     * @param level
     * @return
     */
    PagedGridResult queryPagedComments(String itemId, Integer level,
                                       Integer page, Integer pageSize);

    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searhItems(String keywords, String sort,
                                      Integer page, Integer pageSize);

    /**
     * 根据分类id搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searhItems(Integer catId, String sort,
                                      Integer page, Integer pageSize);

}
