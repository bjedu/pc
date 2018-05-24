package com.bjedu.common.exception;
public abstract class AbstractRuntimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractRuntimeException(String message) {
		super(message);
	}
	
	public AbstractRuntimeException(String message, Throwable t) {
		super(message, t);
		this.setStackTrace(t.getStackTrace());
	}
	
	public AbstractRuntimeException(Throwable t) {
		super(t);
		this.setStackTrace(t.getStackTrace());
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (this.getCause() != null){
			sb.append(getCause());
			StackTraceElement[] trace = getStackTrace();
			for (StackTraceElement ste : trace){
				sb.append("\n\tat "+ ste);
			}
		}
		return sb.toString();
	}
}