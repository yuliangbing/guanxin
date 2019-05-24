package com.zptc.gx.controller.school;

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
import com.zptc.gx.controller.specialty.SpecialtyProfileController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.SchoolEnterpriseCooperation;
import com.zptc.gx.specialty.service.SchoolEnterpriseCooperationService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("SchoolEnterpriseCooperation")
public class SchoolEnterpriseCooperationController extends BaseController{
	 private Logger logger = Logger.getLogger(SchoolEnterpriseCooperationController.class);
	 
	 @Autowired
	 private SchoolEnterpriseCooperationService schoolEnterpriseCooperationService;
	 
//	新增校企合作信息
	 @RequestMapping("/addSchoolEnterpriseCooperation")
	 @ResponseBody
	 public JsonResult addSchoolEnterpriseCooperation(HttpServletRequest request, HttpServletResponse response) {
		 JsonResult jsonResult  = new JsonResult();
		 System.out.println("添加信息接口");
		 try {
			ZptcUser user = (ZptcUser)request.getSession().getAttribute(Constant.USER_SESSION);
			
			Date date = ToolUtil.date2("date", request);
			String content = ToolUtil.str("content", request);
		    String units = ToolUtil.str("units", request);
		    String participants = ToolUtil.str("participants", request);
		    String achievements = ToolUtil.str("achievements", request);
		    Long specialtyId = ToolUtil.lon("specialty_id", request);
		    String specialtyName = ToolUtil.str("specialty_name", request);
		    //Integer status = ToolUtil.integer("status", request);
		    
		    SchoolEnterpriseCooperation schoolEnterpriseCooperation = new SchoolEnterpriseCooperation();
		    schoolEnterpriseCooperation.setContent(content);
		    schoolEnterpriseCooperation.setUnits(units);
		    schoolEnterpriseCooperation.setParticipants(participants);
		    schoolEnterpriseCooperation.setAchievements(achievements);
		    schoolEnterpriseCooperation.setSpecialtyId(specialtyId);
		    schoolEnterpriseCooperation.setSpecialtyName(specialtyName);
		    schoolEnterpriseCooperation.setDate(date);
		    schoolEnterpriseCooperation.setStatus(1);
		    schoolEnterpriseCooperation.setCreateTime(new Date());
		    schoolEnterpriseCooperation.setCreateUser(user.getTeaName());
//		    判断数据是否为空
		    if ((ToolUtil.equalBool(content)&&ToolUtil.equalBool(units)&&ToolUtil.equalBool(date)
		   &&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(achievements)&&ToolUtil.equalBool(specialtyName)) == false) {
		    jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
			return jsonResult;
		  }
		   System.out.println("传入数据成功");
		   System.out.println("addSchoolEnterpriseCooperation方法拿到数据");
		  int result = schoolEnterpriseCooperationService.addSchoolEnterpriseCooperation(schoolEnterpriseCooperation);
		   if (result>0) {
			jsonResult = JsonResult.build(FLAG_SUCCESS);
		}else {
			jsonResult = JsonResult.build(FLAG_FAILED);
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_SUCCESS,e.getMessage());
		}
		 return jsonResult;
	 }
//	 删除校企合作信息
	 @RequestMapping("/delSchoolEnterpriseCooperation")
	 @ResponseBody
	 public JsonResult delSpecialtyProfile(HttpServletRequest request, HttpServletResponse response) {
	  JsonResult jsonResult =new JsonResult();
	  System.out.println("使用delSchoolEnterpriseCooperation方法");
	  try {
		  ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		  Long id =ToolUtil.lonWithNull("id",request);
		 int status = ToolUtil.integer("status", request);
	     System.out.println("id"+id);
	     SchoolEnterpriseCooperation schoolEnterpriseCooperation =schoolEnterpriseCooperationService.findSchoolEnterpriseCooperationById(id);
	    if (schoolEnterpriseCooperation == null) {
			jsonResult = JsonResult.build(FLAG_SUCCESS,"没有该校企合作信息");
			return jsonResult;
		}		 
	     schoolEnterpriseCooperation.setStatus(2);
	     int result = schoolEnterpriseCooperationService.modifySchoolEnterpriseCooperationDel(schoolEnterpriseCooperation);
	     if (result > 0) {
			jsonResult = JsonResult.build(FLAG_SUCCESS);
		}else {
			jsonResult = JsonResult.build(FLAG_FAILED);
		}
	  } catch (Exception e) {
		// TODO: handle exception
		  e.printStackTrace();
		  jsonResult = JsonResult.build(FLAG_SUCCESS,e.getMessage());
	}
	  return jsonResult;
  }
//	 修改校企合作信息
	 @RequestMapping("/updateSchoolEnterpriseCooperation")
	@ResponseBody
	public JsonResult updateSpecialtyIf(HttpServletRequest request, HttpServletResponse response) {
   ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION); 
    JsonResult jsonResult =new JsonResult();
	 System.out.println("使用updateSchoolEnterpriseCooperation方法");
	 Long id = ToolUtil.lon("id", request);
	 Date date = ToolUtil.date2("date", request);
	String content = ToolUtil.str("content", request);
    String units = ToolUtil.str("units", request);
    String participants = ToolUtil.str("participants", request);
    String achievements = ToolUtil.str("achievements", request);
    String specialtyName = ToolUtil.str("specialty_name", request);
//    根据id查找修改信息
	 SchoolEnterpriseCooperation schoolEnterpriseCooperation = schoolEnterpriseCooperationService.findSchoolEnterpriseCooperationById(id);
	 if (schoolEnterpriseCooperation == null) {
		 jsonResult = JsonResult.build(FLAG_FAILED, "没有该校企合作信息！");
	     return jsonResult;
	}
	 schoolEnterpriseCooperation.setDate(date);
	 schoolEnterpriseCooperation.setContent(content);
	 schoolEnterpriseCooperation.setUnits(units);
	 schoolEnterpriseCooperation.setParticipants(participants);
	 schoolEnterpriseCooperation.setAchievements(achievements);
	 schoolEnterpriseCooperation.setSpecialtyName(specialtyName);
	 schoolEnterpriseCooperation.setModifyTime(new Date());
	 schoolEnterpriseCooperation.setModifyUser(user.getTeaName());
	 if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(content)&&ToolUtil.equalBool(units)
			 &&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(achievements)&&ToolUtil.equalBool(specialtyName)) == false) {
	jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
   return jsonResult;
   }
	 System.out.println("传入数据成功");
	 try {
		 int result = schoolEnterpriseCooperationService.modifySchoolEnterpriseCooperation(schoolEnterpriseCooperation);
		 if (result > 0) {
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
//	 获取校企合作信息列表
	 @RequestMapping("/getSchoolEnterpriseCooperation")
	 @ResponseBody
	 public JsonResult getSpecialtyProfile(HttpServletRequest request, HttpServletResponse responses) {
		 System.out.println("获取校企合作信息列表接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
//		获取请求参数
		// Long id = ToolUtil.lon("id", request);
		String date1 = ToolUtil.str("date1", request);
		String date2 = ToolUtil.str("date2", request);
		//String content = ToolUtil.str("content", request);
	    String units = ToolUtil.str("units", request);
	   /* String participants = ToolUtil.str("participants", request);
	    String achievements = ToolUtil.str("achievements", request);
	    Long specialtyId = ToolUtil.lon("specialty_id", request);
	    String specialtyName = ToolUtil.str("specialty_name", request);*/
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
		//用于分页的数据
	    pages = pageVO.getBeginNum();
	  //存入data,用于获取表格数据
	    data.put("date1", date1);
	    data.put("date2", date2);
	  //  data.put("content", content);
	    data.put("units", units);
	   /* data.put("participants", participants);
	    data.put("achievements", achievements);
	    data.put("specialtyId", specialtyId);
	    data.put("specialtyName", specialtyName);*/
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		System.out.println("pages:"+pages);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("date1", date1);
		count.put("date2", date2);
		//count.put("content", content);
		count.put("units", units);
		/*count.put("participants", participants);
		count.put("achievements", achievements);
		count.put("specialtyId", specialtyId);
		count.put("specialtyName", specialtyName);*/
		count.put("limit", pageVO.getLimit());
		count.put("pages", pages);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "success";
		try {
			//ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<SchoolEnterpriseCooperation> schoolEnterpriseCooperationList = schoolEnterpriseCooperationService.getSchoolEnterpriseCooperationList(data);
			//获取所有status == 1的数据条总数
			counts = schoolEnterpriseCooperationService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = JsonResult.build(FLAG_SUCCESS, schoolEnterpriseCooperationList, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	 }
}
