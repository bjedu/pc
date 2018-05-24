/*
 * Copyright (c) Css Team
 * All rights reserved.
 *
 * This file DateBaseException.java creation date: [2009-3-20 ����10:17:58] by jiadawei
 * http://www.css.com.cn
 **/
package com.bjedu.common.exception;

/** 
 * <p>datebase exception</p>
 * 
 * @author wangjw
 * @version 1.0, 2011/05/04
 */


public class DatabaseException extends RuntimeException {
	
	private static final long serialVersionUID = 10L;
	
	public DatabaseException(String message) {
		super(message);
	}
	
	public DatabaseException(String message, Throwable t) {
		super(message, t);
		this.setStackTrace(t.getStackTrace());
	}
	
	public DatabaseException(Throwable t) {
		super(t);
		this.setStackTrace(t.getStackTrace());
	}
	
}

