package com.zptc.gx.controller.issues;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.Issues;
import com.zptc.gx.specialty.service.IssuesService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/issuesList")
public class IssuesListController extends BaseController{
	@Autowired
	private IssuesService issuesService;
	/*获取列表*/
	@RequestMapping("/getIssuesList")
	@ResponseBody
	public JsonResult getIssuesList(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取课题列表接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String code = ToolUtil.str("code", request);
	    String name = ToolUtil.str("name", request);
	    String date = ToolUtil.str("date", request);
	    String sources = ToolUtil.str("sources", request);
	    Integer status = ToolUtil.integer("status", request);
	    String awardsConstruction = ToolUtil.str("awardsConstruction", request);
	    String host = ToolUtil.str("host", request);
	    String participants = ToolUtil.str("participants", request);
	    Long  specialtyId = ToolUtil.lon("specialtyId", request);
	    String createTime = ToolUtil.str("createTime", request);
	    String createUser = ToolUtil.str("createUser", request);
	    String modifyTime = ToolUtil.str("modifyTime", request);
	    String modifyUser = ToolUtil.str("modifyUser", request);
	    
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
	    data.put("date", date);
	    data.put("sources", sources);
	    data.put("status", 1);
	    data.put("awardsConstruction", awardsConstruction);
	    data.put("host", host);
	    data.put("participants", participants);
	    data.put("specialtyId", specialtyId);
	    data.put("createTime", createTime);
	    data.put("createUser", createUser);
	    data.put("modifyTime", modifyTime);
	    data.put("modifyUser", modifyUser);
	    
		data.put("limits", limits);
		data.put("page", page);
	
		System.out.println("page:"+page);
		System.out.println("limits:"+limits);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
	    count.put("code", code);
	    count.put("name", name);
	    count.put("date", date);
	    count.put("sources", sources);
	    count.put("status", 1);
	    count.put("awardsConstruction", awardsConstruction);
	    count.put("host", host);
	    count.put("participants", participants);
	    count.put("specialtyId", specialtyId);
	    count.put("createTime", createTime);
	    count.put("createUser", createUser);
	    count.put("modifyTime", modifyTime);
	    count.put("modifyUser", modifyUser);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "msg";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<Issues> issuesList = issuesService.getIssuesList(data);
			
			//获取所有status == 1的数据条总数
			counts = issuesService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(0, issuesList, msg, counts);
			System.out.println("获得的数据："+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
