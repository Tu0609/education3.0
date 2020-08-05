package com.education.order.service;

import com.education.util.to.PayOrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author TuTu
 * @date 2020/6/24 14:06
 */
@Component
@FeignClient(value = "education-pay")
public interface PayFeignService {

    @PostMapping("/wx/pay/order")
    public Map unifiedOrder(@RequestBody PayOrderInfo payOrderInfo);

}
