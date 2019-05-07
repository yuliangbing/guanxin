package com.zptc.gx.controller.brach;

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

import com.zptc.gx.branch.entity.OrganizationType;
import com.zptc.gx.branch.service.OrganizationTypeService;
import com.zptc.gx.branch.service.impl.OrganizationTypeServiceImpl;
import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.controller.specialty.SpecialtyFilesController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.util.ToolUtil;

import java.util.List;

@Controller
@RequestMapping("/organizationType")
public class OrganizationTypeController extends BaseController{
	private Logger logger = Logger.getLogger(SpecialtyFilesController.class);
	
	@Autowired
    private OrganizationTypeService organizationTypeService;
	
//	获取组织列表
	@RequestMapping("/getOrganizationTypeList")
	@ResponseBody
	public JsonResult getOrganizationType(HttpServletRequest request, HttpServletResponse responses) {
		JsonResult jsonResult =new JsonResult();
		Map<String, Object> data = new HashMap<>();
//		获取请求参数
		Long id = ToolUtil.lon("id", request);
	    String name = ToolUtil.str("name", request);
	    Integer status= ToolUtil.integer("status",request);
//	    String date1 = ToolUtil.str("date1", request);
//	    String date2 = ToolUtil.str("date2", request);
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    Integer pages = 0;
//	    Integer pages = page;
	    Integer limits = 0;
//	    用于分页的数据
	  //存入data,用于获取表格数据
	    data.put("id", id);
	    data.put("name", name);
	    data.put("status", 1);
		data.put("limits", limits);
		data.put("page", page);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
//		count.put("counts", count);
		count.put("id", id);
		count.put("name", name);
		count.put("status", 1);
		int counts=0;
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	        //获取所有status == 1 的所有数据
			List<OrganizationType>    OrganizationTypeList = organizationTypeService.getOrganizationTypeList(data);
			//获取所有status == 1的数据条总数
			counts = organizationTypeService.selectCounts(count);
			jsonResult = jsonResult.build(FLAG_SUCCESS, OrganizationTypeList, msg, counts);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult  =JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
//	新增组织类型
	@RequestMapping("/addOrganizationType")
	@ResponseBody
	public JsonResult addOrganizationType(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult =new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		   
			Long id = ToolUtil.lon("id", request);
		    String name = ToolUtil.str("name", request);
		    Integer status = ToolUtil.integer("status", request);
		     OrganizationType organizationType = new OrganizationType();
		     organizationType.setId(id);
		     organizationType.setName(name);
		     organizationType.setCreateTime(new Date());
		     organizationType.setCreateUser(user.getTeaName());
		     organizationType.setStatus(1);
		     if ((ToolUtil.equalBool(id)&&ToolUtil.equalBool(name)) == false) {
 				jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
		     	return jsonResult;
	     	  }
		     int result = organizationTypeService.addOrganizationType(organizationType);
		     if (result>0) {
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
//	组织类型修改
	@RequestMapping("/updateOrganizationType")
	@ResponseBody
	public JsonResult updateOrganizationType(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long id = ToolUtil.lon("id", request);
		    String name = ToolUtil.str("name", request);
		    
		    OrganizationType organizationType = organizationTypeService.findOrganizationTypeById(id);
		    if (organizationType==null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该组织类型");
				return jsonResult;
			}
		    
		    organizationType.setId(id);
		    organizationType.setName(name);
		    organizationType.setModifyUser(user.getTeaName());
		    organizationType.setModifyTime(new Date());
		    int result = organizationTypeService.modifyOrganizationType(organizationType);
		    if (result>0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			}else {
				jsonResult = JsonResult.build(FLAG_FAILED);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED,e.getMessage());
		}
		return jsonResult;
	}
//	删除组织类型
	@RequestMapping("/deleteOrganizationType")
	@ResponseBody
	public JsonResult deleteOrganizationType(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		    
			Long id = ToolUtil.lon("id", request);
//			用软删除处理
			OrganizationType organizationType = organizationTypeService.findOrganizationTypeById(id);
//			System.out.println(organizationType.toString());
			if (organizationType ==null) {
				jsonResult=JsonResult.build(FLAG_FAILED,"没有该条数据");
				return jsonResult;
			}
			organizationType.setStatus(2);
			int result = organizationTypeService.delOrganizationTypeById(organizationType);
			if (result>0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			} else {
                jsonResult = JsonResult.build(FLAG_SUCCESS);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
