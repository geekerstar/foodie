package com.geekerstar.service;

import com.geekerstar.pojo.Category;
import com.geekerstar.vo.CategoryVO;

import java.util.List;

/**
 * @author geekerstar
 * date: 2019/11/19 19:35
 * description:
 */
public interface CategoryService {
    /**
     * 查询所有一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类ID查询子分类信息
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

}
