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
import com.zptc.gx.controller.permission.MenuController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;
import com.zptc.gx.specialty.service.SpecialtyConstructionAchievementsService;
import com.zptc.gx.specialty.service.SpecialtyService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/specialtyConstructionAchievements")
public class SpecialtyConstructionAchievementsController extends BaseController {
	
		private Logger logger = Logger.getLogger(SpecialtyConstructionAchievementsController.class);
		
		@Autowired
		private SpecialtyConstructionAchievementsService specialtyConstructionAchievementsService; 
		
		/*获取列表*/
		
		@RequestMapping("/getSpecialtyConstructionAchievements")
		@ResponseBody
		public JsonResult getSpecialtyConstructionAchievements(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("列表信息");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				//Long roleId = user.getRoleId();
				Long specialtyId = user.getRoleId();
				List<SpecialtyConstructionAchievements> specialtyConstructionAchievements = specialtyConstructionAchievementsService.getSpecialtyIdList(specialtyId);
				jsonResult = JsonResult.build(FLAG_SUCCESS, specialtyConstructionAchievements);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
			}
			return jsonResult;
		}
		
		/*新增分院*/
		
		@RequestMapping("/addSpecialtyConstructionAchievements")
		@ResponseBody
		public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用addSpecialtyConstructionAchievements方法");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				
				String sources = ToolUtil.str("sources", request);
			    String name = ToolUtil.str("name", request);
			    String level = ToolUtil.str("level", request);
			    String author = ToolUtil.str("author", request);
			    Long specialty_id = ToolUtil.lon("specialty_id", request);
			    Date date = ToolUtil.date1("date", request);
			    
			    SpecialtyConstructionAchievements specialtyConstructionAchievements = new SpecialtyConstructionAchievements();
			    specialtyConstructionAchievements.setDate(date);
			    specialtyConstructionAchievements.setName(name);
			    specialtyConstructionAchievements.setLevel(level);
			    specialtyConstructionAchievements.setAuthor(author);
			    specialtyConstructionAchievements.setSources(sources);
			    specialtyConstructionAchievements.setSpecialtyId(specialty_id);
			    specialtyConstructionAchievements.setCreateTime(new Date());
			    specialtyConstructionAchievements.setCreateUser(user.getTeaName());
			    int result = specialtyConstructionAchievementsService.addSpecialtyConstructionAchievements(specialtyConstructionAchievements);
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
		@RequestMapping("/updateSpecialtyConstructionAchievementsIf")
		@ResponseBody
		public JsonResult updateSpecialtyConstructionAchievementsIf(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用updateSpecialtyConstructionAchievements方法");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				
				Long specialtyAchievementsId = ToolUtil.lon("specialtyAchievementsId", request);	    
				String sources = ToolUtil.str("sources", request);
			    String name = ToolUtil.str("name", request);
			    String level = ToolUtil.str("level", request);
			    String author = ToolUtil.str("author", request);
			    Long specialty_id = ToolUtil.lon("specialty_id", request);
			    Date date = ToolUtil.date1("date", request);
			    
			    SpecialtyConstructionAchievements specialtyConstructionAchievements = specialtyConstructionAchievementsService.findSpecialtyConstructionAchievementsById(specialtyAchievementsId);
			    if (specialtyConstructionAchievements == null) {
			    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
					return jsonResult;
				}
			    
			    specialtyConstructionAchievements.setSources(sources);
			    specialtyConstructionAchievements.setName(name);
			    specialtyConstructionAchievements.setLevel(level);
			    specialtyConstructionAchievements.setAuthor(author);
			    specialtyConstructionAchievements.setSpecialtyId(specialty_id);
			    specialtyConstructionAchievements.setDate(date);
			    specialtyConstructionAchievements.setModifyUser(user.getTeaName());
			    specialtyConstructionAchievements.setModifyTime(new Date());
			    int result = specialtyConstructionAchievementsService.modifySpecialtyConstructionAchievements(specialtyConstructionAchievements);
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
		@RequestMapping("/updateSpecialtyConstructionAchievements")
		@ResponseBody
		public JsonResult updateSpecialty(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用updateSpecialtyConstructionAchievements方法");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				
				Long specialtyAchievementsId = ToolUtil.lon("specialtyAchievementsId", request);	    
				String sources = ToolUtil.str("sources", request);
			    String name = ToolUtil.str("name", request);
			    String level = ToolUtil.str("level", request);
			    String author = ToolUtil.str("author", request);
			    Long specialty_id = ToolUtil.lon("specialty_id", request);
			    Date date = ToolUtil.date1("date", request);
			    
			    SpecialtyConstructionAchievements specialtyConstructionAchievements = specialtyConstructionAchievementsService.findSpecialtyConstructionAchievementsById(specialtyAchievementsId);
			    if (specialtyConstructionAchievements == null) {
			    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
					return jsonResult;
				}
			    
			    specialtyConstructionAchievements.setSources(sources);
			    specialtyConstructionAchievements.setName(name);
			    specialtyConstructionAchievements.setLevel(level);
			    specialtyConstructionAchievements.setAuthor(author);
			    specialtyConstructionAchievements.setSpecialtyId(specialty_id);
			    specialtyConstructionAchievements.setDate(date);
			    specialtyConstructionAchievements.setModifyUser(user.getTeaName());
			    specialtyConstructionAchievements.setModifyTime(new Date());
			    int result = specialtyConstructionAchievementsService.modifySpecialtyConstructionAchievements(specialtyConstructionAchievements);
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
		@RequestMapping("/deleteSpecialtyConstructionAchievements")
		@ResponseBody
		public JsonResult deleteSpecialty(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用deleteSpecialty方法");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				
				Long specialtyAchievementsId = ToolUtil.lon("specialtyAchievementsId", request);
			    
			    int result = specialtyConstructionAchievementsService.deleteSpecialtyConstructionAchievementsById(specialtyAchievementsId);
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
