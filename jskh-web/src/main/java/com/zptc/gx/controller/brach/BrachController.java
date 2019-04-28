package com.zptc.gx.controller.brach;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zptc.gx.branch.entity.BranchIntroduction;
import com.zptc.gx.branch.service.BranchIntroductionService;
import com.zptc.gx.common.util.Constant;
import com.zptc.gx.common.util.JsonResult;
import com.zptc.gx.controller.BaseController;
import com.zptc.gx.controller.permission.MenuController;
import com.zptc.gx.permission.entity.Menu;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.util.MD5Util;
import com.zptc.gx.util.ToolUtil;

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
			
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    String specialtyInfo = ToolUtil.str("introduction", request);
		    String branchCharacteristic = ToolUtil.str("branchCharacteristic", request);
		    Date date = ToolUtil.date1("data", request);
		    
		    BranchIntroduction branch = new BranchIntroduction();
		    branch.setCode(code);
		    branch.setName(name);
		    branch.setSpecialtyInfo(specialtyInfo);
		    branch.setBranchCharacteristic(branchCharacteristic);
			branch.setDate(date);
			branch.setCreateTime(new Date());
			branch.setCreateUser(user.getTeaName());
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
			
			Long branchId = ToolUtil.lon("branchId", request);
			String code = ToolUtil.str("code", request);
		    String name = ToolUtil.str("name", request);
		    String specialtyInfo = ToolUtil.str("introduction", request);
		    String branchCharacteristic = ToolUtil.str("branchCharacteristic", request);
		    Date date = ToolUtil.date1("data", request);
		    
		    BranchIntroduction branch = branchIntroductionService.findBranchIntroductionById(branchId);
		    if (branch == null) {
		    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该分院！");
				return jsonResult;
			}
		    
		    branch.setCode(code);
		    branch.setName(name);
		    branch.setSpecialtyInfo(specialtyInfo);
		    branch.setBranchCharacteristic(branchCharacteristic);
		    branch.setDate(date);
		    branch.setModifyUser(user.getTeaName());
		    branch.setModifyTime(new Date());
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
			
			Long branchId = ToolUtil.lon("branchId", request);
		    
		    int result = branchIntroductionService.deleteBranchIntroductionById(branchId);
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
