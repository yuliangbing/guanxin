package com.zptc.gx.controller.thesis;

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
import com.zptc.gx.controller.specialty.SpecialtyFilesController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.SpecialtyFiles;
import com.zptc.gx.specialty.entity.Thesis;
import com.zptc.gx.specialty.entity.Thesis;
import com.zptc.gx.specialty.service.ThesisService;
import com.zptc.gx.specialty.service.ThesisService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("/thesisList")
public class ThesisListController extends BaseController{
	private Logger logger = Logger.getLogger(ThesisListController.class);
	@Autowired
	private ThesisService thesisService;
	/*论文获取列表*/
	@RequestMapping("/getThesisList")
	@ResponseBody
	public JsonResult getThesisList(HttpServletRequest request, HttpServletResponse responses) {
		System.out.println("获取论文列表接口");
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
	    String date = ToolUtil.str("date", request);
	    String name = ToolUtil.str("name", request);
	    //System.out.println("获取到的时间："+date);
	    String date1 = null;
	    String date2 = null;
	    if (date != null && date != "") {
	    	String[] dates = date.split("~");
		    
	    	date1 = dates[0].trim();
		    date2 = dates[1].trim();
		}
	    
	    Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
		//用于分页的数据
		//pages = (page - 1) * limit;
	    pages = pageVO.getBeginNum();
		//存入data,用于获取表格数据
	    data.put("date1", date1);
	    data.put("date2", date2);
	    data.put("name", name);
	    data.put("status", 1);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
	    count.put("date1", date1);
	    count.put("date2", date2);
	    count.put("name", name);
	    count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "成功";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<Thesis> thesisList = thesisService.getThesisList(data);
			//获取所有status == 1的数据条总数
			counts = thesisService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(0, thesisList, msg, counts);
			System.out.println("获得的数据："+data);
			System.out.println("返回数据条数"+counts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
/*新增论文*/
	
	@RequestMapping("/addThesisList")
	@ResponseBody
	public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addThesisList方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Date date = ToolUtil.date2("date", request);
			String name = ToolUtil.str("name", request);
			String publishedJournal = ToolUtil.str("published_journal", request);
			String indexLevel = ToolUtil.str("index_level", request);
			String awards = ToolUtil.str("awards", request);
			String firstAuthor = ToolUtil.str("first_author", request);
			String otherAuthors = ToolUtil.str("other_authors", request);
			Long specialtyId = ToolUtil.lon("specialty_id", request);
			String specialtyName = ToolUtil.str("specialty_name", request);
		    
		    Thesis thesis = new Thesis();
		    thesis.setDate(date);
		    thesis.setName(name);
		    thesis.setPublishedJournal(publishedJournal);
		    thesis.setIndexLevel(indexLevel);
		    thesis.setAwards(awards);
		    thesis.setFirstAuthor(firstAuthor);
		    thesis.setOtherAuthors(otherAuthors);
		    thesis.setSpecialtyId(specialtyId);
		    thesis.setSpecialtyName(specialtyName);
		    thesis.setStatus(1);
		    thesis.setCreateTime(new Date());
		    thesis.setCreateUser(user.getTeaName());
		    //判断传入的值是否为空或""
		    if ((ToolUtil.equalBool(publishedJournal)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(indexLevel)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(awards)&&ToolUtil.equalBool(firstAuthor)&&ToolUtil.equalBool(otherAuthors)&&ToolUtil.equalBool(date)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("addThesisList方法拿到的数据："+thesis.toString());
		    	return jsonResult;
			}
		    System.out.println("传入数据成功");
		    System.out.println("addThesisList方法拿到的数据："+thesis.toString());
		    int result = thesisService.addThesis(thesis);
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
	/*论文修改*/
	@RequestMapping("/updateThesis")
	@ResponseBody
	public JsonResult updateThesis(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateThesis方法");
		Long ThesisId = ToolUtil.lon("id", request);
		Date date = ToolUtil.date2("date", request);
		String name = ToolUtil.str("name", request);
		String publishedJournal = ToolUtil.str("published_journal", request);
		String indexLevel = ToolUtil.str("index_level", request);
		String awards = ToolUtil.str("awards", request);
		String firstAuthor = ToolUtil.str("first_author", request);
		String otherAuthors = ToolUtil.str("other_authors", request);
		Long specialtyId = ToolUtil.lon("specialty_id", request);
		String specialtyName = ToolUtil.str("specialty_name", request);
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//		//根据ThesisId查询
	    Thesis thesis = thesisService.findThesisById(ThesisId);
	    if (thesis == null) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
			return jsonResult;
		}
	    thesis.setDate(date);
	    thesis.setName(name);
	    thesis.setPublishedJournal(publishedJournal);
	    thesis.setIndexLevel(indexLevel);
	    thesis.setAwards(awards);
	    thesis.setFirstAuthor(firstAuthor);
	    thesis.setOtherAuthors(otherAuthors);
	    thesis.setSpecialtyId(specialtyId);
	    thesis.setSpecialtyName(specialtyName);
	    thesis.setStatus(1);
	    thesis.setModifyTime(new Date());
	    thesis.setModifyUser(user.getTeaName());
	   
	    //判断传入的值是否为空或""
	    if ((ToolUtil.equalBool(publishedJournal)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(indexLevel)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(awards)&&ToolUtil.equalBool(firstAuthor)&&ToolUtil.equalBool(otherAuthors)&&ToolUtil.equalBool(date)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("拿到的数据："+thesis.toString());
	    	return jsonResult;
		}
	    	System.out.println("传入数据成功");
			try {
			    //接口拿到的数据
			    System.out.println("拿到的数据："+thesis.toString());
			    int result = thesisService.modifyThesis(thesis);
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
	@RequestMapping("/delThesisList")
	@ResponseBody
	public JsonResult delThesisList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delThesisList方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long ThesisId = ToolUtil.lon("id", request);
			System.out.println("id"+ThesisId);
		    //判断是否有该专业
			Thesis thesis = thesisService.findThesisById(ThesisId);
			if (thesis == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
			thesis.setStatus(2);
		    int result = thesisService.modifThesisDel(thesis);
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

