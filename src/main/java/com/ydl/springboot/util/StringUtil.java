package com.ydl.springboot.util;

public class StringUtil {
	
	public static boolean isEmpty(String str) {
		return (str == null) || str.equals("");
	}
	
	public static String trim(String str) {
		return str == null ? "" : str.trim();
	}
}
