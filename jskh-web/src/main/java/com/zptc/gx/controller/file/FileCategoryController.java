package com.zptc.gx.controller.file;

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

@Controller
@RequestMapping("/fileCategory")
public class FileCategoryController extends BaseController {
	private Logger logger = Logger.getLogger(FileCategoryController.class);
	
	@Autowired
	private FileCategoryService fileCategoryService;
	
	/*获取列表*/
	@RequestMapping("/getFileCategoryList")
	@ResponseBody
	public JsonResult getSpecialty(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取文件类型数据接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    Integer status = ToolUtil.integer("status", request);
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    
	    Integer pages = page;
	    Integer limits = 0;
		//用于分页的数据
		page = (page - 1) * limit;
		limits = limit*pages;
		//存入data,用于获取表格数据
	    data.put("code", code);
	    data.put("name", name);
		data.put("limits", limits);
		data.put("page", page);
		data.put("status", 1);
	
		System.out.println("page:"+page);
		System.out.println("limits:"+limits);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("counts", count);
		count.put("code", code);
		count.put("name", name);
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
	
}
