package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDTO categoryDTO);

    PageResult page(CategoryPageQueryDTO categoryPageQueryDTO);

    void updateCategoryStatus(Integer status, long id);

    void deleteCategory(long id);

    void update(CategoryDTO categoryDTO);

    List<Category> list(Integer type);
}
