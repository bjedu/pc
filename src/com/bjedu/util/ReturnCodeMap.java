package com.bjedu.util;

import java.util.*;

public class ReturnCodeMap {
	
	private static Map<String,String> map = null;
	
	public static void init() {
		map = new HashMap<String,String>();
		map.put("TAX0000", "正常返回数据");
		map.put("TAX0010", "没有查询结果返回");
		map.put("TAX0020", "入口参数错误");
		map.put("TAX0030", "系统错误");
		map.put("TAX9999", "未知错误");
	}
	
	public static String getReturnCodeMessage(String returnCode) {
		if(map == null) {
			init();
		}
		return map.get(returnCode);
	}

}
