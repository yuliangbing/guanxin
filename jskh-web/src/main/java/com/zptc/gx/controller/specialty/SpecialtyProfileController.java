package com.zptc.gx.controller.specialty;

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
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.service.SpecialtyProfileService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;
/**
 * 专业概况接口
 * @author Administrator
 *
 */
@Controller
@RequestMapping("specialtyProfile")
public class SpecialtyProfileController extends BaseController{
   private Logger logger = Logger.getLogger(SpecialtyProfileController.class);
   
   @Autowired
   private SpecialtyProfileService specialtyProfileService;

/**
 * 获取id为入参specilaty_id的数据(该接口别修改)
 * @param request
 * @param response
 * @return
 */
@RequestMapping("/ByIdSpecialtyProfile")
@ResponseBody
public JsonResult ByIdSpecialtyProfile(HttpServletRequest request, HttpServletResponse response) {
	JsonResult jsonResult = new JsonResult();
	Long specialty_id = ToolUtil.lon("specialty_id", request);
	Map<String, Object> map = new HashMap<>();
	map.put("specialty_id", specialty_id);
	map.put("status", 1);
	
  // SpecialtyProfile specialtyProfile = specialtyProfileService.findSpecialtyProfileByIdAndStatus(map);
   List<SpecialtyProfile> specialtyProfile = specialtyProfileService.findSpecialtyProfileByIdAndStatus(map);
   Integer count = 0;
	try {
	    if (specialtyProfile != null) {
	    	jsonResult = JsonResult.build(FLAG_SUCCESS,specialtyProfile,"获取成功",count);
		} else {
			jsonResult = JsonResult.build(FLAG_FAILED,"不存在数据！");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
	}
	return jsonResult;
}

//增加专业概况信息
@RequestMapping("/addSpecialtyProfile")
@ResponseBody
public JsonResult addSpecialtyProfile(HttpServletRequest request, HttpServletResponse response) {
	JsonResult jsonResult = new JsonResult();
	System.out.println("添加接口");
	try {
		ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		
		//Long id = ToolUtil.lon("id", request);
		String position = ToolUtil.str("position", request);
	    String characteristic = ToolUtil.str("characteristic", request);
	    Date date = ToolUtil.date2("date", request);
	    String director_name = ToolUtil.str("director_name", request);
	    Long specialty_id = ToolUtil.lonWithNull("specialty_id", request);
	    String specialty_name = ToolUtil.str("specialty_name", request);
	    Long branch_introduction = ToolUtil.lon("branch_introduction", request); 
	    Integer status = ToolUtil.integer("status", request);
	    
	   SpecialtyProfile specialtyProfile= new SpecialtyProfile();
	  //specialtyProfile.setId(id);
	  specialtyProfile.setPosition(position);
	  specialtyProfile.setCharacteristic(characteristic);
	  specialtyProfile.setDate(date);
	  specialtyProfile.setDirectorName(director_name);
	  specialtyProfile.setSpecialtyId(specialty_id);
	  specialtyProfile.setSpecialtyName(specialty_name);
	  specialtyProfile.setBranchIntroduction(branch_introduction);
	  specialtyProfile.setStatus(1);
	  specialtyProfile.setCreateTime(new Date());
	  specialtyProfile.setCreateUser(user.getTeaName());
	  if ((ToolUtil.equalBool(position)&&ToolUtil.equalBool(characteristic)
	&&ToolUtil.equalBool(director_name)&&ToolUtil.equalBool(specialty_name)&&ToolUtil.equalBool(branch_introduction)) == false) {
		jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
		return jsonResult;
	  }
	  System.out.println("传入数据成功");
       System.out.println("addSpecialtyProfile方法拿到的数据："+specialtyProfile.toString());
	 int result = specialtyProfileService.addSpecialtyProfile(specialtyProfile);
	 if (result>0) {
		jsonResult = JsonResult.build(FLAG_SUCCESS);
	}else {
		jsonResult = JsonResult.build(FLAG_FAILED);
	}
	}	 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
		 jsonResult = JsonResult.build(FLAG_SUCCESS, e.getMessage());
	}
	return jsonResult;
}

/*根据id进行软删除（修改status状态码）*/
@RequestMapping("/delSpecialtyProfile")
@ResponseBody
public JsonResult delSpecialtyProfile(HttpServletRequest request, HttpServletResponse response) {
	JsonResult jsonResult = new JsonResult();
	System.out.println("启用delSpecialtyProfile方法");
	try {
		ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		Long id =ToolUtil.lonWithNull("id",request);
		int status = ToolUtil.integer("status", request);
		status = 2;
		System.out.println("id"+id);
	    //判断是否有该专业
		SpecialtyProfile specialtyFiles = specialtyProfileService.findSpecialtyProfileById(id);
		if (specialtyFiles == null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
			return jsonResult;
		}
		specialtyFiles.setStatus(status);
	    int result = specialtyProfileService.modifSpecialtyFilesDel(specialtyFiles);
	    System.out.println("status："+status);
	    System.out.println("result:"+result);
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
//   修改专业概况信息
   @RequestMapping("/updateSpecialtyProfilesIf")
	@ResponseBody
	public JsonResult updateSpecialtyIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyProfilesIf方法");
		Long id = ToolUtil.lon("id", request);
		String position = ToolUtil.str("position", request);
	    String characteristic = ToolUtil.str("characteristic", request);
	 /*   String director_name = ToolUtil.str("director_name", request);*/
	    Long specialty_id = ToolUtil.lon("specialty_id", request);
	    String specialty_name = ToolUtil.str("specialty_name",request);
	  /*  Long director_id = ToolUtil.lon("director_id", request);*/
	   /* Long branch_introduction = ToolUtil.lon("branch_introduction", request); */
	    Date date = ToolUtil.date2("date", request);
	   // System.out.println("判断返回的值"+(ToolUtil.equalBool(position)&&ToolUtil.equalBool(characteristic)&&ToolUtil.equalBool(director_name)&&ToolUtil.equalBool(director_id)&&ToolUtil.equalBool(branch_introduction)&&ToolUtil.equalBool(date)));
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//		//根据specialtyProfileId
	    SpecialtyProfile specialtyProfile = specialtyProfileService.findSpecialtyProfileById(id);
	    if (specialtyProfile == null) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
			return jsonResult;
		}
	    specialtyProfile.setDate(date);
	    System.out.println(date);
//	    specialtyProfile.setBranchIntroduction(branch_introduction);
	    specialtyProfile.setCharacteristic(characteristic);/*
	    specialtyProfile.setDirectorId(director_id);
	    specialtyProfile.setDirectorName(director_name);*/
	    specialtyProfile.setSpecialtyId(specialty_id);
	    specialtyProfile.setSpecialtyName(specialty_name);
	    specialtyProfile.setPosition(position);
	    specialtyProfile.setId(id);
	    specialtyProfile.setModifyTime(new Date());
	    specialtyProfile.setModifyUser(user.getTeaName());
	   
//	    判断传入的值是否为空或""
	    if ((ToolUtil.equalBool(position)&&ToolUtil.equalBool(specialty_name)&&ToolUtil.equalBool(characteristic)&&ToolUtil.equalBool(date)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("updateSpecialtyIf方法拿到的数据："+specialtyProfile.toString());
	    	return jsonResult;
		}
	    	System.out.println("传入数据成功");
			try {
			    //接口拿到的数据
			    System.out.println("updateSpecialtyProfileIf方法拿到的数据："+specialtyProfile.toString());
			    int result = specialtyProfileService.modifySpecialtyProfile(specialtyProfile);
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


//  获取获取专业概况列表
 @RequestMapping("/getSpecialtyProfileList")
 @ResponseBody
 public JsonResult getSpecialtyProfile(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取专业概况列表接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String date1 = ToolUtil.str("date1", request);
		String date2 = ToolUtil.str("date2", request);
		String specialtyName = ToolUtil.str("specialty_name", request);
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
		//用于分页的数据
	    pages = pageVO.getBeginNum();
		//存入data,用于获取表格数据
	    data.put("date1", date1);
	    data.put("date2", date2);
	    data.put("specialty_name", specialtyName);
	    
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
	
		System.out.println("pages:"+pages);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("date1", date1);
		count.put("date2", date2);
		count.put("specialty_name", specialtyName);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "msg";
		try {
			//ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<SpecialtyProfile> SpecialtyProfileList = specialtyProfileService.getSpecialtyProfileList(data);
			//获取所有status == 1的数据条总数
			counts = specialtyProfileService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = JsonResult.build(FLAG_SUCCESS, SpecialtyProfileList, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
