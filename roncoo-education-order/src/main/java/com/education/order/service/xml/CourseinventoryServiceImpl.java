package com.education.order.service.xml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.order.bean.Courseinventory;
import com.education.order.mapper.CourseinventoryMapper;
import com.education.order.service.ICourseinventoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-05-21
 */
@Service
public class CourseinventoryServiceImpl extends ServiceImpl<CourseinventoryMapper, Courseinventory> implements ICourseinventoryService {

    @Override
    public boolean updateInventory(Long id) {
        Integer row = baseMapper.updateInventory(id);
        return row > 0 ? true : false;
    }
}
