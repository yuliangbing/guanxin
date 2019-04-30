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

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.service.SpecialtyProfileService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("specialtyProfile")
public class SpecialtyProfileController extends BaseController{
   private Logger logger = Logger.getLogger(SpecialtyProfileController.class);
   
   @Autowired
   private SpecialtyProfileService specialtyProfileService;

private Long branchIntroduction;
   
   @RequestMapping("/getSpecialtyProfileList")
   @ResponseBody
   public JsonResult getSpecialtyProfile(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取专业文件列表接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
	/*	int id = ToolUtil.integer("id", request);
		Long specialty_id = ToolUtil.lon("specialty_id", request);
	    Date date = ToolUtil.date2("date", request);
	    String position = ToolUtil.str("position", request);
	    String characteristic = ToolUtil.str("characteristic", request);
	    Long director_id = ToolUtil.lon("director_id", request);
	    String director_name = ToolUtil.str("director_name", request);
	    Integer status = ToolUtil.integer("status", request);
	    Long branch_introduction = ToolUtil.lon("branch_introduction", request);*/
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    Integer pages = 0;
		//用于分页的数据
		pages = (page - 1) * limit;
		//存入data,用于获取表格数据
/*	    data.put("specialty_id", specialty_id);
	    data.put("position", position);
	    data.put("characteristic", characteristic);
	    data.put("director_id", director_id);
//	    data.put("specialty_id", specialty_id);
	    data.put("date", date);
		data.put("director_name", director_name);
		data.put("branch_introduction", branch_introduction);*/
		data.put("limit", limit);
		data.put("pages", pages);
		data.put("status", 1);
	
		System.out.println("pages:"+pages);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
	/*	count.put("specialty_id", specialty_id);
		count.put("position", position);
		count.put("characteristic", characteristic);
		count.put("director_id", director_id);
		count.put("director_name", director_name);
		count.put("branch_introduction", branch_introduction);
		count.put("date", date);*/
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "msg";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<SpecialtyProfile> SpecialtyProfileList = specialtyProfileService.getSpecialtyProfileList(data);
			//获取所有status == 1的数据条总数
			counts = specialtyProfileService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(FLAG_SUCCESS, SpecialtyProfileList, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
   @RequestMapping("/updateSpecialtyProfilesIf")
	@ResponseBody
	public JsonResult updateSpecialtyIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyFilesIf方法");
		Long id = ToolUtil.lon("id", request);
		String position = ToolUtil.str("position", request);
	    String characteristic = ToolUtil.str("characteristic", request);
	    String director_name = ToolUtil.str("director_name", request);
	    Long specialty_id = ToolUtil.lon("specialty_id", request);
	    Long director_id = ToolUtil.lon("director_id", request);
	    Long branch_introduction = ToolUtil.lon("branch_introduction", request); 
	    Integer status = ToolUtil.integer("status", request);
	    Date date = ToolUtil.date2("date", request);
	    status = 1;
	   // System.out.println("判断返回的值"+(ToolUtil.equalBool(position)&&ToolUtil.equalBool(characteristic)&&ToolUtil.equalBool(director_name)&&ToolUtil.equalBool(director_id)&&ToolUtil.equalBool(branch_introduction)&&ToolUtil.equalBool(date)));
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//		//根据specialtyFilesId
	    SpecialtyProfile specialtyProfile = specialtyProfileService.findSpecialtyProfileById(id);
	    if (specialtyProfile == null) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
			return jsonResult;
		}
	    specialtyProfile.setDate(date);
	    System.out.println(date);
	    specialtyProfile.setBranchIntroduction(branch_introduction);
	    specialtyProfile.setCharacteristic(characteristic);
	    specialtyProfile.setDirectorId(director_id);
	    specialtyProfile.setDirectorName(director_name);
	    specialtyProfile.setSpecialtyId(specialty_id);
	    specialtyProfile.setPosition(position);
	    specialtyProfile.setId(id);
	    specialtyProfile.setStatus(status);
	    specialtyProfile.setModifyTime(new Date());
	    specialtyProfile.setModifyUser(user.getTeaName());
	   
	    //判断传入的值是否为空或""
	    if ((ToolUtil.equalBool(position)&&ToolUtil.equalBool(characteristic)&&ToolUtil.equalBool(director_name)&&ToolUtil.equalBool(director_id)&&ToolUtil.equalBool(branch_introduction)&&ToolUtil.equalBool(date)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("updateSpecialtyIf方法拿到的数据："+specialtyProfile.toString());
	    	return jsonResult;
		}
	    	System.out.println("传入数据成功");
			try {
				
//				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//				//根据specialtyFilesId查询
//			    SpecialtyFiles specialtyFiles = specialtyFilesService.findSpecialtyFilesById(specialtyFilesId);
//			    if (specialtyFiles == null) {
//			    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
//					return jsonResult;
//				}
//			    specialtyFiles.setDate(date);
//			    specialtyFiles.setCode(code);
//			    specialtyFiles.setName(name);
//			    specialtyFiles.setCateName(cateName);
//			    specialtyFiles.setReviser(reviser);
//			    specialtyFiles.setSpecialtyId(specialty_id);
//			    specialtyFiles.setStatus(status);
//			    specialtyFiles.setModifyTime(new Date());
//			    specialtyFiles.setModifyUser(user.getTeaName());
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
	/*不带if的修改*/
	/*@RequestMapping("/updateSpecialtyFiles")
	@ResponseBody
	public JsonResult updateSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyFiles方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyFilesId = ToolUtil.lon("specialtyFilesId", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    String cateName = ToolUtil.str("cateName", request);
		    String reviser = ToolUtil.str("reviser", request);
		    Long specialtyId = ToolUtil.lon("specialtyId", request);
		    //
		    Integer status = ToolUtil.integer("status", request);
		    Date date = ToolUtil.date1("date", request);
		    
		    SpecialtyFiles specialtyFiles = specialtyFilesService.findSpecialtyFilesById(specialtyFilesId);
		    if (specialtyFiles == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialtyFiles.setCode(code);
		    specialtyFiles.setName(name);
		    specialtyFiles.setCateName(cateName);
		    specialtyFiles.setReviser(reviser);
		    specialtyFiles.setSpecialtyId(specialtyId);
		    specialtyFiles.setStatus(status);
		    specialtyFiles.setModifyTime(new Date());
		    specialtyFiles.setModifyUser(user.getTeaName());
		    int result = specialtyFilesService.modifySpecialtyFilesKey(specialtyFiles);
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
	}*/
	/*删除专业文件(数据库删除)*/
	/*@RequestMapping("/deleteSpecialtyFiles")
	@ResponseBody
	public JsonResult deleteSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用deleteSpecialtyFiles方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyFilesId = ToolUtil.lon("specialtyFilesId", request);
		    
		    int result = specialtyFilesService.deleteSpecialtyFilesById(specialtyFilesId);
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
	}*/
	/*根据id进行软删除（修改status状态码）*/
	@RequestMapping("/delSpecialtyProfile")
	@ResponseBody
	public JsonResult delSpecialtyFiles(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delSpecialtyProfile方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			int status = ToolUtil.integer("status", request);
			status = 2;
			Long specialtyFilesId = ToolUtil.lon("specialtyFilesId", request);
			System.out.println("id"+specialtyFilesId);
		    //判断是否有该专业
			SpecialtyProfile specialtyFiles = specialtyProfileService.findSpecialtyProfileById(specialtyFilesId);
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
}
