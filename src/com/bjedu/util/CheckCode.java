/**
 * $RCSfile: CheckCode.java,v $
 * $Revision: 1.1 $
 * $Date: 2010/07/06 06:28:00 $
 *
 * New Jive  from Jdon.com.
 *
 * This software is the proprietary information of CoolServlets, Inc.
 * Use is subject to license terms.
 */
package com.bjedu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Utility class to peform common String manipulation algorithms.
 */
public class CheckCode {
	public static String getCheckCode(String scd) {
		return DesUtil.encrypt(scd).substring(0, 4);
	}
	public static boolean checkFun(String scd, String dcd) {
		if (StringHelper.isEmpty(dcd) || StringHelper.isEmpty(scd))
			return false;
		return dcd.equals(getCheckCode(scd));
	}
	
	public static boolean checkStr(String str) {
		if (StringHelper.isEmpty(str)){
			return false;
		}else{
			//字符串不能包含以下特殊字符
			Pattern p = Pattern.compile("[%&’|=?$'<>]+");
		    Matcher m = p.matcher(str);
		    boolean match = m.find();
		    if(match){
		    	return false;
		    }
		    return true;

		}
	}
}