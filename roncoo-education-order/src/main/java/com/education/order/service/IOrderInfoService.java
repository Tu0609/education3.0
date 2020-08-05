package com.education.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.education.order.bean.OrderInfo;
import com.education.order.bean.to.OrderTO;

import java.util.List;

/**
 * <p>
 * 订单信息表 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-19
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    public List<OrderInfo> getOrderInfoPage(OrderTO queryOrder);

    public Integer insertOrder(OrderInfo orderInfo);

}
