package com.zptc.gx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController {
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping("/toLogin")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse response, ModelMap model) {
		ModelAndView view = new ModelAndView();
		model.put("systemName", "guanxin");
		view.setViewName("login");
		return view;
	}
}
