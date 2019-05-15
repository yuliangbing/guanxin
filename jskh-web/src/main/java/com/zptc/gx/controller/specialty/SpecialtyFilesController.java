package com.zptc.gx.controller.specialty;

import java.util.ArrayList;
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
import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.service.SpecialtyFilesService;
import com.zptc.gx.specialty.service.SpecialtyService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/specialtyFiles")
public class SpecialtyFilesController extends BaseController {
	private Logger logger = Logger.getLogger(SpecialtyFilesController.class);
	
	@Autowired
	private SpecialtyFilesService specialtyFilesService; 
	
	/*获取列表*/
	
	@RequestMapping("/getSpecialtyFilesList")
	@ResponseBody
	public JsonResult getSpecialty(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取专业文件列表接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    String cate_name = ToolUtil.str("cate_name", request);
	    String reviser = ToolUtil.str("reviser", request);
	  /*  Long specialty_id = ToolUtil.lon("specialty_id", request);*/
	    Integer status = ToolUtil.integer("status", request);
	    String date1 = ToolUtil.str("date1", request);
	    String date2 = ToolUtil.str("date2", request);
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    Integer pages = 0;
		//用于分页的数据
		pages = (page - 1) * limit;
		//存入data,用于获取表格数据
	    data.put("code", code);
	    data.put("name", name);
	    data.put("cate_name", cate_name);
	    data.put("reviser", reviser);
//	    data.put("specialty_id", specialty_id);
	    data.put("date1", date1);
	    data.put("date2", date2);
		data.put("limit", limit);
		data.put("pages", pages);
		data.put("status", 1);
	
		System.out.println("pages:"+pages);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("counts", count);
		count.put("code", code);
		count.put("name", name);
		count.put("cate_name", cate_name);
		count.put("reviser", reviser);
//		count.put("specialty_id", specialty_id);
		count.put("date1 ", date1);
		count.put("date2", date2);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<SpecialtyFiles> specialtyFilesList = specialtyFilesService.getSpecialtyFilesList(data);
			//获取所有status == 1的数据条总数
			counts = specialtyFilesService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(0, specialtyFilesList, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/*新增专业文件*/
	
	@RequestMapping("/addSpecialtyFiles")
	@ResponseBody
	public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addSpecialty方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    String cateName = ToolUtil.str("cate_name", request);
		    System.out.println("cateName"+cateName);
		    String reviser = ToolUtil.str("reviser", request);
		    Long specialty_id = ToolUtil.lon("specialty_id", request);
		    System.out.println("专业id："+specialty_id);
		    String specialty_name = ToolUtil.str("specialty_name", request);
		    System.out.println("获取到的专业name"+specialty_name);
		    Date date = ToolUtil.date2("date", request);
		    
		    SpecialtyFiles specialtyFiles = new SpecialtyFiles();
		    specialtyFiles.setCode(code);
		    specialtyFiles.setDate(date);
		    specialtyFiles.setName(name);
		    specialtyFiles.setCateName(cateName);
		    specialtyFiles.setReviser(reviser);
		    specialtyFiles.setSpecialtyId(specialty_id);
		    specialtyFiles.setSpecialtyName(specialty_name);
		    specialtyFiles.setStatus(1);
		    specialtyFiles.setCreateTime(new Date());
		    specialtyFiles.setCreateUser(user.getTeaName());
		    //判断传入的值是否为空或""
		    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(cateName)&&ToolUtil.equalBool(reviser)&&ToolUtil.equalBool(specialty_id)&&ToolUtil.equalBool(date)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("addSpecialty方法拿到的数据："+specialtyFiles.toString());
		    	return jsonResult;
			}
		    System.out.println("传入数据成功");
		    System.out.println("addSpecialty方法拿到的数据："+specialtyFiles.toString());
		    int result = specialtyFilesService.addSpecialtyFiles(specialtyFiles);
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
	/*专业文件修改*/
	/*带if的修改*/
	@RequestMapping("/updateSpecialtyFilesIf")
	@ResponseBody
	public JsonResult updateSpecialtyIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyFilesIf方法");
		Long specialtyFilesId = ToolUtil.lon("Id", request);
		String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    String cateName = ToolUtil.str("cate_name", request);
	    String reviser = ToolUtil.str("reviser", request);
	    Long specialty_id = ToolUtil.lon("specialty_id", request);
	    String specialty_name = ToolUtil.str("specialty_name", request);
	    System.out.println("获取到的专业name"+specialty_name);
	    Integer status = ToolUtil.integer("status", request);
	    Date date = ToolUtil.date2("date", request);
	    status = 1;
	    System.out.println("判断返回的值"+(ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(cateName)&&ToolUtil.equalBool(reviser)&&ToolUtil.equalBool(specialty_id)&&ToolUtil.equalBool(date)));
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//		//根据specialtyFilesId查询
	    SpecialtyFiles specialtyFiles = specialtyFilesService.findSpecialtyFilesById(specialtyFilesId);
	    if (specialtyFiles == null) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
			return jsonResult;
		}
	    specialtyFiles.setDate(date);
	    specialtyFiles.setCode(code);
	    specialtyFiles.setName(name);
	    specialtyFiles.setCateName(cateName);
	    specialtyFiles.setReviser(reviser);
	    specialtyFiles.setSpecialtyId(specialty_id);
	    specialtyFiles.setSpecialtyName(specialty_name);
	    specialtyFiles.setStatus(status);
	    specialtyFiles.setModifyTime(new Date());
	    specialtyFiles.setModifyUser(user.getTeaName());
	   
	    //判断传入的值是否为空或""
	    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(cateName)&&ToolUtil.equalBool(reviser)&&ToolUtil.equalBool(specialty_id)&&ToolUtil.equalBool(specialty_name)&&ToolUtil.equalBool(date)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("updateSpecialtyIf方法拿到的数据："+specialtyFiles.toString());
	    	return jsonResult;
		}
	    else {
	    	System.out.println("传入数据成功");
			try {
				
//				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//				//根据specialtyFilesId查询
//			    SpecialtyFiles specialtyFiles = specialtyFilesService.findSpecialtyFilesById(specialtyFilesId);
//			    if (specialtyFiles == null) {
//			    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
//					return jsonResult;
//				}
//			    specialtyFiles.setDate(date);
//			    specialtyFiles.setCode(code);
//			    specialtyFiles.setName(name);
//			    specialtyFiles.setCateName(cateName);
//			    specialtyFiles.setReviser(reviser);
//			    specialtyFiles.setSpecialtyId(specialty_id);
//			    specialtyFiles.setStatus(status);
//			    specialtyFiles.setModifyTime(new Date());
//			    specialtyFiles.setModifyUser(user.getTeaName());
			    //接口拿到的数据
			    System.out.println("updateSpecialtyIf方法拿到的数据："+specialtyFiles.toString());
			    int result = specialtyFilesService.modifySpecialtyFiles(specialtyFiles);
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
	/*不带if的修改*/
	@RequestMapping("/updateSpecialtyFiles")
	@ResponseBody
	public JsonResult updateSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyFiles方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyFilesId = ToolUtil.lon("specialtyFilesId", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    String cateName = ToolUtil.str("cateName", request);
		    String reviser = ToolUtil.str("reviser", request);
		    Long specialtyId = ToolUtil.lon("specialtyId", request);
		    //
		    Integer status = ToolUtil.integer("status", request);
		    Date date = ToolUtil.date1("date", request);
		    
		    SpecialtyFiles specialtyFiles = specialtyFilesService.findSpecialtyFilesById(specialtyFilesId);
		    if (specialtyFiles == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    specialtyFiles.setCode(code);
		    specialtyFiles.setName(name);
		    specialtyFiles.setCateName(cateName);
		    specialtyFiles.setReviser(reviser);
		    specialtyFiles.setSpecialtyId(specialtyId);
		    specialtyFiles.setStatus(status);
		    specialtyFiles.setModifyTime(new Date());
		    specialtyFiles.setModifyUser(user.getTeaName());
		    int result = specialtyFilesService.modifySpecialtyFilesKey(specialtyFiles);
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
	/*删除专业文件(数据库删除)*/
	@RequestMapping("/deleteSpecialtyFiles")
	@ResponseBody
	public JsonResult deleteSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用deleteSpecialtyFiles方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long specialtyFilesId = ToolUtil.lon("specialtyFilesId", request);
		    
		    int result = specialtyFilesService.deleteSpecialtyFilesById(specialtyFilesId);
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
	/*根据id进行软删除（修改status状态码）*/
	@RequestMapping("/delSpecialtyFiles")
	@ResponseBody
	public JsonResult delSpecialtyFiles(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delSpecialtyFiles方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			int status = ToolUtil.integer("status", request);
			status = 2;
			Long specialtyFilesId = ToolUtil.lon("specialtyFilesId", request);
			System.out.println("id"+specialtyFilesId);
		    //判断是否有该专业
			SpecialtyFiles specialtyFiles = specialtyFilesService.findSpecialtyFilesById(specialtyFilesId);
			if (specialtyFiles == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
			specialtyFiles.setStatus(status);
		    int result = specialtyFilesService.modifSpecialtyFilesDel(specialtyFiles);
		    System.out.println("status："+status);
		    System.out.println("result:"+result);
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
