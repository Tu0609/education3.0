package com.education.pay.feign;

import com.education.pay.service.WxPayService;
import com.education.util.to.PayOrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author TuTu
 * @date 2020/6/24 14:03
 */
@RestController
public class WXPayController {

    @Autowired
    private WxPayService wxPayService;

    @PostMapping("/wx/pay/order")
    public Map unifiedOrder(@RequestBody PayOrderInfo payOrderInfo) {
        Map map = wxPayService.unifiedOrder(payOrderInfo);
        return map;
    }

}
