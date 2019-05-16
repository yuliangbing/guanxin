package com.zptc.gx.controller.history;

import java.math.BigDecimal;
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
import com.zptc.gx.specialty.entity.EnrollmentHistory;
import com.zptc.gx.specialty.entity.TrainingEnvironmentConstruction;
import com.zptc.gx.specialty.service.EnrollmentHistoryService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("EnrollmentHistory")
public class EnrollmentHistoryController extends BaseController{
	private Logger logger = Logger.getLogger(EnrollmentHistoryController.class);
	
	@Autowired
	private EnrollmentHistoryService enrollmentHistoryService;
//	新增历年招生信息
	@RequestMapping("/addEnrollmentHistory")
	 @ResponseBody
	 public JsonResult addTrainingEnvironmentConstruction(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("添加接口");
		try {
			 ZptcUser user = (ZptcUser)request.getSession().getAttribute(Constant.USER_SESSION);
			 
			 Date date = ToolUtil.date2("date", request);
			 Integer planNum = ToolUtil.integer("plan_num", request);
			 Integer actualNum = ToolUtil.integer("actual_num", request);
			 BigDecimal rate= ToolUtil.dec("rate", request);
			  Long specialtyId = ToolUtil.lon("specialty_id", request);
			 String specialtyName = ToolUtil.str("specialty_name", request);
			 Integer status = ToolUtil.integer("status", request);
			 
			 EnrollmentHistory enrollmentHistory = new EnrollmentHistory();
			 enrollmentHistory.setDate(date);
			 enrollmentHistory.setPlanNum(planNum);
			 enrollmentHistory.setActualNum(actualNum);
			 enrollmentHistory.setRate(rate);
			 enrollmentHistory.setSpecialtyId(specialtyId);
			 enrollmentHistory.setSpecialtyName(specialtyName);
			 enrollmentHistory.setStatus(1);
			 enrollmentHistory.setCreateTime(new Date());
			 enrollmentHistory.setCreateUser(user.getTeaName());
//			 判断数据是否为空
			 if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(planNum)&&ToolUtil.equalBool(actualNum)&&ToolUtil.equalBool(rate)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
				    jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
					return jsonResult;
			  }
			 System.out.println("传入数据成功");
			  System.out.println("addEnrollmentHistory方法拿到数据");
			  int result = enrollmentHistoryService.addEnrollmentHistory(enrollmentHistory);
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
		return jsonResult;
	}
//	删除历年招生信息
	@RequestMapping("/delEnrollmentHistory")
	 @ResponseBody
	 public JsonResult delEnrollmentHistory(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("使用delEnrollmentHistory方法");
		try {
			 ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//			 获取请求参数
			 Long id =ToolUtil.lonWithNull("id",request);
			 int status = ToolUtil.integer("status", request);
			 System.out.println("id"+id);
			 EnrollmentHistory enrollmentHistory = enrollmentHistoryService.findEnrollmentHistoryById(id);
			 if (enrollmentHistory == null) {
				jsonResult = JsonResult.build(FLAG_FAILED,"没有该信息！");
			}
			enrollmentHistory.setStatus(2);
			int result = enrollmentHistoryService.modifyEnrollmentHistoryDel(enrollmentHistory);
			 System.out.println("status："+status);
			 System.out.println("result:"+result);
			 if (result >0) {
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
//	修改历年招生信息
	@RequestMapping("/updateEnrollmentHistory")
	@ResponseBody
	public JsonResult updateEnrollmentHistory(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyProfilesIf方法");
		 ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		 Long id = ToolUtil.lon("id", request);
		 Date date = ToolUtil.date2("date", request);
		 Integer planNum = ToolUtil.integer("plan_num", request);
		 Integer actualNum = ToolUtil.integer("actual_num", request);
		 BigDecimal rate= ToolUtil.dec("rate", request);
		  Long specialtyId = ToolUtil.lon("specialty_id", request);
		 String specialtyName = ToolUtil.str("specialty_name", request);
		 Integer status = ToolUtil.integer("status", request);
//		 根据id修改
		 EnrollmentHistory enrollmentHistory = enrollmentHistoryService.findEnrollmentHistoryById(id);
	     if (enrollmentHistory == null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该条信息！");
			return jsonResult;
		}
	     enrollmentHistory.setDate(date);
	     System.out.println(date);
	     enrollmentHistory.setPlanNum(planNum);
	     enrollmentHistory.setActualNum(actualNum);
	     enrollmentHistory.setRate(rate);
	     enrollmentHistory.setSpecialtyId(specialtyId);
	     enrollmentHistory.setSpecialtyName(specialtyName);
	     enrollmentHistory.setModifyTime(new Date());
	     enrollmentHistory.setModifyUser(user.getTeaName());
//	     判断传入的值是否为空或”“
	     if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(planNum)&&ToolUtil.equalBool(actualNum)&&ToolUtil.equalBool(rate)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	return jsonResult;
			}	    
	     System.out.println("传入数据成功");
	     try {
			int result = enrollmentHistoryService.modifyEnrollmentHistory(enrollmentHistory);
			if (result >0) {
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
//	获取历年招生信息
	@RequestMapping("/getEnrollmentHistory")
	 @ResponseBody
	 public JsonResult getEnrollmentHistory(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取历年招生信息接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
//		获取请求参数
		String date1 = ToolUtil.str("date1", request);
		String date2 = ToolUtil.str("date2", request);
		 Integer planNum = ToolUtil.integer("plan_num", request);
		 Integer actualNum = ToolUtil.integer("actual_num", request);
		 BigDecimal rate= ToolUtil.dec("rate", request);
		 // Long specialtyId = ToolUtil.lon("specialty_id", request);
		 //String specialtyName = ToolUtil.str("specialty_name", request);
		 Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
		//用于分页的数据
	    pages = pageVO.getBeginNum();
		//存入data,用于获取表格数据
	    data.put("date1", date1);
	    data.put("date2", date2);
	    data.put("plan_num", planNum);
	    data.put("actual_num", actualNum);
	    data.put("rate", rate);
//	    data.put("specialty_id", specialtyId);
//	    data.put("specialty_name", specialtyName);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		System.out.println("pages:"+pages);
		//存入count,用于获取表格数据条总数
	    Map<String, Object> count = new HashMap<>();
	    count.put("date1", date1);
		count.put("date2", date2);
		count.put("planNum", planNum);
		count.put("actual_num", actualNum);
		count.put("rate", rate);
//		count.put("specialty_id", specialtyId);
//		count.put("specialty_name", specialtyName);
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
			List<EnrollmentHistory> enrollmentHistorieList = enrollmentHistoryService.getEnrollmentHistoryList(data);
			//获取所有status == 1的数据条总数
			counts = enrollmentHistoryService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(FLAG_SUCCESS,enrollmentHistorieList , msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
