package com.zptc.gx.controller.teacher;

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
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.TeachingAssets;
import com.zptc.gx.specialty.service.TeachingAssetsService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("/TeachingAssets")
public class TeachingAssetsController extends BaseController{
	private Logger logger = Logger.getLogger(TeachingAssetsController.class);
	
	@Autowired
	private TeachingAssetsService teachingAssetsService;
	
//	增加教学资产信息
	@RequestMapping("/addSTeachingAssets")
	@ResponseBody
	public JsonResult addSTeachingAssets(HttpServletRequest request, HttpServletResponse response) {
	   JsonResult jsonResult =new JsonResult();
	   System.out.println("添加数据");
	   try {
		    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		    
		    String cate_code = ToolUtil.str("cate_code", request);
		    String name = ToolUtil.str("name", request);
		    String model_num = ToolUtil.str("model_num", request);
		    String specification = ToolUtil.str("specification", request);
		    String sources = ToolUtil.str("sources", request);
		    Date date = ToolUtil.date2("date", request);
		    BigDecimal total_amount =ToolUtil.dec("total_amount", request);
		   String country_code = ToolUtil.str("country_code", request);
		   String code = ToolUtil.str("code", request);
		   String manufacturer = ToolUtil.str("manufacturer", request);
		   String use_person = ToolUtil.str("use_person", request);
		   String status_code = ToolUtil.str("status_code", request);
		   String training_room = ToolUtil.str("training_room", request);
		   String remark = ToolUtil.str("remark", request);
		   Long specialty_id = ToolUtil.lon("specialty_id", request);
		   String specialty_name = ToolUtil.str("specialty_name", request);
		    Integer status = ToolUtil.integer("status", request);
		   
		   TeachingAssets teachingAssets = new TeachingAssets();
		   teachingAssets.setDate(date);
		   teachingAssets.setCateCode(cate_code);
		   teachingAssets.setName(name);
		   teachingAssets.setModelNum(model_num);
		   teachingAssets.setSources(sources);
		   teachingAssets.setTotalAmount(total_amount);
		   teachingAssets.setCountryCode(country_code);
		   teachingAssets.setCode(code);
		   teachingAssets.setManufacturer(manufacturer);
		   teachingAssets.setUsePerson(use_person);
		   teachingAssets.setTrainingRoom(training_room);
		   teachingAssets.setStatusCode(status_code);
		   teachingAssets.setRemark(remark);
		   teachingAssets.setSpecialtyId(specialty_id);
		   teachingAssets.setSpecialtyName(specialty_name);
		   teachingAssets.setStatus(1);;
	   if ((ToolUtil.equalBool(cate_code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(country_code)&&ToolUtil.equalBool(code)
			&&ToolUtil.equalBool(model_num)&&ToolUtil.equalBool(sources)&&ToolUtil.equalBool(total_amount)
			&&ToolUtil.equalBool(manufacturer)&&ToolUtil.equalBool(use_person)&&ToolUtil.equalBool(training_room)
			&&ToolUtil.equalBool(status_code)&&ToolUtil.equalBool(remark)
			&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(specialty_id)&&ToolUtil.equalBool(specialty_name)) == false) {
		   jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
			return jsonResult;
		  }
		   System.out.println("数据传入成功");
		   System.out.println("addSTeachingAssets方法拿到的数据："+teachingAssets.toString());
		  int result =teachingAssetsService.addTeachingAssets(teachingAssets); 
		  if (result>0) {
			jsonResult = JsonResult.build(FLAG_SUCCESS);
		}else {
			jsonResult =jsonResult.build(FLAG_FAILED);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		jsonResult = JsonResult.build(FLAG_SUCCESS,e.getMessage());
	}
	   return jsonResult;
	}
	
//	删除教学资源信息（修改status状态码）
	@RequestMapping("/delTeachingAssets")
	@ResponseBody
	public JsonResult delSTeachingAssets(HttpServletRequest request, HttpServletResponse response) {
	  JsonResult jsonResult =new JsonResult();
	  System.out.println("启用delSTeachingAssets方法");
	  try {
		  ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
         
		Long id =ToolUtil.lonWithNull("id",request);
		int status = ToolUtil.integer("status", request);
		System.out.println("id"+id);
//		判断是否有该教学资源信息
		TeachingAssets teachingAssets = teachingAssetsService.findTeachingAssetsById(id);
		if (teachingAssets == null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该教学资源信息");
			return jsonResult;
		}
		teachingAssets.setStatus(2);
		int result = teachingAssetsService.modifTeachingAssetsDel(teachingAssets);
		System.out.println("status："+status);
	    System.out.println("result:"+result);
		if (result>0) {
			jsonResult = JsonResult.build(FLAG_SUCCESS);
		}else {
			jsonResult = JsonResult.build(FLAG_FAILED);
		}
	  } catch (Exception e) {
		// TODO: handle exception
		  e.printStackTrace();
		  jsonResult = JsonResult.build(FLAG_FAILED,e.getMessage());
	}
	  return jsonResult;
	}
//  修改教学资产信息
  @RequestMapping("/updateTeachingAssets")
	@ResponseBody
	public JsonResult updateTeachingAssets(HttpServletRequest request, HttpServletResponse response) {
    JsonResult jsonResult = new JsonResult();
	System.out.println("启用updateTeachingAssets方法");
	Long id = ToolUtil.lon("id", request);
	String cate_code = ToolUtil.str("cate_code", request);
    String name = ToolUtil.str("name", request);
    String model_num = ToolUtil.str("model_num", request);
    String specification = ToolUtil.str("specification", request);
    String sources = ToolUtil.str("sources", request);
    Date date = ToolUtil.date2("date", request);
    BigDecimal total_amount =ToolUtil.dec("total_amount", request);
   String country_code = ToolUtil.str("country_code", request);
   String code = ToolUtil.str("code", request);
   String manufacturer = ToolUtil.str("manufacturer", request);
   String use_person = ToolUtil.str("use_person", request);
   String status_code = ToolUtil.str("status_code", request);
   String training_room = ToolUtil.str("training_room", request);
   String remark = ToolUtil.str("remark", request);
   Long specialty_id = ToolUtil.lon("specialty_id", request);
   String specialty_name = ToolUtil.str("specialty_name", request);
   
   ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
  TeachingAssets teachingAssets = teachingAssetsService.findTeachingAssetsById(id);
  if (teachingAssets == null) {
	jsonResult = JsonResult.build(FLAG_FAILED, "没有该教学资产信息");
	return jsonResult;
}
  teachingAssets.setDate(date);
  teachingAssets.setCateCode(cate_code);
  teachingAssets.setName(name);
  teachingAssets.setModelNum(model_num);
  teachingAssets.setSources(sources);
  teachingAssets.setTotalAmount(total_amount);
  teachingAssets.setCountryCode(country_code);
  teachingAssets.setCode(code);
  teachingAssets.setManufacturer(manufacturer);
  teachingAssets.setUsePerson(use_person);
  teachingAssets.setTrainingRoom(training_room);
  teachingAssets.setStatusCode(status_code);
  teachingAssets.setModifyTime(new Date());
  teachingAssets.setModifyUser(user.getTeaName());
//  判断是否缺少数据
  if ((ToolUtil.equalBool(cate_code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(country_code)&&ToolUtil.equalBool(code)
			&&ToolUtil.equalBool(model_num)&&ToolUtil.equalBool(sources)&&ToolUtil.equalBool(total_amount)
			&&ToolUtil.equalBool(manufacturer)&&ToolUtil.equalBool(use_person)&&ToolUtil.equalBool(training_room)
			&&ToolUtil.equalBool(status_code)&&ToolUtil.equalBool(remark)
			&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(specialty_id)&&ToolUtil.equalBool(specialty_name)) == false) {
		   jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
			return jsonResult;
		  }
  System.out.println("数据传入成功");
  try {
	int result = teachingAssetsService.modifyTeachingAssets(teachingAssets);
	if (result >0 ) {
		jsonResult = JsonResult.build(FLAG_SUCCESS);
	}else {
		jsonResult = JsonResult.build(FLAG_FAILED);
	}
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	jsonResult= JsonResult.build(FLAG_FAILED,e.getMessage());
}
  return jsonResult;
  }
//  获取教学资产信息列表&搜索
  @RequestMapping("/getTeachingAssets")
  @ResponseBody
  public JsonResult getTeachingAssets(HttpServletRequest request, HttpServletResponse responses) {
	  System.out.println("获取教学资产信息列表&搜索");
	  JsonResult jsonResult = new JsonResult();
	  Map<String, Object> data = new HashMap<>();
//	  获取请求参数
	  String cate_code = ToolUtil.str("cate_code", request);
	    String name = ToolUtil.str("name", request);
	    String model_num = ToolUtil.str("model_num", request);
	    String specification = ToolUtil.str("specification", request);
	    String sources = ToolUtil.str("sources", request);
	    Date date = ToolUtil.date2("date", request);
	    BigDecimal total_amount =ToolUtil.dec("total_amount", request);
	   String country_code = ToolUtil.str("country_code", request);
	   String code = ToolUtil.str("code", request);
	   String manufacturer = ToolUtil.str("manufacturer", request);
	   String use_person = ToolUtil.str("use_person", request);
	   String status_code = ToolUtil.str("status_code", request);
	   String training_room = ToolUtil.str("training_room", request);
	   String remark = ToolUtil.str("remark", request);
	   //Long specialty_id = ToolUtil.lon("specialty_id", request);
	   String specialty_name = ToolUtil.str("specialty_name", request);
	   Integer status = ToolUtil.integer("status", request);
	   Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
	  //用于分页的数据
	    pages = pageVO.getBeginNum();
	  //存入data,用于获取表格数据
	    data.put("cate_code", cate_code);
	    data.put("name", name);
	    data.put("model_num", model_num);
	    data.put("specification", specification);
	    data.put("sources", sources);
	    data.put("date", date);
	    data.put("total_amount", total_amount);
	    data.put("country_code", country_code);
	    data.put("code", code);
	    data.put("manufacturer", manufacturer);
	    data.put("use_person", use_person);
	    data.put("status_code", status_code);
	    data.put("training_room", training_room);
	    data.put("remark", remark);
	   // data.put("specialty_id", specialty_id);
	    data.put("specialty_name", specialty_name);
	    data.put("limit", pageVO.getLimit());
	    data.put("pages", pages);
	    data.put("status", 1);
	    System.out.println("pages:"+pages);
	  //存入count,用于获取表格数据条总数
		Map<String, Object> count = new HashMap<>();
		count.put("cate_code", cate_code);
		count.put("name", name);
		count.put("model_num", model_num);
		count.put("specification", specification);
		count.put("sources", sources);
		count.put("date", date);
		count.put("total_amount", total_amount);
		count.put("country_code", country_code);
		count.put("code", code);
		count.put("manufacturer", manufacturer);
		count.put("use_person", use_person);
		count.put("status_code", status_code);
		count.put("training_room", training_room);
		count.put("remark", remark);
		count.put("specialty_name", specialty_name);
		count.put("status", 1);
	  //定义返回的数据条总数
  		int counts = 0;
  		//定义返回的msg
  		String msg = "success";
  		try {
  			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
  		//获取所有status == 1 的所有数据
  			List<TeachingAssets> teachingAssetsList = teachingAssetsService.getTeachingAssetsList(data);
  		//获取所有status == 1的数据条总数
  			counts = teachingAssetsService.selectCounts(count);
  		//返回接口的具体数据
  			jsonResult = jsonResult.build(0, teachingAssetsList, msg,counts);
  			System.out.println("获得的数据："+data);
  		} catch (Exception e) {
			// TODO: handle exception
  			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
      return jsonResult;
  }
  }
