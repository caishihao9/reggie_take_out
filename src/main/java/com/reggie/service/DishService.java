package com.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.reggie.dto.DishDto;
import com.reggie.entity.Dish;

import java.util.List;

/**
 * @author caishihao9
 */
public interface DishService extends IService<Dish> {

    /**
     * 新增菜品，同时插入菜品对应的口味数据
     * @param dishDto
     */
    void saveWithFlavor(DishDto dishDto);

    /**
     * 删除菜品，同时删除菜品口味数据
     * @param ids
     */
    void removeWithFlavor(List<Long> ids);

    /**
     * 根据id查询菜品信息和对应口味信息
     * @param id
     * @return
     */
    DishDto getByIdWithFlavor(Long id);

    /**
     * 修改菜品，同时修改菜品对应的口味数据
     * @param dishDto
     */
    void updateWithFlavor(DishDto dishDto);
}
