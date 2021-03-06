package com.zptc.gx.controller.foreignExchange;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.ForeignExchange;
import com.zptc.gx.specialty.service.ForeignExchangeService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 对外学习交流
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/foreignExchange")
public class ForeignExchangeController extends BaseController {
	private Logger logger = Logger.getLogger(ForeignExchangeController.class);
	
	@Autowired
	private ForeignExchangeService fService;
	/**
	 * 获取列表
	 */
	@RequestMapping("/getForeignExchangeList")
	@ResponseBody
	public JsonResult getForeignExchangeList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		String  date1 = ToolUtil.str("date1", request);
		String  date2 = ToolUtil.str("date2", request);
		String  units = ToolUtil.str("units", request);
		String  participants = ToolUtil.str("participants", request);
		Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
		Map<String, Object> data = new HashMap<>();
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
	    //用于分页的数据
	    pages = pageVO.getBeginNum();
	    //存入data,用于获取表格数据
	    data.put("date1", date1);
	    data.put("date2", date2);
	    data.put("units",units);
	    data.put("participants",participants);
  		data.put("limit", pageVO.getLimit());
  		data.put("pages", pages);
  		data.put("status", 1);
  		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
  		count.put("date1", date1);
  		count.put("date2", date2);
	    count.put("units",units);
	    count.put("participants",participants);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "获取成功";
		try {
			//获取所有status == 1 的所有数据
			List<ForeignExchange> fList = fService.getForeignExchangeList(data);
			System.out.println("返回的数据："+fList);
			counts = fService.selectCounts(count);
			jsonResult = JsonResult.build(FLAG_SUCCESS, fList,msg,counts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 添加
	 */
	@RequestMapping("/addForeignExchange")
	@ResponseBody
	public JsonResult addForeignExchange(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addForeignExchange方法");
	   
		Date date = ToolUtil.date2("date", request);
		String content = ToolUtil.str("content", request);
		String units = ToolUtil.str("units", request);
		String participants = ToolUtil.str("participants", request);
		String achievements = ToolUtil.str("achievements", request);
		Long specialtyId = ToolUtil.lon("specialty_id", request);
		String specialtyName = ToolUtil.str("specialty_name", request);
		
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    ForeignExchange fExchange = new ForeignExchange();
	    fExchange.setDate(date);
	    fExchange.setContent(content);
	    fExchange.setUnits(units);
	    fExchange.setParticipants(participants);
	    fExchange.setAchievements(achievements);
	    fExchange.setSpecialtyId(specialtyId);
	    fExchange.setSpecialtyName(specialtyName);
	    fExchange.setStatus(1);
	    fExchange.setCreateTime(new Date());
	    fExchange.setCreateUser(user.getTeaName());
	   System.out.println("获取到的数据="+fExchange.toString());
	    /*判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(fExchange.getDate())&&ToolUtil.equalBool(fExchange.getContent())&&ToolUtil.equalBool(fExchange.getUnits())&&ToolUtil.equalBool(fExchange.getParticipants())&&ToolUtil.equalBool(fExchange.getAchievements())
	    		&&ToolUtil.equalBool(fExchange.getSpecialtyId())&&ToolUtil.equalBool(fExchange.getSpecialtyName())) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+fExchange.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+fExchange.toString());
		try {
			
			int result = fService.addForeignExchange(fExchange);
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"添加成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"添加失败,请重新尝试");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 修改
	 */
	@RequestMapping("/updateForeignExchange")
	@ResponseBody
	public JsonResult updateForeignExchange(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateForeignExchange方法");
	    
		Long id = ToolUtil.lon("id", request);
		Date date = ToolUtil.date2("date", request);
		String content = ToolUtil.str("content", request);
		String units = ToolUtil.str("units", request);
		String participants = ToolUtil.str("participants", request);
		String achievements = ToolUtil.str("achievements", request);
		Long specialtyId = ToolUtil.lon("specialty_id", request);
		String specialtyName = ToolUtil.str("specialty_name", request);
		
	    ForeignExchange fExchange = fService.findForeignExchangeById(id);//查询该id的数据
	    if (fExchange == null) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该 对外学习交流信息！");
			return jsonResult;
		}
	    
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    //将传入的数据注入将要修改的数据中
	    fExchange.setDate(date);
	    fExchange.setContent(content);
	    fExchange.setUnits(units);
	    fExchange.setParticipants(participants);
	    fExchange.setAchievements(achievements);
	    fExchange.setSpecialtyId(specialtyId);
	    fExchange.setSpecialtyName(specialtyName);
	    fExchange.setModifyTime(new Date());
	    fExchange.setModifyUser(user.getTeaName());
	    
	    /*判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(date)&&ToolUtil.equalBool(content)&&ToolUtil.equalBool(units)&&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(achievements)
	    		&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	//接口拿到的数据
		    System.out.println("方法拿到的数据："+fExchange.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+fExchange.toString());
	    
	    try {
			
			int result = fService.modifyForeignExchange(fExchange);
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"修改成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"修改失败,请重新尝试");
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
	@RequestMapping("/delForeignExchange")
	@ResponseBody
	public JsonResult delForeignExchange(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delForeignExchange方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long id = ToolUtil.lon("id", request);
			System.out.println("id="+id);
		    //判断是否有该专业
			
			ForeignExchange foreignExchange = fService.findForeignExchangeById(id);
			if (foreignExchange == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该 对外学习交流信息！");
				return jsonResult;
			}
			foreignExchange.setStatus(2);
		    int result = fService.delForeignExchange(foreignExchange);
		    System.out.println("要删除的数据是："+foreignExchange.toString());
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"删除成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"删除失败，请检查网络后，重新尝试");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
