package com.zptc.gx.controller.permission;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	private Logger logger = Logger.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;

	/**
	 * 添加角色
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addRole")
	@ResponseBody
	public JsonResult addRole(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			//接受前端数据--开始
			String roleName = ToolUtil.str("roleName", request);
		    String roleNum = ToolUtil.str("roleNum", request);
		    Integer roleOrder = ToolUtil.integer("roleOrder", request);
		  //接受前端数据--结束
			
		    //编写对象参数--开始
			Role role = new Role();
			role.setRoleName(roleName);
			role.setRoleNum(roleNum);
			role.setRoleOrder(roleOrder);
			role.setStatus(1);
			//设为不默认
			role.setIsDefault(2);
			role.setCreateId(user.getId());
			role.setCreateTime(new Date());
			role.setCreateUser(user.getTeaName());
			//编写对象参数--结束
			
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
	
	/**
	 * 修改角色
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	public JsonResult updateRole(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long roleId = ToolUtil.lon("roleId", request);
			String roleName = ToolUtil.str("roleName", request);
		    String roleNum = ToolUtil.str("roleNum", request);
		    Integer roleOrder = ToolUtil.intWithNull("roleOrder", request);
		    Integer status = ToolUtil.intWithNull("status", request);
			
			Role role = roleService.findRoleById(roleId);
			if (role == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该角色！");
				return jsonResult;
			}
			role.setRoleName(roleName);
			role.setRoleNum(roleNum);
			role.setRoleOrder(roleOrder);
			role.setStatus(status);
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
	
	/**
	 * 设置为默认
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/setDefault")
	@ResponseBody
	public JsonResult setDefault(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long roleId = ToolUtil.lon("roleId", request);
			
			Role role = roleService.findRoleById(roleId);
			if (role == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该角色！");
				return jsonResult;
			}
			role.setIsDefault(1);
			role.setModifyId(user.getId());
			role.setModifyTime(new Date());
			role.setModifyUser(user.getTeaName());
			
			int result = roleService.setDefault(role);
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
	 * 获取角色列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getRoleList")
	@ResponseBody
	public JsonResult getRoleList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			int page = ToolUtil.integer("page", request);
			int limit = ToolUtil.integer("limit", request);
			
			Map<String, Object> par = new HashMap<>();
			//获取总数量
			par.put("isNotDel", 1);
			int count = roleService.countRoleList(par);
			
			PageVO pageVO = new PageVO(page, limit);
			
			par.put("beginNum", pageVO.getBeginNum());
			par.put("endNum", pageVO.getEndNum());
			
			List<Role> roleList = roleService.queryRoleList(par);
			jsonResult = JsonResult.build(FLAG_SUCCESS, roleList, null, count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
