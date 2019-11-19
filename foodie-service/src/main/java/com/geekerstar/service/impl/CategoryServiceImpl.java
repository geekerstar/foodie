package com.geekerstar.service.impl;

import com.geekerstar.mapper.CategoryMapper;
import com.geekerstar.pojo.Category;
import com.geekerstar.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author geekerstar
 * date: 2019/11/19 19:36
 * description:
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);
        List<Category> result = categoryMapper.selectByExample(example);
        return result;
    }
}
