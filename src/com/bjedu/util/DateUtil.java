/*
 * Created on 2006-7-12
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bjedu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Administrator TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */
public class DateUtil {
	public static final long daysInterval(Date fromDate, Date toDate) {
		return (toDate.getTime() - fromDate.getTime()) / 86400000;
	}
	public static final long daysInterval(Date fromDate) {
		if (fromDate == null)
			return 0;
		Date toDate = new Date();
		return daysInterval(fromDate, toDate);
	}
	public static final int yearsInterval(Date fromDate, Date toDate) {
		if (fromDate == null || toDate == null)
			return 0;
		return toDate.getYear() - fromDate.getYear();
	}
	public static final String leftDays(Date fromDate) {
		Date toDate = new Date();
		long l = daysInterval(fromDate, toDate);
		l = l * (-1) + 1;
		if (l <= 0)
			return "到期";
		return String.valueOf(l);
	}
	public static final int yearsInterval(Date fromDate) {
		if (fromDate == null)
			return 0;
		Date toDate = new Date();
		return yearsInterval(fromDate, toDate);
	}
	public static boolean compareDate(Date d1, Date d2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d1).equals(sdf.format(d2));
	}
	public static String getDate(int days) {
		GregorianCalendar calTmp = new GregorianCalendar();
		calTmp.add(GregorianCalendar.DATE, -1 * days);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calTmp.getTime());
	}
	public static Date toDate(int days) {
		GregorianCalendar calTmp = new GregorianCalendar();
		calTmp.add(GregorianCalendar.DATE, -1 * days);
		return calTmp.getTime();
	}
	public static Date toDate(Date from,int days) {
		GregorianCalendar calTmp = new GregorianCalendar();
		calTmp.setTime(from);
		calTmp.add(GregorianCalendar.DATE, -1 * days);
		return calTmp.getTime();
	}
	public static Date getFirstWeek(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_WEEK) - dayOfWeek + 1);
		return cal.getTime();
	}
	public static Date getLastWeek(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_WEEK) - dayOfWeek + 2);
		return cal.getTime();
	}
	public static Date getFirstMonth(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH) - dayOfWeek);
		return cal.getTime();
	}
	public static Date getLastMonth(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH) - dayOfWeek+1);
		return cal.getTime();
	}
	public static Date getFirstYear(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_YEAR);
		cal.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_YEAR) - dayOfWeek);
		return cal.getTime();
	}
	public static Date getLastYear(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_YEAR);
		cal.add(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_YEAR) - dayOfWeek+1);
		return cal.getTime();
	}
	
	//返回一个的最早时间，以利于ReportAction中的initCycle()方法调用
	public static Date getStart() {
		Calendar cal = new GregorianCalendar();
		cal.set(2008, 6, 8, 0, 0, 0);
		return cal.getTime();
	}
	//返回一个的最晚的时间，以利于ReportAction中的initCycle()方法调用
	public static Date getEnd() {
		Calendar cal = new GregorianCalendar();
		return cal.getTime();
	}
	
	public static String getDate() {
		GregorianCalendar calTmp = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(calTmp.getTime());
	}
	
	public static String getTime() {
		GregorianCalendar calTmp = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmissa");
		return sdf.format(calTmp.getTime());
	}
}
