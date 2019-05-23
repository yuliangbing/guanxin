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
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.service.SpecialtyService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("/specialty")
public class SpecialtyController extends BaseController {
	private Logger logger = Logger.getLogger(SpecialtyController.class);
	
	@Autowired
	private SpecialtyService specialtyService; 
	private Integer status; 
	
	/**
	 * 获得从建校起到date时间段内的所有专业数量(别修改)
	 */
	@RequestMapping("/specialtyCounts")
	@ResponseBody
	public JsonResult specialtyCounts(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
	    String setup_date = ToolUtil.str("setup_date", request);//当前时间
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("setup_date", setup_date);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		//String msg = "success";
		try {
			counts = specialtyService.datesCounts(count);
			//返回接口的具体数据
			jsonResult = JsonResult.build(counts);
			System.out.println("获得的数据："+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/**
	 * 获取下拉列表专业id的，不要修改
	 * @param request
	 * @param response
	 * @return
	 */
	//下拉列表的接口
	@RequestMapping("/getSpecialtyList")
	@ResponseBody
	public JsonResult getSpecialty(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("获取专业信息下拉列表数据口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    //status = ToolUtil.integer("status", request);
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
	
	/**
	 * 获取专业信息的列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ListSpecialty")
	@ResponseBody
	public JsonResult ListSpecialty(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("获取专业信息列表接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		/*String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    String setup_date = ToolUtil.str("setup_date", request);*/
	  //  Integer status = ToolUtil.integer("status", request);
		/*PageVO pageVO = new PageVO();
        Integer	limit = pageVO.getLimit();
        System.out.println("1="+limit);
	    limit = ToolUtil.integer("limit", request);
	    System.out.println("2="+limit);
	    Integer page = pageVO.getPage();
	    page = ToolUtil.integer("page", request);
	    PageVO pageVO1 = new PageVO(page, limit);*/
		Integer page = ToolUtil.integer("page", request);
		Integer limit = ToolUtil.integer("limit", request);
		PageVO pageVO = new PageVO(page,limit);
	    Integer pages = 0;
		//用于分页的数据
	    pages = pageVO.getBeginNum();
		//存入data,用于获取表格数据
	   /* data.put("code", code);
	    data.put("name", name);
	    data.put("setup_date", setup_date);*/
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
	/*	count.put("code", code);
		count.put("name", name);
		count.put("setup_date", setup_date);*/
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<Specialty> specialtyList = specialtyService.ListSpecialty(data);
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
		    Date setup_date = ToolUtil.date2("setup_date", request);
		    Specialty specialty = new Specialty();
		    
		    specialty.setCode(code);
		    specialty.setName(name);
		    specialty.setSetupDate(setup_date);
		    specialty.setStatus(1);
		    specialty.setCreateTime(new Date());
		    specialty.setCreateUser(user.getTeaName());
		    
		    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(setup_date)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("方法拿到的数据："+specialty.toString());
		    	return jsonResult;
			}
		    
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
	@RequestMapping("/updateSpecialty")
	@ResponseBody
	public JsonResult updateSpecialtyIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyId = ToolUtil.lon("id", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date setup_date = ToolUtil.date2("setup_date", request);
		    System.out.println("id="+specialtyId);
		    Specialty specialty = specialtyService.findSpecialtyById(specialtyId);
		    if (specialty == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(setup_date)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("方法拿到的数据："+specialty.toString());
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
				System.out.println(1);
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
	@RequestMapping("/updateSpecialtys")
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
	/*删除分院(软)*/
	@RequestMapping("/delSpecialty")
	@ResponseBody
	public JsonResult delSpecialtyFiles(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			status = 2;
			Long specialtyId = ToolUtil.lon("id", request);
			System.out.println("id="+specialtyId);
		    //判断是否有该专业
			Specialty specialty = specialtyService.findSpecialtyById(specialtyId);
			if (specialty == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
			specialty.setStatus(status);
		    int result = specialtyService.modifSpecialtyDel(specialty);
		    System.out.println("要删除的数据是："+specialty.toString());
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
	
	@RequestMapping("/getEnableSpecialtyList")
	@ResponseBody
	public JsonResult getEnableSpecialtyList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("获取专业信息下拉列表数据口");
		JsonResult jsonResult = new JsonResult();
		//定义返回的msg
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			List<Specialty> specialtyList = specialtyService.getEnableSpecialtyList();
			jsonResult = jsonResult.build(FLAG_SUCCESS, specialtyList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
