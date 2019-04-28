package com.zptc.gx.controller.permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.entity.Role;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.service.MenuService;
import com.zptc.gx.permission.service.RoleMenuRelService;
import com.zptc.gx.vo.PageVO;
import com.zptc.gx.vo.helper.menu.MenuVOHelper;
import com.zptc.gx.vo.menu.MenuVO1;

@Controller
@RequestMapping("/roleMenuRel")
public class RoleMenuRelController extends BaseController {
	private Logger logger = Logger.getLogger(RoleMenuRelController.class);
	
	@Autowired
	private RoleMenuRelService roleMenuRelService;
	
	@Autowired
	private MenuService menuService;

	/**
	 * 获取用户菜单权限列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getRoleMenuRelList")
	@ResponseBody
	public JsonResult getRoleMenuRelList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();

		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			List<Long> roleMenuListIdList = roleMenuRelService.getMenuIdListByRoleId(user.getRoleId());
			
			//获取父菜单开始
			Map<String, Object> par = new HashMap<>();
			par.put("parentIsNull", 1);
			List<Menu> menuList = menuService.queryMenuList(par);
			//获取父菜单结束
			List<MenuVO1> menuVOList = getMenuVOList(menuList, roleMenuListIdList);

			jsonResult = JsonResult.build(FLAG_SUCCESS, menuVOList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	// 获取菜单列表
	private List<MenuVO1> getMenuVOList(List<Menu> menuList, List<Long> roleMenuIdList) {
		List<MenuVO1> menuVOList = new ArrayList<>();
		for (Menu parentMenu : menuList) {
			MenuVO1 parentMenuVO = MenuVOHelper.getMenuVO1FromMenu(parentMenu);
			
			//是否已选择
			if (roleMenuIdList.contains(parentMenuVO.getId())) {
				parentMenuVO.setChecked(true);
			}
			Map<String, Object> menuPar = new HashMap<>();
			menuPar.put("parentId", parentMenu.getId());
			List<Menu> subMenuList = menuService.queryMenuList(menuPar);
			if (!CollectionUtils.isEmpty(subMenuList)) {
				parentMenuVO.setHasSubMenu(true);
				List<MenuVO1> subMenuVOList = getMenuVOList(subMenuList, roleMenuIdList);
				parentMenuVO.setSubMenuList(subMenuVOList);
			} else {
				parentMenuVO.setHasSubMenu(false);
			}
			menuVOList.add(parentMenuVO);
		}
		return menuVOList;
	}
}
