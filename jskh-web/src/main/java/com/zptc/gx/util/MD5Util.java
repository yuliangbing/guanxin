package com.zptc.gx.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.zptc.gx.controller.util.PageController;

public class MD5Util {
	private static Logger logger = Logger.getLogger(MD5Util.class);
	
	Base64 base64 = new Base64();

	public byte[] decode(HttpServletRequest request) {
		String code = request.getParameter("code");
		return base64.decode(code.getBytes());
	}
}
