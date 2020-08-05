package com.education.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.education.order.bean.Courseinventory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Tutu
 * @since 2020-05-21
 */
@Mapper
public interface CourseinventoryMapper extends BaseMapper<Courseinventory> {

    Integer updateInventory(Long id);

}
