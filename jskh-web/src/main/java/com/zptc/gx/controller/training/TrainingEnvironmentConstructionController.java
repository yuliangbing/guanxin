package com.zptc.gx.controller.training;

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
import com.zptc.gx.specialty.entity.TrainingEnvironmentConstruction;
import com.zptc.gx.specialty.service.TrainingEnvironmentConstructionService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

import groovy.lang.Buildable;

@Controller
@RequestMapping("TrainingEnvironmentConstruction")
public class TrainingEnvironmentConstructionController extends BaseController{
	private Logger logger = Logger.getLogger(TrainingEnvironmentConstructionController.class);
	
	 @Autowired
	 private TrainingEnvironmentConstructionService trainingEnvironmentConstructionService;
	 
//	新增实训环境建设
	 @RequestMapping("/addTrainingEnvironmentConstruction")
	 @ResponseBody
	 public JsonResult addTrainingEnvironmentConstruction(HttpServletRequest request, HttpServletResponse response) {
		 JsonResult jsonResult = new JsonResult();
		 System.out.println("添加信息接口");
		 try {
			 ZptcUser user = (ZptcUser)request.getSession().getAttribute(Constant.USER_SESSION);
		
			 Date date = ToolUtil.date2("date", request);
			String content = ToolUtil.str("content", request);
		    String participants = ToolUtil.str("participants", request);
		    //Long specialtyId = ToolUtil.lon("specialty_id", request);
		    String specialtyName = ToolUtil.str("specialty_name", request);
		    Integer status = ToolUtil.integer("status", request);
		    
		    TrainingEnvironmentConstruction trainingEnvironmentConstruction = new  TrainingEnvironmentConstruction();
		    trainingEnvironmentConstruction.setContent(content);
		   trainingEnvironmentConstruction.setDate(date);
		   trainingEnvironmentConstruction.setParticipants(participants);
		   trainingEnvironmentConstruction.setSpecialtyName(specialtyName);
		   trainingEnvironmentConstruction.setStatus(1);
		   trainingEnvironmentConstruction.setCreateTime(new Date());
		   trainingEnvironmentConstruction.setCreateUser(user.getTeaName());
//		   判断数据是否为空
//		   if ((ToolUtil.equalBool(content)&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(specialtyName)) == false) {
//				    jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
//					return jsonResult;
//			  }
		   System.out.println("传入数据成功");
		   System.out.println("addTrainingEnvironmentConstruction方法拿到数据");
		   int result = trainingEnvironmentConstructionService.addTrainingEnvironmentConstruction(trainingEnvironmentConstruction);
		   if (result > 0) {
			jsonResult = JsonResult.build(FLAG_SUCCESS);
		} else {
           jsonResult = JsonResult.build(FLAG_FAILED);
		}
		 } catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 jsonResult = JsonResult.build(FLAG_SUCCESS,e.getMessage());
		}
		 return jsonResult ;
	 }
//	 删除实训环境建设
	 @RequestMapping("/delTrainingEnvironmentConstruction")
	 @ResponseBody
	 public JsonResult delTrainingEnvironmentConstruction(HttpServletRequest request, HttpServletResponse response) {
		 JsonResult jsonResult = new JsonResult();
		 System.out.println("使用delTrainingEnvironmentConstruction方法");
		 try {
			 ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		     
			 Long id =ToolUtil.lonWithNull("id",request);
			 int status = ToolUtil.integer("status", request);
			 System.out.println("id"+id);
			 TrainingEnvironmentConstruction trainingEnvironmentConstruction= trainingEnvironmentConstructionService.findTrainingEnvironmentConstructionById(id);
		     if (trainingEnvironmentConstruction == null) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
				return jsonResult;
			}
		     trainingEnvironmentConstruction.setStatus(2);
		     int result = trainingEnvironmentConstructionService.modifyTrainingEnvironmentConstructionDel(trainingEnvironmentConstruction);
		     if (result > 0 ) {
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
//	修改实训环境建设信息
	 @RequestMapping("/updateTrainingEnvironmentConstruction")
	@ResponseBody
	public JsonResult updateTrainingEnvironmentConstruction(HttpServletRequest request, HttpServletResponse response) {
		ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION); 
		JsonResult jsonResult =new JsonResult();
		 System.out.println("使用updateTrainingEnvironmentConstruction方法");
		 Long id = ToolUtil.lon("id", request);
		 Date date = ToolUtil.date2("date", request);
		String content = ToolUtil.str("content", request);
	    String participants = ToolUtil.str("participants", request);
	    //Long specialtyId = ToolUtil.lon("specialty_id", request);
	    String specialty_name = ToolUtil.str("specialty_name", request);
//	    根据id查找修改信息
	    TrainingEnvironmentConstruction trainingEnvironmentConstruction = trainingEnvironmentConstructionService.findTrainingEnvironmentConstructionById(id);
	    if (trainingEnvironmentConstruction == null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该实训环境建设信息");
			return jsonResult;
		}
	    trainingEnvironmentConstruction.setDate(date);
	    trainingEnvironmentConstruction.setContent(content);
	    trainingEnvironmentConstruction.setParticipants(participants);
	    //trainingEnvironmentConstruction.setSpecialtyId(specialtyId);
	    trainingEnvironmentConstruction.setSpecialtyName(specialty_name);
	    trainingEnvironmentConstruction.setStatus(1);
	    trainingEnvironmentConstruction.setModifyTime(new Date());
	    trainingEnvironmentConstruction.setModifyUser(user.getTeaName());
//	    判断数据传入是否为空
//	    if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(content)&&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(specialty_name)) == false) {
//	 		    jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
//	 			return jsonResult;
//	 		}
	    System.out.println("传入数据成功");
	    try {
			int result = trainingEnvironmentConstructionService.modifyTrainingEnvironmentConstruction(trainingEnvironmentConstruction);
		  if (result >0) {
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
//	 获取实训环境信息列表
	 @RequestMapping("/getSchoolEnterpriseCooperation")
	 @ResponseBody
	 public JsonResult getSpecialtyProfile(HttpServletRequest request, HttpServletResponse responses) {
		 System.out.println(" 获取实训环境信息列表接口");
			JsonResult jsonResult = new JsonResult();
			Map<String, Object> data = new HashMap<>();
//			获取请求参数
			// Long id = ToolUtil.lon("id", request);
			 String date1 = ToolUtil.str("date1", request);
			 String date2 = ToolUtil.str("date2", request);
			String content = ToolUtil.str("content", request);
		    String participants = ToolUtil.str("participants", request);
		    Long specialtyId = ToolUtil.lon("specialty_id", request);
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
		    data.put("content", content);
		    data.put("participants", participants);
		    data.put("specialtyId", specialtyId);
		    data.put("specialtyName", specialtyName);
			data.put("limit", pageVO.getLimit());
			data.put("pages", pages);
			data.put("status", 1);
			System.out.println("pages:"+pages);
			//存入count,用于获取表格数据条总数
			Map<String, Object> count = new HashMap<>();
			count.put("date1", date1);
			count.put("date2", date2);
			count.put("content", content);
			count.put("participants", participants);
			count.put("specialtyId", specialtyId);
			count.put("specialtyName", specialtyName);
			count.put("limit", pageVO.getLimit());
			count.put("pages", pages);
			count.put("status", 1);
			//定义返回的数据条总数
			int counts = 0;
			//定义返回的msg
			String msg = "success";
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				//获取所有status == 1 的所有数据
				List<TrainingEnvironmentConstruction> trainingEnvironmentConstructionList = trainingEnvironmentConstructionService.getTrainingEnvironmentConstructionList(data);
				//获取所有status == 1的数据条总数
				counts = trainingEnvironmentConstructionService.selectCounts(count);
				//返回接口的具体数据
				jsonResult = jsonResult.build(FLAG_SUCCESS, trainingEnvironmentConstructionList, msg, counts);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
			}
			return jsonResult;
	 }
}
