package com.cervus.nippon.common;

import org.apache.axis.encoding.Base64;

public class EncodeDecodeBase64 {
	public static String encodeString(String text) {
		try {
			byte[] bytes = text.getBytes("UTF-8");
			String encodeString = Base64.encode(bytes);
			return encodeString;
		} catch (Exception e) {
			return text;
		}
		
	}

	public static String decodeString(String encodeText) {
		try {
			byte[] decodeBytes = Base64.decode(encodeText);
			String str = new String(decodeBytes, "UTF-8");
			return str;
		} catch (Exception e) {
			return encodeText;
		}
	}
}
