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
import com.zptc.gx.specialty.entity.SpecialtyConstructionAchievements;
import com.zptc.gx.specialty.entity.SpecialtyConstructionMeasures;
import com.zptc.gx.specialty.service.SpecialtyConstructionMeasuresService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 专业建设举措
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/specialtyConstructionMeasures")
public class SpecialtyConstructionMeasuresController extends BaseController {
	private Logger logger = Logger.getLogger(SpecialtyConstructionMeasuresController.class);
	
	@Autowired
	private SpecialtyConstructionMeasuresService specialtyConstructionMeasuresService; 
	
	/*获取列表*/
	
	@RequestMapping("/getSpecialtyConstructionMeasures")
	@ResponseBody
	public JsonResult getSpecialtyConstructionAchievements(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String date1 = ToolUtil.str("date1", request);
		String date2 = ToolUtil.str("date2", request);
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
	  //用于分页的数据
	    pages = pageVO.getBeginNum();
	    System.out.println("pages:"+pages);
		//存入data,用于获取表格数据
	    data.put("date1", date1);
	    data.put("date2", date2);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("date1", date1);
		count.put("date2", date2);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<SpecialtyConstructionMeasures> specialtyConstructionMeasures = specialtyConstructionMeasuresService.getSpecialtyMeasuresList(data);
			counts = specialtyConstructionMeasuresService.selectCounts(count);
			jsonResult = JsonResult.build(FLAG_SUCCESS, specialtyConstructionMeasures,msg,counts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/*新增*/
	
	@RequestMapping("/addSpecialtyConstructionMeasures")
	@ResponseBody
	public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addSpecialtyConstructionMeasures方法");
		
		/**
		 * 获取参数
		 */
		String measures = ToolUtil.str("measures", request);
	    Long specialtyId = ToolUtil.lon("specialty_id", request);
	    String specialtyName = ToolUtil.str("specialty_name", request);
	    Date date = ToolUtil.date2("date", request);
	    
	    /**
	     * 注入实体类
	     */
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    SpecialtyConstructionMeasures specialtyConstructionMeasures = new SpecialtyConstructionMeasures();
	    specialtyConstructionMeasures.setDate(date);
	    specialtyConstructionMeasures.setMeasures(measures);
	    specialtyConstructionMeasures.setSpecialtyId(specialtyId);
	    specialtyConstructionMeasures.setSpecialtyName(specialtyName);
	    specialtyConstructionMeasures.setStatus(1);
	    specialtyConstructionMeasures.setCreateTime(new Date());
	    specialtyConstructionMeasures.setCreateUser(user.getTeaName());
	   
	    /**
	     * 判断传入的值是否为空或""
	     */
	    if ((ToolUtil.equalBool(measures)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(date)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+specialtyConstructionMeasures.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+specialtyConstructionMeasures.toString());
		try {
			
			int result = specialtyConstructionMeasuresService.addSpecialtyConstructionMeasures(specialtyConstructionMeasures);
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
	@RequestMapping("/updateSpecialtyConstructionMeasuresIf")
	@ResponseBody
	public JsonResult updateSpecialtyConstructionAchievementsIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyConstructionMeasuresIf方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyMeasuresId = ToolUtil.lon("id", request);	    
			String measures = ToolUtil.str("measures", request);
		    Long specialtyId = ToolUtil.lon("specialtyId", request);
		    String specialtyName = ToolUtil.str("specialty_name", request);
		    Date date = ToolUtil.date2("date", request);
		    
		    SpecialtyConstructionMeasures specialtyConstructionMeasures = specialtyConstructionMeasuresService.findSpecialtyConstructionMeasuresById(specialtyMeasuresId);
		    if (specialtyConstructionMeasures == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialtyConstructionMeasures.setDate(date);
		    specialtyConstructionMeasures.setMeasures(measures);
		    specialtyConstructionMeasures.setSpecialtyId(specialtyId);
		    specialtyConstructionMeasures.setSpecialtyName(specialtyName);
		    specialtyConstructionMeasures.setModifyTime(new Date());
		    specialtyConstructionMeasures.setModifyUser(user.getTeaName());
		    /**
		     * 判断传入的值是否为空或""
		     */
		    if ((ToolUtil.equalBool(measures)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(date)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("方法拿到的数据："+specialtyConstructionMeasures.toString());
		    	return jsonResult;
			}
		    System.out.println("传入数据成功");
		    System.out.println("方法拿到的数据："+specialtyConstructionMeasures.toString());
		    int result = specialtyConstructionMeasuresService.modifySpecialtyConstructionMeasures(specialtyConstructionMeasures);
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
	@RequestMapping("/updateSpecialtyConstructionMeasures")
	@ResponseBody
	public JsonResult updateSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyConstructionAchievements方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyMeasuresId = ToolUtil.lon("specialtyMeasuresId", request);	    
			String measures = ToolUtil.str("measures", request);
		    Long specialtyId = ToolUtil.lon("specialtyId", request);
		    Date date = ToolUtil.date1("date", request);
		    
		    SpecialtyConstructionMeasures specialtyConstructionMeasures = specialtyConstructionMeasuresService.findSpecialtyConstructionMeasuresById(specialtyMeasuresId);
		    if (specialtyConstructionMeasures == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialtyConstructionMeasures.setDate(date);
		    specialtyConstructionMeasures.setMeasures(measures);
		    specialtyConstructionMeasures.setSpecialtyId(specialtyId);
		    specialtyConstructionMeasures.setModifyTime(new Date());
		    specialtyConstructionMeasures.setModifyUser(user.getTeaName());
		    int result = specialtyConstructionMeasuresService.modifySpecialtyConstructionAchievementsKey(specialtyConstructionMeasures);
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
	@RequestMapping("/deleteSpecialtyConstructionMeasures")
	@ResponseBody
	public JsonResult deleteSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用deleteSpecialtyConstructionMeasures方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyConstructionMeasuresId = ToolUtil.lon("specialtyConstructionMeasuresId", request);
		    
		    int result = specialtyConstructionMeasuresService.deleteSpecialtyConstructionMeasuresById(specialtyConstructionMeasuresId);
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
	@RequestMapping("/delMeasures")
	@ResponseBody
	public JsonResult delSpecialtyFiles(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delMeasures方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			int status = ToolUtil.integer("status", request);
			status = 2;
			Long specialtyMeasuresId = ToolUtil.lon("id", request);
			System.out.println("id"+specialtyMeasuresId);
		    //判断是否有该专业
			SpecialtyConstructionMeasures specialtyConstructionMeasures = specialtyConstructionMeasuresService.findSpecialtyConstructionMeasuresById(specialtyMeasuresId);
			if (specialtyConstructionMeasures == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
			specialtyConstructionMeasures.setStatus(status);
		    int result = specialtyConstructionMeasuresService.modifSpecialtyMeasuresDel(specialtyConstructionMeasures);
		    System.out.println("要删除的数据是："+specialtyConstructionMeasures.toString());
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
