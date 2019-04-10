package com.zptc.gx.controller.specialty;

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
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.service.SpecialtyService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/specialty")
public class SpecialtyController extends BaseController {
	private Logger logger = Logger.getLogger(SpecialtyController.class);
	
	@Autowired
	private SpecialtyService specialtyService; 
	
	/*获取列表*/
	
	@RequestMapping("/getSpecialty")
	@ResponseBody
	public JsonResult getSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//Long roleId = user.getRoleId();
//			Long specialtyId = user.getRoleId();
			List<Specialty> specialtyList = specialtyService.getSpecialtyIdList(null);
			jsonResult = JsonResult.build(FLAG_SUCCESS, specialtyList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/*新增分院*/
	
	@RequestMapping("/addSpecialty")
	@ResponseBody
	public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date setup_date = ToolUtil.date1("setup_date", request);
		    
		    Specialty specialty = new Specialty();
		    specialty.setCode(code);
		    specialty.setName(name);
		    specialty.setSetupDate(setup_date);
		    specialty.setCreateTime(new Date());
		    specialty.setCreateUser(user.getTeaName());
		    int result = specialtyService.addSpecialty(specialty);
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
	/*分院修改*/
	/*带if的修改*/
	@RequestMapping("/updateSpecialtyIf")
	@ResponseBody
	public JsonResult updateSpecialtyIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyId = ToolUtil.lon("specialtyId", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date setup_date = ToolUtil.date1("setup_date", request);
		    
		    Specialty specialty = specialtyService.findSpecialtyById(specialtyId);
		    if (specialty == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialty.setCode(code);
		    specialty.setName(name);
		    specialty.setSetupDate(setup_date);
		    specialty.setModifyUser(user.getTeaName());
		    specialty.setModifyTime(new Date());
		    int result = specialtyService.modifySpecialty(specialty);
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
	@RequestMapping("/updateSpecialty")
	@ResponseBody
	public JsonResult updateSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyId = ToolUtil.lon("specialtyId", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date setup_date = ToolUtil.date1("setup_date", request);
		    
		    Specialty specialty = specialtyService.findSpecialtyById(specialtyId);
		    if (specialty == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialty.setCode(code);
		    specialty.setName(name);
		    specialty.setSetupDate(setup_date);
		    specialty.setModifyUser(user.getTeaName());
		    specialty.setModifyTime(new Date());
		    int result = specialtyService.modifySpecialtyKey(specialty);
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
	/*删除分院*/
	@RequestMapping("/deleteSpecialty")
	@ResponseBody
	public JsonResult deleteSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用deleteSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyId = ToolUtil.lon("specialtyId", request);
		    
		    int result = specialtyService.deleteSpecialtyById(specialtyId);
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
