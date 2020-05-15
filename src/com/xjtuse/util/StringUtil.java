package com.xjtuse.util;
/*
 * 
 * @author qgm
 * String类的一些操作方法
 */
public class StringUtil {
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str)) return true;
		else return false;
	}
}
