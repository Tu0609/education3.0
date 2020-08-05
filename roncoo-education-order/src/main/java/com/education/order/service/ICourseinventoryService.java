package com.education.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.order.bean.Courseinventory;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-05-21
 */
public interface ICourseinventoryService extends IService<Courseinventory> {

    boolean updateInventory(Long id);

}
