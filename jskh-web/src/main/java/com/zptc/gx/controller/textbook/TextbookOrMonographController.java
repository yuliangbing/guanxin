package com.zptc.gx.controller.textbook;

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
import com.zptc.gx.controller.foreignExchange.ForeignExchangeController;
import com.zptc.gx.permission.entity.ZptcUser;
import com.zptc.gx.specialty.entity.ForeignExchange;
import com.zptc.gx.specialty.entity.TextbookOrMonograph;
import com.zptc.gx.specialty.service.TextbookOrMonographService;
import com.zptc.gx.util.ToolUtil;
import com.zptc.gx.vo.PageVO;

/**
 * 教材或专著
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/TextbookOrMonograph")
public class TextbookOrMonographController extends BaseController {
	
	private Logger logger = Logger.getLogger(TextbookOrMonographController.class);
	
	@Autowired
	private TextbookOrMonographService tService;
	
	/**
	 * 获取列表
	 */
	@RequestMapping("/getTextbookOrMonographList")
	@ResponseBody
	public JsonResult getTextbookOrMonographList(HttpServletRequest request, HttpServletResponse response) {
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
			List<TextbookOrMonograph> tList = tService.getTextbookOrMonographList(data);
			System.out.println("返回的数据："+tList);
			counts = tService.selectCounts(count);
			jsonResult = JsonResult.build(FLAG_SUCCESS, tList,msg,counts);
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
	@RequestMapping("/addTextbookOrMonograph")
	@ResponseBody
	public JsonResult addTextbookOrMonograph(@RequestBody TextbookOrMonograph tOrMonograph,HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用addForeignExchange方法");
	    
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    
	    tOrMonograph.setStatus(1);
	    tOrMonograph.setCreateTime(new Date());
	    tOrMonograph.setCreateUser(user.getTeaName());
	   System.out.println("获取到的数据="+tOrMonograph.toString());
	    /*判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(tOrMonograph.getDate())&&ToolUtil.equalBool(tOrMonograph.getName())&&ToolUtil.equalBool(tOrMonograph.getPress())&&ToolUtil.equalBool(tOrMonograph.getFirstAuthor())&&ToolUtil.equalBool(tOrMonograph.getOtherAuthors())
	    		&&ToolUtil.equalBool(tOrMonograph.getSpecialtyId())&&ToolUtil.equalBool(tOrMonograph.getSpecialtyName())) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+tOrMonograph.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+tOrMonograph.toString());
		try {
			
			int result = tService.addTextbookOrMonograph(tOrMonograph);
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
	@RequestMapping("/updateTextbookOrMonograph")
	@ResponseBody
	public JsonResult updateTextbookOrMonograph(@RequestBody TextbookOrMonograph tOrMonograph,HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用updateTextbookOrMonograph方法");
	    
	    ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
	    
	    TextbookOrMonograph textbookOrMonograph = tService.findTextbookOrMonographById(tOrMonograph.getId());
	    if (textbookOrMonograph == null) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "没有该教材或专著信息！");
			return jsonResult;
		}
	    tOrMonograph.setModifyTime(new Date());
	    tOrMonograph.setModifyUser(user.getTeaName());
	   System.out.println("获取到的数据="+tOrMonograph.toString());
	    /*判断传入的值是否为空或""*/
	    if ((ToolUtil.equalBool(tOrMonograph.getDate())&&ToolUtil.equalBool(tOrMonograph.getName())&&ToolUtil.equalBool(tOrMonograph.getPress())&&ToolUtil.equalBool(tOrMonograph.getFirstAuthor())&&ToolUtil.equalBool(tOrMonograph.getOtherAuthors())
	    		&&ToolUtil.equalBool(tOrMonograph.getSpecialtyId())&&ToolUtil.equalBool(tOrMonograph.getSpecialtyName())) == false) {
	    	jsonResult = JsonResult.build(FLAG_FAILED, "必填数据缺少！");
	    	System.out.println("错误，传入数据错误");
	    	 //接口拿到的数据
		    System.out.println("方法拿到的数据："+tOrMonograph.toString());
	    	return jsonResult;
		}
	    System.out.println("传入数据成功");
	    System.out.println("方法拿到的数据："+tOrMonograph.toString());
		try {
			
			int result = tService.modifyTextbookOrMonograph(tOrMonograph);
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
	@RequestMapping("/delTextbookOrMonograph")
	@ResponseBody
	public JsonResult delTextbookOrMonograph(HttpServletRequest request, HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		System.out.println("启用delTextbookOrMonograph方法");
		try {
			//ZptcUser user = (ZptcUser) request.getSession().getAttribute(Constant.USER_SESSION);
			Long id = ToolUtil.lon("id", request);
			System.out.println("id="+id);
		    //判断是否有该专业
			
			TextbookOrMonograph textbookOrMonograph = tService.findTextbookOrMonographById(id);
			if (textbookOrMonograph == null) {
				jsonResult = JsonResult.build(FLAG_FAILED, "没有该对外学习交流信息！");
				return jsonResult;
			}
			textbookOrMonograph.setStatus(2);
		    int result = tService.delTextbookOrMonograph(textbookOrMonograph);
		    System.out.println("要删除的数据是："+textbookOrMonograph.toString());
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
