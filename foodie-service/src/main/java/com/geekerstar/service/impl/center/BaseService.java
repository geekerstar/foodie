package com.geekerstar.service.impl.center;

import com.geekerstar.util.PagedGridResult;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author geekerstar
 * date: 2019/11/23 20:33
 * description:
 */
public class BaseService {
    public PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }
}
