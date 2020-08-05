package com.education.user.config;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author TuTu
 * @date 2020/6/24 9:36
 */
@Component
public class SmsConfig {

    public void send(String sendTo,String templateId,String[] data) {
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8aaf0708701ea9ab0170244cc10601d6";
        String accountToken = "5c43c0055c2a49188a3dd48262bd0735";

        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        //初始化
        sdk.init(serverIp,serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId("8aaf0708701ea9ab0170244cc16a01dd");

        //发送
        HashMap<String, Object> stringObjectHashMap = sdk.sendTemplateSMS(sendTo, templateId, data);

        if("000000".equals(stringObjectHashMap.get("statusCode"))) {
            System.out.println("发送成功！");
        } else {
            System.out.println("发送失败！");
        }
    }

}
