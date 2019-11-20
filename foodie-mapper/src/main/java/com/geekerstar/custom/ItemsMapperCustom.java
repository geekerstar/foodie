package com.geekerstar.custom;

import com.geekerstar.vo.ItemCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author geekerstar
 * date: 2019/11/20 20:29
 * description:
 */
public interface ItemsMapperCustom {
    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);
}
