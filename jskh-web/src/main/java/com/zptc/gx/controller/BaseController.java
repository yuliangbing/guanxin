package com.zptc.gx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class BaseController {

	private Logger logger = Logger.getLogger(BaseController.class);
	
	public static String FLAG_SUCCESS = "200";// 请求响应成功
	public static String FLAG_FAILED = "500";// 请求响应失败
	
	public Map<String, Object> getMap(){
		return new HashMap<String, Object>();
	}
	
	public String getParam(HttpServletRequest request, String name){
		return request.getParameter(name);
	}
}
