package com.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.reggie.entity.Category;

/**
 * @author caishihao9
 */
public interface CategoryService extends IService<Category> {
    /**
     * 删除分类
     * @param id
     */
    void remove(Long id);
}
