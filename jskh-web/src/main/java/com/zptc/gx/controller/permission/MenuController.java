package com.zptc.gx.controller.permission;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.service.MenuService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	private Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;

	/**
	 * 获取菜单列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getMenuList")
	@ResponseBody
	public JsonResult getMenuList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			List<Menu> menuList = menuService.queryMenuList(null);
			jsonResult = JsonResult.build(FLAG_SUCCESS, menuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	@RequestMapping("/addMenu")
	@ResponseBody
	public JsonResult addMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			String menuStr = ToolUtil.str("menuStr", request);
		    String menuNum = ToolUtil.str("menuNum", request);
		    Long parentId = ToolUtil.lon("parentId", request);
		    String parentStr = ToolUtil.str("parentStr", request);
		    String parentNum = ToolUtil.str("parentNum", request);
		    Integer menuOrder = ToolUtil.integer("menuOrder", request);
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
		    menu.setCreateId(user.getId());
		    menu.setCreateTime(new Date());
		    menu.setCreateUser(user.getTeaName());
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
	
	@RequestMapping("/updateMenu")
	@ResponseBody
	public JsonResult updateMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long menuId = ToolUtil.lon("menuId", request);
			String menuStr = ToolUtil.str("menuStr", request);
		    String menuNum = ToolUtil.str("menuNum", request);
		    Long parentId = ToolUtil.lon("parentId", request);
		    String parentStr = ToolUtil.str("parentStr", request);
		    String parentNum = ToolUtil.str("parentNum", request);
		    Integer menuOrder = ToolUtil.integer("menuOrder", request);
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
	
	@RequestMapping("/deleteMenu")
	@ResponseBody
	public JsonResult deleteMenu(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long menuId = ToolUtil.lon("menuId", request);
		    
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
}
