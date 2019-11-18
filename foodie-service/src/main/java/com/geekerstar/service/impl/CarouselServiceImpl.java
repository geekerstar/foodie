package com.geekerstar.service.impl;

import com.geekerstar.mapper.CarouselMapper;
import com.geekerstar.pojo.Carousel;
import com.geekerstar.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author geekerstar
 * date: 2019/11/18 21:24
 * description:
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").asc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow",isShow);
        List<Carousel> result = carouselMapper.selectByExample(example);
        return result;
    }
}
