package com.zptc.gx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.service.ZptcUserService;
import com.zptc.gx.util.MD5Util;
import com.zptc.gx.util.RandomValidateCodeUtil;
import com.zptc.gx.util.ToolUtil;

@Controller
public class LoginController extends BaseController {
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private ZptcUserService zptcUserService;
	
	/**
	 * 登陆页
	 * 
	 * @param req
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/toLogin")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse response, ModelMap model) {
		ModelAndView view = new ModelAndView();
		model.put("systemName", Constant.systemName);
		view.setViewName("login");
		return view;
	}

	/**
	 * 生成验证码
	 */
	@RequestMapping("/getVerify")
	public void getVerify(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
			response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0);
			RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
			randomValidateCode.getRandcode(request, response);// 输出验证码图片方法
		} catch (Exception e) {
			logger.error("获取验证码失败>>>>   ", e);
		}
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(HttpServletRequest request, HttpServletResponse response) {
		//获取参数
		String username = ToolUtil.str("username", request);
		String password = ToolUtil.str("password", request);
		String verify = ToolUtil.str("verify", request);
		
		//验证码
		String sessionVerify = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
		if (!verify.equals(sessionVerify)) {
			return JsonResult.build(FLAG_FAILED, "验证码错误！");
		}
		
		//参数写入map
		Map<String, Object> par = new HashMap<>();
		par.put("username", username);
		par.put("password", MD5Util.encodeAsString(password));
		List<ZptcUser> userList = zptcUserService.findByParam(par);
		
		if (!CollectionUtils.isEmpty(userList)) {
			ZptcUser zptcUser = userList.get(0);
			//user存入session
			request.getSession().setAttribute(Constant.USER_SESSION, zptcUser);
		} else {
			return JsonResult.build(FLAG_FAILED, "用户名或密码错误！");
		}
		return JsonResult.build(FLAG_SUCCESS);
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public JsonResult register(HttpServletRequest request, HttpServletResponse response) {
		String teaCode = ToolUtil.str("teaCode", request);
		String password = ToolUtil.str("password", request);
		
		ZptcUser zptcUser = new ZptcUser();
		zptcUser.setTeaCode(teaCode);
		zptcUser.setPassword(MD5Util.encodeAsString(password));
		int num = zptcUserService.addZptcUser(zptcUser);
		if (num > 0) {
			return JsonResult.build(FLAG_SUCCESS);
		} else {
			return JsonResult.build(FLAG_FAILED, "注册成功！");
		}
	}
}
