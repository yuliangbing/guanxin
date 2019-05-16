package com.zptc.gx.controller.mainCourses;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.MainCourses;
import com.zptc.gx.specialty.service.MainCoursesService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 主干课程
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/MainCourses")
public class MainCoursesController extends BaseController {
	
	private Logger logger = Logger.getLogger(MainCoursesController.class);

	@Autowired MainCoursesService mService;
	
	/**
	 * 获取列表
	 */
	@RequestMapping("/getMainCoursesList")
	@ResponseBody
	public JsonResult getMainCoursesList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
		Map<String, Object> data = new HashMap<>();
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
	    //用于分页的数据
	    pages = pageVO.getBeginNum();
	    //存入data,用于获取表格数据
  		data.put("limit", pageVO.getLimit());
  		data.put("pages", pages);
  		data.put("status", 1);
  		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "获取成功";
		try {
			//获取所有status == 1 的所有数据
			List<MainCourses> mList = mService.getMainCoursesList(data);
			System.out.println("返回的数据："+mList);
			counts = mService.selectCounts(count);
			jsonResult = JsonResult.build(FLAG_SUCCESS, mList,msg,counts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 添加
	 */
	@RequestMapping("/addMainCourses")
	@ResponseBody
	public JsonResult addMainCourses(@RequestBody MainCourses mainCourses,HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addForeignExchange方法");
	    
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    
	    mainCourses.setStatus(1);
	    mainCourses.setCreateTime(new Date());
	    mainCourses.setCreateUser(user.getTeaName());
	   System.out.println("获取到的数据="+mainCourses.toString());
	    /*判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(mainCourses.getSpecialtyId())&&ToolUtil.equalBool(mainCourses.getSpecialtyName())
	    		&&ToolUtil.equalBool(mainCourses.getDate())&&ToolUtil.equalBool(mainCourses.getCourses())) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+mainCourses.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+mainCourses.toString());
		try {
			
			int result = mService.addMainCourses(mainCourses);
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"添加成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"添加失败,请重新尝试");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 修改
	 */
	@RequestMapping("/updateMainCourses")
	@ResponseBody
	public JsonResult updateMainCourses(@RequestBody MainCourses mainCourses,HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateMainCourses方法");
	    
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    
	    MainCourses mainCourses2 = mService.findMainCoursesById(mainCourses.getId());
	    if (mainCourses2 == null) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该教材或专著信息！");
			return jsonResult;
		}
	    mainCourses.setModifyTime(new Date());
	    mainCourses.setModifyUser(user.getTeaName());
	    System.out.println("获取到的数据="+mainCourses.toString());
	    /*判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(mainCourses.getSpecialtyId())&&ToolUtil.equalBool(mainCourses.getSpecialtyName())
	    		&&ToolUtil.equalBool(mainCourses.getDate())&&ToolUtil.equalBool(mainCourses.getCourses())) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+mainCourses.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+mainCourses.toString());
		try {
			
			int result = mService.modifyMainCourses(mainCourses);
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"修改成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"修改失败,请重新尝试");
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
	@RequestMapping("/delMainCourses")
	@ResponseBody
	public JsonResult delMainCourses(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delMainCourses方法");
		try {
			//ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long id = ToolUtil.lon("id", request);
			System.out.println("id="+id);
		    //判断是否有该专业
			
			MainCourses mainCourses = mService.findMainCoursesById(id);
		    if (mainCourses == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该主干课程信息！");
				return jsonResult;
			}
		    mainCourses.setStatus(2);
		    int result = mService.delMainCourses(mainCourses);
		    System.out.println("要删除的数据是："+mainCourses.toString());
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"删除成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"删除失败，请检查网络后，重新尝试");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}	
}
