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
import com.zptc.gx.controller.specialty.SpecialtyProfileController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.entity.Teachers;
import com.zptc.gx.specialty.service.TeachersService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("/teachers")
public class TeachersController extends BaseController{
	 private Logger logger = Logger.getLogger(SpecialtyProfileController.class);
     
	 @Autowired
	 private TeachersService teachersService;
	
	 @RequestMapping("/getTeachersList")
	 @ResponseBody
	 public JsonResult getTeachers(HttpServletRequest request, HttpServletResponse responses) {
		 	JsonResult jsonResult = new JsonResult();
		 	Map<String , Object> data = new HashMap<>();
		 	//获取请求参数
		 	Long  id = ToolUtil.lon("id", request);
		 	String name = ToolUtil.str("name",request);
		 	String code = ToolUtil.str("code",request);
		 	Date entry_time = ToolUtil.date2("entry_time", request);
		 	Date birthday = ToolUtil.date2("birthday", request);
		 	String graduate_school = ToolUtil.str("graduate_school", request);
		 	String final_degree = ToolUtil.str("final_degree", request);
			String political_status = ToolUtil.str("political_status", request);
			String specialty_code = ToolUtil.str("specialty_code", request);
		 	String specialty_name = ToolUtil.str("specialty_name", request);
		 	String research_direction = ToolUtil.str("research_direction", request);
		 	Integer is_part_time = ToolUtil.integer("is_part_time", request);
		 	Long specialty_id = ToolUtil.lon("specialty_id", request);
		      Integer status = ToolUtil.integer("status", request);
		      Integer limit = ToolUtil.integer("limit", request);
		      Integer page = ToolUtil.integer("page", request);
		      Integer pages = 0;
		    //分页数据
		    PageVO pageVO = new PageVO(page, limit);
		    pages = pageVO.getBeginNum();
		    
			//存入data,用于获取表格数据
		    data.put("id", id);
		    data.put("name", name);
		    data.put("code", code);
		    data.put("entry_time", entry_time);
		    data.put("birthday", birthday);
		    data.put("graduate_school", graduate_school);
		    data.put("final_degree", final_degree);
		    data.put("political_status", political_status);
		    data.put("specialty_code", specialty_code);
		    data.put("specialty_name", specialty_name);
		    data.put("research_direction", research_direction);
		    data.put("is_part_time", is_part_time);
		    data.put("specialty_id", specialty_id);
			data.put("limit", pageVO.getLimit());
			data.put("pages", pages);
			data.put("status", 1);
			
			System.out.println("pages:"+pages);
			Map<String, Object> count = new HashMap<>();
			//存入count,用于获取表格数据条总数
		    count.put("id", id);
		    count.put("name", name);
		    count.put("code", code);
		    count.put("entry_time", entry_time);
		    count.put("birthday", birthday);
		    count.put("graduate_school", graduate_school);
		    count.put("final_degree", final_degree);
		    count.put("political_status", political_status);
		    count.put("specialty_code", specialty_code);
		    count.put("specialty_name", specialty_name);
		    count.put("research_direction", research_direction);
		    count.put("is_part_time", is_part_time);
		    count.put("specialty_id", specialty_id);
		    count.put("status", 1);
			
			//定义返回的数据条总数，初值为0.
			int counts = 0;
			//定义返回的信息msg
			String msg = "success";
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				//获取所有status == 1 的所有数据
				List<Teachers> teachers = teachersService.getTeachersList(data);
				//获取所有status == 1的数据条总数
				counts = teachersService.selectCounts(count);
				//返回接口的具体数据
				jsonResult = jsonResult.build(FLAG_SUCCESS, teachers, msg, counts);
				System.out.println("获得的数据："+data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
			}
			return jsonResult;
	 }
	 
		/*//更新教师信息
	 	@RequestMapping("/updateTeacher")
		@ResponseBody
		public JsonResult updateTeachers(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用updateTeacherTeam...方法");
			
			Long  id = ToolUtil.lon("id", request);
		 	String name = ToolUtil.str("name",request);
		 	String code = ToolUtil.str("code",request);
		 	Date entry_time = ToolUtil.date2("entry_time", request);
		 	Date birthday = ToolUtil.date2("birthday", request);
		 	String graduate_school = ToolUtil.str("graduate_school", request);
		 	String final_degree = ToolUtil.str("final_degree", request);
			String political_status = ToolUtil.str("political_status", request);
			String specialty_code = ToolUtil.str("specialty_code", request);
		 	String specialty_name = ToolUtil.str("specialty_name", request);
		 	String research_direction = ToolUtil.str("research_direction", request);
		 	Integer is_part_time = ToolUtil.integer("is_part_time", request);
		 	Long specialty_id = ToolUtil.lon("specialty_id", request);
		 	String create_user = ToolUtil.str("create_user", request);
		     Integer status = ToolUtil.integer("status", request);
		    status = 1;
//			//根据TeacherId,查找教师
		    Teachers teachers = teachersService.findTeachersById(id);
		    if (teachers == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该教师！");
				return jsonResult;
			}
//		    teachers.setId(id);
//		    teachers.setSpecialtyId(specialty_id);
//		    teacherTeam.setSpecialtyCode(specialty_code);;
//		    teacherTeam.setSpecialtyName(specialty_name);
//		    teacherTeam.setDate(date);
//		    teacherTeam.setSpecialtyName(specialty_name);
//		    teacherTeam.setSpecialtyTeachers(specialty_teachers);
//		    teacherTeam.setPartTimeTeachers(part_time_teachers);
//		    teacherTeam.setDirector(director);
//		    teacherTeam.setLatest(latest);
		   
		    //判断传入的值是否为空或""
		    if ((ToolUtil.equalBool(id)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(code)&&ToolUtil.equalBool(entry_time)&&ToolUtil.equalBool(birthday)&&ToolUtil.equalBool(graduate_school)
		    		&&ToolUtil.equalBool(final_degree)&&ToolUtil.equalBool(political_status)&&ToolUtil.equalBool(specialty_code)&&ToolUtil.equalBool(specialty_name)&&ToolUtil.equalBool(research_direction)&&ToolUtil.equalBool(is_part_time)&&ToolUtil.equalBool(specialty_id)&&ToolUtil.equalBool(create_user)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("updateTeacherIf方法拿到的数据："+teachers.toString());
		    	return jsonResult;
			}
		    else {
		    	System.out.println("传入数据成功");
				try {
					
      				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
					//根据specialtyFilesId查询
				    teachers = teachersService.findTeacherTeamById(specialty_id);
				    if (teachers == null) {
				    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该教师！");
						return jsonResult;
					}
				    teachers.setId(id);
				    teachers.setName(name);
				    teachers.setCode(code);
				    teachers.setEntryTime(entry_time);
				    teachers.setBirthday(birthday);
				    teachers.setGraduateSchool(graduate_school);
				    teachers.setFinalDegree(final_degree);
				    teachers.setPoliticalStatus(political_status);
				    teachers.setSpecialtyCode(specialty_code);
				    teachers.setSpecialtyName(specialty_name);
				    teachers.setResearchDirection(research_direction);
				    teachers.setIsPartTime(is_part_time);
				    teachers.setSpecialtyId(specialty_id);
				    teachers.setStatus(status);
				    teachers.setCreateTime(entry_time);
				    teachers.setCreateUser(create_user);
				    teachers.setModifyTime(new Date());
				    teachers.setModifyUser(user.getTeaName());
				    //接口拿到的数据
				    System.out.println("updateSpecialtyIf方法拿到的数据："+teachersService.toString());
				    int result = teachersService.modifySpecialtyProfile(teachersService);
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
		}*/
	 	
	 	//根据id删除教师信息
		@RequestMapping("/deleteTeachersif")
		@ResponseBody
		public JsonResult deleteTeachersIf(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用deleteTeachersif方法");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				//int status = ToolUtil.integer("status", request);
				int status = 2;
				Long id = ToolUtil.lon("id", request);
				System.out.println("id"+id);
			    //判断是否有该专业
				Teachers teachers = teachersService.findTeachersById(id);
				if (teachers == null) {
					jsonResult = JsonResult.build(FLAG_FAILED, "没有该老师！");
					return jsonResult;
				}
				teachers.setStatus(status);
			    int result = teachersService.modifyTeachers(teachers);
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
	 		return    jsonResult;
	 	}
	 	
}
