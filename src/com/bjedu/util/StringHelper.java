//$Id: StringHelper.java,v 1.1 2010/04/14 09:11:33 lican Exp $
package com.bjedu.util;

import java.text.ParsePosition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class StringHelper {
	private static final int ALIAS_TRUNCATE_LENGTH = 10;
	private StringHelper() { /* static methods only - hide constructor */
	}
	public static String formatArticle(String s) {
		if (StringHelper.isEmpty(s))
			return "";
		s = "<br/>" + s + "<br/>";
		s = s.replaceAll("\t", " ");
		s = s.replaceAll("　", "");
		s = s.replaceAll("  ", "　");
		s = s.replaceAll("　", "");
		s = s.replaceAll("<br/> ", "<br/>");
		int s_index = -1;
		while (true) {
			s_index = s.indexOf("<br/><br/>");
			if (s_index >= 0) {
				s = s.replaceAll("<br/><br/>", "<br/>");
			} else
				break;
		}
		s = s.replaceAll("<br/>", "<br/><br/>　　");
		return s.substring("<br/><br/>".length(), s.length() - "<br/><br/>　　".length());
	}
	public static char getChar(String a) {
		char ch = a.charAt(0);
		return (char) ('A' + ch - '1');
	}
	public static String getAnwStr(String str) {
		String strTmp = "";
		char ch;
		String arr[] = str.toUpperCase().split(",");
		if (arr == null)
			return "";
		for (int i = 0; i < arr.length; i++) {
			if (StringHelper.isNotEmpty(arr[i])) {
				ch = getChar(arr[i]);
				strTmp += String.valueOf(ch) + ",";
			}
		}
		strTmp = strTmp.substring(0, strTmp.length() - 1);
		return strTmp;
	}
	public static String jiequ(String str, String ch, int n) {
		try {
			String tmp = "";
			for (int i = 0; i < n; i++) {
				int index = str.indexOf(ch);
				tmp += str.substring(0, index + 1);
				str = str.substring(index + 1);
			}
			tmp = tmp.substring(0, tmp.length() - 1);
			return tmp;
		} catch (Exception ex) {
			return "";
		}
	}
	public static String digitToString(String a) {
		a = a.substring(0,a.indexOf("."));
		
		String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String weight[] = { "", "", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟" };
		String jg = new String();
		String tmp = a;
		String zs = new String();
		String xs = new String();
		int dot = tmp.indexOf(".");
		if (dot > 0) {
			zs = tmp.substring(0, dot);
			xs = tmp.substring(dot + 1);
		} else
			zs = tmp.substring(0);
		int w = 0;
		boolean flag = false;
		for (int i = 0; i < zs.length(); i++) {
			w = Integer.parseInt(zs.substring(i, i + 1));
			if (w == 0) {
				if ((zs.length() - i) == 5)
					jg = jg + "万";
				if ((zs.length() - i) == 9)
					jg = jg + "亿";
				flag = true;
			} else {
				if (flag) {
					jg = jg + "零";
					flag = false;
				}
				jg = jg + digit[w];
				jg = jg + weight[zs.length() - i];
			}
		}
		if (dot > 0) {
			jg = jg + "点";
			for (int i = 0; i < xs.length(); i++) {
				w = Integer.parseInt(xs.substring(i, i + 1));
				jg = jg + digit[w];
			}
		}
		//去掉点
		jg = jg + "元整";
		return jg;
	}
	public static boolean findStr(String sSource, String sFind) {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		p = Pattern.compile("(" + sFind + ")", Pattern.CASE_INSENSITIVE);
		m = p.matcher(sSource);
		return m.find();
	}
	public static String getCharStr(int i) {
		char ch = (char) ('A' + i);
		return String.valueOf(ch);
	}
	public static String getKeyword(String sOurce, int len, String highlightWord) {
		String keyword = getByteString(sOurce, len);
		if (isNotEmpty(highlightWord))
			keyword = replaceString(keyword, highlightWord, "<span class=highlightCls>" + highlightWord + "</span>");
		return keyword;
	}
	public static String getByteString(String sOurce, int len) {
		try {
			byte[] hanzi;
			hanzi = sOurce.getBytes("GBK");
			if (hanzi.length <= len)
				return sOurce;
			String tmp;
			int lenTmp = 0, i;
			for (i = 0; i < 2 * len; i++) {
				tmp = sOurce.substring(i, i + 1);
				lenTmp += tmp.getBytes("GBK").length;
				if (lenTmp > len)
					break;
			}
			return tmp = sOurce.substring(0, i);
		} catch (Exception ex) {
			return "";
		}
	}
	public static int getByteLen(String sOurce) {
		try {
			byte[] hanzi = sOurce.getBytes("GBK");
			return hanzi.length;
		} catch (Exception ex) {
			return 0;
		}
	}
	public static String getKeyword(String sOurce, int len) {
		sOurce = ParseUtil.plainText(sOurce);
		sOurce = sOurce.replaceAll("　", "");
		return getByteString(sOurce, len);
	}
	public static String join(String seperator, String[] strings) {
		int length = strings.length;
		if (length == 0)
			return "";
		StringBuffer buf = new StringBuffer(length * strings[0].length()).append(strings[0]);
		for (int i = 1; i < length; i++) {
			buf.append(seperator).append(strings[i]);
		}
		return buf.toString();
	}
	public static String join(String seperator, Iterator objects) {
		StringBuffer buf = new StringBuffer();
		if (objects.hasNext())
			buf.append(objects.next());
		while (objects.hasNext()) {
			buf.append(seperator).append(objects.next());
		}
		return buf.toString();
	}
	public static String[] add(String[] x, String sep, String[] y) {
		String[] result = new String[x.length];
		for (int i = 0; i < x.length; i++) {
			result[i] = x[i] + sep + y[i];
		}
		return result;
	}
	public static String repeat(String string, int times) {
		StringBuffer buf = new StringBuffer(string.length() * times);
		for (int i = 0; i < times; i++)
			buf.append(string);
		return buf.toString();
	}
	public static String replace(String template, String placeholder, String replacement) {
		return replace(template, placeholder, replacement, false);
	}
	public static String replace(String template, String placeholder, String replacement, boolean wholeWords) {
		int loc = template.indexOf(placeholder);
		if (loc < 0) {
			return template;
		} else {
			final boolean actuallyReplace = !wholeWords || loc + placeholder.length() == template.length()
					|| !Character.isJavaIdentifierPart(template.charAt(loc + placeholder.length()));
			String actualReplacement = actuallyReplace ? replacement : placeholder;
			return new StringBuffer(template.substring(0, loc)).append(actualReplacement).append(
					replace(template.substring(loc + placeholder.length()), placeholder, replacement, wholeWords))
					.toString();
		}
	}
	public static String replaceOnce(String template, String placeholder, String replacement) {
		int loc = template.indexOf(placeholder);
		if (loc < 0) {
			return template;
		} else {
			return new StringBuffer(template.substring(0, loc)).append(replacement).append(
					template.substring(loc + placeholder.length())).toString();
		}
	}
	public static String[] split(String seperators, String list) {
		return split(seperators, list, false);
	}
	public static String[] split(String seperators, String list, boolean include) {
		StringTokenizer tokens = new StringTokenizer(list, seperators, include);
		String[] result = new String[tokens.countTokens()];
		int i = 0;
		while (tokens.hasMoreTokens()) {
			result[i++] = tokens.nextToken();
		}
		return result;
	}
	public static String unqualify(String qualifiedName) {
		return qualifiedName.substring(qualifiedName.lastIndexOf(".") + 1);
	}
	public static String qualifier(String qualifiedName) {
		int loc = qualifiedName.lastIndexOf(".");
		return (loc < 0) ? "" : qualifiedName.substring(0, loc);
	}
	public static String[] suffix(String[] columns, String suffix) {
		if (suffix == null)
			return columns;
		String[] qualified = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			qualified[i] = suffix(columns[i], suffix);
		}
		return qualified;
	}
	private static String suffix(String name, String suffix) {
		return (suffix == null) ? name : name + suffix;
	}
	public static String root(String qualifiedName) {
		int loc = qualifiedName.indexOf(".");
		return (loc < 0) ? qualifiedName : qualifiedName.substring(0, loc);
	}
	public static String unroot(String qualifiedName) {
		int loc = qualifiedName.indexOf(".");
		return (loc < 0) ? qualifiedName : qualifiedName.substring(loc + 1, qualifiedName.length());
	}
	public static boolean booleanValue(String tfString) {
		String trimmed = tfString.trim().toLowerCase();
		return trimmed.equals("true") || trimmed.equals("t");
	}
	public static String toString(Object[] array) {
		int len = array.length;
		if (len == 0)
			return "";
		StringBuffer buf = new StringBuffer(len * 12);
		for (int i = 0; i < len - 1; i++) {
			buf.append(array[i]).append(", ");
		}
		return buf.append(array[len - 1]).toString();
	}
	public static String[] multiply(String string, Iterator placeholders, Iterator replacements) {
		String[] result = new String[] { string };
		while (placeholders.hasNext()) {
			result = multiply(result, (String) placeholders.next(), (String[]) replacements.next());
		}
		return result;
	}
	private static String[] multiply(String[] strings, String placeholder, String[] replacements) {
		String[] results = new String[replacements.length * strings.length];
		int n = 0;
		for (int i = 0; i < replacements.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				results[n++] = replaceOnce(strings[j], placeholder, replacements[i]);
			}
		}
		return results;
	}
	public static int countUnquoted(String string, char character) {
		if ('\'' == character) {
			throw new IllegalArgumentException("Unquoted count of quotes is invalid");
		}
		if (string == null)
			return 0;
		// Impl note: takes advantage of the fact that an escpaed single quote
		// embedded within a quote-block can really be handled as two seperate
		// quote-blocks for the purposes of this method...
		int count = 0;
		int stringLength = string.length();
		boolean inQuote = false;
		for (int indx = 0; indx < stringLength; indx++) {
			char c = string.charAt(indx);
			if (inQuote) {
				if ('\'' == c) {
					inQuote = false;
				}
			} else if ('\'' == c) {
				inQuote = true;
			} else if (c == character) {
				count++;
			}
		}
		return count;
	}
	public static boolean isNotEmpty(String string) {
		return string != null && string.length() > 0;
	}
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}
	public static String qualify(String prefix, String name) {
		if (name == null || prefix == null) {
			throw new NullPointerException();
		}
		return new StringBuffer(prefix.length() + name.length() + 1).append(prefix).append('.').append(name).toString();
	}
	public static String[] qualify(String prefix, String[] names) {
		if (prefix == null)
			return names;
		int len = names.length;
		String[] qualified = new String[len];
		for (int i = 0; i < len; i++) {
			qualified[i] = qualify(prefix, names[i]);
		}
		return qualified;
	}
	public static int firstIndexOfChar(String sqlString, String string, int startindex) {
		int matchAt = -1;
		for (int i = 0; i < string.length(); i++) {
			int curMatch = sqlString.indexOf(string.charAt(i), startindex);
			if (curMatch >= 0) {
				if (matchAt == -1) { // first time we find match!
					matchAt = curMatch;
				} else {
					matchAt = Math.min(matchAt, curMatch);
				}
			}
		}
		return matchAt;
	}
	public static String truncate(String string, int length) {
		if (string.length() <= length) {
			return string;
		} else {
			return string.substring(0, length);
		}
	}
	/*
	 * Generate a nice alias for the given class name or collection role name
	 * and unique integer. Subclasses of Loader do <em>not</em> have to use
	 * aliases of this form.
	 * 
	 * @return an alias of the form <tt>foo1_</tt>
	 */
	public static String generateAlias(String description, int unique) {
		return generateAliasRoot(description) + Integer.toString(unique) + '_';
	}
	private static String generateAliasRoot(String description) {
		final String result = truncate(unqualify(description), ALIAS_TRUNCATE_LENGTH).toLowerCase().replace('$', '_'); // classname
		// may
		// be
		// an
		// inner
		// class
		if (Character.isDigit(result.charAt(result.length() - 1))) {
			return result + "x"; // ick!
		} else {
			return result;
		}
	}
	public static String generateAlias(String description) {
		return generateAliasRoot(description) + '_';
	}
	public static String toUpperCase(String str) {
		return str == null ? null : str.toUpperCase();
	}
	public static String toLowerCase(String str) {
		return str == null ? null : str.toLowerCase();
	}
	public static String dealNull(String str) {
		return str == null ? "" : str.trim();
	}
	public static Object dealNull(Object str) {
		return str == null ? "" : str;
	}
	public static String replaceString(String str, String str1, String str2) {
		int s_index;
		String outstr = "";
		if (StringHelper.isEmpty(str))
			return "";
		if (StringHelper.isEmpty(str1))
			return str;
		while (true) {
			s_index = str.indexOf(str1);
			if (s_index >= 0) {
				outstr += str.substring(0, s_index) + str2;
				str = str.substring(s_index + str1.length());
			} else {
				outstr += str;
				break;
			}
		}
		return outstr;
	}
	public static String getFileExt(String fileName) {
		int iIndex = fileName.lastIndexOf(".");
		if (iIndex < 0)
			return "";
		return fileName.substring(iIndex + 1).toLowerCase();
	}
	
	public static Date strToDate(String strDate){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date dateStr = format.parse(strDate, pos);
		return dateStr;
		
	}
	
	
	public static String dateToString(Date strDate,String formateStr){
		SimpleDateFormat format = new SimpleDateFormat(formateStr);
		String dateStr = format.format(strDate);
		return dateStr;
		
	}
	
	public static String dateToString(Date strDate){
		return dateToString(strDate,"yyyy-MM-dd");
	}
	
	public static Date strToDateOther(String strDate){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date dateStr = format.parse(strDate, pos);
		return dateStr;
		
	}
	
	public static String repNull(Object obj)
	{
		if (obj == null)
			return "";
		else
			return obj.toString();
	}
	
	public static String trim(String str){
		if(StringHelper.isEmpty(str)){
			return "";
		}else{
			return str.trim();
		}
	}
	
	public static String compareDate(Date startDate,Date endDate){
		return "";
	}
	
}
