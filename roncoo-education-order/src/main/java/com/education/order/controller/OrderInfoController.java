package com.education.order.controller;


import com.education.order.bean.OrderInfo;
import com.education.order.bean.to.OrderTO;
import com.education.order.service.IOrderInfoService;
import com.education.order.service.PayFeignService;
import com.education.util.to.PayOrderInfo;
import com.education.util.tools.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单信息表 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-19
 */
@RestController
@Slf4j
@Api(value = "订单信息")
@RequestMapping("/courses/pc/order")
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private PayFeignService payFeignService;
    /**
     * 更具条件获取订单信息
     * @param queryOrder
     * @return
     */
    @ApiOperation(value = "获取订单信息")
    @PostMapping(value = "/info/list")
    public ResultUtils getOrderInfoPage(@RequestBody OrderTO queryOrder) {
        log.info("-----------------------获取订单信息--------------------------------");
        log.info("--------------------------订单查询的条件：" + queryOrder);

        List<OrderInfo> orderInfoPage = orderInfoService.getOrderInfoPage(queryOrder);

        log.info("--------------------------查询出来的订单数据：" + orderInfoPage);
        Map<String, Object> map = new HashMap<>();
        map.put("orderInfo", orderInfoPage);

        return ResultUtils.ok(map);
    }

    @ApiOperation(value = "添加订单信息")
    @PutMapping("/info/save")
    public ResultUtils insertOrder(@RequestBody OrderInfo orderInfo) {

        log.info("----------------------------添加订单---------------------------");
        log.info("--------------------------用户添加的订单信息：" + orderInfo);

        Map<String, Object> map = new HashMap<>();

        if (orderInfoService.insertOrder(orderInfo) > 0) {
            map.put("msg", "订单添加成功");
            return ResultUtils.ok(map);
        }
        return ResultUtils.error();
    }

    @ApiOperation(value = "支付订单")
    @PostMapping("/pay")
    public ResultUtils payOrderController(@RequestBody PayOrderInfo orderInfo) {
        log.info("----------------------------支付订单---------------------------");
        log.info("==============" + orderInfo);
        Map map = payFeignService.unifiedOrder(orderInfo);
        log.info("------------------------------支付成功的信息：" + map);
        return ResultUtils.ok(map);
    }

}

