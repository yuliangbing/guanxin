package com.zptc.gx.controller.specialty;

import java.util.ArrayList;
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
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.service.SpecialtyFilesService;
import com.zptc.gx.specialty.service.SpecialtyService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/specialtyFiles")
public class SpecialtyFilesController extends BaseController {
	private Logger logger = Logger.getLogger(SpecialtyFilesController.class);
	
	@Autowired
	private SpecialtyFilesService specialtyFilesService; 
	
	/*获取列表*/
	@RequestMapping("/getSpecialtyFilesList")
	
	@ResponseBody
	public JsonResult getSpecialty(HttpServletRequest request, HttpServletResponse responses) {
		JsonResult jsonResult = new JsonResult();
		//jsonResult.setCode(0);
//		List<Map<String, Object>> returnmap = new ArrayList<Map<String,Object>>();
		Map<String, Object> data = new HashMap<>();
		String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    String cateName = ToolUtil.str("cateName", request);
	    String reviser = ToolUtil.str("reviser", request);
	    Long specialtyId = ToolUtil.lon("specialtyId", request);
	    Integer status = ToolUtil.integer("status", request);
	    Date date1 = ToolUtil.date1("date", request);
	    data.put("code", code);
	    data.put("name", name);
		int limit = ToolUtil.integer("limit", request);
		int page = ToolUtil.integer("page", request);
		int counts = 0 ;
		page = (page - 1) * limit;
		data.put("limit", limit);
		data.put("page", page);
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//Long roleId = user.getRoleId();
			List<SpecialtyFiles> specialtyFilesList = specialtyFilesService.getSpecialtyFilesList(data);
			counts = specialtyFilesService.selectCounts(counts);
			String msg = "msg";
			System.out.println(page);
			System.out.println("map的data数据："+data);
			System.out.println("count值为："+counts);
			jsonResult = jsonResult.build(0, specialtyFilesList, msg, counts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/*新增专业文件*/
	
	@RequestMapping("/addSpecialtyFiles")
	@ResponseBody
	public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addSpecialtyFiles方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    String cateName = ToolUtil.str("cateName", request);
		    String reviser = ToolUtil.str("reviser", request);
		    Long specialtyId = ToolUtil.lon("specialtyId", request);
		    //
		    Integer status = ToolUtil.integer("status", request);
		    Date date = ToolUtil.date1("date", request);
		    
		    SpecialtyFiles specialtyFiles = new SpecialtyFiles();
		    specialtyFiles.setCode(code);
		    specialtyFiles.setName(name);
		    specialtyFiles.setCateName(cateName);
		    specialtyFiles.setReviser(reviser);
		    specialtyFiles.setSpecialtyId(specialtyId);
		    specialtyFiles.setStatus(status);
		    specialtyFiles.setCreateTime(new Date());
		    specialtyFiles.setCreateUser(user.getTeaName());
		    int result = specialtyFilesService.addSpecialtyFiles(specialtyFiles);
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
	/*专业文件修改*/
	/*带if的修改*/
	@RequestMapping("/updateSpecialtyFilesIf")
	@ResponseBody
	public JsonResult updateSpecialtyIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyFilesIf方法");
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
		    int result = specialtyFilesService.modifySpecialtyFiles(specialtyFiles);
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
	@RequestMapping("/updateSpecialtyFiles")
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
	}
	/*删除专业文件*/
	@RequestMapping("/deleteSpecialtyFiles")
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
	}
	/*根据id获取当前所选的数据*/
	
}
