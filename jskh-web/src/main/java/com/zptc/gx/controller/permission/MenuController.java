package com.zptc.gx.controller.permission;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.controller.LoginController;
import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.service.MenuService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.helper.menu.MenuVOHelper;
import com.zptc.gx.vo.menu.MenuVO1;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	private Logger logger = Logger.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	/**
	 * 获取菜单列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getMenuList")
	@ResponseBody
	public JsonResult getMenuList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();

		try {
			//获取父菜单开始
			Map<String, Object> par = new HashMap<>();
			par.put("parentIsNull", 1);
			List<Menu> menuList = menuService.queryMenuList(par);
			//获取父菜单结束
			List<MenuVO1> menuVOList = getMenuVOList(menuList);
			jsonResult = JsonResult.build(FLAG_SUCCESS, menuVOList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}

	/**
	 * 添加菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addMenu")
	@ResponseBody
	public JsonResult addMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);

			String menuStr = ToolUtil.str("menuStr", request);
			String menuNum = ToolUtil.str("menuNum", request);
			Long parentId = ToolUtil.lonWithNull("parentId", request);
			String parentStr = ToolUtil.str("parentStr", request);
			String parentNum = ToolUtil.str("parentNum", request);
			Integer menuOrder = ToolUtil.intWithNull("menuOrder", request);
			String url = ToolUtil.str("url", request);
			String remark = ToolUtil.str("remark", request);

			Menu menu = new Menu();
			menu.setMenuStr(menuStr);
			menu.setMenuNum(menuNum);
			menu.setParentId(parentId);
			menu.setParentStr(parentStr);
			menu.setParentNum(parentNum);
			menu.setMenuOrder(menuOrder);
			menu.setUrl(url);
			menu.setRemark(remark);
			// 显示
			menu.setShowType(1);
			menu.setCreateId(user.getId());
			menu.setCreateTime(new Date());
			menu.setCreateUser(user.getTeaName());
			if (parentId != null) {
				Menu parentMenu = menuService.findMenuById(parentId);
				if (parentMenu != null) {
					menu.setLevel(parentMenu.getLevel()+1);
				} else {
					jsonResult = JsonResult.build(FLAG_FAILED,"没有找到父菜单！");
					return jsonResult;
				}
			} else {
				menu.setLevel(MENU_LEVEL);
			}
			int result = menuService.addMenu(menu);
			if (result > 0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}

	/**
	 * 修改菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateMenu")
	@ResponseBody
	public JsonResult updateMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);

			Long menuId = ToolUtil.lon("menuId", request);
			String menuStr = ToolUtil.str("menuStr", request);
			String menuNum = ToolUtil.str("menuNum", request);
			Long parentId = ToolUtil.lonWithNull("parentId", request);
			String parentStr = ToolUtil.str("parentStr", request);
			String parentNum = ToolUtil.str("parentNum", request);
			Integer menuOrder = ToolUtil.intWithNull("menuOrder", request);
			String url = ToolUtil.str("url", request);
			String remark = ToolUtil.str("remark", request);

			Menu menu = menuService.findMenuById(menuId);
			if (menu == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该菜单！");
				return jsonResult;
			}

			menu.setMenuStr(menuStr);
			menu.setMenuNum(menuNum);
			menu.setParentId(parentId);
			menu.setParentStr(parentStr);
			menu.setParentNum(parentNum);
			menu.setMenuOrder(menuOrder);
			menu.setUrl(url);
			menu.setRemark(remark);
			menu.setModifyId(user.getId());
			menu.setModifyTime(new Date());
			menu.setModifyUser(user.getTeaName());
			int result = menuService.modifyMenu(menu);
			if (result > 0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}

	/**
	 * 删除菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteMenu")
	@ResponseBody
	public JsonResult deleteMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);

			Long menuId = ToolUtil.lon("menuId", request);

			// 删除菜单
			int result = menuService.deleteMenuById(menuId);
			if (result > 0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}

	/**
	 * 菜单软删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/removeMenu")
	@ResponseBody
	public JsonResult removeMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);

			Long menuId = ToolUtil.lon("menuId", request);

			Menu menu = menuService.findMenuById(menuId);
			if (menu == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该菜单！");
				return jsonResult;
			}
			menu.setShowType(2);

			menu.setModifyId(user.getId());
			menu.setModifyTime(new Date());
			menu.setModifyUser(user.getTeaName());
			int result = menuService.modifyMenu(menu);
			if (result > 0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}

	/**
	 * 根据id获取菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getMenuById")
	@ResponseBody
	public JsonResult getMenuById(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();

		try {
			Long id = ToolUtil.lon("menuId", request);
			Menu menu = menuService.findMenuById(id);
			jsonResult = JsonResult.build(FLAG_SUCCESS, menu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}

	// 获取菜单列表
	private List<MenuVO1> getMenuVOList(List<Menu> menuList) {
		List<MenuVO1> menuVOList = new ArrayList<>();
		for (Menu parentMenu : menuList) {
			MenuVO1 parentMenuVO = MenuVOHelper.getMenuVO1FromMenu(parentMenu);
			Map<String, Object> menuPar = new HashMap<>();
			menuPar.put("parentId", parentMenu.getId());
			List<Menu> subMenuList = menuService.queryMenuList(menuPar);
			if (!CollectionUtils.isEmpty(subMenuList)) {
				parentMenuVO.setHasSubMenu(true);
				List<MenuVO1> subMenuVOList = getMenuVOList(subMenuList);
				parentMenuVO.setSubMenuList(subMenuVOList);
			} else {
				parentMenuVO.setHasSubMenu(false);
			}
			menuVOList.add(parentMenuVO);
		}
		return menuVOList;
	}
}
