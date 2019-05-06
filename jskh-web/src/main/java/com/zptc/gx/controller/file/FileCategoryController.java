package com.zptc.gx.controller.file;

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
import com.zptc.gx.specialty.entity.FileCategory;
import com.zptc.gx.specialty.service.FileCategoryService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("/fileCategory")
public class FileCategoryController extends BaseController {
	private Logger logger = Logger.getLogger(FileCategoryController.class);
	
	@Autowired
	private FileCategoryService fileCategoryService;
	
	/**
	 * 这个是获取下拉列表的，不要修改
	 * @param request
	 * @param responses
	 * @return
	 */
	@RequestMapping("/getFileCategoryList")
	@ResponseBody
	public JsonResult getFileCategoryList(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取文件类型数据接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
	    Integer status = ToolUtil.integer("status", request);
		data.put("status", 1);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "msg";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<FileCategory> fileCategories = fileCategoryService.getFileCategoryList(data);
			System.out.println("获得"+fileCategories.size()+"个数据");
			//获取所有status == 1的数据条总数
			counts = fileCategoryService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(0, fileCategories, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 获取文件类型列表信息
	 */
	@RequestMapping("/ListFileCategory")
	@ResponseBody
	public JsonResult ListFileCategory(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取文件类型数据接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		/*String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    Integer status = ToolUtil.integer("status", request);*/
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
		//用于分页的数据
	    Integer pages = pageVO.getBeginNum();
		//存入data,用于获取表格数据
	  /*  data.put("code", code);
	    data.put("name", name);*/
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
	/*	count.put("code", code);
		count.put("name", name);*/
		count.put("status", 1);
		//定义返回的数据条总数
		Integer counts = 0;
		//定义返回的msg
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<FileCategory> fileCategories = fileCategoryService.FileCategoryList(data);
			//获取所有status == 1的数据条总数
			counts = fileCategoryService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(0, fileCategories, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 添加文件类型
	 */
	@RequestMapping("/addFileCategory")
	@ResponseBody
	public JsonResult addFileCategory(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("添加文件类型接口启动");
		JsonResult jsonResult = new JsonResult();
		//获取参数
		String code = ToolUtil.str("code", request);
		String name = ToolUtil.str("name", request);
		ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		FileCategory fileCategory = new FileCategory();
		fileCategory.setCode(code);
		fileCategory.setName(name);
		fileCategory.setStatus(1);
		fileCategory.setCreateTime(new Date());
		fileCategory.setCreateUser(user.getTeaName()); 
	    /* 判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+fileCategory.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+fileCategory.toString());
	    try {
			
			int result = fileCategoryService.addFileCategory(fileCategory);
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
	 * 修改文件类型
	 */
	@RequestMapping("/UpdateFileCategory")
	@ResponseBody
	public JsonResult UpdateFileCategory(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("修改文件类型接口启动");
		JsonResult jsonResult = new JsonResult();
		//获取参数
		Long id = ToolUtil.lon("id", request);
		String code = ToolUtil.str("code", request);
		String name = ToolUtil.str("name", request);
		FileCategory fileCategory = fileCategoryService.findFileCategoryById(id);
		if(fileCategory == null) {
			jsonResult = jsonResult.build(FLAG_FAILED, "没有该文件类型");
			return jsonResult;
		}
		ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		
		fileCategory.setCode(code);
		fileCategory.setName(name);
		fileCategory.setModifyTime(new Date());
		fileCategory.setModifyUser(user.getTeaName()); 
		
	    /* 判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+fileCategory.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+fileCategory.toString());
	    try {
			
			int result = fileCategoryService.modifyFileCategory(fileCategory);
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
	 * 删除文件类型
	 */
	@RequestMapping("/DelFileCategory")
	@ResponseBody
	public JsonResult DelFileCategory(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("修改文件类型接口启动");
		JsonResult jsonResult = new JsonResult();
		//获取参数
		Long id = ToolUtil.lon("id", request);
		FileCategory fileCategory = fileCategoryService.findFileCategoryById(id);
		if(fileCategory == null) {
			jsonResult = jsonResult.build(FLAG_FAILED, "没有该文件类型");
			return jsonResult;
		}
		fileCategory.setStatus(2);
	    try {
			
			int result = fileCategoryService.modifFileCategoryDel(fileCategory);
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
