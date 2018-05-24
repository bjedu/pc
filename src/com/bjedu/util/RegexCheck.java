package com.bjedu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author donne TODO To change the template for this generated type comment go
 *         to Window - Preferences - Java - Code Style - Code Templates
 */
public class RegexCheck {
	public static String imgCheck(String sSource) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("((<|</)(form|script)|^\\son)", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.substring(0, 1).equals("<"))
				s = "&lt;" + m.group().substring(1);
			else
				s = " &#111n";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String TagReverse(String sSource) {
		if (StringHelper.isEmpty(sSource))
			return "";
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("(<br/>|\\&lt;|\\&gt;)", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals("<br/>"))
				s = "\n";
			else if (sTmp.equals("&lt;"))
				s = "<";
			else if (sTmp.equals("&gt;"))
				s = ">";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String TagReverseAdmin(String sSource) {
		if (StringHelper.isEmpty(sSource))
			return "";
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("(\\&lt;|\\&gt;)", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals("&lt;"))
				s = "<";
			else if (sTmp.equals("&gt;"))
				s = ">";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String TagReplace(String sSource) {
		if (StringHelper.isEmpty(sSource))
			return "";
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("(\\n|\\r|<|>|'|%)", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals("\n"))
				s = "<br/>";
			else if (sTmp.equals("\r"))
				s = "";
			else if (sTmp.equals("<"))
				s = "&lt;";
			else if (sTmp.equals(">"))
				s = "&gt;";
			else if (sTmp.equals("'"))
				s = "&apos";
			else if (sTmp.equals("%"))
				s = "&pc";	
			
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String tikuTagReplace(String sSource) {
		if (StringHelper.isEmpty(sSource))
			return sSource;
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("(\\n|\\r|<|>)", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals("\n"))
				s = "<br/>";
			else if (sTmp.equals("\r"))
				s = "";
			else if (sTmp.equals("<"))
				s = "&lt;";
			else if (sTmp.equals(">"))
				s = "&gt;";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String TagReplaceAll(String sSource) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("( |\\t|\\n|<|>|\\&)", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals(" "))
				s = "&nbsp;";
			else if (sTmp.equals("\t"))
				s = "&nbsp;&nbsp;&nbsp;";
			else if (sTmp.equals("\n"))
				s = "<br/>";
			else if (sTmp.equals("<"))
				s = "&lt;";
			else if (sTmp.equals(">"))
				s = "&gt;";
			else if (sTmp.equals("&"))
				s = "&amp;";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String HtmlCheck(String sSource) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("(<(input|select|form|frame|html|option|object|script|text|area|iframe)|^\\son)",
				Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.substring(0, 1).equals("<"))
				s = "&lt;" + m.group().substring(1);
			else
				s = " &#111n";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String HtmlReplace(String sSource) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile(
				"(<(div|/div|input|select|form|frame|html|option|object|script|text|area|iframe)|^\\son|,|'|\\(|\\))",
				Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals(","))
				s = "，";
			else if (sTmp.equals("'"))
				s = "&#39;";
			else if (sTmp.equals("("))
				s = "&#40;";
			else if (sTmp.equals(")"))
				s = "&#41;";
			else if (sTmp.substring(0, 1).equals("<"))
				s = "&lt;" + m.group().substring(1);
			else
				s = " &#111n";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String Replace(String IN_String, String sRegex, String sDes) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		p = Pattern.compile(sRegex, Pattern.CASE_INSENSITIVE);
		m = p.matcher(IN_String);
		return m.replaceAll(sDes);
	}
	public static String SQLReplace(String sSource) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("(,|'|\\(|\\))", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals(","))
				s = "&#44;";
			else if (sTmp.equals("'"))
				s = "&#39";
			else if (sTmp.equals("("))
				s = "&#40;";
			else if (sTmp.equals(")"))
				s = "&#41;";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String HtmlTextReplace(String sSource) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("( |\\t|\\n|<|>|,|'|\\(|\\)|\\&)", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals(" "))
				s = "&nbsp;";
			else if (sTmp.equals("\t"))
				s = "&nbsp;&nbsp;&nbsp;";
			else if (sTmp.equals("\n"))
				s = "<br/>";
			else if (sTmp.equals("<"))
				s = "&lt;";
			else if (sTmp.equals(">"))
				s = "&gt;";
			else if (sTmp.equals(","))
				s = "&#44;";
			else if (sTmp.equals("'"))
				s = "&#39";
			else if (sTmp.equals("("))
				s = "&#40;";
			else if (sTmp.equals(")"))
				s = "&#41;";
			else if (sTmp.equals("&"))
				s = "&amp;";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public static String sqltonohtml(String sSource) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("( |<|>|,|'|;|%|&|=|\\?|)|\\&|-", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals("<"))
				s = "&lt;";
			else if (sTmp.equals(">"))
				s = "&gt;";
			else if (sTmp.equals(","))
				s = "&#44;";
			else if (sTmp.equals("'"))
				s = "&#39;";
			else if (sTmp.equals("%"))
				s = "&#37;";
			else if (sTmp.equals("&"))
				s = "&#38;";
			else if (sTmp.equals("="))
				s = "&#61;";
			else if (sTmp.equals("?"))
				s = "&#63;";
			else if (sTmp.equals("("))
				s = "&#40;";
			else if (sTmp.equals("-"))
				s = "&#45;";	
			else if (sTmp.equals("&"))
				s = "&amp;";
			else 
				s= null;			
			
			if(StringHelper.isNotEmpty(s)){
				m.appendReplacement(sb, s);
			}
		}
		
		
		m.appendTail(sb);
		return sb.toString();
	}

	public static String nohtmltosql(String sSource) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("(|\\&lt;|\\&gt;|\\&#44;|\\&#39;|\\&#37;|\\&#38;|\\&#61;|\\&#63;|\\&#40;|\\&#41;|\\&#45;)", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group().toLowerCase();
			if (sTmp.equals( "&lt;"))
				s =  "<";
			else if (sTmp.equals("&gt;"))
				s =  ">" ;
			else if (sTmp.equals("&#44;"))
				s =  ",";
			else if (sTmp.equals("&#39;"))
				s = "'";
			else if (sTmp.equals("&#37;"))
				s =  "%";
			else if (sTmp.equals("&#38;"))
				s = "&";
			else if (sTmp.equals("&#61;"))
				s =  "=";
			else if (sTmp.equals("&#63;"))
				s = "?";	
			else if (sTmp.equals("&#40;"))
				s = "(";
			else if (sTmp.equals("&#41;"))
				s = ");";		
			else if (sTmp.equals("&#45;"))
				s = "-;";				
			else 
				s= null;
			if(StringHelper.isNotEmpty(s)){
				m.appendReplacement(sb, s);
			}
			
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static String dealURL(String sSource) {
		if(sSource==null) return "";
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		String s = null, sTmp = null;
		StringBuffer sb = null;
		p = Pattern.compile("http://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		sb = new StringBuffer();
		while (m.find()) {
			sTmp = m.group();// .toLowerCase();
			s = "<a href=\"" + sTmp + "\" target=\"_blank\">" + sTmp + "</a>";
			m.appendReplacement(sb, s);
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public static boolean IndexOf(String sSource, String sRegex) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		p = Pattern.compile(sRegex, Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		return m.find();
	}
	
	public static void main(String[] args){
		String str="[a%a&a’a|a=a?a$a'a<a>a]a+a";
		try {
		for(String s:str.split("a")){
			System.out.println(new String(s.getBytes("utf-8")));
		}
		}catch(Exception e){
			
		}
	}
}