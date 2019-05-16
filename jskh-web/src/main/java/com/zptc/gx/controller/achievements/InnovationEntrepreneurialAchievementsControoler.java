package com.zptc.gx.controller.achievements;

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
import com.zptc.gx.controller.history.GraduateHistoryController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.GraduateHistory;
import com.zptc.gx.specialty.entity.InnovationEntrepreneurialAchievements;
import com.zptc.gx.specialty.service.InnovationEntrepreneurialAchievementsService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 创新创业成果
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/IEAchievements")
public class InnovationEntrepreneurialAchievementsControoler extends BaseController {
	private Logger logger = Logger.getLogger(InnovationEntrepreneurialAchievementsControoler.class);
	
	@Autowired
	private InnovationEntrepreneurialAchievementsService iService;
	/**
	 * 创新创业列表
	 */
	@RequestMapping("/ListIEAchievements")
	@ResponseBody
	public JsonResult getIEAchievementsList(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("获取历年毕业生列表");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> count = new HashMap<>();
		//获取请求参数
		String date1 = ToolUtil.str("date1", request);
		String date2 = ToolUtil.str("date2", request);
		String participants = ToolUtil.str("participants", request);
		Integer limit = ToolUtil.integer("limit", request);
		Integer page = ToolUtil.integer("page", request);
		
		PageVO pageVO = new PageVO(page, limit);
		Integer pages = 0;
		//用于分页的方法
		pages = pageVO.getBeginNum();
		//把数据put进入data
		data.put("participants", participants);
		data.put("date1", date1);
		data.put("date2", date2);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		System.out.println("获取到的数据="+data);
		count.put("date1", date1);
		count.put("date2", date2);
		count.put("participants", participants);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "成功";
		try {
			//获取所有数据(带需求)
			List<InnovationEntrepreneurialAchievements> gList = iService.getIEAchievementsList(data);
			//获取数据总条数
			counts = iService.Counts(count);
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
	 * 添加创新创业成果
	 */
	@RequestMapping("/addIEAchievements")
	@ResponseBody
	public JsonResult addIEAchievements(HttpServletRequest request,HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启动add添加方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Date date = ToolUtil.date2("date",request);
			String content = ToolUtil.str("content", request);
			String participants = ToolUtil.str("participants", request);
			Long specialtyId = ToolUtil.lon("specialty_id", request);
			String specialtyName = ToolUtil.str("specialty_name", request);
			InnovationEntrepreneurialAchievements innovationEntrepreneurialAchievements = new InnovationEntrepreneurialAchievements();
			innovationEntrepreneurialAchievements.setDate(date);
			innovationEntrepreneurialAchievements.setContent(content);
			innovationEntrepreneurialAchievements.setParticipants(participants);
			innovationEntrepreneurialAchievements.setSpecialtyId(specialtyId);
			innovationEntrepreneurialAchievements.setSpecialtyName(specialtyName);
			innovationEntrepreneurialAchievements.setStatus(1);
			innovationEntrepreneurialAchievements.setCreateTime(new Date());
			innovationEntrepreneurialAchievements.setCreateUser(user.getTeaName());
			if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(content)&&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
				jsonResult = jsonResult.build(FLAG_FAILED, "必填数据缺少！");
				System.out.println("错误，传入数据错误！");
				System.out.println("方法拿到的数据："+innovationEntrepreneurialAchievements.toString());
				return jsonResult;
			}
			
			int result = iService.addInnovationEntrepreneurialAchievements(innovationEntrepreneurialAchievements);
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
	 * 修改创新创业成果
	 */
	@RequestMapping("/updateIEAchievements")
	@ResponseBody
	public JsonResult updateIEAchievements(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateIEAchievements方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long Id = ToolUtil.lon("id", request);
			Date date = ToolUtil.date2("date",request);
			String content = ToolUtil.str("content", request);
			String participants = ToolUtil.str("participants", request);
			Long specialtyId = ToolUtil.lon("specialty_id", request);
			String specialtyName = ToolUtil.str("specialty_name", request);
		    InnovationEntrepreneurialAchievements achievements = iService.findInnovationEntrepreneurialAchievementsById(Id);
		    if (achievements == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该数据,无法修改！");
				return jsonResult;
			}
		    if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(content)&&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
				jsonResult = jsonResult.build(FLAG_FAILED, "必填数据缺少！");
				System.out.println("错误，传入数据错误！");
				System.out.println("方法拿到的数据："+achievements.toString());
				return jsonResult;
			}
		    achievements.setDate(date);
		    achievements.setContent(content);
		    achievements.setParticipants(participants);
		    achievements.setSpecialtyId(specialtyId);
		    achievements.setSpecialtyName(specialtyName);
		    achievements.setModifyTime(new Date());
		    achievements.setModifyUser(user.getTeaName());
		    
		    int result = iService.modifyInnovationEntrepreneurialAchievements(achievements);
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
	 * 删除创新创业成果（批量）
	 */
	/*删除分院(软)*/
	@RequestMapping("/delIEAchievements")
	@ResponseBody
	public JsonResult delIEAchievements(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delIEAchievements方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long Id = ToolUtil.lon("id", request);
			System.out.println("id="+Id);
		    //判断是否有该专业
			InnovationEntrepreneurialAchievements achievements = iService.findInnovationEntrepreneurialAchievementsById(Id);
			if (achievements == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该数据，无法删除！");
				return jsonResult;
			}
			achievements.setStatus(2);
		    int result = iService.dellIEAchievements(achievements);
		    System.out.println("要删除的数据是："+achievements.toString());
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
