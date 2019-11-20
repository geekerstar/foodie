package com.geekerstar.custom;

import com.geekerstar.my.mapper.MyMapper;
import com.geekerstar.pojo.Category;
import com.geekerstar.vo.CategoryVO;
import com.geekerstar.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {
    List<CategoryVO> getSubCatList(Integer rootCatId);

    public List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);

}
