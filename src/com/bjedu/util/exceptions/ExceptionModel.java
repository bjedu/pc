package com.bjedu.util.exceptions;

import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ExceptionModel implements Comparable<ExceptionModel>{
	private Date happenDate;
	private Exception e;
	
	public ExceptionModel(){}
	
	public ExceptionModel(Exception e){
		this.e = e;
		happenDate = new Date();
	}
	
	public ExceptionModel(Date happenDate, Exception e) {
		super();
		this.happenDate = happenDate;
		this.e = e;
	}
	public Date getHappenDate() {
		return happenDate;
	}
	public void setHappenDate(Date happenDate) {
		this.happenDate = happenDate;
	}
	public Exception getE() {
		return e;
	}
	public void setE(Exception e) {
		this.e = e;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(e.getClass());
		sb.append(":");
		sb.append(e.getMessage());
		StackTraceElement[] stes = e.getStackTrace();
		for(StackTraceElement ste : stes){
			sb.append("<br/>");
			sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			sb.append(ste.getClassName());
			sb.append(".");
			sb.append(ste.getMethodName());
			sb.append("(line--");
			sb.append(ste.getLineNumber());
			sb.append(")");
		}
		return sb.toString();
	}

	@Override
	public int compareTo(ExceptionModel o) {
		if(happenDate.before(o.getHappenDate())){
			return 0;
		}else
			return -1;
	}

}
