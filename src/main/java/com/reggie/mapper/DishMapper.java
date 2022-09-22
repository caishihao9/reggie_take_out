package com.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author caishihao9
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
