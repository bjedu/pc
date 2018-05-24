package com.bjedu.util;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static Date getNowDate(){
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		return date;
	}
}
