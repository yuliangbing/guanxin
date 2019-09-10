package com.zptc.gx.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.permission.service.RoleService;
import com.zptc.gx.permission.service.ZptcUserService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 用户表
 * @author L6617
 *
 */
@Controller
@RequestMapping("/ZptcUser")
public class ZptcUserController extends BaseController{

	@Autowired
	private ZptcUserService zptcUserService;
//添加用户
	@RequestMapping("/addZptcUser")
	@ResponseBody
	 public JsonResult addZptcUser(HttpServletRequest request, HttpServletResponse responses) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("添加用户接口");
		try {
			ZptcUser user = (ZptcUser)request.getSession().getAttribute(Constant.USER_SESSION);
			String teaName = ToolUtil.str("tea_name", request);
		    String teaCode = ToolUtil.str("tea_code", request);
		    String tel = ToolUtil.str("tel", request);
		    Long roleId = ToolUtil.lon("role_id", request);
		    String roleName = ToolUtil.str("role_name", request);
		    String password = ToolUtil.str("password", request);
		    Integer status = ToolUtil.integer("status", request);
			ZptcUser  zptcUser = new ZptcUser();
			zptcUser.setTeaName(teaName);
			zptcUser.setTeaCode(teaCode);
			zptcUser.setTel(tel);
			zptcUser.setRoleId(roleId);
			zptcUser.setRoleName(roleName);
			zptcUser.setPassword(password);
			zptcUser.setStatus(1);
			zptcUser.setRegisterTime(new Date());
//			判断数据是否为空
			 if ((ToolUtil.equalBool(teaName)&&ToolUtil.equalBool(teaCode)&&ToolUtil.equalBool(tel)
			   &&ToolUtil.equalBool(roleId)&&ToolUtil.equalBool(roleName)&&ToolUtil.equalBool(password)) == false) {
			    jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
				return jsonResult;
			  }
			 System.out.println("传入数据成功");
			   System.out.println("addZptcUser方法拿到数据");
			   int result = zptcUserService.addZptcUser(zptcUser);
			   if (result > 0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
                jsonResult = JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_SUCCESS, e.getMessage());
		}
		return jsonResult;
	}
//	删除用户
	@RequestMapping("/delZptcUser")
	 @ResponseBody
	 public JsonResult delZptcUser(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult =new JsonResult();
	     System.out.println("使用delZptcUser方法");
	     try {
	    	  ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    	  Long id =ToolUtil.lonWithNull("id",request);
	 		 int status = ToolUtil.integer("status", request);
	 	       System.out.println("id"+id);
	 	     ZptcUser zptcUser = zptcUserService.findZptcUserById(id);
	 	     if (zptcUser ==null) {
	 	    	jsonResult = JsonResult.build(FLAG_SUCCESS,"没有该用户信息");
				return jsonResult; 
			}
	 	     zptcUser.setStatus(2);
	 	     int result = zptcUserService.modifyZptcUserDel(zptcUser);
	 	     if (result > 0 ) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
                jsonResult = JsonResult.build(FLAG_FAILED);
			}
	     } catch (Exception e) {
			// TODO: handle exception
		   e.printStackTrace();
		   jsonResult = JsonResult.build(FLAG_SUCCESS, e.getMessage());
	     }
	     return jsonResult;
	}
//	修改用户信息
	@RequestMapping("/updateZptcUser")
	@ResponseBody
	public JsonResult updateZptcUser(HttpServletRequest request, HttpServletResponse response) {
		ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION); 
		JsonResult jsonResult =new JsonResult();
		System.out.println("使用updateZptcUser方法");
		 Long id = ToolUtil.lon("id", request);
		String teaName = ToolUtil.str("tea_name", request);
	    String teaCode = ToolUtil.str("tea_code", request);
	    String tel = ToolUtil.str("tel", request);
	    Long roleId = ToolUtil.lon("role_id", request);
	    String roleName = ToolUtil.str("role_name", request);
	    String password = ToolUtil.str("password", request);
//	    根据id查找修改信息
	    ZptcUser zptcUser = zptcUserService.findZptcUserById(id);
	    if (zptcUser == null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该用户信息");
			return jsonResult;
		}
	    zptcUser.setTeaName(teaName);
	    zptcUser.setTeaCode(teaCode);
	    zptcUser.setTel(tel);
	    zptcUser.setRoleId(roleId);
	    zptcUser.setRoleName(roleName);
	    zptcUser.setPassword(password);
	    zptcUser.setModifyTime(new Date());
	    if ((ToolUtil.equalBool(teaName)&&ToolUtil.equalBool(teaCode)&&ToolUtil.equalBool(tel)
				 &&ToolUtil.equalBool(roleId)&&ToolUtil.equalBool(roleName)&&ToolUtil.equalBool(password)) == false) {
		jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
	   return jsonResult;
	}
	    System.out.println("传入数据成功");
	    try {
			int result = zptcUserService.modifyZptcUser(zptcUser);
			if (result > 0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			}else {
				jsonResult = JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
	    return jsonResult;
	}
/**
 * 获取用户列表
 * 
 */
	@RequestMapping("/getZptcUserList")
	@ResponseBody
	 public JsonResult getZptcUserList(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取用户信息接口"); 
		JsonResult jsonResult  = new JsonResult();
		 Map<String , Object> data = new HashMap<>();
//		 获取请求参数
		 Date registerTime = ToolUtil.date2("register_time", request);
		 String teaCode = ToolUtil.str("tea_code",request);
		 Integer limit = ToolUtil.integer("limit", request);
	     Integer page = ToolUtil.integer("page", request);
	     Integer pages = 0;
//	     分页数据
	     PageVO pageVO = new PageVO(page, limit);
		pages = pageVO.getBeginNum();
		//存入data,用于获取表格数据
		data.put("tea_code", teaCode);
		data.put("register_time", registerTime);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
	    count.put("register_time", registerTime);
	    count.put("tea_code", teaCode);
	    count.put("status", 1);
		//定义返回的数据条总数，初值为0.
		int counts = 0;
		//定义返回的信息msg
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<ZptcUser> zptcUsers = zptcUserService.getZptcUser(data);
			//获取所有status == 1的数据条总数
			counts = zptcUserService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(FLAG_SUCCESS, zptcUsers, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
