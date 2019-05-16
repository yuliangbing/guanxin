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
import com.zptc.gx.specialty.entity.PatentType;
import com.zptc.gx.specialty.service.PatentTypeService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 专利类型
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/patentType")
public class PatentTypeController extends BaseController {
	private Logger logger = Logger.getLogger(PatentTypeController.class);
	
	@Autowired
	private PatentTypeService pService;
	/**
	 * 下拉列表方法
	 */
	@RequestMapping("/PatentTypeList")
	@ResponseBody
	public JsonResult PatentList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		Map<String, Object> data = new HashMap<>();
	    //存入data,用于获取表格数据
  		data.put("status", 1);
  		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("status", 1);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "获取成功";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<Patent> patents = pService.selectPatentType(data);
			jsonResult = JsonResult.build(FLAG_SUCCESS, patents);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	
	/**
	 * 获取列表接口
	 */
	@RequestMapping("/getPatentTypeList")
	@ResponseBody
	public JsonResult getPatentTypeList(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("列表信息");
		Map<String, Object> data = new HashMap<>();
		//获取请求参数
		String name = ToolUtil.str("name", request);
		Integer limit = ToolUtil.integer("limit", request);
	    Integer page = ToolUtil.integer("page", request);
	    PageVO pageVO = new PageVO(page, limit);
	    Integer pages = 0;
	    //用于分页的数据
	    pages = pageVO.getBeginNum();
	    //存入data,用于获取表格数据
	    data.put("name", name);
  		data.put("limit", pageVO.getLimit());
  		data.put("pages", pages);
  		data.put("status", 1);
  		Map<String, Object> count = new HashMap<>();
		//存入count,用于获取表格数据条总数
		count.put("status", 1);
		count.put("name", name);
		//定义返回的数据条总数
		int counts = 0;
		//定义返回的msg
		String msg = "获取成功";
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			//获取所有status == 1 的所有数据
			List<Patent> patentTypes = pService.getPatentTypeList(data);
			counts = pService.selectCounts(count);
			jsonResult = JsonResult.build(FLAG_SUCCESS, patentTypes,msg,counts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
	/**
	 * 添加专利类型接口
	 */
	@RequestMapping("/addPatentType")
	@ResponseBody
	public JsonResult addPatentType(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addPatentType方法");
		
		/*获取参数*/
		String code = ToolUtil.str("code", request);
		String name = ToolUtil.str("name", request);
	    
	    /*注入实体类*/
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    PatentType patentType = new PatentType();
	    patentType.setCode(code);
	    patentType.setName(name);
	    patentType.setStatus(1);
	    patentType.setCreateTime(new Date());
	    patentType.setCreateUser(user.getTeaName());
	   
	    /*判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+patentType.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+patentType.toString());
		try {
			
			int result = pService.addPatentType(patentType);
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"添加成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"添加失败");
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
	@RequestMapping("/updatePatentType")
	@ResponseBody
	public JsonResult updatePatentType(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updatePatentType方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long id = ToolUtil.lon("id", request);	    
			String code = ToolUtil.str("code", request);
			String name = ToolUtil.str("name", request);
		    
		    PatentType patentType = pService.findPatentTypeById(id);
		    if (patentType == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该专利类型！");
				return jsonResult;
			}
		    patentType.setCode(code);
		    patentType.setName(name);
		    patentType.setModifyTime(new Date());
		    patentType.setModifyUser(user.getTeaName());
		    /*判断传入的值是否为空或""*/
		    if ((ToolUtil.equalBool(code)&&ToolUtil.equalBool(name)) == false) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
		    	System.out.println("错误，传入数据错误");
		    	 //接口拿到的数据
			    System.out.println("方法拿到的数据："+patentType.toString());
		    	return jsonResult;
			}
		    System.out.println("传入数据成功");
		    System.out.println("方法拿到的数据："+patentType.toString());
		    int result = pService.modifyPatentType(patentType);
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
	/**
	 * 根据id进行软删除（修改status状态码）
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delPatentType")
	@ResponseBody
	public JsonResult delPatentType(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delPatentType方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long id = ToolUtil.lon("id", request);
			System.out.println("id="+id);
		    //判断是否有该专业
			PatentType patentType = pService.findPatentTypeById(id);
			if (patentType == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该专利类型！");
				return jsonResult;
			}
			patentType.setStatus(2);//修改状态码
		    int result = pService.delPatenType(patentType);
		    System.out.println("要删除的数据是："+patentType.toString());
		    if (result > 0) {
		    	jsonResult = JsonResult.build(FLAG_SUCCESS,"删除成功");
			} else {
				jsonResult = JsonResult.build(FLAG_FAILED,"删除失败,请重新尝试");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResult = JsonResult.build(FLAG_FAILED, e.getMessage());
		}
		return jsonResult;
	}
}
