package com.education.gateway.filter;

import com.education.util.tools.JSONUtil;
import com.education.util.tools.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/22 16:19
 */
@Component
@Slf4j
public class FilterPre implements GlobalFilter, Ordered {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //获取request请求
        ServerHttpRequest request = exchange.getRequest();
        //获取头部信息
        HttpHeaders headers = request.getHeaders();
        //获取token值
        String token = headers.getFirst("token");

        //获取请求路径
        String url = request.getURI().getPath();
        log.info("----------------------------网关用户请求的路径：" + url);
        log.info("----------------------------用户的token值：" + token);

        if (token == null) {
            return chain.filter(exchange);
        }
//判断用户是否登录
//        if (!stringRedisTemplate.hasKey(token)) {
//            log.info("请先登录！");
//            try {
//                throw new Exception("请先登录");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        //获取用户的编号
        Long userNo = getUserNoByToken(token);

        if (url.contains("/pc")) {
            //检验用户是否有该权限
            String menulist = stringRedisTemplate.opsForValue().get(token);

            if (!checkUri(url, menulist)) {
                log.info("没有该权限！");
            }

        }

        return chain.filter(exchange);
    }

    /**
     *  获取用户ID
     * @param
     * @return
     */
    public Long getUserNoByToken(String token) {
        String memberIdByJwtToken = JwtUtils.getMemberIdByJwtToken(token);
        return Long.parseLong(memberIdByJwtToken);
    }

    /**
     *  校验用户是否有权限
     * @param uri
     * @param token
     * @return
     */
    private static Boolean checkUri(String uri, String token) {
        List<String> menuList = JSONUtil.parseArray(token, String.class);
        if (StringUtils.hasText(uri) && uri.endsWith("/")) {
            uri = uri.substring(0, uri.length() - 1);
        }
        for (String str : menuList) {
            if (str.contains(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
