package com.education.gateway.controller;

import com.education.util.tools.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class HandlerController implements ErrorController {

	/**
	 * 出异常后进入该方法，交由下面的方法处理
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	@ResponseStatus(HttpStatus.OK)
	public ResultUtils error() {
		log.info("系统出现了错误！");
		return ResultUtils.error();
	}

}
