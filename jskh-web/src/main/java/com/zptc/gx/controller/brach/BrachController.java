package com.zptc.gx.controller.brach;

import java.awt.TextArea;
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

import com.mysql.fabric.xmlrpc.base.Data;
import com.zptc.gx.branch.entity.BranchIntroduction;
import com.zptc.gx.branch.entity.OrganizationMember;
import com.zptc.gx.branch.service.BranchIntroductionService;
import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.controller.permission.MenuController;
import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.util.MD5Util;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

@Controller
@RequestMapping("/branch")
public class BrachController extends BaseController {
	private Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired
	private BranchIntroductionService branchIntroductionService; 
	
	/*新增分院*/
	
	@RequestMapping("/addBranch")
	@ResponseBody
	public JsonResult addBranch(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addBranch方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			/*String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);*/
		    String specialtyInfo = ToolUtil.str("specialtyInfo", request);
		    String branchCharacteristic = ToolUtil.str("branchCharacteristic", request);
		    Date date = ToolUtil.date2("date", request);
		    Integer status = ToolUtil.integer("status", request);
		    
		    BranchIntroduction branch = new BranchIntroduction();
		    /*branch.setCode(code);
		    branch.setName(name)*/;
		    branch.setSpecialtyInfo(specialtyInfo);
		    branch.setBranchCharacteristic(branchCharacteristic);
			branch.setDate(date);
			branch.setStatus(1);
			branch.setCreateTime(new Date());
			branch.setCreateUser(user.getTeaName());
			if ((ToolUtil.equalBool(specialtyInfo)&&ToolUtil.equalBool(branchCharacteristic)&&ToolUtil.equalBool(date)) == false) {
		    			jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
		    			System.out.println(branch.toString());
		    			return jsonResult;
		       }
			int result = branchIntroductionService.addBranchIntroduction(branch);
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
	/*分院修改*/
	@RequestMapping("/updateBranch")
	@ResponseBody
	public JsonResult updateBranch(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateBranch方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long Id = ToolUtil.lon("Id", request);/*
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);*/
		    String specialtyInfo = ToolUtil.str("specialtyInfo", request);
		    String branchCharacteristic = ToolUtil.str("branchCharacteristic", request);
		    Date date = ToolUtil.date2("date ", request);
		    
		    BranchIntroduction branch = branchIntroductionService.findBranchIntroductionById(Id);
		    if (branch == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该分院！");
				return jsonResult;
			}
		    
		    /*branch.setCode(code);
		    branch.setName(name);*/
		    branch.setSpecialtyInfo(specialtyInfo);
		    branch.setBranchCharacteristic(branchCharacteristic);
		    branch.setDate(date);
		    branch.setModifyUser(user.getTeaName());
		    branch.setModifyTime(new Date());
		    if ((ToolUtil.equalBool(specialtyInfo)&&ToolUtil.equalBool(branchCharacteristic)&&ToolUtil.equalBool(date)) == false) {
    			jsonResult = JsonResult.build(FLAG_FAILED,"数据缺少");
    			System.out.println(branch.toString());
    			return jsonResult;
		    }
		    int result = branchIntroductionService.modifyBranchIntroduction(branch);
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
	/*删除分院*/
	@RequestMapping("/deleteBranch")
	@ResponseBody
	public JsonResult deleteBranch(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用deleteBranch方法");
		try {
			ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			
			Long id = ToolUtil.lon("id", request);
		    BranchIntroduction branchIntroduction = branchIntroductionService.findBranchIntroductionById(id);
		   if (branchIntroduction==null) {
			jsonResult = JsonResult.build(FLAG_FAILED, "没有该分院");
			return jsonResult;
		}
//		   改变stauts
		  // branchIntroduction.setStatus(2);
		    int result = branchIntroductionService.deleteBranchIntroductionById(branchIntroduction);
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
//	显示文本框数据
	@RequestMapping("/getBranchText")
	@ResponseBody
	public JsonResult getBranchText(HttpServletRequest request, HttpServletResponse responses) {
		JsonResult jsonResult =new JsonResult();
		Map<String, Object> data= new HashMap<>();
//		获取请求参数
		String specialty_info = ToolUtil.str("specialty_info",request);
		String branch_characteristic = ToolUtil.str("branch_characteristic",request);
		Date date = ToolUtil.date2("date", request);
		  Integer limit = ToolUtil.integer("limit", request);
		    Integer page = ToolUtil.integer("page", request);
		    PageVO pageVO = new PageVO(page, limit);
		    Integer pages = 0;
//		    用于分页的数据
		    pages = pageVO.getBeginNum();

		  //存入data,用于获取表格数据
		    data.put("specialty_info", specialty_info);
		    data.put("branch_characteristic", branch_characteristic);
		    data.put("date", date);
		    data.put("status", 1);
			data.put("limit", pageVO.getLimit());
			data.put("pages", pages); 
			String msg = "success";
			try {
				ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
				//获取所有status == 1 的所有数据
				List<BranchIntroduction>  branchIntroductions = branchIntroductionService.getBranchText(data);
				//返回接口的具体数据
				jsonResult = jsonResult.build(FLAG_SUCCESS, branchIntroductions, msg,pages);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				jsonResult = JsonResult.build(FLAG_FAILED,e.getMessage());
			}
			return jsonResult;
	}
}
