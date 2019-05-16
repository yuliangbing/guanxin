package com.zptc.gx.controller.patent;

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
import com.zptc.gx.specialty.entity.Patent;
import com.zptc.gx.specialty.service.PatentService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 专利
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/patent")
public class PatentController extends BaseController {
	private Logger logger = Logger.getLogger(PatentController.class);
	
	@Autowired
	private PatentService patentService;
	
	/**
	 * 获取列表接口
	 */
	@RequestMapping("/getPatentList")
	@ResponseBody
	public JsonResult getPatent(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String date1 = ToolUtil.str("date1", request);
		String date2 = ToolUtil.str("date2", request);
		String firstAuthor = ToolUtil.str("first_author", request);
		Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
	    //用于分页的数据
	    pages = pageVO.getBeginNum();
	    //存入data,用于获取表格数据
	    data.put("date1", date1);
	    data.put("date2", date2);
	    data.put("first_author", firstAuthor);
  		data.put("limit", pageVO.getLimit());
  		data.put("pages", pages);
  		data.put("status", 1);
  		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("status", 1);
		count.put("date1", date1);
		count.put("date2", date2);
		count.put("first_author", firstAuthor);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<Patent> patents = patentService.getPatentList(data);
			counts = patentService.selectCounts(count);
			jsonResult = JsonResult.build(FLAG_SUCCESS, patents,msg,counts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/**
	 * 添加专利接口
	 */
	@RequestMapping("/addPatent")
	@ResponseBody
	public JsonResult addPatent(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addPatent方法");
		
		/*获取参数*/
		String code = ToolUtil.str("code", request);
		String name = ToolUtil.str("name", request);
		String type = ToolUtil.str("type", request);
		String firstAuthor = ToolUtil.str("first_author", request);
		String otherAuthors = ToolUtil.str("other_authors", request);
	    Long specialtyId = ToolUtil.lon("specialty_id", request);
	    String specialtyName = ToolUtil.str("specialty_name", request);
	    Date date = ToolUtil.date2("date", request);
	    
	    /*注入实体类*/
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    Patent patent = new Patent();
	    patent.setDate(date);
	    patent.setCode(code);
	    patent.setName(name);
	    patent.setType(type);
	    patent.setFirstAuthor(firstAuthor);
	    patent.setOtherAuthors(otherAuthors);
	    patent.setSpecialtyId(specialtyId);
	    patent.setSpecialtyName(specialtyName);
	    patent.setStatus(1);
	    patent.setCreateTime(new Date());
	    patent.setCreateUser(user.getTeaName());
	   
	    /*判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(code)&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(type)
	    		&&ToolUtil.equalBool(firstAuthor)&&ToolUtil.equalBool(otherAuthors)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+patent.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+patent.toString());
		try {
			
			int result = patentService.addPatent(patent);
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
	 * 修改专利接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updatePatent")
	@ResponseBody
	public JsonResult updateSpecialtyConstructionAchievementsIf(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateSpecialtyConstructionMeasuresIf方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long patentId = ToolUtil.lon("id", request);	    
			String code = ToolUtil.str("code", request);
			String name = ToolUtil.str("name", request);
			String type = ToolUtil.str("type", request);
			String firstAuthor = ToolUtil.str("first_author", request);
			String otherAuthors = ToolUtil.str("other_authors", request);
		    Long specialtyId = ToolUtil.lon("specialty_id", request);
		    String specialtyName = ToolUtil.str("specialty_name", request);
		    Date date = ToolUtil.date2("date", request);
		    
		    Patent patent = patentService.findPatentById(patentId);
		    if (patent == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专业！");
				return jsonResult;
			}
		    
		    patent.setDate(date);
		    patent.setCode(code);
		    patent.setName(name);
		    patent.setType(type);
		    patent.setFirstAuthor(firstAuthor);
		    patent.setOtherAuthors(otherAuthors);
		    patent.setSpecialtyId(specialtyId);
		    patent.setSpecialtyName(specialtyName);
		    patent.setStatus(1);
		    patent.setModifyTime(new Date());
		    patent.setModifyUser(user.getTeaName());
		    /*判断传入的值是否为空或""*/
		    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(code)&&ToolUtil.equalBool(date)&&ToolUtil.equalBool(type)
		    		&&ToolUtil.equalBool(firstAuthor)&&ToolUtil.equalBool(otherAuthors)&&ToolUtil.equalBool(specialtyId)&&ToolUtil.equalBool(specialtyName)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("方法拿到的数据："+patent.toString());
		    	return jsonResult;
			}
		    System.out.println("传入数据成功");
		    System.out.println("方法拿到的数据："+patent.toString());
		    int result = patentService.modifyPatent(patent);
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
	 * 根据id进行软删除（修改status状态码）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delPatent")
	@ResponseBody
	public JsonResult delSpecialtyFiles(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delPatent方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			int status = ToolUtil.integer("status", request);
			status = 2;
			Long patentId = ToolUtil.lon("id", request);
			System.out.println("id"+patentId);
		    //判断是否有该专业
			Patent patent = patentService.findPatentById(patentId);
			if (patent == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该专利！");
				return jsonResult;
			}
			patent.setStatus(status);
		    int result = patentService.modifyPatentDel(patent);
		    System.out.println("要删除的数据是："+patent.toString());
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
