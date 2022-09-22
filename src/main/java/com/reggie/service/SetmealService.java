package com.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.reggie.dto.SetmealDto;
import com.reggie.entity.Setmeal;

import java.util.List;

/**
 * @author caishihao9
 */
public interface SetmealService extends IService<Setmeal> {

    /**
     * 添加套餐，并保存套餐菜品
     * @param setmealDto
     */
    void saveSetmealWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，并删除套餐菜品
     * @param ids
     */
    void removeWithDish(List<Long> ids);
}
