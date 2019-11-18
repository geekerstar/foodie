package com.geekerstar.service;

import com.geekerstar.pojo.Carousel;

import java.util.List;

/**
 * @author geekerstar
 * date: 2019/11/18 21:22
 * description:
 */
public interface CarouselService {
    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
    List<Carousel> queryAll(Integer isShow);
}
