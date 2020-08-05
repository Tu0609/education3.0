package com.education.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.system.bean.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
public interface ISysMenuService extends IService<SysMenu> {

    //根据用户ID获取菜单信息
    public List<String> getMenuList(Long userID);

}
