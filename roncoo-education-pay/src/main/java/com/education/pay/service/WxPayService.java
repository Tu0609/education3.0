package com.education.pay.service;

import com.education.util.to.PayOrderInfo;

import java.util.Map;

/**
 * @author TuTu
 * @date 2020/6/24 11:33
 */
public interface WxPayService {

    /**
     * @Description: 微信支付统一下单
     * @Author:
     * @Date: 2019/8/1
     * @return
     */
    Map unifiedOrder(PayOrderInfo payOrderInfo);

}
