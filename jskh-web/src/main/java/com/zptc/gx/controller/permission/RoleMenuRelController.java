package com.zptc.gx.controller.permission;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.service.RoleMenuRelService;

@Controller
@RequestMapping("/roleMenuRel")
public class RoleMenuRelController extends BaseController {
	private Logger logger = Logger.getLogger(RoleMenuRelController.class);
	
	@Autowired
	private RoleMenuRelService roleMenuRelService;

}
