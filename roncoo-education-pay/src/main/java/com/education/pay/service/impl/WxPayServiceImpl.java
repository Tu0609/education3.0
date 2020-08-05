package com.education.pay.service.impl;

import com.education.pay.service.WxPayService;
import com.education.pay.util.HttpClient;
import com.education.pay.util.PayCommonUtil;
import com.education.pay.util.XMLUtil;
import com.education.util.to.PayOrderInfo;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author TuTu
 * @date 2020/6/24 11:34
 */
@Service
@Slf4j
public class WxPayServiceImpl implements WxPayService {

    @Override
    public Map unifiedOrder(PayOrderInfo payOrderInfo) {
        System.out.println("----------------订单信息：" + payOrderInfo);
        try {
            SortedMap<Object, Object> m = new TreeMap<>();
            m.put("appid","wx74862e0dfcf69954");
            m.put("mch_id", "1558950191");
            m.put("nonce_str", WXPayUtil.generateNonceStr());
            m.put("body", payOrderInfo.getCourseName()); //课程标题
            m.put("out_trade_no", payOrderInfo.getOrderNo().toString()); //订单号
            m.put("total_fee", payOrderInfo.getPricePaid().multiply(new BigDecimal("100")).longValue()+"");
            m.put("spbill_create_ip", "127.0.0.1");
            m.put("notify_url", "http:/cn.tcr/order-pay/success");
            m.put("trade_type", "NATIVE");
            m.put("sign", PayCommonUtil.createSign("UTF-8", m, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));

            String requestXml = PayCommonUtil.getRequestXml(m);

            String resXml = HttpClient.postData("https://api.mch.weixin.qq.com/pay/unifiedorder", requestXml);

            Map map = null;
            map = XMLUtil.doXMLParse(resXml);

            return map;
        } catch (Exception e) {
            log.info("------------------生成二维码失败！");
        }
        return null;
    }
}
