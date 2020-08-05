package com.education.order.service.xml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.order.bean.OrderInfo;
import com.education.order.bean.to.OrderTO;
import com.education.order.mapper.OrderInfoMapper;
import com.education.order.service.IOrderInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-19
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    /**
     *  根据查询条件分页查询
     * @param queryOrder
     * @return
     */
    @Override
    public List<OrderInfo> getOrderInfoPage(OrderTO queryOrder) {

        Page page = new Page(queryOrder.getCurrend(), queryOrder.getLimit());

        QueryWrapper wrapper = new QueryWrapper();

        if (queryOrder.getMobile() != null) {
            wrapper.eq("mobile", queryOrder.getMobile());
        }

        if (queryOrder.getCourseName() != null) {
            wrapper.like("course_name", queryOrder.getCourseName());
        }

        if (queryOrder.getCreateTime() != null && queryOrder.getEndTime() != null) {
            wrapper.between("gmt_create",queryOrder.getCreateTime(),queryOrder.getEndTime());
        }

        if (queryOrder.getOrderStatus() != -1) {
            wrapper.eq("order_status", queryOrder.getOrderStatus());
        }

        if (queryOrder.getOrderNo() != null) {
            wrapper.eq("order_no", queryOrder.getOrderNo());
        }

        if (queryOrder.getRemark() != null) {
            wrapper.like("remark", queryOrder.getRemark());
        }

        if (queryOrder.getLecturerName() != null) {
            wrapper.like("lecturer_name", queryOrder.getLecturerName());
        }

        if (queryOrder.getChannelType() != -1) {
            wrapper.eq("channel_type", queryOrder.getChannelType());
        }

        if (queryOrder.getPayType() != -1) {
            wrapper.eq("pay_type", queryOrder.getPayType());
        }
        IPage iPage = baseMapper.selectPage(page, wrapper);
        return iPage.getRecords();
    }

    /**
     * 用户添加订单
     * @param orderInfo
     * @return
     */
    @Override
    public Integer insertOrder(OrderInfo orderInfo) {
        return baseMapper.insert(orderInfo);
    }
}
