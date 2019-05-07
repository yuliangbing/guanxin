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
import com.zptc.gx.specialty.entity.GraduateHistory;
import com.zptc.gx.specialty.entity.OutstandingGraduateHistory;
import com.zptc.gx.specialty.service.OutstandingGraduateHistoryService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 优秀毕业生情况
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/outstandingGraduateHistory")
public class OutstandingGraduateHistoryController extends BaseController {

	private Logger logger = Logger.getLogger(OutstandingGraduateHistoryController.class);
	
	@Autowired
	private OutstandingGraduateHistoryService outstandingGraduateHistoryService;
	/**
	 * 优秀毕业生列表
	 */
	@RequestMapping("/ListOutstandingGraduateHistory")
	@ResponseBody
	public JsonResult ListOutstandingGraduateHistory(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("获取优秀毕业生列表");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> count = new HashMap<>();
		//获取请求参数
		String name = ToolUtil.str("name", request);
		Integer limit = ToolUtil.integer("limit", request);
		Integer page = ToolUtil.integer("page", request);
		
		PageVO pageVO = new PageVO(page, limit);
		Integer pages = 0;
		//用于分页的方法
		pages = pageVO.getBeginNum();
		//把数据put进入data
		data.put("name", name);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		System.out.println("获取到的数据="+data);
		count.put("name", name);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "成功";
		try {
			//获取所有数据(带需求)
			List<OutstandingGraduateHistory> gList = outstandingGraduateHistoryService.getOutstandingGraduateHistoryList(data);
			//获取数据总条数
			counts = outstandingGraduateHistoryService.Counts(count);
			jsonResult = jsonResult.build(FLAG_SUCCESS, gList, msg, counts);
			System.out.println("查询到的数据为="+gList);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = jsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 添加优秀毕业生
	 */
	@RequestMapping("/addOutstandingGraduateHistory")
	@ResponseBody
	public JsonResult addOutstandingGraduateHistory(HttpServletRequest request,HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启动add添加方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Date date = ToolUtil.date2("date",request);
			String name = ToolUtil.str("name", request);
			String image = ToolUtil.str("image", request);
			String company = ToolUtil.str("company", request);
			String position = ToolUtil.str("position", request);
			String advancedDescription = ToolUtil.str("advanced_description", request);
			BigDecimal salary = ToolUtil.dec("salary", request);
			Long specialtyId = ToolUtil.lon("specialty_id", request);
			String specialtyName = ToolUtil.str("specialty_name", request);
			OutstandingGraduateHistory outstandingGraduateHistory = new OutstandingGraduateHistory();
			outstandingGraduateHistory.setDate(date);
			outstandingGraduateHistory.setName(name);
			outstandingGraduateHistory.setImage(image);
			outstandingGraduateHistory.setCompany(company);
			outstandingGraduateHistory.setPosition(position);
			outstandingGraduateHistory.setAdvancedDescription(advancedDescription);
			outstandingGraduateHistory.setSalary(salary);
			outstandingGraduateHistory.setSpecialtyId(specialtyId);
			outstandingGraduateHistory.setSpecialtyName(specialtyName);
			outstandingGraduateHistory.setStatus(1);
			outstandingGraduateHistory.setCreateTime(new Date());
			outstandingGraduateHistory.setCreateUser(user.getTeaName());
			if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(image)
					&&ToolUtil.equalBool(company)&&ToolUtil.equalBool(position)&&ToolUtil.equalBool(advancedDescription)&&ToolUtil.equalBool(salary)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
				jsonResult = jsonResult.build(FLAG_FAILED, "必填数据缺少！");
				System.out.println("错误，传入数据错误！");
				System.out.println("方法拿到的数据："+outstandingGraduateHistory.toString());
				return jsonResult;
			}
			
			int result = outstandingGraduateHistoryService.addOutstandingGraduateHistory(outstandingGraduateHistory);
			if (result > 0 ) {
				jsonResult = jsonResult.build(FLAG_SUCCESS,"添加成功");
			}else {
				jsonResult = jsonResult.build(FLAG_FAILED,"添加失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = jsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 修改优秀毕业生
	 */
	@RequestMapping("/updateOutstandingGraduateHistory")
	@ResponseBody
	public JsonResult updateOutstandingGraduateHistory(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateOutstandingGraduateHistory方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long Id = ToolUtil.lon("id", request);
			Date date = ToolUtil.date2("date",request);
			String name = ToolUtil.str("name", request);
			String image = ToolUtil.str("image", request);
			String company = ToolUtil.str("company", request);
			String position = ToolUtil.str("position", request);
			String advancedDescription = ToolUtil.str("advanced_description", request);
			BigDecimal salary = ToolUtil.dec("salary", request);
			Long specialtyId = ToolUtil.lon("specialty_id", request);
			String specialtyName = ToolUtil.str("specialty_name", request);
			OutstandingGraduateHistory outstandingGraduateHistory = outstandingGraduateHistoryService.findOutstandingGraduateHistoryById(Id);
		    if (outstandingGraduateHistory == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该数据,无法修改！");
				return jsonResult;
			}
		    if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(image)
					&&ToolUtil.equalBool(company)&&ToolUtil.equalBool(position)&&ToolUtil.equalBool(advancedDescription)&&ToolUtil.equalBool(salary)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
				jsonResult = jsonResult.build(FLAG_FAILED, "必填数据缺少！");
				System.out.println("错误，传入数据错误！");
				System.out.println("方法拿到的数据："+outstandingGraduateHistory.toString());
				return jsonResult;
			}
		    outstandingGraduateHistory.setDate(date);
			outstandingGraduateHistory.setName(name);
			outstandingGraduateHistory.setImage(image);
			outstandingGraduateHistory.setCompany(company);
			outstandingGraduateHistory.setPosition(position);
			outstandingGraduateHistory.setAdvancedDescription(advancedDescription);
			outstandingGraduateHistory.setSalary(salary);
			outstandingGraduateHistory.setSpecialtyId(specialtyId);
			outstandingGraduateHistory.setSpecialtyName(specialtyName);
			outstandingGraduateHistory.setModifyTime(new Date());
			outstandingGraduateHistory.setModifyUser(user.getTeaName());
		    
		    int result = outstandingGraduateHistoryService.modifyOutstandingGraduateHistory(outstandingGraduateHistory);
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"修改成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 删除优秀毕业生（批量）
	 */
	@RequestMapping("/delOutstandingGraduateHistory")
	@ResponseBody
	public JsonResult delGraduateHistory(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delOutstandingGraduateHistory方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long Id = ToolUtil.lon("id", request);
			System.out.println("id="+Id);
		    //判断是否有该专业
			OutstandingGraduateHistory outstandingGraduateHistory = outstandingGraduateHistoryService.findOutstandingGraduateHistoryById(Id);
			if (outstandingGraduateHistory == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该数据，无法删除！");
				return jsonResult;
			}
			outstandingGraduateHistory.setStatus(2);
		    int result = outstandingGraduateHistoryService.delOutstandingGraduateHistory(outstandingGraduateHistory);
		    System.out.println("要删除的数据是："+outstandingGraduateHistory.toString());
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"删除成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"删除失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
}