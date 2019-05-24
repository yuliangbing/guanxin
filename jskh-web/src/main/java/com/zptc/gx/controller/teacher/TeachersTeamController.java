package com.zptc.gx.controller.teacher;

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
import com.zptc.gx.controller.achievements.InnovationEntrepreneurialAchievementsControoler;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.InnovationEntrepreneurialAchievements;
import com.zptc.gx.specialty.entity.TeacherTeam;
import com.zptc.gx.specialty.service.TeacherTeamService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 教师团队
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/teachersTeam")
public class TeachersTeamController extends BaseController {
	private Logger logger = Logger.getLogger(TeachersTeamController.class);
	
	@Autowired
	private TeacherTeamService teacherTeamService;
	/**
	 * 教师团队列表
	 */
	@RequestMapping("/getTeachersTeamList")
	@ResponseBody
	public JsonResult getIEAchievementsList(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("获取教师团队列表");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> count = new HashMap<>();
		//获取请求参数
		String latest = ToolUtil.str("latest", request);
		String director = ToolUtil.str("director", request);
		Integer lat = null;
		if(latest.equals("1")) {
			lat = 1;
		}else if(latest.equals("2")) {
			lat = 2;
		}
		
		Integer limit = ToolUtil.integer("limit", request);
		Integer page = ToolUtil.integer("page", request);
		
		PageVO pageVO = new PageVO(page, limit);
		Integer pages = 0;
		//用于分页的方法
		pages = pageVO.getBeginNum();
		//把数据put进入data
		data.put("latest", lat);
		data.put("director", director);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		
		System.out.println("获取到的数据="+data);
		count.put("latest", latest);
		count.put("director", director);
		
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "成功";
		try {
			//获取所有数据(带需求)
			List<TeacherTeam> tList = teacherTeamService.getTeacherTeamList(data);
			//获取数据总条数
			counts = teacherTeamService.selectCounts(count);
			jsonResult = jsonResult.build(FLAG_SUCCESS, tList, msg, counts);
			System.out.println("查询到的数据为="+tList);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = jsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
