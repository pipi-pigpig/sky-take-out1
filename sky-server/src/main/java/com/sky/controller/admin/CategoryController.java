package com.sky.controller.admin;


import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

 @PostMapping
    public Result<String> addCategory(@RequestBody CategoryDTO categoryDTO) {

     log.info("新增分类：{}", categoryDTO);
     categoryService.addCategory(categoryDTO);
     return Result.success();
 }

 @GetMapping("/page")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {

     log.info("员工分页查询{}", categoryPageQueryDTO);
     PageResult pageResult= categoryService.page(categoryPageQueryDTO);
     return Result.success(pageResult);
 }

 @PostMapping("/status/{status}")
    public Result<String> updateCategoryStatus(@PathVariable("status") Integer status, long id) {
     log.info("启用禁用员工账号：{}，{}", status,id );
     categoryService.updateCategoryStatus(status,id);
     return  Result.success();
 }

 @DeleteMapping
    public Result<String> deleteCategory(long id) {

     categoryService.deleteCategory(id);
     return Result.success();
 }

 @PutMapping
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO) {

     log.info("编辑分类信息：{}", categoryDTO);
     categoryService.update(categoryDTO);

     return Result.success();
 }
    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
}
