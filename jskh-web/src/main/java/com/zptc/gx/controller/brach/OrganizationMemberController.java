package com.zptc.gx.controller.brach;

import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zptc.gx.branch.entity.OrganizationMember;
import com.zptc.gx.branch.entity.OrganizationType;
import com.zptc.gx.branch.service.OrganizationMemberService;
import com.zptc.gx.branch.service.OrganizationTypeService;
import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.controller.specialty.SpecialtyFilesController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.util.ToolUtil;


@Controller
@RequestMapping("/organizationMember")
public class OrganizationMemberController extends BaseController{

	private Logger logger = Logger.getLogger(SpecialtyFilesController.class);
	
	@Autowired
    private OrganizationMemberService organizationMemberService;
	
//	获取组织机构成员列表
	@RequestMapping("/getOrganizationMemberList")
	@ResponseBody
	public JsonResult getOrganizationMember(HttpServletRequest request, HttpServletResponse responses) {
		JsonResult jsonResult =new JsonResult();
		Map<String, Object> data= new HashMap<>();
//		获取请求参数
		//Long id = ToolUtil.lon("id", request);
		String position = ToolUtil.str("position",request);
	    String name = ToolUtil.str("name", request);
	 //  Integer status= ToolUtil.integer("status",request);
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    Integer pages = 0;
//	    Integer pages = page;
	    Integer limits = 0;
//	    用于分页的数据
	  //存入data,用于获取表格数据
	    //data.put("id", id);
	    data.put("name", name);
	    data.put("position", position);
	    data.put("status", 1);
		data.put("limits", limits);
		data.put("page", page); 
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
//		count.put("counts", count);
		//count.put("id", id);
		count.put("name", name);
		count.put("position", position);
		count.put("status", 1);
		int counts=0;
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			List<OrganizationMember>  OrganizationTypeList = organizationMemberService.getOrganizationMemberList(data);
			jsonResult =jsonResult.build(FLAG_SUCCESS, OrganizationTypeList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED,e.getMessage());
		}
		return jsonResult;
	}
	
	//新增组织成员
	@RequestMapping("/addOrganizationMember")
	@ResponseBody
	public JsonResult addOrganizationMember(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult =new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			   
			Long id = ToolUtil.lon("id", request);
		    String name = ToolUtil.str("name", request);
		    String position = ToolUtil.str("position",request);
		    OrganizationMember organizationMember =new OrganizationMember();
		    organizationMember.setId(id);
		    organizationMember.setName(name);
		    organizationMember.setPosition(position);
		    organizationMember.setCreateTime(new Date());
		    organizationMember.setCreateUser(user.getTeaName());
		    int result = organizationMemberService.addOrganizationMember(organizationMember);
		    if (result>0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
                jsonResult =JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
//	组织成员修改
	@RequestMapping("/updateOrganizationMember")
	@ResponseBody
	public JsonResult updateOrganizationMember(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult =new JsonResult();
		try {
			ZptcUser user=(ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		
			Long id = ToolUtil.lon("id", request);
		    String name = ToolUtil.str("name", request);
		    String position = ToolUtil.str("position",request);
		    OrganizationMember organizationMember =organizationMemberService.findOrganizationMemberById(id);
		    if (organizationMember == null) {
				jsonResult = JsonResult.build(FLAG_FAILED,"没有该组织成员");
				return jsonResult;
			} 
		    organizationMember.setId(id);
		    organizationMember.setName(name);
		    organizationMember.setPosition(position);
		    organizationMember.setCreateTime(new Date());
		    organizationMember.setCreateUser(user.getTeaName());
		    int result = organizationMemberService.modifyOrganizationMember(organizationMember);
		    if (result>0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
               jsonResult = jsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
//	删除组织成员
	@RequestMapping("/deleteOrganizationMember")
	@ResponseBody
	public JsonResult deleteOrganizationMember(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult =new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		   
			Long id = ToolUtil.lon("id",request);
//			软删除处理
			OrganizationMember organizationMember =organizationMemberService.findOrganizationMemberById(id);
			if (organizationMember == null) {
				jsonResult = JsonResult.build(FLAG_FAILED,"没有该组织成员");
				return jsonResult;
			}
			organizationMember.setStatus(2);
			int result = organizationMemberService.delOrganizationMemberById(organizationMember);
			if (result>0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
                jsonResult = JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
