/*
 * Created on 2006-8-19
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bjedu.util;


/**
 * @author Administrator TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */
public class Ajax {
	public static String xmlHead() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><data>";
	}
	public static String xmlResult(int code, String description) {
		return xmlResult(code, description, "");
	}
	public static String xmlResult(int code, String description, String content) {
		StringBuffer sb = new StringBuffer();
		sb.append(xmlHead());
		sb.append("<code>" + code + "</code>");
		sb.append("<desc><![CDATA[" + description + "]]></desc>");
		sb.append(content);
		sb.append(xmlFoot());
		return sb.toString();
	}
	public static String xmlFoot() {
		return "</data>";
	}
	public static String getTagWhere(String funName, String tag) {
		tag = tag.trim();
		if (StringHelper.isEmpty(tag.trim()))
			return "";
		tag = StringHelper.replaceString(tag, "，", ",");
		String[] a = tag.split(",");
		StringBuffer sb = new StringBuffer();
		sb.append(" and ( 1=1 ");
		String str = "";
		for (int i = 0; i < a.length; i++) {
			str = a[i].trim();
			if (StringHelper.isNotEmpty(str))
				sb.append(" and " + funName + " like '%" + str + "%'");
		}
		sb.append(") ");
		return sb.toString();
	}
	public static String getTagOrWhere(String funName, String tag) {
		tag = tag.trim();
		if (StringHelper.isEmpty(tag.trim()))
			return "";
		tag = StringHelper.replaceString(tag, "，", ",");
		String[] a = tag.split(",");
		StringBuffer sb = new StringBuffer();
		if (a.length > 0) {
			sb.append(" and ( ");
			String str = "";
			for (int i = 0; i < a.length; i++) {
				str = a[i].trim();
				if (StringHelper.isNotEmpty(str)) {
					if (i > 0)
						sb.append(" or ");
					sb.append(funName + " like '%" + str + "%'");
				}
			}
			sb.append(") ");
		}
		return sb.toString();
	}
	public static String getTagOrString(String funName, String tag) {
		tag = tag.trim();
		if (StringHelper.isEmpty(tag.trim()))
			return "";
		tag = StringHelper.replaceString(tag, "，", ",");
		String[] a = tag.split(",");
		StringBuffer sb = new StringBuffer();
		if (a.length > 0) {
			sb.append(" ( ");
			String str = "";
			for (int i = 0; i < a.length; i++) {
				str = a[i].trim();
				if (StringHelper.isNotEmpty(str)) {
					if (i > 0)
						sb.append(" or ");
					sb.append(funName + " like '%" + str + "%'");
				}
			}
			sb.append(") ");
		}
		return sb.toString();
	}
	public static String parseTag2(String funName, String tag) {
		tag = tag.trim();
		if (StringHelper.isEmpty(tag.trim()))
			return "";
		tag = StringHelper.replaceString(tag, "，", ",");
		String[] a = tag.split(",");
		StringBuffer sb = new StringBuffer();
		String str = "";
		for (int i = 0; i < a.length; i++) {
			str = a[i].trim();
			if (StringHelper.isNotEmpty(str))
				sb.append("<a href=\"javascript:" + funName + "('" + str + "')\">" + str
						+ "</a> <a href=\"javascript:del" + funName + "('" + str
						+ "')\"><img border=0 src='images/del.gif'></a> ");
		}
		return sb.toString();
	}
	public static String parseTag(String funName, String tag) {
		tag = tag.trim();
		if (StringHelper.isEmpty(tag.trim()))
			return "";
		tag = StringHelper.replaceString(tag, "，", ",");
		String[] a = tag.split(",");
		StringBuffer sb = new StringBuffer();
		String str = "";
		for (int i = 0; i < a.length; i++) {
			str = a[i].trim();
			if (StringHelper.isNotEmpty(str))
				sb.append("<a href=\"javascript:" + funName + "('" + str + "')\">" + str + "</a> ");
		}
		return sb.toString();
	}
	public static String parseCmTag(String funName, String tag, int col, int typeId) {
		tag = tag.trim();
		if (StringHelper.isEmpty(tag.trim()))
			return "";
		tag = StringHelper.replaceString(tag, "，", ",");
		String[] a = tag.split(",");
		StringBuffer sb = new StringBuffer();
		String str = "";
		for (int i = 0; i < a.length; i++) {
			str = a[i].trim();
			if (StringHelper.isNotEmpty(str))
				sb.append("<a href=\"javascript:" + funName + "(" + typeId + ",'" + col + "','" + str + "')\">" + str
						+ "</a> ");
		}
		return sb.toString();
	}
	public static String parseTag(String funName, String tag, int clearFlag) {
		tag = tag.trim();
		if (StringHelper.isEmpty(tag.trim()))
			return "";
		tag = StringHelper.replaceString(tag, "，", ",");
		String[] a = tag.split(",");
		StringBuffer sb = new StringBuffer();
		String str = "";
		for (int i = 0; i < a.length; i++) {
			str = a[i].trim();
			if (StringHelper.isNotEmpty(str))
				sb.append("<a href=\"javascript:" + funName + "('" + str + "'," + clearFlag + ")\">" + str + "</a> ");
		}
		return sb.toString();
	}
	public static String[] parseTag(String tag) {
		tag = tag.trim();
		if (StringHelper.isEmpty(tag.trim()))
			return null;
		tag = StringHelper.replaceString(tag, "，", ",");
		String[] a = tag.split(",");
		return a;
	}
	public static String parseQuoteTag(String tag) {
		if (StringHelper.isEmpty(tag))
			return "";
		String[] a = tag.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i = i + 2) {
			sb.append("[<a href=\"personal.action?uId=" + a[i] + "\" target=_blank>" + a[i + 1] + "</a>]");
		}
		return sb.toString();
	}
}