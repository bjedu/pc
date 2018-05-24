package com.bjedu.common.exception;

import com.bjedu.configuration.Constants;

public class ActionException extends AbstractRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionException(String message, Throwable t) {
		super(message, t);
	}

	public ActionException(String message) {
		super(message);
	}

	public ActionException(Throwable t) {
		super(Constants.EXCEPTION_ACTION, t);
	}
}
