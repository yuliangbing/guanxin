package com.zptc.gx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class BaseController {

	private Logger logger = Logger.getLogger(BaseController.class);
	
	public static final Integer FLAG_SUCCESS = 200;// 请求响应成功
	public static final Integer FLAG_FAILED = 500;// 请求响应失败
	public static final Integer FLAG_FAILED_NOLOGIN = 303;// 请求响应失败-需要登录
	public static final Integer FLAG_VALID_FAIL_CODE = 507;// 参数验证错误
	private static final Integer FLAG_NULL = 300; // 查询数据为空
	
	public Map<String, Object> getMap(){
		return new HashMap<String, Object>();
	}
	
	public String getParam(HttpServletRequest request, String name){
		return request.getParameter(name);
	}
	
	public void setSession(HttpServletRequest request, String name, Object sessionObj) {
		request.getSession().setAttribute(name, sessionObj);
	}
}
