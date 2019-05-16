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
import com.zptc.gx.controller.permission.MenuController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;
import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.service.SpecialtyConstructionAchievementsService;
import com.zptc.gx.specialty.service.SpecialtyService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

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
			Map<String, Object> data = new HashMap<>();
			//获取请求参数
			String level = ToolUtil.str("level", request);
		    /*String name = ToolUtil.str("name", request);
		    String cate_name = ToolUtil.str("cate_name", request);
		    String reviser = ToolUtil.str("reviser", request);
		    Integer status = ToolUtil.integer("status", request);
		    String date1 = ToolUtil.str("date1", request);
		    String date2 = ToolUtil.str("date2", request);*/
		    Integer limit = ToolUtil.integer("limit", request);
		    Integer page = ToolUtil.integer("page", request);
		    PageVO pageVO = new PageVO(page, limit);
		    Integer pages = 0;
			//用于分页的数据
		    pages = pageVO.getBeginNum();
			//存入data,用于获取表格数据
		  /*data.put("code", code);
		    data.put("name", name);
		    data.put("cate_name", cate_name);
		    data.put("reviser", reviser);
		    data.put("date1", date1);
		    data.put("date2", date2);*/
			data.put("level", level);
			data.put("limit", pageVO.getLimit());
			data.put("pages", pages);
			data.put("status", 1);
			Map<String, Object> count = new HashMap<>();
			//存入count,用于获取表格数据条总数
		/*	count.put("code", code);
			count.put("name", name);
			count.put("cate_name", cate_name);
			count.put("reviser", reviser);
			count.put("date1", date1);
			count.put("date2", date2);*/
			count.put("level", level);
			count.put("status", 1);
			//定义返回的数据条总数
			int counts = 0;
			//定义返回的msg
			String msg = "";
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				//Long specialtyId = user.getRoleId();
				//获取所有status == 1 的所有数据
				List<SpecialtyConstructionAchievements> specialtyConstructionAchievements = specialtyConstructionAchievementsService.getSpecialtyAchievementsList(data);
				//获取所有status == 1的数据条总数
				counts = specialtyConstructionAchievementsService.selectCounts(count);
				jsonResult = JsonResult.build(FLAG_SUCCESS, specialtyConstructionAchievements,msg,counts);
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
			    Long specialtyId = ToolUtil.lon("specialty_id", request);
			    String specialtyName = ToolUtil.str("specialty_name", request);
			    Date date = ToolUtil.date2("date", request);
			    
			    SpecialtyConstructionAchievements specialtyConstructionAchievements = new SpecialtyConstructionAchievements();
			    specialtyConstructionAchievements.setDate(date);
			    specialtyConstructionAchievements.setName(name);
			    specialtyConstructionAchievements.setLevel(level);
			    specialtyConstructionAchievements.setAuthor(author);
			    specialtyConstructionAchievements.setSources(sources);
			    specialtyConstructionAchievements.setSpecialtyId(specialtyId);
			    specialtyConstructionAchievements.setSpecialtyName(specialtyName);
			    specialtyConstructionAchievements.setStatus(1);
			    specialtyConstructionAchievements.setCreateTime(new Date());
			    specialtyConstructionAchievements.setCreateUser(user.getTeaName());
			  //判断传入的值是否为空或""
			    if ((ToolUtil.equalBool(sources)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(level)&&ToolUtil.equalBool(author)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(date)) == false) {
			    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
			    	System.out.println("错误，传入数据错误");
			    	 //接口拿到的数据
				    System.out.println("addSpecialty方法拿到的数据："+specialtyConstructionAchievements.toString());
			    	return jsonResult;
				}
			    System.out.println("传入数据成功");
			    System.out.println("add方法拿到的数据："+specialtyConstructionAchievements.toString());
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
			System.out.println("启用updateSpecialtyConstructionAchievementsIf方法");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				
				Long specialtyAchievementsId = ToolUtil.lon("id", request);	    
				String sources = ToolUtil.str("sources", request);
			    String name = ToolUtil.str("name", request);
			    String level = ToolUtil.str("level", request);
			    String author = ToolUtil.str("author", request);
			    Long specialtyId = ToolUtil.lon("specialty_id", request);
			    String specialtyName = ToolUtil.str("specialty_name", request);
			    Date date = ToolUtil.date2("date", request);
			    
			    SpecialtyConstructionAchievements specialtyConstructionAchievements = specialtyConstructionAchievementsService.findSpecialtyConstructionAchievementsById(specialtyAchievementsId);
			    if (specialtyConstructionAchievements == null) {
			    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
					return jsonResult;
				}
			    
			    specialtyConstructionAchievements.setSources(sources);
			    specialtyConstructionAchievements.setName(name);
			    specialtyConstructionAchievements.setLevel(level);
			    specialtyConstructionAchievements.setAuthor(author);
			    specialtyConstructionAchievements.setSpecialtyId(specialtyId);
			    specialtyConstructionAchievements.setSpecialtyName(specialtyName);
			    specialtyConstructionAchievements.setDate(date);
			    specialtyConstructionAchievements.setModifyUser(user.getTeaName());
			    specialtyConstructionAchievements.setModifyTime(new Date());
			    //判断传入的值是否为空或""
			    if ((ToolUtil.equalBool(sources)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(level)&&ToolUtil.equalBool(author)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(date)) == false) {
			    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
			    	System.out.println("错误，传入数据错误");
			    	 //接口拿到的数据
				    System.out.println("addSpecialty方法拿到的数据："+specialtyConstructionAchievements.toString());
			    	return jsonResult;
				}
			    System.out.println("传入数据成功");
			    System.out.println("add方法拿到的数据："+specialtyConstructionAchievements.toString());
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
			    Date date = ToolUtil.date2("date", request);
			    
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
			    int result = specialtyConstructionAchievementsService.modifySpecialtyConstructionAchievementsKey(specialtyConstructionAchievements);
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
		/*根据id进行软删除（修改status状态码）*/
		@RequestMapping("/delSpecialtyAchievements")
		@ResponseBody
		public JsonResult delSpecialtyFiles(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用delSpecialtyAchievements方法");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				int status = ToolUtil.integer("status", request);
				status = 2;
				Long specialtyFilesId = ToolUtil.lon("id", request);
				System.out.println("id"+specialtyFilesId);
			    //判断是否有该专业
				SpecialtyConstructionAchievements specialtyConstructionAchievements = specialtyConstructionAchievementsService.findSpecialtyConstructionAchievementsById(specialtyFilesId);
				if (specialtyConstructionAchievements == null) {
					jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
					return jsonResult;
				}
				specialtyConstructionAchievements.setStatus(status);
			    int result = specialtyConstructionAchievementsService.modifSpecialtyFilesDel(specialtyConstructionAchievements);
			    System.out.println("要删除的数据是："+specialtyConstructionAchievements.toString());
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
