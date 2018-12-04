package com.zptc.gx.controller.tea;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zptc.gx.controller.BaseController;

@Controller
@RequestMapping("/tea")
public class TestContoller extends BaseController {
	private static Logger logger = Logger.getLogger(TestContoller.class);
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "index";
	}
}
