package com.geekerstar.custom;

import com.geekerstar.my.mapper.MyMapper;
import com.geekerstar.pojo.Category;
import com.geekerstar.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom {
    List<CategoryVO> getSubCatList(Integer rootCatId);
}
