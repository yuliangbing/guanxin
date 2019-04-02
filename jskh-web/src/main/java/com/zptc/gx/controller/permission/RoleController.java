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
import com.zptc.gx.permission.entity.Role;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.service.RoleService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	private Logger logger = Logger.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;

	@RequestMapping("/addRole")
	@ResponseBody
	public JsonResult addRole(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			String roleName = ToolUtil.str("roleName", request);
		    String roleNum = ToolUtil.str("roleNum", request);
		    Integer roleOrder = ToolUtil.integer("roleOrder", request);
			
			Role role = new Role();
			role.setRoleName(roleName);
			role.setRoleNum(roleNum);
			role.setRoleOrder(roleOrder);
			role.setCreateId(user.getId());
			role.setCreateTime(new Date());
			role.setCreateUser(user.getTeaName());
			
			int result = roleService.addRole(role);
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
	
	@RequestMapping("/updateRole")
	@ResponseBody
	public JsonResult updateRole(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long roleId = ToolUtil.lon("roleId", request);
			String roleName = ToolUtil.str("roleName", request);
		    String roleNum = ToolUtil.str("roleNum", request);
		    Integer roleOrder = ToolUtil.integer("roleOrder", request);
			
			Role role = roleService.findRoleById(roleId);
			if (role == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该角色！");
				return jsonResult;
			}
			role.setRoleName(roleName);
			role.setRoleNum(roleNum);
			role.setRoleOrder(roleOrder);
			role.setModifyId(user.getId());
			role.setModifyTime(new Date());
			role.setModifyUser(user.getTeaName());
			
			int result = roleService.modifyRole(role);
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
