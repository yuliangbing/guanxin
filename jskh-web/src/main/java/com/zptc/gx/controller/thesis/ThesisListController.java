package com.zptc.gx.controller.thesis;

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
import com.zptc.gx.controller.specialty.SpecialtyFilesController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.Thesis;
import com.zptc.gx.specialty.entity.Thesis;
import com.zptc.gx.specialty.service.ThesisService;
import com.zptc.gx.specialty.service.ThesisService;
import com.zptc.gx.util.ToolUtil;

@Controller
@RequestMapping("/thesisList")
public class ThesisListController extends BaseController{
	private Logger logger = Logger.getLogger(ThesisListController.class);
	@Autowired
	private ThesisService thesisService;
	/*获取列表*/
	@RequestMapping("/getThesisList")
	@ResponseBody
	public JsonResult getThesisList(HttpServletRequest request, HttpServletResponse responses) {
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
			    String publishedJournal = ToolUtil.str("publishedJournal", request);
			    String indexLevel = ToolUtil.str("indexLevel", request);
			    Integer status = ToolUtil.integer("status", request);
			    String awards = ToolUtil.str("awards", request);
			    String firstAuthor = ToolUtil.str("firstAuthor", request);
			    String otherAuthors = ToolUtil.str("otherAuthors", request);
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
			    data.put("date1", date1);
			    data.put("date2", date2);
			    data.put("publishedJournal", publishedJournal);
			    data.put("indexLevel", indexLevel);
			    data.put("status", 1);
			    data.put("awards", awards);
			    data.put("firstAuthor", firstAuthor);
			    data.put("otherAuthors", otherAuthors);
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
			    count.put("date1", date1);
			    count.put("date2", date2);
			    count.put("publishedJournal", publishedJournal);
			    count.put("indexLevel", indexLevel);
			    count.put("status", 1);
			    count.put("awards", awards);
			    count.put("firstAuthor", firstAuthor);
			    count.put("otherAuthors", otherAuthors);
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
					List<Thesis> thesisList = thesisService.getThesisList(data);
					System.out.println("11");
					//获取所有status == 1的数据条总数
					counts = thesisService.selectCounts(count);
					//返回接口的具体数据
					jsonResult = jsonResult.build(0, thesisList, msg, counts);
					System.out.println("获得的数据："+data);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("22");
					e.printStackTrace();
					jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
				}
				return jsonResult;
			}
	/*根据id进行软删除（修改status状态码）*/
	@RequestMapping("/del")
	@ResponseBody
	public JsonResult delThesisList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delThesisList方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			int status = ToolUtil.integer("status", request);
			status = 2;
			Long specialtyId = ToolUtil.lon("specialtyId", request);
			System.out.println("id"+specialtyId);
		    //判断是否有该专业
			Thesis thesis = thesisService.findThesisById(specialtyId);
//			if (thesis == null) {
//				jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
//				return jsonResult;
//			}
			thesis.setStatus(status);
		    int result = thesisService.modifThesisDel(thesis);
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

