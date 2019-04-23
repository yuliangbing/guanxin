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
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.service.SpecialtyService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/specialty")
public class SpecialtyController extends BaseController {
	private Logger logger = Logger.getLogger(SpecialtyController.class);
	
	@Autowired
	private SpecialtyService specialtyService; 
	
	/*获取列表*/
	
	@RequestMapping("/getSpecialtyList")
	@ResponseBody
	public JsonResult getSpecialty(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("获取专业信息列表接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    Integer status = ToolUtil.integer("status", request);
	    String setup_date = ToolUtil.str("setup_date", request);
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
//	    Integer pages = page;
	    Integer limits = 0;
		//用于分页的数据
		page = (page - 1) * limit;
		limits = limit*page;
		//存入data,用于获取表格数据
	    data.put("code", code);
	    data.put("name", name);
	    data.put("setup_date", setup_date);
		data.put("limits", limits);
		data.put("page", page);
		data.put("status", 1);
		System.out.println("page:"+page);
		System.out.println("limits:"+limits);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
//		count.put("counts", count);
		count.put("code", code);
		count.put("name", name);
		count.put("setup_date", setup_date);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<Specialty> specialtyList = specialtyService.getSpecialtyList(data);
			//获取所有status == 1的数据条总数
			counts = specialtyService.selectCounts(count);
			System.out.println("返回条数："+counts);
			//返回接口的具体数据
			//jsonResult = JsonResult.build(FLAG_SUCCESS, specialtyList);
			jsonResult = jsonResult.build(0, specialtyList, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/*新增分院*/
	
	@RequestMapping("/addSpecialty")
	@ResponseBody
	public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date setup_date = ToolUtil.date1("setup_date", request);
		    
		    Specialty specialty = new Specialty();
		    specialty.setCode(code);
		    specialty.setName(name);
		    specialty.setSetupDate(setup_date);
		    specialty.setCreateTime(new Date());
		    specialty.setCreateUser(user.getTeaName());
		    int result = specialtyService.addSpecialty(specialty);
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
	@RequestMapping("/updateSpecialtyIf")
	@ResponseBody
	public JsonResult updateSpecialtyIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyId = ToolUtil.lon("specialtyId", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date setup_date = ToolUtil.date1("setup_date", request);
		    
		    Specialty specialty = specialtyService.findSpecialtyById(specialtyId);
		    if (specialty == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialty.setCode(code);
		    specialty.setName(name);
		    specialty.setSetupDate(setup_date);
		    specialty.setModifyUser(user.getTeaName());
		    specialty.setModifyTime(new Date());
		    int result = specialtyService.modifySpecialty(specialty);
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
	@RequestMapping("/updateSpecialty")
	@ResponseBody
	public JsonResult updateSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyId = ToolUtil.lon("specialtyId", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date setup_date = ToolUtil.date1("setup_date", request);
		    
		    Specialty specialty = specialtyService.findSpecialtyById(specialtyId);
		    if (specialty == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialty.setCode(code);
		    specialty.setName(name);
		    specialty.setSetupDate(setup_date);
		    specialty.setModifyUser(user.getTeaName());
		    specialty.setModifyTime(new Date());
		    int result = specialtyService.modifySpecialtyKey(specialty);
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
	@RequestMapping("/deleteSpecialty")
	@ResponseBody
	public JsonResult deleteSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用deleteSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyId = ToolUtil.lon("specialtyId", request);
		    
		    int result = specialtyService.deleteSpecialtyById(specialtyId);
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
