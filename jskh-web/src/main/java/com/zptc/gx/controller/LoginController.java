package com.zptc.gx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.service.MenuService;
import com.zptc.gx.permission.service.ZptcUserService;
import com.zptc.gx.util.MD5Util;
import com.zptc.gx.util.RandomValidateCodeUtil;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.helper.menu.MenuVOHelper;
import com.zptc.gx.vo.menu.MenuVO1;

@Controller
@RequestMapping("/home")
public class LoginController extends BaseController {
	private Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private ZptcUserService zptcUserService;

	@Autowired
	private MenuService menuService;

	/**
	 * 登陆页
	 * 
	 * @param req
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/toLogin")
	public ModelAndView toLogin(HttpServletRequest req, HttpServletResponse response, ModelMap model) {
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

	/**
	 * 登陆
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(HttpServletRequest request, HttpServletResponse response) {
		// 获取参数
		String teaCode = ToolUtil.str("username", request);
		String password = ToolUtil.str("password", request);
		String valiDate = ToolUtil.str("valiDate", request);

		// 验证码
		String sessionVerify = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
		if (!valiDate.equals(sessionVerify)) {
			return JsonResult.build(FLAG_FAILED, "验证码错误！");
		}

		// 参数写入map
		Map<String, Object> par = new HashMap<>();
		par.put("teaCode", teaCode);
		par.put("password", MD5Util.encodeAsString(password));
		List<ZptcUser> userList = zptcUserService.findByParam(par);

		if (!CollectionUtils.isEmpty(userList)) {
			ZptcUser zptcUser = userList.get(0);
			// user存入session
			request.getSession().setAttribute(Constant.USER_SESSION, zptcUser);

			long roleId = zptcUser.getRoleId();

			// 获取menuList
			Map<String, Object> menuPar = new HashMap<>();
			menuPar.put("roleId", roleId);
			menuPar.put("parentIsNull", 1);
			List<Menu> menuList = menuService.findUserMenu(menuPar);
			if (!CollectionUtils.isEmpty(menuList)) {
				List<MenuVO1> menuVOList = getMenuVOList(menuList, MENU_LEVEL, roleId);
				System.out.println("+++++++++++++menuVOList:" + JSON.toJSONString(menuVOList));
				request.getSession().setAttribute(Constant.USER_MENU, menuVOList);
			}
		} else {
			return JsonResult.build(FLAG_FAILED, "用户名或密码错误！");
		}
		return JsonResult.build(FLAG_SUCCESS);
	}

	/**
	 * 注册
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public JsonResult register(HttpServletRequest request, HttpServletResponse response) {
		String teaCode = ToolUtil.str("username", request);
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

	/**
	 * 获取系统名称
	 * 
	 * @param req
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getSystem")
	@ResponseBody
	public JsonResult getSystem(HttpServletRequest req, HttpServletResponse response, ModelMap model) {
		try {
			Map<String, Object> par = new HashMap<>();

			String systemName = Constant.systemName;

			String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();

			par.put("systemName", systemName);
			par.put("systemLink", basePath);
			return JsonResult.build(FLAG_SUCCESS, par);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonResult.build(FLAG_FAILED, Constant.SYS_ERR);
		}
	}

	/**
	 * 获取用户信息
	 * 
	 * @param req
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public JsonResult getUser(HttpServletRequest req, HttpServletResponse response, ModelMap model) {
		try {
			Map<String, Object> par = new HashMap<>();

			ZptcUser user = (ZptcUser) req.getSession().getAttribute(Constant.USER_SESSION);
			par.put("user", user);
			return JsonResult.build(FLAG_SUCCESS, par);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonResult.build(FLAG_FAILED, Constant.SYS_ERR);
		}
	}

	/**
	 * 退出
	 * 
	 * @param req
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public JsonResult logout(HttpServletRequest req, HttpServletResponse response, ModelMap model) {
		try {
			req.getSession().removeAttribute(Constant.USER_SESSION);
			return JsonResult.build(FLAG_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonResult.build(FLAG_FAILED, Constant.SYS_ERR);
		}
	}

	@RequestMapping("/getUserMenu")
	@ResponseBody
	public JsonResult getUserMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();

		try {
			List<MenuVO1> menuVO1List = (List<MenuVO1>) request.getSession().getAttribute(Constant.USER_MENU);
			if (!CollectionUtils.isEmpty(menuVO1List)) {
				jsonResult = JsonResult.build(FLAG_SUCCESS, menuVO1List);
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有菜单！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}

	// 获取菜单列表
	private List<MenuVO1> getMenuVOList(List<Menu> menuList, int level, long roleId) {
		int nextLevel = level + 1;
		List<MenuVO1> menuVOList = new ArrayList<>();
		for (Menu parentMenu : menuList) {
			MenuVO1 parentMenuVO = MenuVOHelper.getMenuVO1FromMenu(parentMenu);
			parentMenuVO.setLevel(level);
			Map<String, Object> menuPar = new HashMap<>();
			menuPar.put("parentId", parentMenu.getId());
			menuPar.put("roleId", roleId);
			List<Menu> subMenuList = menuService.findUserMenu(menuPar);
			if (!CollectionUtils.isEmpty(subMenuList)) {
				parentMenuVO.setHasSubMenu(true);
				List<MenuVO1> subMenuVOList = getMenuVOList(subMenuList, nextLevel, roleId);
				parentMenuVO.setSubMenuList(subMenuVOList);
			} else {
				parentMenuVO.setHasSubMenu(false);
			}
			menuVOList.add(parentMenuVO);
		}
		return menuVOList;
	}
}
