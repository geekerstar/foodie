package com.geekerstar.controller;

import com.geekerstar.enums.YesOrNo;
import com.geekerstar.pojo.Carousel;
import com.geekerstar.service.CarouselService;
import com.geekerstar.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author geekerstar
 * date: 2019/11/18 21:30
 * description:
 */
@Api(value = "首页",tags = "首页展示的相关接口")
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "获取首页轮播图列表",notes = "获取首页轮播图列表",httpMethod = "GET")
    @GetMapping("/carousel")
    public JSONResult carousel(){
        List<Carousel> result = carouselService.queryAll(YesOrNo.YES.type);
        return JSONResult.ok(result);
    }

}
