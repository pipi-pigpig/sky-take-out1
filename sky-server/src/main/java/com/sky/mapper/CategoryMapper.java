package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import com.sky.result.PageResult;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) VALUES " +
             "(#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser}) ")
    @AutoFill(value = OperationType.INSERT)
    void insert(Category category);


    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);


    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);

    @Delete("delete  from category where id=#{id}")
    void delete(long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
