package com.zptc.gx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	
	@Autowired
	private MenuService menuService;

	public JsonResult getUserMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long roleId = user.getRoleId();
			List<Menu> menuList = menuService.findMenuByRoleId(roleId);
			jsonResult = JsonResult.build(FLAG_SUCCESS, menuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
