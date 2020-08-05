package com.education.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.system.bean.SysMenu;
import com.education.system.mapper.SysMenuMapper;
import com.education.system.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import cn.tcr.sys.controller.SysMenuController;

/**
 * <p>
 * 菜单信息 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    /**
     *
     * @param userID 用户ID
     * @return
     */
    @Override
    public List<String> getMenuList(Long userID) {
        List<String> list = new ArrayList<>();

        List<SysMenu> menuList = baseMapper.getMenuList(userID);

        for (SysMenu menu : menuList) {
            list.add(menu.getApiUrl());
        }
        return list;
    }
}
