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
import com.zptc.gx.specialty.entity.Specialty;
import com.zptc.gx.specialty.entity.SpecialtyProfile;
import com.zptc.gx.specialty.entity.TeacherTeam;
import com.zptc.gx.specialty.entity.Teachers;
import com.zptc.gx.specialty.service.SpecialtyService;
import com.zptc.gx.specialty.service.TeacherTeamService;
import com.zptc.gx.specialty.service.TeachersService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;
/**
 * 教师简介
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/teachers")
public class TeachersController extends BaseController{
	 private Logger logger = Logger.getLogger(TeachersController.class);
     
	 @Autowired
	 private TeachersService teachersService;
	 
	 @Autowired
	 private TeacherTeamService teacherTeamService;//专业教师团队
	 
	 @Autowired
	 private SpecialtyService specialtyService;
	 
	/**
	 * 获取教师列表
	 * @param request
	 * @param responses
	 * @return
	 */
	 @RequestMapping("/getTeachersList")
	 @ResponseBody
	 public JsonResult getTeachers(HttpServletRequest request, HttpServletResponse responses) {
		 	JsonResult jsonResult = new JsonResult();
		 	Map<String , Object> data = new HashMap<>();
		 	//获取请求参数
		 	String name = ToolUtil.str("name",request);
	        Integer limit = ToolUtil.integer("limit", request);
	        Integer page = ToolUtil.integer("page", request);
	        Integer pages = 0;
		    //分页数据
		    PageVO pageVO = new PageVO(page, limit);
		    pages = pageVO.getBeginNum();
		    
			//存入data,用于获取表格数据
			data.put("limit", pageVO.getLimit());
			data.put("pages", pages);
		    data.put("name", name);
			data.put("status", 1);
			
			Map<String, Object> count = new HashMap<>();
			//存入count,用于获取表格数据条总数
		    count.put("name", name);
		    count.put("status", 1);
			
			//定义返回的数据条总数，初值为0.
			int counts = 0;
			//定义返回的信息msg
			String msg = "获取成功";
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				//获取所有status == 1 的所有数据
				List<Teachers> teachers = teachersService.getTeachersList(data);
				//获取所有status == 1的数据条总数
				counts = teachersService.selectCounts(count);
				//返回接口的具体数据
				jsonResult = jsonResult.build(FLAG_SUCCESS, teachers, msg, counts);
				System.out.println("获得的数据："+data);
				System.out.println("返回的数据："+teachers.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
			}
			return jsonResult;
	 }
	 
	 /**
	  * 添加教师
	  * @param request
	  * @param response
	  * @return
	  */
	 @RequestMapping("/addTeacher")
		@ResponseBody
		public JsonResult addTeacher(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用addTeacher...方法");
			
		 	String name = ToolUtil.str("name",request);
		 	String code = ToolUtil.str("code",request);
		 	Date entryTime = ToolUtil.date2("entry_time", request);
		 	Date birthday = ToolUtil.date2("birthday", request);
		 	String graduateSchool = ToolUtil.str("graduate_school", request);
		 	String finalDegree = ToolUtil.str("final_degree", request);
			String politicalStatus = ToolUtil.str("political_status", request);
//			String specialtyCode = ToolUtil.str("specialty_code", request);
//		 	String specialtyName = ToolUtil.str("specialty_name", request);
			String specialtyCode = "";
		 	String specialtyName = "";
		 	String researchDirection = ToolUtil.str("research_direction", request);
		 	Integer isPartTime = ToolUtil.integer("is_part_time", request);
		 	Long specialtyId = ToolUtil.lon("specialty_id", request);
		 	String director = ToolUtil.str("director", request);
			try {
					ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				 	Teachers teachers = new Teachers();
				 	//根据specialty_id查出专业code和专业name
				 	Specialty specialty = specialtyService.findSpecialtyById(specialtyId);
				 	if (specialty == null) {
						System.out.println("没有该专业");
						jsonResult = jsonResult.build(FLAG_FAILED, "该专业不存在");
						return jsonResult;
					}
				 	specialtyCode = specialty.getCode();
				 	specialtyName = specialty.getName();
				    teachers.setName(name);
				    teachers.setCode(code);
				    teachers.setEntryTime(entryTime);
				    teachers.setBirthday(birthday);
				    teachers.setGraduateSchool(graduateSchool);
				    teachers.setFinalDegree(finalDegree);
				    teachers.setPoliticalStatus(politicalStatus);
//				    teachers.setSpecialtyCode(specialtyCode);
//				    teachers.setSpecialtyName(specialtyName);
				    teachers.setSpecialtyCode(specialtyCode);
				    teachers.setSpecialtyName(specialtyName);
				    teachers.setSpecialtyId(specialtyId);
				    teachers.setDirector(director);
				    teachers.setResearchDirection(researchDirection);
				    teachers.setIsPartTime(isPartTime);
				    teachers.setCreateTime(new Date());
				    teachers.setCreateUser(user.getTeaName());
				    teachers.setStatus(1);
				    //判断传入的值是否为空或""
				    if ((ToolUtil.equalBool(director)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(code)&&ToolUtil.equalBool(entryTime)&&ToolUtil.equalBool(birthday)&&ToolUtil.equalBool(graduateSchool)
				    		&&ToolUtil.equalBool(finalDegree)&&ToolUtil.equalBool(politicalStatus)&&ToolUtil.equalBool(specialtyName)&&ToolUtil.equalBool(researchDirection)&&ToolUtil.equalBool(isPartTime)&&ToolUtil.equalBool(specialtyId)) == false) {
				    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
				    	System.out.println("错误，传入数据缺少");
				    	 //接口拿到的数据
					    System.out.println("add方法拿到的数据："+teachers.toString());
				    	return jsonResult;
					}
				    System.out.println("成功，传入数据错误");
				    System.out.println("add方法拿到的数据："+teachers.toString());
				    //查询当前教师是否存在
				    Map<String, Object> map = new HashMap<>();
				    map.put("name", name);
				    map.put("status", 1);
				    Teachers teachers2 = teachersService.findTeachersByName(map);
				    if (teachers2 != null) {
						jsonResult = jsonResult.build(FLAG_FAILED, "该老师已存在！");
						return jsonResult;
					}
				    System.out.println("教师不存在，可以继续添加！");
				    
				    //存放查询参数
				    Map<String, Object> data =new HashMap<>();
				    data.put("specialty_id", specialtyId);
				    data.put("latest", "1");
				    TeacherTeam teacherTeam = teacherTeamService.findTeacherTeamByIdAndLatest(data);
				    TeacherTeam teacherTeam2 = new TeacherTeam();
				    if (teacherTeam == null) {//专业团队不存在
						System.out.println("专业团队不存在，将创建新团队");
						//System.out.println("教师团队拿到的数据："+teacherTeam.toString());
						  //判断是不是团队负责人
					    if (director.equals("1")) {
							//是团队负责人
				    		teacherTeam2.setDirector(name);
						}
						//新增团队
						teacherTeam2.setSpecialtyId(specialtyId);
						teacherTeam2.setLatest("1");
						teacherTeam2.setDate(new Date());
						teacherTeam2.setSpecialtyName(specialtyName);
						teacherTeam2.setSpecialtyCode(specialtyCode);
						if (isPartTime == 1) {
							teacherTeam2.setSpecialtyTeachers(name);
							teacherTeam2.setPartTimeTeachers(null);
						}else {
							teacherTeam2.setSpecialtyTeachers(null);
							teacherTeam2.setPartTimeTeachers(name);
						}
						int rs1 = teacherTeamService.addTeacherTeam(teacherTeam2);
						int rs2 = teachersService.addTeachers(teachers);
						if (rs1 > 0 && rs2 > 0 ) {
							 
							jsonResult = jsonResult.build(FLAG_SUCCESS,"教师团队新增成功");
						}else {
							jsonResult = jsonResult.build(FLAG_FAILED,"教师团队新增失败");
						}
						return jsonResult;
					}
				    
				    String Latest = teacherTeam.getLatest();//存放的是是否最新
				    
				    //存在专业团队
				    
				    int updT = 0;//当前教师团队是否为最新的返回值
				    int addT = 0;//当前教师团队新增团队的返回值
				    String getTeachers ="";//返回非最新团队的团队成员成员
				    //判断是不是团队负责人
				    if (director.equals("1")) {
				    	
				    	 teacherTeam.setLatest("2");
						 int updT1 = teacherTeamService.modifyTeacherTeam(teacherTeam);
						 
						//是团队负责人
				    	if (teacherTeam.getDirector() != null && !"".equals(teacherTeam.getDirector()) ) {//当有团队负责人时
				    		//找到负责人的教师信息
				    		
				    		Map<String, Object> mDrie =new HashMap<>();
				    		mDrie.put("name", teacherTeam.getDirector());
				    		mDrie.put("status", 1);
				    		Teachers tDire = teachersService.findTeachersByName(mDrie);
				    		if (tDire == null) {
								System.out.println("找不到该团队负责人");
								jsonResult = jsonResult.build(FLAG_FAILED, "找不到该团队负责人！");
								return jsonResult;
							}
							//将其改为不是团队负责人
				    		tDire.setDirector("2");
				    		int tD = teachersService.modifyTeachers(tDire);
				    		if (tD < 0) {
				    			System.out.println("修改负责人状态失败");
								jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
								return jsonResult;
							}
				    		teacherTeam.setDirector(name);
						}else {
							System.out.println("团队负责人不存在，可以直接存入");
							teacherTeam.setDirector(name);
						}
//					}
					    if (isPartTime == 1) {//非兼职
							if (Latest.equals("1")) {
								
								 //新增
								 teacherTeam.setLatest("1");
								 teacherTeam.setDate(new Date());
								 teacherTeam.setId(null);
								 getTeachers = teacherTeam.getSpecialtyTeachers();
								 if (getTeachers != null &&!"".equals(getTeachers)) {
									 teacherTeam.setSpecialtyTeachers(getTeachers+","+name);
								}else {
									 teacherTeam.setSpecialtyTeachers(name);
								}
								// teacherTeam.setPartTimeTeachers(null);
								 addT = teacherTeamService.addTeacherTeam(teacherTeam);
								 
							}
						}else {//兼职
							if (Latest.equals("1")) {
								teacherTeam.setLatest("1");
								teacherTeam.setDate(new Date());
								teacherTeam.setId(null);
								getTeachers = teacherTeam.getPartTimeTeachers();
								 if (getTeachers != null &&!"".equals(getTeachers)) {
									 teacherTeam.setPartTimeTeachers(getTeachers+","+name);
								}else {
									 teacherTeam.setPartTimeTeachers(name);
								}
								// teacherTeam.setSpecialtyTeachers(null);
								 addT = teacherTeamService.addTeacherTeam(teacherTeam);
							}
						}
				    }else {//不是团队负责人
				    	 teacherTeam.setLatest("2");
						 int updT1 = teacherTeamService.modifyTeacherTeam(teacherTeam);
						
					     if (isPartTime == 1) {//非兼职
							if (Latest.equals("1")) {
								
								 //新增
								 teacherTeam.setLatest("1");
								 teacherTeam.setDate(new Date());
								 teacherTeam.setId(null);
								 getTeachers = teacherTeam.getSpecialtyTeachers();
								 if (getTeachers != null &&!"".equals(getTeachers)) {
									 teacherTeam.setSpecialtyTeachers(getTeachers+","+name);
								}else {
									 teacherTeam.setSpecialtyTeachers(name);
								}
								// teacherTeam.setPartTimeTeachers(null);
								 addT = teacherTeamService.addTeacherTeam(teacherTeam);
								 
							}
						 }else {//兼职
							if (Latest.equals("1")) {
								teacherTeam.setLatest("1");
								teacherTeam.setDate(new Date());
								teacherTeam.setId(null);
								getTeachers = teacherTeam.getPartTimeTeachers();
								 if (getTeachers != null &&!"".equals(getTeachers)) {
									 teacherTeam.setPartTimeTeachers(getTeachers+","+name);
								}else {
									 teacherTeam.setPartTimeTeachers(name);
								}
								// teacherTeam.setSpecialtyTeachers(null);
								 addT = teacherTeamService.addTeacherTeam(teacherTeam);
							}
						}
					}
				    
				    int result = teachersService.addTeachers(teachers);
//					if (result > 0 && updT > 0 && addT > 0) {
				    if (result > 0 ) {
						jsonResult = jsonResult.build(FLAG_SUCCESS,"添加成功");
					}else {
						jsonResult = jsonResult.build(FLAG_FAILED,"添加失败");
					}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
			}
			return jsonResult;
	    }
	 	
	 
		//更新教师信息
	 	@RequestMapping("/updateTeacher")
		@ResponseBody
		public JsonResult updateTeachers(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用updateTeacherTeam...方法");
			
			Long  id = ToolUtil.lon("id", request);
			String name = ToolUtil.str("name",request);
		 	String code = ToolUtil.str("code",request);
		 	Date entryTime = ToolUtil.date2("entry_time", request);
		 	Date birthday = ToolUtil.date2("birthday", request);
		 	String graduateSchool = ToolUtil.str("graduate_school", request);
		 	String finalDegree = ToolUtil.str("final_degree", request);
			String politicalStatus = ToolUtil.str("political_status", request);
			String specialtyCode = ToolUtil.str("specialty_code", request);
		 	String specialtyName = ToolUtil.str("specialty_name", request);
		 	String researchDirection = ToolUtil.str("research_direction", request);
		 	Integer isPartTime = ToolUtil.integer("is_part_time", request);
		 	Long specialtyId = ToolUtil.lon("specialty_id", request);
		 	String director = ToolUtil.str("director", request);
			//根据id,查找教师数据
		    Teachers teachers = teachersService.findTeachersById(id);//未修改之前的数据
		    if (teachers == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该教师！");
				return jsonResult;
			}
		    
		    //拿到未修改前的教师团队最新数据（拿同等数据的）
		    Map<String, Object> data = new HashMap<>();
		    data.put("specialty_id", teachers.getSpecialtyId());
		    data.put("latest", "1");
		  
		    
		    TeacherTeam teacherTeam = teacherTeamService.findTeacherTeamByIdAndLatest(data);
		    
		    int updT = 0;//当前教师团队是否为最新的返回值
		    int addT = 0;//当前教师团队新增团队的返回值
		   String teacherNames = "";
		  
		    if (specialtyId != teachers.getSpecialtyId()) { //判断教师是否修改专业 
				//把之前的数据修改
		    	teacherTeam.setLatest("2");//设置不是最新
		    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
		    	
		    	/**
		    	 * 判断是不是团队负责人(原团队负责人是不是当前更改的该教师)
		    	 */
		    	if (teachers.getName().equals(teacherTeam.getDirector())) {//相等，是同人
					//删除该团队负责人
		    		teacherTeam.setDirector(null);
				}
		    	
		    	/**
		    	 * 变更专业id
		    	 */

	    		teacherTeam.setLatest("1");//设置最新
			 	teacherTeam.setDate(new Date());
				teacherTeam.setId(null);
				//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
				Map<String, Object> Tdata = new HashMap<>();
				Tdata.put("specialty_id", teachers.getSpecialtyId());
				Tdata.put("status", 1);
				Tdata.put("is_part_time", teachers.getIsPartTime());//1
				List<String> tList = teachersService.getTeachersByIdList(Tdata);
				System.out.println("所有未修改前相同专业id的教师姓名"+tList);
				//获取list所存取的name值,就是一个新的教师团队
				for(int i=0;i<tList.size();i++) {
					if (!teachers.getName().equals(tList.get(i))) {//比较tList中不等于查询出的教师姓名,才进行赋值
						if (teacherNames.equals("")) {
							teacherNames +=tList.get(i); 
						}else {
							teacherNames +=","+tList.get(i); 
						}
					}
				}
				
		    	if (teachers.getIsPartTime() ==1) {//判断原来的团队是否为兼职
		    		
					//专业教师
		    		
					//初始化团队成员
					teacherTeam.setSpecialtyTeachers(null);//设置专业教师团队为空
					teacherTeam.setSpecialtyTeachers(teacherNames);
				}else {
					
					//兼职教师
					
					//初始化团队成员
					teacherTeam.setPartTimeTeachers(null);//设置兼职教师团队为空
					teacherTeam.setPartTimeTeachers(teacherNames);//新的兼职教师团队
				}
		    	//新增一条变更后专业的教师团队
		    	addT = teacherTeamService.addTeacherTeam(teacherTeam);
		    	
		    	/**
		    	 * 变更到那条专业id的教师团队加数据
		    	 */
		    	//根据修改的专业id查询到专业团队（本质就是新增新增）
		    	Map<String, Object> map = new HashMap<>();
				map.put("specialty_id", specialtyId);
				map.put("latest", "1");
				TeacherTeam teacherT = teacherTeamService.findTeacherTeamByIdAndLatest(map);//查询到的最新的教师团队
				int updtT = 0;//当前教师团队是否为最新的返回值
			    int addtT = 0;//当前教师团队新增团队的返回值
			    String tTNames = "";
			    teacherT.setLatest("2");//设置不是最新
		    	updtT = teacherTeamService.modifyTeacherTeam(teacherT);//修改数据为旧数据
				teacherT.setLatest("1");//设置最新
				teacherT.setId(null);
				teacherTeam.setDate(new Date());
					
				if (director.equals("1")) {
					// 是团队负责人
					if (teacherT.getDirector() != null && !"".equals(teacherT.getDirector())) {// 当有团队负责人时
						// 找到负责人的教师信息
						Map<String, Object> mDrie = new HashMap<>();
						mDrie.put("name", teacherT.getDirector());
						mDrie.put("status", 1);
						Teachers tDire = teachersService.findTeachersByName(mDrie);
						if (tDire == null) {
							System.out.println("找不到该团队负责人");
							jsonResult = jsonResult.build(FLAG_FAILED, "找不到该团队负责人！");
							return jsonResult;
						}
						// 将其改为不是团队负责人
						tDire.setDirector("2");
						int tD = teachersService.modifyTeachers(tDire);
						if (tD < 0) {
							System.out.println("修改团队负责人状态失败");
							jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
							return jsonResult;
						}
						teacherT.setDirector(name);
					} else {// 没有团队负责人时
						System.out.println("没有团队负责人，可以直接存入。。。");
						teacherT.setDirector(name);
					}
				}

				if (isPartTime == 1) {//判断是否兼职
					
					//专业教师团队
					
					tTNames = teacherT.getSpecialtyTeachers();
					teacherT.setSpecialtyTeachers(tTNames+","+name);
				}else {
					
					//兼职教师团队
					
					tTNames = teacherT.getPartTimeTeachers();
					teacherT.setPartTimeTeachers(tTNames+","+name);
				}
				addtT = teacherTeamService.addTeacherTeam(teacherT);//新增团队新数据
				if (addT<0) {
					System.out.println("修改专业后，添加数据失败！");
					jsonResult = jsonResult.build(FLAG_FAILED, "修改专业后，添加数据失败！");
				}
				
			}else {//没有变更专业
				
				if (isPartTime != teachers.getIsPartTime()) {//变更教师团队
					
					//先存下团队负责人数据，避免修改失败
					String Dire = teacherTeam.getDirector();
					//更新教师团队为不是最新
			    	teacherTeam.setLatest("2");//设置不是最新
			    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
			    	
			    	/**
			    	 * 判断是不是团队负责人
			    	 */
			    	
				    if (director.equals("1")) {
				    	//是团队负责人
				    	if (teacherTeam.getDirector() != null && !"".equals(teacherTeam.getDirector()) ) {//当有团队负责人时
				    		//找到负责人的教师信息
				    		Map<String, Object> mDrie =new HashMap<>();
				    		mDrie.put("name", teacherTeam.getDirector());
				    		mDrie.put("status", 1);
				    		Teachers tDire = teachersService.findTeachersByName(mDrie);
				    		if (tDire == null) {
								System.out.println("找不到该团队负责人");
//								jsonResult = jsonResult.build(FLAG_FAILED, "找不到该团队负责人！");
//								return jsonResult;
								System.out.println("直接将该教师修改为团队负责人");
								teacherTeam.setDirector(name);
							}else {
								//将其改为不是团队负责人
					    		tDire.setDirector("2");
					    		int tD = teachersService.modifyTeachers(tDire);
					    		if (tD < 0) {
					    			System.out.println("修改团队负责人状态失败");
					    			System.out.println("还原团队原数据");
					    			//还原数据
					    			teacherTeam.setLatest("1");//设置最新
					    			teacherTeam.setDirector(Dire);//还原团队负责人
							    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
									jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
									return jsonResult;
								}
					    		teacherTeam.setDirector(name);
							}
							
						}else {//没有团队负责人时
							teacherTeam.setDirector(name);
						}
					}else {
						//不是团队负责人
						if (teachers.getName().equals(teacherTeam.getDirector())) {//相等，是同人
							//删除该团队负责人
				    		teacherTeam.setDirector(null);
						}
					}
			    	
			    	//新增最新团队
			    	teacherTeam.setLatest("1");//设置最新
				 	teacherTeam.setDate(new Date());
					teacherTeam.setId(null);
					//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
					Map<String, Object> Tdata = new HashMap<>();
					Tdata.put("specialty_id", teachers.getSpecialtyId());
					Tdata.put("status", 1);
					Tdata.put("is_part_time", teachers.getIsPartTime());//2
					List<String> tList = teachersService.getTeachersByIdList(Tdata);
					System.out.println("所有未修改前相同专业id的教师姓名"+tList);
					//同时还要去除之前的教师团队里的该教师
					//获取list所存取的name值,就是一个新的教师团队
					for(int i=0;i<tList.size();i++) {
						if (!teachers.getName().equals(tList.get(i))) {//比较tList中不等于查询出的教师姓名,才进行赋值
							if (teacherNames.equals("")) {
								teacherNames +=tList.get(i); 
							}else {
								teacherNames +=","+tList.get(i); 
							}
						}	
					}
					if (teachers.getIsPartTime() ==1) {//判断原来的团队是否为兼职
						
						//专业教师
						
						teacherTeam.setSpecialtyTeachers(null);//设置专业教师团队为空
						teacherTeam.setPartTimeTeachers(teacherTeam.getPartTimeTeachers()+","+name);
						teacherTeam.setSpecialtyTeachers(teacherNames);//新专业教师团队
					}else {
						
						//兼职教师
						teacherTeam.setSpecialtyTeachers(teacherTeam.getSpecialtyTeachers()+","+name);
						teacherTeam.setPartTimeTeachers(null);//设置兼职教师团队为空
						teacherTeam.setPartTimeTeachers(teacherNames);//新的兼职教师团队
					}
					addT = teacherTeamService.addTeacherTeam(teacherTeam);//新增团队新数据
					if (addT<0) {
						System.out.println("修改是否兼职后，添加数据失败！");
						jsonResult = jsonResult.build(FLAG_FAILED, "修改是否兼职后，添加数据失败！");
					}
				}else {//不变更教师团队
					
					if (!name.equals(teachers.getName())) {//教师姓名是否修改
						
						//教师姓名修改
						
						//更新教师团队为不是最新
				    	teacherTeam.setLatest("2");//设置不是最新
				    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
				    	
				    	/**
				    	 * 判断是不是团队负责人
				    	 */
					    if (director.equals("1")) {
					    	//是团队负责人
					    	if (teacherTeam.getDirector() != null && !"".equals(teacherTeam.getDirector()) ) {//当有团队负责人时
					    		//找到负责人的教师信息
					    		Map<String, Object> mDrie =new HashMap<>();
					    		mDrie.put("name", teacherTeam.getDirector());
					    		mDrie.put("status", 1);
					    		Teachers tDire = teachersService.findTeachersByName(mDrie);
					    		if (tDire == null) {
									System.out.println("找不到该团队负责人");
									System.out.println("将直接将该教师添加为团队负责人");
//									jsonResult = jsonResult.build(FLAG_FAILED, "找不到该团队负责人！");
//									return jsonResult;
									teacherTeam.setDirector(name);
								}else {
									//将其改为不是团队负责人
						    		tDire.setDirector("2");
						    		int tD = teachersService.modifyTeachers(tDire);
						    		if (tD < 0) {
						    			System.out.println("修改团队负责人状态失败");
										jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
										return jsonResult;
									}
						    		teacherTeam.setDirector(name);
								}
								
							}else {//没有团队负责人时
								teacherTeam.setDirector(name);
							}
						}else {
							//当前选择不是团队负责人
							
							//如果曾经是团队负责人
							if (teachers.getName().equals(teacherTeam.getDirector())) {//相等，是同人
								//删除该团队负责人
					    		teacherTeam.setDirector(null);
							}
						}
				    	
				    	//新增最新团队
				    	teacherTeam.setLatest("1");//设置最新
					 	teacherTeam.setDate(new Date());
						teacherTeam.setId(null);
						//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
						Map<String, Object> Tdata = new HashMap<>();
						Tdata.put("specialty_id", teachers.getSpecialtyId());
						Tdata.put("status", 1);
						Tdata.put("is_part_time", teachers.getIsPartTime());//3
						List<String> tList = teachersService.getTeachersByIdList(Tdata);
						System.out.println("所有未修改前相同专业id的教师姓名"+tList);
						//获取list所存取的name值,就是一个新的教师团队
						for(int i=0;i<tList.size();i++) {
							if (!teachers.getName().equals(tList.get(i))) {//比较tList中不等于查询出的教师姓名,才进行赋值
								if (teacherNames.equals("")) {
									teacherNames +=tList.get(i); 
								}else {
									teacherNames +=","+tList.get(i); 
								}
							}	
						}
						
						if (teachers.getIsPartTime() ==1) {//判断原来的团队是否为兼职
							
							//专业教师
							//teacherTeam.setPartTimeTeachers(teacherTeam.getPartTimeTeachers()+","+name);
							teacherTeam.setSpecialtyTeachers(null);//设置专业教师团队为空
							teacherTeam.setSpecialtyTeachers(teacherNames+","+name);
						}else {
							
							//兼职教师
							//teacherTeam.setSpecialtyTeachers(teacherTeam.getSpecialtyTeachers()+","+name);
							teacherTeam.setPartTimeTeachers(null);//设置兼职教师团队为空
							teacherTeam.setPartTimeTeachers(teacherNames+","+name);//新的兼职教师团队
						}
						int	addTName = teacherTeamService.addTeacherTeam(teacherTeam);//新增团队新数据
					}
					else {//不变更教师姓名（只变更是团队负责人）
						
						//更新教师团队为不是最新
				    	teacherTeam.setLatest("2");//设置不是最新
				    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
						if (director.equals("1")) {
					    	//是团队负责人
					    	if (teacherTeam.getDirector() != null && !"".equals(teacherTeam.getDirector()) ) {//当有团队负责人时
					    		//找到负责人的教师信息
					    		Map<String, Object> mDrie =new HashMap<>();
					    		mDrie.put("name", teacherTeam.getDirector());
					    		mDrie.put("status", 1);
					    		Teachers tDire = teachersService.findTeachersByName(mDrie);
					    		if (tDire == null) {
									System.out.println("找不到该团队负责人");
//									jsonResult = jsonResult.build(FLAG_FAILED, "找不到该团队负责人！");
//									return jsonResult;
									System.out.println("将直接将该教师添加为团队负责人");
									teacherTeam.setDirector(name);
								}else {
									//将其改为不是团队负责人
						    		tDire.setDirector("2");
						    		int tD = teachersService.modifyTeachers(tDire);
						    		if (tD < 0) {
						    			System.out.println("修改团队负责人状态失败");
										jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
										return jsonResult;
									}
						    		teacherTeam.setDirector(name);
								}
								
							}else {//没有团队负责人时
								teacherTeam.setDirector(name);
							}
						}
						//新增最新团队
				    	teacherTeam.setLatest("1");//设置最新
					 	teacherTeam.setDate(new Date());
						teacherTeam.setId(null);
						//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
						Map<String, Object> Tdata = new HashMap<>();
						Tdata.put("specialty_id", teachers.getSpecialtyId());
						Tdata.put("status", 1);
						Tdata.put("is_part_time", teachers.getIsPartTime());//5
						List<String> tList = teachersService.getTeachersByIdList(Tdata);
						System.out.println("所有未修改前相同专业id的教师姓名"+tList);
						//获取list所存取的name值,就是一个新的教师团队
						for(int i=0;i<tList.size();i++) {
							if (!teachers.getName().equals(tList.get(i))) {//比较tList中不等于查询出的教师姓名,才进行赋值
								if (teacherNames.equals("")) {
									teacherNames +=tList.get(i); 
								}else {
									teacherNames +=","+tList.get(i); 
								}
							}	
						}
						
						if (teachers.getIsPartTime() ==1) {//判断原来的团队是否为兼职
							
							//专业教师//teacherTeam.setPartTimeTeachers(teacherTeam.getPartTimeTeachers()+","+name);
							teacherTeam.setSpecialtyTeachers(null);//设置专业教师团队为空
							teacherTeam.setSpecialtyTeachers(teacherNames+","+name);
						}else {
							
							//兼职教师//teacherTeam.setSpecialtyTeachers(teacherTeam.getSpecialtyTeachers()+","+name);
							teacherTeam.setPartTimeTeachers(null);//设置兼职教师团队为空
							teacherTeam.setPartTimeTeachers(teacherNames+","+name);//新的兼职教师团队
						}
						int	addTName = teacherTeamService.addTeacherTeam(teacherTeam);//新增团队新数据
				}				
				}
			}
		   
		    //判断传入的值是否为空或""
		    if ((ToolUtil.equalBool(director)&&ToolUtil.equalBool(id)&&ToolUtil.equalBool(name)&&ToolUtil.equalBool(code)&&ToolUtil.equalBool(entryTime)&&ToolUtil.equalBool(birthday)&&ToolUtil.equalBool(graduateSchool)
		    		&&ToolUtil.equalBool(finalDegree)&&ToolUtil.equalBool(politicalStatus)&&ToolUtil.equalBool(researchDirection)&&ToolUtil.equalBool(isPartTime)&&ToolUtil.equalBool(specialtyId)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据缺少");
		    	 //接口拿到的数据
			    System.out.println("update方法拿到的数据："+teachers.toString());
		    	return jsonResult;
			}
		    
		    	System.out.println("传入数据成功");
				try {
					
      				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				   
				    teachers.setName(name);
				    teachers.setCode(code);
				    teachers.setEntryTime(entryTime);
				    teachers.setBirthday(birthday);
				    teachers.setGraduateSchool(graduateSchool);
				    teachers.setFinalDegree(finalDegree);
				    teachers.setPoliticalStatus(politicalStatus);
				    teachers.setSpecialtyCode(specialtyCode);
				    teachers.setSpecialtyName(specialtyName);
				    teachers.setSpecialtyId(specialtyId);
				    teachers.setResearchDirection(researchDirection);
				    teachers.setIsPartTime(isPartTime);
				    teachers.setDirector(director);
				    teachers.setModifyTime(new Date());
				    teachers.setModifyUser(user.getTeaName());
				    System.out.println("update方法拿到的数据："+teachers.toString());
				    
				    int result = teachersService.modifyTeachers(teachers);
				    if (result > 0) {
				    	jsonResult = JsonResult.build(FLAG_SUCCESS,"修改成功");
					} else {
						jsonResult = JsonResult.build(FLAG_FAILED,"修改失败");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
				}
				return jsonResult;
		    }
	 	
	 	//根据id删除教师信息(软删除)
		@RequestMapping("/deleteTeachers")
		@ResponseBody
		public JsonResult deleteTeachersIf(HttpServletRequest request, HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			System.out.println("启用deleteTeachers方法");
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				Long id = ToolUtil.lon("id", request);
				System.out.println("要删除的数据id是"+id);
			    //判断是否有该专业
				Teachers teachers = teachersService.findTeachersById(id);
				if (teachers == null) {
					jsonResult = JsonResult.build(FLAG_FAILED, "没有该教师！");
					return jsonResult;
				}
				/*
				 * 删除教师团队里的该教师
				 */
				//拿到未修改前的教师团队最新数据（拿同等数据的）
			    Map<String, Object> data = new HashMap<>();
			    data.put("specialty_id", teachers.getSpecialtyId());
			    data.put("latest", "1");
			    TeacherTeam teacherTeam = teacherTeamService.findTeacherTeamByIdAndLatest(data);
			    
			    int updT = 0;//当前教师团队是否为最新的返回值
			    int addT = 0;//当前教师团队新增团队的返回值
			   String teacherNames = "";
				//更新教师团队为不是最新
		    	teacherTeam.setLatest("2");//设置不是最新
		    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
		    	//新增最新团队
		    	teacherTeam.setLatest("1");//设置最新
			 	teacherTeam.setDate(new Date());
				teacherTeam.setId(null);
				//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
				Map<String, Object> Tdata = new HashMap<>();
				Tdata.put("specialty_id", teachers.getSpecialtyId());
				Tdata.put("status", 1);
				Tdata.put("is_part_time", teachers.getIsPartTime());//4
				List<String> tList = teachersService.getTeachersByIdList(Tdata);
				System.out.println("所有未修改前相同专业id的教师姓名"+tList);
				//获取list所存取的name值,就是一个新的教师团队
				for(int i=0;i<tList.size();i++) {
					if (!teachers.getName().equals(tList.get(i))) {//比较tList中不等于查询出的教师姓名,才进行赋值
						if (teacherNames.equals("")) {
							teacherNames +=tList.get(i); 
						}else {
							teacherNames +=","+tList.get(i); 
						}
					}	
				}
				if (teachers.getName().equals(teacherTeam.getDirector())) {//判断是不是团队负责人
					//是团队负责人
					teacherTeam.setDirector(null);//删除团队负责人
				}
				
				if (teachers.getIsPartTime() ==1) {//判断原来的团队是否为兼职
					
					//专业教师
					teacherTeam.setSpecialtyTeachers(null);//设置专业教师团队为空
					teacherTeam.setSpecialtyTeachers(teacherNames);
				}else {
					
					//兼职教师
					teacherTeam.setPartTimeTeachers(null);//设置兼职教师团队为空
					teacherTeam.setPartTimeTeachers(teacherNames);//新的兼职教师团队
				}
				int	addTName = teacherTeamService.addTeacherTeam(teacherTeam);//新增团队新数据
				if (addTName < 0) {
					jsonResult.build(FLAG_FAILED, "教师团队数据删除失败");
					System.out.println("教师团队数据删除失败");
					return jsonResult;
				}
				//这里才开始删除教师数据
				teachers.setStatus(2);
			    int result = teachersService.delTeachers(teachers);
			    if (result > 0) {
			    	jsonResult = JsonResult.build(FLAG_SUCCESS,"删除成功");
				} else {
					jsonResult = JsonResult.build(FLAG_FAILED,"删除失败");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
			}
	 		return    jsonResult;
	 	}
	 	
}
