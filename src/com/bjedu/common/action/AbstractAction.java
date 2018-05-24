/*
 * Copyright (c) Css Team
 * All rights reserved.
 *
 * This file AbstractAction.java creation date: [2011-5-4 ����10:44:19] by wangjw
 * http://www.css.com.cn
 **/
package com.bjedu.common.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bjedu.configuration.ReturnMessage;
import com.bjedu.util.Ajax;
import com.bjedu.util.ExceptionAnalysis;
import com.bjedu.util.hibernate.HibernateUtil;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;

/**
 * Superclass for Hibernate-aware actions. Demonstrates the use of an XWork IoC
 * component in an Action.
 * 
 * @author jiadawei
 * @version $Id: AbstractAction.java,v 1.1 2010/05/04 02:22:55 wangjw Exp $
 */

@SuppressWarnings("all")
public abstract class AbstractAction extends ActionSupport {
	
	private static Log log = LogFactory.getLog(HibernateUtil.class);

	private String message;

	public String actionName;
	
	protected String result;
	
	protected ReturnMessage msg;

	public String execute() throws Exception {
		try {
			if (hasErrors()) {
				LOG.debug("action not executed, field or action errors");
				LOG.debug("Field errors: " + getFieldErrors());
				LOG.debug("Action errors: " + getActionErrors());
				return INPUT;
			}
			if (LOG.isDebugEnabled()) {
				LOG.debug("executing action");
			}
			String sRet = go();
			return sRet;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			result=Ajax.xmlResult(1, ExceptionAnalysis.analysisStr(e));
			return ERROR;
		} finally {
			//HibernateUtil.closeSession();
		}
	}

	protected abstract String go();

	/**
	 * Get an object from the WebWork user Application
	 */
	protected Object appGet(String name) {
		return ActionContext.getContext().getApplication().get(name);
	}

	/**
	 * Put an object in the WebWork user Application
	 */
	protected void appSet(String name, Object value) {
		ActionContext.getContext().getApplication().put(name, value);
	}

	/**
	 * Put an object in the WebWork user Application
	 */
	protected void appRemove(Object key) {
		Object obj = ActionContext.getContext().getApplication().get(key);
		if (obj != null) {
			obj = null;
			ActionContext.getContext().getApplication().remove(key);
		}
	}

	/**
	 * Get an object from the WebWork user session
	 */
	protected Object get(String name) {
		return ActionContext.getContext().getSession().get(name);
	}

	/**
	 * Put an object in the WebWork user session
	 */
	protected void set(String name, Object value) {
		ActionContext.getContext().getSession().put(name, value);
	}
	

	/**
	 * Put an object in the WebWork user session
	 */
	protected void remove(Object key) {
		ActionContext.getContext().getSession().remove(key);
	}

	/**
	 * @return Returns the sMessage.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            The sMessage to set.
	 */
	public void setMessage(String message) {
		this.message = message;
		ActionContext.getContext().getSession().put("message", message);
	}

	/**
	 * @return Returns the actionName.
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName
	 *            The actionName to set.
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ReturnMessage getMsg() {
		return msg;
	}

	public void setMsg(ReturnMessage msg) {
		this.msg = msg;
	}

	
}
