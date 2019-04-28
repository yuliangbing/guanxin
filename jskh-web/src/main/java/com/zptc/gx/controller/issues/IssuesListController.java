package com.zptc.gx.controller.issues;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.Issues;
import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.service.IssuesService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/issuesList")
public class IssuesListController extends BaseController{
	@Autowired
	private IssuesService issuesService;
	private Long issuesId;
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
	    String date1 = null;
	    String date2 = null;
	    if (date != null && date != "") {
	    	String[] dates = date.split("~");
		    
	    	date1 = dates[0].trim();
		    date2 = dates[1].trim();
		}
	    
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
	    
	    Integer pages = 0;
	    Integer limits = 0;
		//用于分页的数据
		pages = (page - 1) * limit;
		//存入data,用于获取表格数据
	    data.put("code", code);
	    data.put("name", name);
	    data.put("date1", date1);
	    data.put("date2", date2);
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
	    
		data.put("limit", limit);
		data.put("pages", pages);
	
		System.out.println("page:"+pages);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
	    count.put("code", code);
	    count.put("name", name);
	    count.put("date1", date1);
	    count.put("date2", date2);
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
	/*add*/
	
	@RequestMapping("/addIssues")
	@ResponseBody
	public JsonResult addIssues(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addIssues方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Date now = new Date();
			
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date date = ToolUtil.date2("date", request);
		    
		    
		    String sources = ToolUtil.str("sources", request);
		    Integer status = ToolUtil.integer("status", request);
		    String awardsConstruction = ToolUtil.str("awardsConstruction", request);
		    String host = ToolUtil.str("host", request);
		    String participants = ToolUtil.str("participants", request);
		    Long  specialtyId = ToolUtil.lon("specialtyId", request);
		    status = 1;
		    Issues issues = new Issues();
		    issues.setCode(code);
		    issues.setDate(date);
		    issues.setName(name);
		    issues.setSources(sources);
		    issues.setAwardsConstruction(awardsConstruction);
		    issues.setHost(host);
		    issues.setParticipants(participants);
		    issues.setSpecialtyId(specialtyId);
		    issues.setStatus(status);
		    issues.setCreateTime(new Date());
		    issues.setCreateUser(user.getTeaName());
		  //判断传入的值是否为空或""
		    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(sources)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(host)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("addIssues方法拿到的数据："+issues.toString());
		    	return jsonResult;
			}
			
		    System.out.println("传入数据成功");
		    System.out.println("addIssues方法拿到的数据："+issues.toString());
		    int result = issuesService.addIssues(issues);
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
	/*带if的修改*/
	@RequestMapping("/updateIssues")
	@ResponseBody
	public JsonResult updateIssues(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateIssues方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long issuesId = ToolUtil.lon("id", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    Date date = ToolUtil.date2("date", request);
		
		    
		    String sources = ToolUtil.str("sources", request);
		    //Integer status = ToolUtil.integer("status", request);
		    String awardsConstruction = ToolUtil.str("awardsConstruction", request);
		    String host = ToolUtil.str("host", request);
		    String participants = ToolUtil.str("participants", request);
		    Long  specialtyId = ToolUtil.lon("specialtyId", request);
		    

		   
		    
		    
		    Issues issues = issuesService.findIssuesById(issuesId);
		    if (issues == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    issues.setCode(code);
		    issues.setDate(date);
		    issues.setName(name);
		    issues.setSources(sources);
		    issues.setAwardsConstruction(awardsConstruction);
		    issues.setHost(host);
		    issues.setParticipants(participants);
		    issues.setSpecialtyId(specialtyId);
		    issues.setStatus(1);
		    issues.setModifyTime(new Date());
		    issues.setModifyUser(user.getTeaName());
		  //判断传入的值是否为空或""
		    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(participants)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(sources)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(awardsConstruction)&&ToolUtil.equalBool(host)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("updateIssues方法拿到的数据："+issues.toString());
		    	return jsonResult;
			}
		    System.out.println("拿到的数据："+issues.toString());
		    
		    int result = issuesService.modifyIssuesKey(issues);
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
@RequestMapping("/del")
@ResponseBody
public JsonResult delIssuesList(HttpServletRequest request, HttpServletResponse response) {
	JsonResult jsonResult = new JsonResult();
	System.out.println("启用delIssuesList方法");
	try {
		ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
		int status = ToolUtil.integer("status", request);
		status = 2;
		Long issuesId = ToolUtil.lon("Id", request);
		System.out.println("id"+issuesId);
	    //判断是否有该专业
		Issues issues = issuesService.findIssuesById(issuesId);
		if (issues == null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
			return jsonResult;
		}
		issues.setStatus(status);
		int result = issuesService.modifIssuesDel(issues);
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