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
	private RoleService roleService;// Autowired：spring注解自动注入roleService

	/**
	 * 添加角色
	 * 
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

			// 接受前端数据--开始
			String roleName = ToolUtil.str("roleName", request);
			String roleNum = ToolUtil.str("roleNum", request);
			Integer roleOrder = ToolUtil.integer("roleOrder", request);
			// 接受前端数据--结束

			// 编写对象参数--开始
			Role role = new Role();
			role.setRoleName(roleName);
			role.setRoleNum(roleNum);
			role.setRoleOrder(roleOrder);
			role.setStatus(1);
			// 设为不默认
			role.setIsDefault(2);
			role.setCreateId(user.getId());
			role.setCreateTime(new Date());
			role.setCreateUser(user.getTeaName());
			// 编写对象参数--结束

			// 保存数据
			int result = roleService.addRole(role);

			// jsonResult:返回的数据格式
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
	 * 
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

			// 接受前端数据
			Long roleId = ToolUtil.lon("roleId", request);
			String roleName = ToolUtil.str("roleName", request);
			String roleNum = ToolUtil.str("roleNum", request);
			Integer roleOrder = ToolUtil.intWithNull("roleOrder", request);
			Integer status = ToolUtil.intWithNull("status", request);

			// 查询是否有该角色
			Role role = roleService.findRoleById(roleId);

			// 如果没有该角色
			if (role == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该角色！");
				return jsonResult;
			}

			// 修改角色的数据开始
			role.setRoleName(roleName);
			role.setRoleNum(roleNum);
			role.setRoleOrder(roleOrder);
			role.setStatus(status);
			role.setModifyId(user.getId());
			role.setModifyTime(new Date());
			role.setModifyUser(user.getTeaName());
			// 修改角色的数据结束

			// 保存角色数据
			int result = roleService.modifyRole(role);

			// jsonResult:返回的数据格式
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
	 * 
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

			// 接受前端数据
			Long roleId = ToolUtil.lon("roleId", request);

			// 查询是否有该角色
			Role role = roleService.findRoleById(roleId);

			// 如果没有该角色
			if (role == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该角色！");
				return jsonResult;
			}

			// 修改角色的数据开始
			role.setIsDefault(1);// 设为默认
			role.setModifyId(user.getId());
			role.setModifyTime(new Date());
			role.setModifyUser(user.getTeaName());
			// 修改角色的数据结束

			// 保存角色数据
			int result = roleService.setDefault(role);

			// jsonResult:返回的数据格式
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
	 * 
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

			// 获取前端的筛选参数
			int page = ToolUtil.integer("page", request);// 分页的页码
			int limit = ToolUtil.integer("limit", request);// 分页显示的数量

			// par是用来传筛选参数给sql语句的（键值对）
			Map<String, Object> par = new HashMap<>();
			par.put("isNotDel", 1);

			// 获取角色总数量
			int count = roleService.countRoleList(par);
			// 1.可以按住ctrl+左键点击countRoleList的Declaration查看service接口
			// 2.可以按住ctrl+左键点击countRoleList的Implementation查看service接口

			// 分页参数开始
			PageVO pageVO = new PageVO(page, limit);
			par.put("beginNum", pageVO.getBeginNum());
			par.put("endNum", pageVO.getEndNum());
			// 分页参数结束

			// 查询分页的角色列表
			List<Role> roleList = roleService.queryRoleList(par);

			// 编写返回的数据格式（FLAG_SUCCESS：返回编码；roleList：返回的数据，null：返回的消息字符串；count：总数量）
			jsonResult = JsonResult.build(FLAG_SUCCESS, roleList, null, count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
