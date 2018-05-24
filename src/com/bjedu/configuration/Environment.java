/*
 * Copyright (c) Css Team
 * All rights reserved.
 *
 * This file Environment.java creation date: [2009-3-26 ����10:07:21] by jiadawei
 * http://www.css.com.cn
 **/
package com.bjedu.configuration;

/** 
 * <p>common Environment data</p>
 * 
 * @author wangjw
 * @version 1.0 2011/5/6
 */
public class Environment {
	
	public static final String SESSION_LOGIN_USER = "gUser";	

	public static final String SESSION_ROLE_KEY = "GROLE";
	
	public static final String INNER_FLOW_ID = "UUID";
	
	public static final String INNER_FLOW_PKID = "PKID";
	
	public static final String INNER_FLOW_TAXID = "TAXID";
	
	public static final String INNER_FLOW_YEAR = "YEAR";
	
	public static final String INNER_FLOW_DW = "BDPFDW";
	
	public static final String INNER_DW_ONLY = "ISONLY";   // 0 非独立审核  1 独立审核
	
	public static final String INNER_DW_AUDIT = "AUDIT";   // 0 未审核   1 审核通过
	
	public final static String BDPF_RY_AUTO = "BDPF_RY_SQ";
	
	public static final String OUTER_FLOW_ID = "UUID";
	
	public static final String OUTER_FLOW_PKID = "PKID";
	
	public static final String OUTER_FLOW_YEAR = "YEAR";
	
	public static final String OUTER_FLOW_DW = "BDPFDW";
	
	public final static String OUTER_BDPF_RY_AUTO = "BDPF_RY_SQ";
	
	public final static String INNER_IS_AUDIT = "INNER_IS_AUDIT";
	
	public final static String INNER_IS_NUM = "INNER_IS_NUM";
	
	public final static String DW_SERARCH_ROW = "DW_SERARCH_ROW";
	
	public static final String System_SessionID = "SystemSessionID_Donne";
	
	public static final Integer ERROR_ID = 999;
	
	//权限等级
	public static final int USER_LEVEL = 0;
	
	//区域等级
	public static final int CITY_LEVEL = 0;
	
	public static final String QIAN_JIAO = "qianjiao";
	
	public final static String SUBSIDY_OBJ_TYPE = "SUBSIDY_OBJ_TYPE";
	
	//ip地址
	public static final String IP_ADDRESS = "ipaddress";
	
	//是否缴足保障金      1-已缴足     0-未缴足
	public static final String INNER_IS_PAY_BZJ = "ispaybzj";
	
	//在残疾人列表页面判断是否重新审核用      1-重新审核
	public static final String INNER_FLOW_ISREAUDIT = "isReAudit";
	
	public static final String DWRY_UUID = "UUID";
	
	public static final String IS_CONFIRM_AUDIT = "IS_CONFIRM_AUDIT";
	
	//登录后左侧菜单功能树
	public static final String LEFT_MENU_FUNC="leftMenufunc";
	
}
