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
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.OtherAchievements;
import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;
import com.zptc.gx.specialty.service.OtherAchievementsService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 其他成果
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/otherAchievements")
public class OtherAchievementsController extends BaseController {
	private Logger logger = Logger.getLogger(OtherAchievementsController.class);
	
	@Autowired
	private OtherAchievementsService otherAchievementsService;
	/*获取列表*/
	@RequestMapping("/getOtherAchievementsList")
	@ResponseBody
	public JsonResult getOtherAchievementsList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String name = ToolUtil.str("name", request);
		String date1 = ToolUtil.str("date1", request);
		String date2 = ToolUtil.str("date2", request);
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
	  //用于分页的数据
	    pages = pageVO.getBeginNum();
		//存入data,用于获取表格数据
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("date1", date1);
		data.put("data2", data);
		data.put("name", name);
		data.put("status", 1);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("date1", date1);
		count.put("data2", data);
		count.put("name", name);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<OtherAchievements> otherAchievements = otherAchievementsService.getOtherAchievementsList(data);
			counts = otherAchievementsService.selectCounts(count);
			jsonResult = JsonResult.build(FLAG_SUCCESS, otherAchievements,msg,counts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/*新增*/
	
	@RequestMapping("/addOtherAchievements")
	@ResponseBody
	public JsonResult addOtherAchievements(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addOtherAchievements方法");
		/*获取参数*/
		String name = ToolUtil.str("name", request);
		String sources = ToolUtil.str("sources", request);
		String level = ToolUtil.str("level", request);
		String firstAuthor = ToolUtil.str("first_author", request);
		String otherAuthors = ToolUtil.str("other_authors", request);
	    Long specialtyId = ToolUtil.lon("specialty_id", request);
	    String specialtyName = ToolUtil.str("specialty_name", request);
	    Date date = ToolUtil.date2("date", request);
	    
	    /* 注入实体类  */
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    OtherAchievements otherAchievements = new OtherAchievements();
	    otherAchievements.setDate(date);
	    otherAchievements.setName(name);
	    otherAchievements.setSources(sources);
	    otherAchievements.setLevel(level);
	    otherAchievements.setFirstAuthor(firstAuthor);
	    otherAchievements.setOtherAuthors(otherAuthors);
	    otherAchievements.setSpecialtyId(specialtyId);
	    otherAchievements.setSpecialtyName(specialtyName);
	    otherAchievements.setStatus(1);
	    otherAchievements.setCreateTime(new Date());
	    otherAchievements.setCreateUser(user.getTeaName());
	   
	    /* 判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(name)&&ToolUtil.equalBool(otherAuthors)&&ToolUtil.equalBool(firstAuthor)&&ToolUtil.equalBool(sources)&&ToolUtil.equalBool(level)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(date)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+otherAchievements.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+otherAchievements.toString());
		try {
			
			int result = otherAchievementsService.addOtherAchievements(otherAchievements);
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
	/*修改*/
	@RequestMapping("/updateOtherAchievements")
	@ResponseBody
	public JsonResult updateOtherAchievements(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateOtherAchievements方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long otherAchievementsId = ToolUtil.lon("id", request);	    
			String name = ToolUtil.str("name", request);
			String sources = ToolUtil.str("sources", request);
			String level = ToolUtil.str("level", request);
			String firstAuthor = ToolUtil.str("first_author", request);
			String otherAuthors = ToolUtil.str("other_authors", request);
		    Long specialtyId = ToolUtil.lon("specialty_id", request);
		    String specialtyName = ToolUtil.str("specialty_name", request);
		    Date date = ToolUtil.date2("date", request);
		    
		    OtherAchievements otherAchievements = otherAchievementsService.findOtherAchievementsById(otherAchievementsId);
		    if (otherAchievements == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    otherAchievements.setDate(date);
		    otherAchievements.setName(name);
		    otherAchievements.setSources(sources);
		    otherAchievements.setLevel(level);
		    otherAchievements.setFirstAuthor(firstAuthor);
		    otherAchievements.setOtherAuthors(otherAuthors);
		    otherAchievements.setSpecialtyId(specialtyId);
		    otherAchievements.setSpecialtyName(specialtyName);
		    otherAchievements.setStatus(1);
		    otherAchievements.setModifyTime(new Date());
		    otherAchievements.setModifyUser(user.getTeaName());
		    /* 判断传入的值是否为空或""*/
		    if ((ToolUtil.equalBool(name)&&ToolUtil.equalBool(otherAuthors)&&ToolUtil.equalBool(firstAuthor)&&ToolUtil.equalBool(sources)&&ToolUtil.equalBool(level)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(date)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("方法拿到的数据："+otherAchievements.toString());
		    	return jsonResult;
			}
		    System.out.println("传入数据成功");
		    System.out.println("方法拿到的数据："+otherAchievements.toString());
		    int result = otherAchievementsService.modifyOtherAchievements(otherAchievements);
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
	/**
	 * 根据id进行软删除（修改status状态码）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delOtherAchievements")
	@ResponseBody
	public JsonResult delSpecialtyFiles(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delOtherAchievements方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			int status = ToolUtil.integer("status", request);
			status = 2;
			Long otherAchievementsId = ToolUtil.lon("id", request);
			System.out.println("id"+otherAchievementsId);
		    //判断是否有该专业
			OtherAchievements otherAchievements = otherAchievementsService.findOtherAchievementsById(otherAchievementsId);
			if (otherAchievements == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
			otherAchievements.setStatus(status);
		    int result = otherAchievementsService.modifOtherAchievementsDel(otherAchievements);
		    System.out.println("要删除的数据是："+otherAchievements.toString());
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
