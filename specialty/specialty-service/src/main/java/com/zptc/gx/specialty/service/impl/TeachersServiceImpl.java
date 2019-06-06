package com.zptc.gx.specialty.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.specialty.entity.TeacherTeam;
import com.zptc.gx.specialty.entity.Teachers;
import com.zptc.gx.specialty.mapper.TeachersMapper;
import com.zptc.gx.specialty.service.TeacherTeamService;
import com.zptc.gx.specialty.service.TeachersService;

@Component
public class TeachersServiceImpl implements TeachersService {

	@Autowired
	private TeachersMapper teachersMapper;
	@Autowired
	private TeacherTeamService teacherTeamService;
	
	/**
	 * 添加
	 */
	@Override
	@Transactional
	public int addTeachers(Teachers teachers){
		System.out.println("教师添加的...impl...启动");
		//存放查询参数
	    Map<String, Object> data =new HashMap<>();
	    data.put("specialty_id", teachers.getSpecialtyId());
	    data.put("latest", "1");
	    TeacherTeam teacherTeam = teacherTeamService.findTeacherTeamByIdAndLatest(data);
	    TeacherTeam teacherTeam2 = new TeacherTeam();
		if (teacherTeam == null) {//专业团队不存在
			System.out.println("专业团队不存在，将创建新团队");
			//System.out.println("教师团队拿到的数据："+teacherTeam.toString());
			  //判断是不是团队负责人
		    if (teachers.getDirector().equals("1")) {
				//是团队负责人
	    		teacherTeam2.setDirector(teachers.getName());
			}
			//新增团队
			teacherTeam2.setSpecialtyId(teachers.getSpecialtyId());
			teacherTeam2.setLatest("1");
			teacherTeam2.setDate(teachers.getCreateTime());
			teacherTeam2.setSpecialtyName(teachers.getSpecialtyName());
			teacherTeam2.setSpecialtyCode(teachers.getSpecialtyCode());
			teacherTeam2.setCreateTime(new Date());
			teacherTeam2.setCreateUser(teachers.getCreateUser());
			if (teachers.getIsPartTime() == 1) {
				teacherTeam2.setSpecialtyTeachers(teachers.getName());
				teacherTeam2.setPartTimeTeachers(null);
			}else {
				teacherTeam2.setSpecialtyTeachers(null);
				teacherTeam2.setPartTimeTeachers(teachers.getName());
			}
			int rs1 = teacherTeamService.addTeacherTeam(teacherTeam2);
			if (rs1 > 0) {
				 System.out.println("教师团队新增成功！教师团队为空时...impl...");
			}
		}else {//存在专业团队
				String Latest = teacherTeam.getLatest();//存放的是是否最新
				int updT = 0;//当前教师团队是否为最新的返回值
			    int addT = 0;//当前教师团队新增团队的返回值
			    String getTeachers ="";//返回非最新团队的团队成员成员
			    //判断是不是团队负责人
			    if (teachers.getDirector().equals("1")) {
			    	
			    	 teacherTeam.setLatest("2");
					 int updT1 = teacherTeamService.modifyTeacherTeam(teacherTeam);
					 
					//是团队负责人
			    	if (teacherTeam.getDirector() != null && !"".equals(teacherTeam.getDirector()) ) {//当有团队负责人时
			    		//找到负责人的教师信息
			    		
			    		Map<String, Object> mDrie =new HashMap<>();
			    		mDrie.put("name", teacherTeam.getDirector());
			    		mDrie.put("status", 1);
			    		//Teachers tDire = teachersService.findTeachersByName(mDrie);
			    		Teachers tDire = findTeachersByName(mDrie);
			    		if (tDire == null) {
							System.out.println("找不到该团队负责人");
							return 404;
						}
						//将其改为不是团队负责人
			    		tDire.setDirector("2");
			    		//int tD = teachersService.modifyTeachers(tDire);
			    		int tD = teachersMapper.updateByPrimaryKeySelective(tDire);
			    		if (tD < 0) {
			    			System.out.println("修改负责人状态失败");
							return 201;
						}
			    		teacherTeam.setDirector(teachers.getName());
					}else {
						System.out.println("团队负责人不存在，可以直接存入");
						teacherTeam.setDirector(teachers.getName());
					}
//				}
				    if (teachers.getIsPartTime() == 1) {//非兼职
						if (Latest.equals("1")) {
							
							 //新增
							 teacherTeam.setLatest("1");
							 teacherTeam.setDate(teachers.getCreateTime());
							 teacherTeam.setId(null);
							 teacherTeam.setCreateTime(new Date());
							 teacherTeam.setCreateUser(teachers.getCreateUser());
							 getTeachers = teacherTeam.getSpecialtyTeachers();
							 if (getTeachers != null &&!"".equals(getTeachers)) {
								 teacherTeam.setSpecialtyTeachers(getTeachers+","+teachers.getName());
							}else {
								 teacherTeam.setSpecialtyTeachers(teachers.getName());
							}
							// teacherTeam.setPartTimeTeachers(null);
							 addT = teacherTeamService.addTeacherTeam(teacherTeam);
							 
						}
					}else {//兼职
						if (Latest.equals("1")) {
							teacherTeam.setLatest("1");
							teacherTeam.setDate(teachers.getCreateTime());
							teacherTeam.setId(null);
							teacherTeam.setCreateTime(new Date());
							teacherTeam.setCreateUser(teachers.getCreateUser());
							getTeachers = teacherTeam.getPartTimeTeachers();
							 if (getTeachers != null &&!"".equals(getTeachers)) {
								 teacherTeam.setPartTimeTeachers(getTeachers+","+teachers.getName());
							}else {
								 teacherTeam.setPartTimeTeachers(teachers.getName());
							}
							// teacherTeam.setSpecialtyTeachers(null);
							 addT = teacherTeamService.addTeacherTeam(teacherTeam);
						}
					}
			    }else {//不是团队负责人
			    	 teacherTeam.setLatest("2");
					 int updT1 = teacherTeamService.modifyTeacherTeam(teacherTeam);
					
				     if (teachers.getIsPartTime() == 1) {//非兼职
						if (Latest.equals("1")) {
							
							 //新增
							 teacherTeam.setLatest("1");
							 teacherTeam.setDate(teachers.getCreateTime());
							 teacherTeam.setId(null);
							 teacherTeam.setCreateTime(new Date());
							 teacherTeam.setCreateUser(teachers.getCreateUser());
							 getTeachers = teacherTeam.getSpecialtyTeachers();
							 if (getTeachers != null &&!"".equals(getTeachers)) {
								 teacherTeam.setSpecialtyTeachers(getTeachers+","+teachers.getName());
							}else {
								 teacherTeam.setSpecialtyTeachers(teachers.getName());
							}
							// teacherTeam.setPartTimeTeachers(null);
							 addT = teacherTeamService.addTeacherTeam(teacherTeam);
							 
						}
					 }else {//兼职
						if (Latest.equals("1")) {
							teacherTeam.setLatest("1");
							teacherTeam.setDate(teachers.getCreateTime());
							teacherTeam.setId(null);
							teacherTeam.setCreateTime(new Date());
							teacherTeam.setCreateUser(teachers.getCreateUser());
							getTeachers = teacherTeam.getPartTimeTeachers();
							 if (getTeachers != null &&!"".equals(getTeachers)) {
								 teacherTeam.setPartTimeTeachers(getTeachers+","+teachers.getName());
							}else {
								 teacherTeam.setPartTimeTeachers(teachers.getName());
							}
							// teacherTeam.setSpecialtyTeachers(null);
							 addT = teacherTeamService.addTeacherTeam(teacherTeam);
						}
					}
				}
		}
		System.out.println("教师的添加。。。impl。。。的结束");
		return teachersMapper.insertSelective(teachers);
	}
	
	/**
	 * 修改教师
	 */
	@Override
	@Transactional
	public int modifyTeachers(Teachers teas){
		System.out.println("教师修改...impl...开启");
		//根据id,查找教师数据
	    //Teachers teachers = teachersService.findTeachersById(id);
		
		Teachers teachers = findTeachersById(teas.getId());//未修改之前的数据
	    if (teachers == null) {
	    	System.out.println("没有该教师！");
			return 404;
		}
	    
	    //拿到未修改前的教师团队最新数据（拿同等数据的）
	    Map<String, Object> data = new HashMap<>();
	    data.put("specialty_id", teachers.getSpecialtyId());
	    data.put("latest", "1");
	  
	    
	    TeacherTeam teacherTeam = teacherTeamService.findTeacherTeamByIdAndLatest(data);
	    
	    int updT = 0;//当前教师团队是否为最新的返回值
	    int addT = 0;//当前教师团队新增团队的返回值
	   String teacherNames = "";
	  
	   // if (specialtyId != teachers.getSpecialtyId()) { 
	   if (teas.getSpecialtyId() != teachers.getSpecialtyId()) { //判断教师是否修改专业 
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
		 	teacherTeam.setDate(teachers.getModifyTime());
			teacherTeam.setId(null);
			teacherTeam.setModifyTime(new Date());
			teacherTeam.setModifyUser(teachers.getModifyUser());
			//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
			Map<String, Object> Tdata = new HashMap<>();
			Tdata.put("specialty_id", teachers.getSpecialtyId());
			Tdata.put("status", 1);
			Tdata.put("is_part_time", teachers.getIsPartTime());//1
			//List<String> tList = teachersService.getTeachersByIdList(Tdata);
			List<String> tList = getTeachersByIdList(Tdata);
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
//			map.put("specialty_id", specialtyId);
	    	map.put("specialty_id", teas.getSpecialtyId());
			map.put("latest", "1");
			TeacherTeam teacherT = teacherTeamService.findTeacherTeamByIdAndLatest(map);//查询到的最新的教师团队
			//判断是否有这个教师团队
			if (null == teacherT) {//教师团队不存在，新增教师团队
				TeacherTeam team = new TeacherTeam();
				System.out.println("专业团队不存在，将创建新团队");
				
			    //判断是不是团队负责人
			    if ("1".equals(teas.getDirector())) {
					//是团队负责人
			    	team.setDirector(teas.getName());
				}
				//新增团队
			    team.setSpecialtyId(teas.getSpecialtyId());
			    team.setLatest("1");
			    team.setDate(new Date());
			    team.setSpecialtyName(teas.getSpecialtyName());
			    team.setSpecialtyCode(teas.getSpecialtyCode());
			    team.setCreateTime(new Date());
			    team.setCreateUser(teas.getCreateUser());
				if (teachers.getIsPartTime() == 1) {//不兼职
					team.setSpecialtyTeachers(teas.getName());
					team.setPartTimeTeachers(null);
				}else {//兼职
					team.setSpecialtyTeachers(null);
					team.setPartTimeTeachers(teas.getName());
				}
				int rs1 = teacherTeamService.addTeacherTeam(team);
				if (rs1 > 0) {
					 System.out.println("教师团队新增成功！");
				}
				
			}else {//教师团队
				
				int updtT = 0;//当前教师团队是否为最新的返回值
			    int addtT = 0;//当前教师团队新增团队的返回值
			    String tTNames = "";
			    teacherT.setLatest("2");//设置不是最新
		    	updtT = teacherTeamService.modifyTeacherTeam(teacherT);//修改数据为旧数据
				teacherT.setLatest("1");//设置最新
				teacherT.setDate(teachers.getModifyTime());
				teacherT.setId(null);
				teacherT.setModifyTime(new Date());
				teacherT.setModifyUser(teachers.getModifyUser());	
				if ("1".equals(teas.getDirector())) {
					// 是团队负责人
					if (teacherT.getDirector() != null && !"".equals(teacherT.getDirector())) {// 当有团队负责人时
						// 找到负责人的教师信息
						Map<String, Object> mDrie = new HashMap<>();
						mDrie.put("name", teacherT.getDirector());
						mDrie.put("status", 1);
						//Teachers tDire = teachersService.findTeachersByName(mDrie);
						Teachers tDire = findTeachersByName(mDrie);
						if (tDire == null) {
							System.out.println("找不到该团队负责人");
							return 405;
						}
						// 将其改为不是团队负责人
						tDire.setDirector("2");
						//int tD = teachersService.modifyTeachers(tDire);
						//int tD = modifyTeachers(tDire);
						int tD = teachersMapper.updateByPrimaryKeySelective(tDire);
						if (tD < 0) {
							System.out.println("修改团队负责人状态失败");
							//jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
							return 781;
						}
						//teacherT.setDirector(name);
						teacherT.setDirector(teas.getName());
					} else {// 没有团队负责人时
						System.out.println("没有团队负责人，可以直接存入。。。");
						//teacherT.setDirector(name);
						teacherT.setDirector(teas.getName());
					}
				}
	
				if (teas.getIsPartTime() == 1) {//判断是否兼职
					//专业教师团队
					
					tTNames = teacherT.getSpecialtyTeachers();
					//teacherT.setSpecialtyTeachers(tTNames+","+name);
					teacherT.setSpecialtyTeachers(tTNames+","+teas.getName());
				}else {
					
					//兼职教师团队
					
					tTNames = teacherT.getPartTimeTeachers();
					//teacherT.setPartTimeTeachers(tTNames+","+name);
					teacherT.setPartTimeTeachers(tTNames+","+teas.getName());
				}
				addtT = teacherTeamService.addTeacherTeam(teacherT);//新增团队新数据
				if (addT < 0) {
					System.out.println("修改专业后，添加数据失败！");
					//jsonResult = jsonResult.build(FLAG_FAILED, "修改专业后，添加数据失败！");
					return 780;
				}
			
			}//存在教师团队,且加入新教师数据结束  (**专业变更修改结束)
			
		}else {//没有变更专业
			
			if (teas.getIsPartTime() != teachers.getIsPartTime()) {//变更教师团队
				//先存下团队负责人数据，避免修改失败
				String Dire = teacherTeam.getDirector();
				//更新教师团队为不是最新
		    	teacherTeam.setLatest("2");//设置不是最新
		    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
		    	
		    	/**
		    	 * 判断是不是团队负责人
		    	 */
		    	
			   // if (director.equals("1")) {
		    	if (teas.getDirector().equals("1")) {
			    	//是团队负责人
			    	if (teacherTeam.getDirector() != null && !"".equals(teacherTeam.getDirector()) ) {//当有团队负责人时
			    		//找到负责人的教师信息
			    		Map<String, Object> mDrie =new HashMap<>();
			    		mDrie.put("name", teacherTeam.getDirector());
			    		mDrie.put("status", 1);
			    		//Teachers tDire = teachersService.findTeachersByName(mDrie);
			    		Teachers tDire = findTeachersByName(mDrie);
			    		if (tDire == null) {
							System.out.println("找不到该团队负责人");
//							jsonResult = jsonResult.build(FLAG_FAILED, "找不到该团队负责人！");
//							return jsonResult;
							System.out.println("直接将该教师修改为团队负责人");
							//teacherTeam.setDirector(name);
							teacherTeam.setDirector(teas.getName());
						}else {
							//将其改为不是团队负责人
				    		tDire.setDirector("2");
				    		//int tD = teachersService.modifyTeachers(tDire);
				    		//int tD = modifyTeachers(tDire);
				    		int tD = teachersMapper.updateByPrimaryKeySelective(tDire);
				    		if (tD < 0) {
				    			System.out.println("修改团队负责人状态失败");
				    			System.out.println("还原团队原数据");
				    			//还原数据
				    			teacherTeam.setLatest("1");//设置最新
				    			teacherTeam.setDirector(Dire);//还原团队负责人
						    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
								//jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
								return 781;
							}
				    		//teacherTeam.setDirector(name);
				    		teacherTeam.setDirector(teas.getName());
						}
						
					}else {//没有团队负责人时
						//teacherTeam.setDirector(name);
						teacherTeam.setDirector(teas.getName());
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
				teacherTeam.setDate(teachers.getModifyTime());
				teacherTeam.setId(null);
				teacherTeam.setModifyTime(new Date());
				teacherTeam.setModifyUser(teachers.getModifyUser());
				//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
				Map<String, Object> Tdata = new HashMap<>();
				Tdata.put("specialty_id", teachers.getSpecialtyId());
				Tdata.put("status", 1);
				Tdata.put("is_part_time", teachers.getIsPartTime());//2
				//List<String> tList = teachersService.getTeachersByIdList(Tdata);
				List<String> tList = getTeachersByIdList(Tdata);
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
					//teacherTeam.setPartTimeTeachers(teacherTeam.getPartTimeTeachers()+","+name);
					teacherTeam.setPartTimeTeachers(teacherTeam.getPartTimeTeachers()+","+teas.getName());
					teacherTeam.setSpecialtyTeachers(teacherNames);//新专业教师团队
				}else {
					
					//兼职教师
					//teacherTeam.setSpecialtyTeachers(teacherTeam.getSpecialtyTeachers()+","+name);
					teacherTeam.setSpecialtyTeachers(teacherTeam.getSpecialtyTeachers()+","+teas.getName());
					teacherTeam.setPartTimeTeachers(null);//设置兼职教师团队为空
					teacherTeam.setPartTimeTeachers(teacherNames);//新的兼职教师团队
				}
				addT = teacherTeamService.addTeacherTeam(teacherTeam);//新增团队新数据
				if (addT<0) {
					System.out.println("修改是否兼职后，添加数据失败！");
					return 881;
				}
			}else {//不变更教师团队
				
				//if (!name.equals(teachers.getName())) {//教师姓名是否修改
				if (!teas.getName().equals(teachers.getName())) {//教师姓名是否修改
					//教师姓名修改
					
					//更新教师团队为不是最新
			    	teacherTeam.setLatest("2");//设置不是最新
			    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
			    	
			    	/**
			    	 * 判断是不是团队负责人
			    	 */
				   // if (director.equals("1")) {
			    	  if (teas.getDirector().equals("1")) {
				    	//是团队负责人
				    	if (teacherTeam.getDirector() != null && !"".equals(teacherTeam.getDirector()) ) {//当有团队负责人时
				    		//找到负责人的教师信息
				    		Map<String, Object> mDrie =new HashMap<>();
				    		mDrie.put("name", teacherTeam.getDirector());
				    		mDrie.put("status", 1);
				    		//Teachers tDire = teachersService.findTeachersByName(mDrie);
				    		Teachers tDire = findTeachersByName(mDrie);
				    		if (tDire == null) {
								System.out.println("找不到该团队负责人");
								System.out.println("将直接将该教师添加为团队负责人");
//								jsonResult = jsonResult.build(FLAG_FAILED, "找不到该团队负责人！");
//								return jsonResult;
								//teacherTeam.setDirector(name);
								teacherTeam.setDirector(teas.getName());
							}else {
								//将其改为不是团队负责人
					    		tDire.setDirector("2");
					    		//int tD = teachersService.modifyTeachers(tDire);
					    	//	int tD = modifyTeachers(tDire);
					    		int tD = teachersMapper.updateByPrimaryKeySelective(tDire);
					    		if (tD < 0) {
					    			System.out.println("修改团队负责人状态失败");
									//jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
									return 781;
								}
					    		//teacherTeam.setDirector(name);
					    		teacherTeam.setDirector(teas.getName());
							}
							
						}else {//没有团队负责人时
							//teacherTeam.setDirector(name);
							teacherTeam.setDirector(teas.getName());
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
//				 	teacherTeam.setDate(new Date());
//					teacherTeam.setId(null);
			    	teacherTeam.setDate(teachers.getModifyTime());
					teacherTeam.setId(null);
					teacherTeam.setModifyTime(new Date());
					teacherTeam.setModifyUser(teachers.getModifyUser());
					//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
					Map<String, Object> Tdata = new HashMap<>();
					Tdata.put("specialty_id", teachers.getSpecialtyId());
					Tdata.put("status", 1);
					Tdata.put("is_part_time", teachers.getIsPartTime());//3
					//List<String> tList = teachersService.getTeachersByIdList(Tdata);
					List<String> tList = getTeachersByIdList(Tdata);
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
						//teacherTeam.setSpecialtyTeachers(teacherNames+","+name);
						teacherTeam.setSpecialtyTeachers(teacherNames+","+teas.getName());
					}else {
						
						//兼职教师
						//teacherTeam.setSpecialtyTeachers(teacherTeam.getSpecialtyTeachers()+","+name);
						teacherTeam.setPartTimeTeachers(null);//设置兼职教师团队为空
						//teacherTeam.setPartTimeTeachers(teacherNames+","+name);//新的兼职教师团队
						teacherTeam.setPartTimeTeachers(teacherNames+","+teas.getName());//新的兼职教师团队
					}
					int	addTName = teacherTeamService.addTeacherTeam(teacherTeam);//新增团队新数据
				}
				else {//不变更教师姓名（只变更是团队负责人）
					
					//更新教师团队为不是最新
			    	teacherTeam.setLatest("2");//设置不是最新
			    	updT = teacherTeamService.modifyTeacherTeam(teacherTeam);//修改数据为旧数据
					//if (director.equals("1")) {
			    	if (teas.getDirector().equals("1")) {
				    	//是团队负责人
				    	if (teacherTeam.getDirector() != null && !"".equals(teacherTeam.getDirector()) ) {//当有团队负责人时
				    		//找到负责人的教师信息
				    		Map<String, Object> mDrie =new HashMap<>();
				    		mDrie.put("name", teacherTeam.getDirector());
				    		mDrie.put("status", 1);
				    		//Teachers tDire = teachersService.findTeachersByName(mDrie);
				    		Teachers tDire = findTeachersByName(mDrie);
				    		if (tDire == null) {
								System.out.println("找不到该团队负责人");
//								jsonResult = jsonResult.build(FLAG_FAILED, "找不到该团队负责人！");
//								return jsonResult;
								System.out.println("将直接将该教师添加为团队负责人");
								//teacherTeam.setDirector(name);
								teacherTeam.setDirector(teas.getName());
							}else {
								//将其改为不是团队负责人
					    		tDire.setDirector("2");
					    		//int tD = teachersService.modifyTeachers(tDire);
					    		//int tD = modifyTeachers(tDire);
					    		int tD = teachersMapper.updateByPrimaryKeySelective(tDire);
					    		if (tD < 0) {
					    			System.out.println("修改团队负责人状态失败");
									//jsonResult = jsonResult.build(FLAG_FAILED, "修改团队负责人状态失败");
									return 781;
								}
					    		//teacherTeam.setDirector(name);
					    		teacherTeam.setDirector(teas.getName());
							}
							
						}else {//没有团队负责人时
							//teacherTeam.setDirector(name);
							teacherTeam.setDirector(teas.getName());
						}
					}
					//新增最新团队
			    	teacherTeam.setLatest("1");//设置最新
//				 	teacherTeam.setDate(new Date());
//					teacherTeam.setId(null);
			    	teacherTeam.setDate(new Date());
					teacherTeam.setId(null);
					teacherTeam.setModifyTime(new Date());
					teacherTeam.setModifyUser(teachers.getModifyUser());
					//拿到未修改之前的specialty_id都相同的（不含当前修改的数据），加入到新组合中
					Map<String, Object> Tdata = new HashMap<>();
					Tdata.put("specialty_id", teachers.getSpecialtyId());
					Tdata.put("status", 1);
					Tdata.put("is_part_time", teachers.getIsPartTime());//5
					//List<String> tList = teachersService.getTeachersByIdList(Tdata);
					List<String> tList =getTeachersByIdList(Tdata);
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
						//teacherTeam.setSpecialtyTeachers(teacherNames+","+name);
						if("".equals(teacherNames)) {//判断teacherNames是否为空字符串
							teacherTeam.setSpecialtyTeachers(teas.getName());
						}else {
							teacherTeam.setSpecialtyTeachers(teacherNames+","+teas.getName());
						}
						
					}else {
						
						//兼职教师//teacherTeam.setSpecialtyTeachers(teacherTeam.getSpecialtyTeachers()+","+name);
						teacherTeam.setPartTimeTeachers(null);//设置兼职教师团队为空
						//teacherTeam.setPartTimeTeachers(teacherNames+","+name);//新的兼职教师团队
						
						if ("".equals(teacherNames)) {//判断teacherNames是否为空字符串
							teacherTeam.setPartTimeTeachers(teas.getName());
						}else {
							teacherTeam.setPartTimeTeachers(teacherNames+","+teas.getName());
						}
					}
					//判断初始是否为团队总负责人(判断教师)
					if ("1".equals(teachers.getDirector())) {//是团队总负责人
						if ("2".equals(teas.getDirector())) {//判断是否修改团队负责人
							teacherTeam.setDirector(null);//清空团队负责人为null
						}
					}
					int	addTName = teacherTeamService.addTeacherTeam(teacherTeam);//新增团队新数据
			}				
			}
		}
	    System.out.println("教师修改...impl...结束");
		
		
		return teachersMapper.updateByPrimaryKeySelective(teas);
	}
	@Override
	public void deleteTeachersById(Long id){
		teachersMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Teachers findTeachersById(Long id){
		Teachers teachers = teachersMapper.selectByPrimaryKey(id);
		return teachers;
	}
	@Override
	public List<Teachers> getTeachersList(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return teachersMapper.getTeachersList(data);
	}
	/*@Override
	public int  delTeachersStaus(Teachers teachers) {
		// TODO Auto-generated method stub
		return teachersMapper.delByPrimaryKeyStaus(teachers);
	}*/
	@Override
	public int selectCounts(Map<String, Object> count) {
		// TODO Auto-generated method stub
		return teachersMapper.selectCounts(count);
	}
	//查询name是否存在
	@Override
	public Teachers findTeachersByName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Teachers teachers = teachersMapper.selectByName(map);
		return teachers;
	}
	//查询专业团队负责人
/*	@Override
	public Teachers findTeachersByDirector(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Teachers teachers = teachersMapper.getTeacherByDirector(map);
		return teachers;
	}*/
	//用于获取specialtyId相同的教师数据
	@Override
	public List<String> getTeachersByIdList(Map<String, Object> Tdata) {
		// TODO Auto-generated method stub
		return teachersMapper.getTeacherByList(Tdata);
	}
	/**
	 * 删除，批量删除
	 */
	@Override
	@Transactional
	public int delTeachers(Teachers teachers) {
		// TODO Auto-generated method stub
		
		//删除教师团队里的该教师
		
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
		//List<String> tList = teachersService.getTeachersByIdList(Tdata);
		List<String> tList = getTeachersByIdList(Tdata);
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
			System.out.println("教师团队数据删除失败");
			return 58;
		}
		//这里才开始删除教师数据
		teachers.setStatus(2);

		return teachersMapper.updateByStatus(teachers);
	}
}
