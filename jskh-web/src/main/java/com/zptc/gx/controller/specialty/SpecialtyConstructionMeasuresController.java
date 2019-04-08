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
import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;
import com.zptc.gx.specialty.service.SpecialtyConstructionMeasuresService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/specialtyConstructionMeasures")
public class SpecialtyConstructionMeasuresController extends BaseController {
	private Logger logger = Logger.getLogger(SpecialtyConstructionMeasuresController.class);
	
	@Autowired
	private SpecialtyConstructionMeasuresService specialtyConstructionMeasuresService; 
	
	/*获取列表*/
	
	@RequestMapping("/getSpecialtyConstructionMeasures")
	@ResponseBody
	public JsonResult getSpecialtyConstructionAchievements(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//Long roleId = user.getRoleId();
			Long specialtyId = user.getRoleId();
			List<SpecialtyConstructionMeasures> specialtyConstructionMeasures = specialtyConstructionMeasuresService.getSpecialtyIdList(specialtyId);
			jsonResult = JsonResult.build(FLAG_SUCCESS, specialtyConstructionMeasures);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/*新增分院*/
	
	@RequestMapping("/addSpecialtyConstructionMeasures")
	@ResponseBody
	public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addSpecialtyConstructionMeasures方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			String measures = ToolUtil.str("measures", request);
		    Long specialtyId = ToolUtil.lon("specialtyId", request);
		    Date date = ToolUtil.date1("date", request);
		    
		    SpecialtyConstructionMeasures specialtyConstructionMeasures = new SpecialtyConstructionMeasures();
		    specialtyConstructionMeasures.setDate(date);
		    specialtyConstructionMeasures.setMeasures(measures);
		    specialtyConstructionMeasures.setSpecialtyId(specialtyId);
		    specialtyConstructionMeasures.setCreateTime(new Date());
		    specialtyConstructionMeasures.setCreateUser(user.getTeaName());
		    int result = specialtyConstructionMeasuresService.addSpecialtyConstructionMeasures(specialtyConstructionMeasures);
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
	@RequestMapping("/updateSpecialtyConstructionMeasuresIf")
	@ResponseBody
	public JsonResult updateSpecialtyConstructionAchievementsIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyConstructionMeasuresIf方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyMeasuresId = ToolUtil.lon("specialtyMeasuresId", request);	    
			String measures = ToolUtil.str("measures", request);
		    Long specialtyId = ToolUtil.lon("specialtyId", request);
		    Date date = ToolUtil.date1("date", request);
		    
		    SpecialtyConstructionMeasures specialtyConstructionMeasures = specialtyConstructionMeasuresService.findSpecialtyConstructionMeasuresById(specialtyMeasuresId);
		    if (specialtyConstructionMeasures == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialtyConstructionMeasures.setDate(date);
		    specialtyConstructionMeasures.setMeasures(measures);
		    specialtyConstructionMeasures.setSpecialtyId(specialtyId);
		    specialtyConstructionMeasures.setModifyTime(new Date());
		    specialtyConstructionMeasures.setModifyUser(user.getTeaName());
		    int result = specialtyConstructionMeasuresService.modifySpecialtyConstructionMeasures(specialtyConstructionMeasures);
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
	@RequestMapping("/updateSpecialtyConstructionMeasures")
	@ResponseBody
	public JsonResult updateSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyConstructionAchievements方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyMeasuresId = ToolUtil.lon("specialtyMeasuresId", request);	    
			String measures = ToolUtil.str("measures", request);
		    Long specialtyId = ToolUtil.lon("specialtyId", request);
		    Date date = ToolUtil.date1("date", request);
		    
		    SpecialtyConstructionMeasures specialtyConstructionMeasures = specialtyConstructionMeasuresService.findSpecialtyConstructionMeasuresById(specialtyMeasuresId);
		    if (specialtyConstructionMeasures == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialtyConstructionMeasures.setDate(date);
		    specialtyConstructionMeasures.setMeasures(measures);
		    specialtyConstructionMeasures.setSpecialtyId(specialtyId);
		    specialtyConstructionMeasures.setModifyTime(new Date());
		    specialtyConstructionMeasures.setModifyUser(user.getTeaName());
		    int result = specialtyConstructionMeasuresService.modifySpecialtyConstructionAchievementsKey(specialtyConstructionMeasures);
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
	@RequestMapping("/deleteSpecialtyConstructionMeasures")
	@ResponseBody
	public JsonResult deleteSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用deleteSpecialtyConstructionMeasures方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyConstructionMeasuresId = ToolUtil.lon("specialtyConstructionMeasuresId", request);
		    
		    int result = specialtyConstructionMeasuresService.deleteSpecialtyConstructionMeasuresById(specialtyConstructionMeasuresId);
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
