package com.zptc.gx.controller.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zptc.gx.controller.BaseController;

@Controller
public class PageController extends BaseController {
	private static Logger logger = Logger.getLogger(PageController.class);
	
	@RequestMapping("/toPage")
	public String index(HttpServletRequest request) {
		String pageName = request.getParameter("page");
		return pageName;
	}
}
