package com.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author caishihao9
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
