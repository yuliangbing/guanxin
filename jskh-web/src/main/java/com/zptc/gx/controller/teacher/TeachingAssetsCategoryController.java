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
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.TeachingAssetsCategory;
import com.zptc.gx.specialty.service.TeachingAssetsCategoryService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("teachingAssetsCategory")
public class TeachingAssetsCategoryController extends BaseController{
   private Logger logger = Logger.getLogger(TeachingAssetsController.class);
   @Autowired
   private TeachingAssetsCategoryService teachingAssetsCategoryService;
   
//   增加教学资产分类信息
   @RequestMapping("/addTeachingAssetsCategory")
   @ResponseBody
   public JsonResult addTeachingAssetsCategory(HttpServletRequest request, HttpServletResponse response) {
     JsonResult jsonResult = new JsonResult();
    System.out.println("添加接口");
    try {
    	ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    
    	String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    Integer status = ToolUtil.integer("status", request);
	    
	   TeachingAssetsCategory teachingAssetsCategory = new TeachingAssetsCategory();
	   teachingAssetsCategory.setCode(code);
	   teachingAssetsCategory.setName(name);
	   teachingAssetsCategory.setStatus(1);
	  teachingAssetsCategory.setCreateTime(new Date());
	  teachingAssetsCategory.setCreateUser(user.getTeaName());
	  if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)) == false) {
		jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
		return jsonResult;
	}
	  System.out.println("数据传入成果");
	  int reault = teachingAssetsCategoryService.addTeachingAssetsCategory(teachingAssetsCategory);
      if (reault>0) {
		jsonResult = JsonResult.build(FLAG_SUCCESS);
	}else {
		jsonResult = JsonResult.build(FLAG_FAILED);
	}
    } catch (Exception e) {
		// TODO: handle exception
    	e.printStackTrace();
    	jsonResult = JsonResult.build(FLAG_SUCCESS,e.getMessage());
	}
    return jsonResult;
   }
//   根据id进行软删除（修改status状态码）
   @RequestMapping("/delTeachingAssetsCategory")
   @ResponseBody
   public JsonResult delSpecialtyProfile(HttpServletRequest request, HttpServletResponse response) {
    JsonResult jsonResult = new JsonResult();
    System.out.println("启用delTeachingAssetsCategory方法");
    try {
    	ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		
    	Long id =ToolUtil.lonWithNull("id",request);
		int status = ToolUtil.integer("status", request);
		System.out.println("id"+id);
		TeachingAssetsCategory teachingAssetsCategory = teachingAssetsCategoryService.findTeachingAssetsCategoryById(id);
		if (teachingAssetsCategory==null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该教学资产分类信息");
			return jsonResult;
		}
		teachingAssetsCategory.setStatus(2);
		int result = teachingAssetsCategoryService.modifyTeachingAssetsCategoryDel(teachingAssetsCategory);
	} catch (Exception e) {
		// TODO: handle exception
	  e.printStackTrace();
	  jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
	}
    return jsonResult;
   }
//  修改教学资产分类信息
   @RequestMapping("/updateTeachingAssetsCategory")
	@ResponseBody
	public JsonResult updateTeachingAssetsCategory(HttpServletRequest request, HttpServletResponse response) {
    JsonResult jsonResult = new JsonResult();
    System.out.println("启用updateTeachingAssetsCategory方法");
    Long id = ToolUtil.lon("id", request);
    String code = ToolUtil.str("code", request);
    String name = ToolUtil.str("name", request);
    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//   根据id修改
    TeachingAssetsCategory teachingAssetsCategory = teachingAssetsCategoryService.findTeachingAssetsCategoryById(id);
	   if (teachingAssetsCategory == null) {
		jsonResult = JsonResult.build(FLAG_FAILED, "没有该教学资产分类信息");
		return jsonResult;
	} 
	teachingAssetsCategory.setId(id);
	teachingAssetsCategory.setCode(code);
	teachingAssetsCategory.setName(name);
	 if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("updateTeachingAssetsCategory方法拿到的数据："+teachingAssetsCategory.toString());
	    	return jsonResult;
	}
	 try {
		int result = teachingAssetsCategoryService.modifyTeachingAssetsCategory(teachingAssetsCategory);
		if (result>0) {
			jsonResult = JsonResult.build(FLAG_SUCCESS);
		}else {
			jsonResult = JsonResult.build(FLAG_FAILED);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
	}
	 return jsonResult;
   }
//   获取教学资产分类
   @RequestMapping("/getTeachingAssetsCategoryList")
	 @ResponseBody
	 public JsonResult getTeachingAssetsCategoryList(HttpServletRequest request, HttpServletResponse responses) {
     JsonResult jsonResult =new JsonResult();
     Map< String, Object> data = new HashMap<>();
//     获取请求参数
    // Long id = ToolUtil.lon("id", request);
     String code = ToolUtil.str("code", request);
     String name = ToolUtil.str("name", request);
     //Integer status = ToolUtil.integer("status", request);
	  Integer limit = ToolUtil.integer("limit", request);
	  Integer page = ToolUtil.integer("page", request);
	  PageVO pageVO = new PageVO(page, limit);
	  Integer pages = 0;
	//用于分页的数据
	  pages = pageVO.getBeginNum();
	//存入data,用于获取表格数据
	  //data.put("id", id);
	  data.put("code", code);
	  data.put("name", name);
	  data.put("limit", pageVO.getLimit());
	  data.put("pages", pages);
	  data.put("status", 1);
	  Map<String, Object> count = new HashMap<>();
	//存入count,用于获取表格数据条总数
	  //count.put("id", id);
	  count.put("counts", count);
	  count.put("code", code);
	  count.put("name", name);
	  count.put("status", 1);
//	  定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<TeachingAssetsCategory> teachingAssetsCategoryList = teachingAssetsCategoryService.getTeachingAssetsCategoryList(data);
			//获取所有status == 1的数据条总数
			counts = teachingAssetsCategoryService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(0, teachingAssetsCategoryList, msg, counts);
			System.out.println("获得的数据："+data);		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
   }
   }
