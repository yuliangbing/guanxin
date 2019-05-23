package com.zptc.gx.controller.subject;

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
import com.zptc.gx.controller.specialty.SpecialtyProfileController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.entity.SubjectCompetition;
import com.zptc.gx.specialty.service.SubjectCompetitionService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;



@Controller
@RequestMapping("/subjectCompetition")
public class SubjectCompetitionController extends BaseController{
	private Logger logger = Logger.getLogger(SpecialtyProfileController.class);
    
	@Autowired
	private SubjectCompetitionService subjectCompetitionService;
	
//	增加学科竞赛信息
	@RequestMapping("/addSubjectCompetition")
	@ResponseBody
	public JsonResult addSpecialty(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult =new JsonResult();
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			//Long id = ToolUtil.lon("id", request);
			String name = ToolUtil.str("name", request);
		    String award_level = ToolUtil.str("award_level", request);
		    Date date = ToolUtil.date2("date", request);
		    String students = ToolUtil.str("students", request);
		    String teachers = ToolUtil.str("teachers", request);
		   Long specialty_id = ToolUtil.lon("specialty_id", request); 
		    String specialty_name = ToolUtil.str("specialty_name", request);
		    Integer status = ToolUtil.integer("status", request);
		    
		    SubjectCompetition subjectCompetition = new SubjectCompetition();
		    //subjectCompetition.setId(id);
		    subjectCompetition.setName(name);
		    subjectCompetition.setAwardLevel(award_level);
		    subjectCompetition.setStudents(students);
		    subjectCompetition.setDate(date);
		    subjectCompetition.setTeachers(teachers);
		    subjectCompetition.setSpecialtyId(specialty_id);
		    subjectCompetition.setSpecialtyName(specialty_name);
		    subjectCompetition.setStatus(1);
		    subjectCompetition.setCreateTime(new Date());
		    subjectCompetition.setCreateUser(user.getTeaName());
		    if ((ToolUtil.equalBool(name)&&ToolUtil.equalBool(award_level)&&ToolUtil.equalBool(date)
                    &&ToolUtil.equalBool(students)&&ToolUtil.equalBool(teachers)&&ToolUtil.equalBool(specialty_id)&&ToolUtil.equalBool(specialty_name)) == false) {
		    			jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
		    			System.out.println(subjectCompetition.toString());
		    			return jsonResult;
		       }
		   int result = subjectCompetitionService.addSubjectCompetition(subjectCompetition);
	        if (result>0) {
				jsonResult = JsonResult.build(FLAG_SUCCESS);
			}else {
				jsonResult = JsonResult.build(FLAG_FAILED);
			}
		}  catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_SUCCESS, e.getMessage());
		}   
		return jsonResult;
	}
//	删除（软删除）
	@RequestMapping("/delSubjectCompetition")
	@ResponseBody
	public JsonResult delSpecialtyProfile(HttpServletRequest request, HttpServletResponse response) {
	 JsonResult jsonResult = new JsonResult();
	 try {
		ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    
		Long id =ToolUtil.lonWithNull("id",request);
		int status = ToolUtil.integer("status", request);
		SubjectCompetition subjectCompetition = subjectCompetitionService.findSubjectCompetitionById(id);
		if (subjectCompetition ==null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该学科竞赛信息!");
			return jsonResult;
		}
		subjectCompetition.setStatus(2);
		int result = subjectCompetitionService.modifySubjectCompetition(subjectCompetition);
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
//	修改学科竞赛信息
	@RequestMapping("/updateSubjectCompetition")
	@ResponseBody
	public JsonResult updateSubjectCompetition(HttpServletRequest request, HttpServletResponse response) {
       JsonResult jsonResult = new JsonResult();
      
       Long id = ToolUtil.lon("id", request);
     String name = ToolUtil.str("name", request);
     
	 String award_level = ToolUtil.str("award_level", request);
	  String students = ToolUtil.str("students", request);
	  String teachers = ToolUtil.str("teachers", request);
	  Long specialty_id = ToolUtil.lon("specialty_id", request); 
	  String specialty_name = ToolUtil.str("specialty_name", request);   
	  
	  ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
//	  根据award_level
	  SubjectCompetition subjectCompetition = subjectCompetitionService.findSubjectCompetitionById(id);
	 if (subjectCompetition==null) {
		jsonResult =JsonResult.build(FLAG_FAILED,"没有该学科竞赛信息");
		return jsonResult;
	}
	 subjectCompetition.setId(id);
	 subjectCompetition.setName(name);
	 subjectCompetition.setAwardLevel(award_level);
	 subjectCompetition.setStudents(students);
	 subjectCompetition.setTeachers(teachers);
	 subjectCompetition.setSpecialtyId(specialty_id);
	 subjectCompetition.setSpecialtyName(specialty_name);
	 subjectCompetition.setModifyTime(new Date());
     subjectCompetition.setModifyUser(user.getTeaName());
//	判断传入的值是否为空或""
	 if ((ToolUtil.equalBool(id)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(award_level)&&ToolUtil.equalBool(students)&&ToolUtil.equalBool(teachers)&&ToolUtil.equalBool(specialty_id)&&ToolUtil.equalBool(specialty_name)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("updateSubjectCompetition方法拿到的数据："+subjectCompetition.toString());
	    	return jsonResult;
		}
	 try {
//	 接口拿到的数据	
     int result = subjectCompetitionService.modifySubjectCompetition(subjectCompetition);
	 if (result>0) {
		jsonResult=JsonResult.build(FLAG_SUCCESS);
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
//	获取学科竞赛列表
	@RequestMapping("/getSubjectCompetitionList")
	 @ResponseBody
	 public JsonResult getSubjectCompetition(HttpServletRequest request, HttpServletResponse responses) {
	 JsonResult jsonResult = new JsonResult();
	 Map< String, Object> data = new HashMap<>();
//	 获取请求参数
	 //Long id = ToolUtil.lon("id", request);
	 String  date1 = ToolUtil.str("date1", request);
	 String  date2 = ToolUtil.str("date2", request);
	 String award_level = ToolUtil.str("award_level", request);
	//  Integer status = ToolUtil.integer("status", request);
	  Integer limit = ToolUtil.integer("limit", request);
	  Integer page = ToolUtil.integer("page", request);
	  PageVO pageVO = new PageVO(page, limit);
	  Integer pages = 0;
		//用于分页的数据
	  pages = pageVO.getBeginNum();
		//存入data,用于获取表格数据
	    //data.put("id", id);
	    data.put("date1", date1);
	    data.put("date2", date2);
	    data.put("award_level", award_level);
		data.put("limit", pageVO.getLimit());
		data.put("pages", pages);
		data.put("status", 1);
		
		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
	//	count.put("id", id);
		count.put("date1", date1);
		count.put("date2", date2);
		count.put("award_level", award_level);
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "success";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<SubjectCompetition> SubjectCompetitionList = subjectCompetitionService.getSubjectCompetitionList(data);
			//获取所有status == 1的数据条总数
			counts = subjectCompetitionService.selectCounts(count);
			//返回接口的具体数据
			jsonResult = jsonResult.build(FLAG_SUCCESS, SubjectCompetitionList,msg,counts);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	 }
}
