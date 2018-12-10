package com.zptc.gx.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

public class MD5Util {
	
	Base64 base64 = new Base64();

	public byte[] decode(HttpServletRequest request) {
		String code = request.getParameter("code");
		return base64.decode(code.getBytes());
	}
}
