package com.zptc.gx.controller.history;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

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
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.service.GraduateHistoryService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;
/**
 * 历年毕业生情况
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/graduateHistory")
public class GraduateHistoryController extends BaseController {

	private Logger logger = Logger.getLogger(GraduateHistoryController.class);
	
	@Autowired
	private GraduateHistoryService graduateHistoryService;
	
	/**
	 * 历年毕业生列表
	 */
	@RequestMapping("/ListGraduateHistory")
	@ResponseBody
	public JsonResult getGraduateHistoryList(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("获取历年毕业生列表");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> count = new HashMap<>();
		//获取请求参数
		String date = ToolUtil.str("date", request);
	    String date1 = null;
	    String date2 = null;
	    if (date != null && date != "") {
	    	String[] dates = date.split("~");
		    
	    	date1 = dates[0].trim();
		    date2 = dates[1].trim();
		}
		Integer limit = ToolUtil.integer("limit", request);
		Integer page = ToolUtil.integer("page", request);
		
		PageVO pageVO = new PageVO(page, limit);
		Integer pages = 0;
		//用于分页的方法
		pages = pageVO.getBeginNum();
		//把数据put进入data
		data.put("date1", date1);
		data.put("date2", date2);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		System.out.println("获取到的数据="+data);
		count.put("date1", date1);
		count.put("date2", date2);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "成功";
		try {
			//获取所有数据(带需求)
			List<GraduateHistory> gList = graduateHistoryService.getGraduateHistoryList(data);
			//获取数据总条数
			counts = graduateHistoryService.Counts(count);
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
	 * 添加历年毕业生情况
	 */
	@RequestMapping("/addGraduateHistory")
	@ResponseBody
	public JsonResult addGraduateHistory(HttpServletRequest request,HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启动add添加方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Date date = ToolUtil.date2("date",request);
			int graduateNum = ToolUtil.integer("graduate_num", request);
			int employedNum = ToolUtil.integer("employed_num", request);
			int entrepreneursNum = ToolUtil.integer("entrepreneurs_num", request);
			BigDecimal employmentRate = ToolUtil.dec("employment_rate", request);
			Long specialtyId = ToolUtil.lon("specialty_id", request);
			String specialtyName = ToolUtil.str("specialty_name", request);
			GraduateHistory graduateHistory = new GraduateHistory();
			graduateHistory.setDate(date);
			graduateHistory.setGraduateNum(graduateNum);
			graduateHistory.setEmployedNum(employedNum);
			graduateHistory.setEntrepreneursNum(entrepreneursNum);
			graduateHistory.setEmploymentRate(employmentRate);
			graduateHistory.setSpecialtyId(specialtyId);
			graduateHistory.setSpecialtyName(specialtyName);
			graduateHistory.setStatus(1);
			graduateHistory.setCreateTime(new Date());
			graduateHistory.setCreateUser(user.getTeaName());
			if ((ToolUtil.equalBool(employmentRate)&&ToolUtil.equalBool(graduateNum)&&ToolUtil.equalBool(employedNum)
					&&ToolUtil.equalBool(entrepreneursNum)&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
				jsonResult = jsonResult.build(FLAG_FAILED, "必填数据缺少！");
				System.out.println("错误，传入数据错误！");
				System.out.println("方法拿到的数据："+graduateHistory.toString());
				return jsonResult;
			}
			
			int result = graduateHistoryService.addGraduateHistory(graduateHistory);
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
	 * 修改历年毕业生情况
	 */
	@RequestMapping("/updateGraduateHistory")
	@ResponseBody
	public JsonResult updateGraduateHistory(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateGraduateHistory方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long Id = ToolUtil.lon("id", request);
			Date date = ToolUtil.date2("date",request);
			int graduateNum = ToolUtil.integer("graduate_num", request);
			int employedNum = ToolUtil.integer("employed_num", request);
			int entrepreneursNum = ToolUtil.integer("entrepreneurs_num", request);
			BigDecimal employmentRate = ToolUtil.dec("employment_rate", request);
			Long specialtyId = ToolUtil.lon("specialty_id", request);
			String specialtyName = ToolUtil.str("specialty_name", request);
		    GraduateHistory graduateHistory = graduateHistoryService.findGraduateHistoryById(Id);
		    if (graduateHistory == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该数据,无法修改！");
				return jsonResult;
			}
		    if ((ToolUtil.equalBool(employmentRate)&&ToolUtil.equalBool(graduateNum)&&ToolUtil.equalBool(employedNum)
					&&ToolUtil.equalBool(entrepreneursNum)&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
				jsonResult = jsonResult.build(FLAG_FAILED, "必填数据缺少！");
				System.out.println("错误，传入数据错误！");
				System.out.println("方法拿到的数据："+graduateHistory.toString());
				return jsonResult;
			}
		    graduateHistory.setDate(date);
		    graduateHistory.setGraduateNum(graduateNum);
		    graduateHistory.setEmployedNum(employedNum);
		    graduateHistory.setEntrepreneursNum(entrepreneursNum);
		    graduateHistory.setEmploymentRate(employmentRate);
		    graduateHistory.setSpecialtyId(specialtyId);
		    graduateHistory.setSpecialtyName(specialtyName);
		    graduateHistory.setModifyTime(new Date());
		    graduateHistory.setModifyUser(user.getTeaName());
		    
		    int result = graduateHistoryService.modifyGraduateHistory(graduateHistory);
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
	 * 删除历年毕业生（批量）
	 */
	/*删除分院(软)*/
	@RequestMapping("/delGraduateHistory")
	@ResponseBody
	public JsonResult delGraduateHistory(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delGraduateHistory方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long Id = ToolUtil.lon("id", request);
			System.out.println("id="+Id);
		    //判断是否有该专业
			GraduateHistory graduateHistory = graduateHistoryService.findGraduateHistoryById(Id);
			if (graduateHistory == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该数据，无法删除！");
				return jsonResult;
			}
			graduateHistory.setStatus(2);
		    int result = graduateHistoryService.modifSpecialtyDel(graduateHistory);
		    System.out.println("要删除的数据是："+graduateHistory.toString());
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
