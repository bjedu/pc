/*
 * Created on 2005-7-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bjedu.util.interceptor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.bjedu.util.RegexCheck;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.AroundInterceptor;
import com.opensymphony.xwork.util.XWorkConverter;
/**
 * @author WangWeidong TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */
public class HtmlInterceptorWL extends AroundInterceptor {
	// ~ Methods
	// ////////////////////////////////////////////////////////////////
	protected void after(ActionInvocation dispatcher, String result) throws Exception {
	}
	protected void before(ActionInvocation invocation) throws Exception {
		if (!(invocation.getAction() instanceof HtmlParameter)) {
			Map parameters = ActionContext.getContext().getParameters();
			if (log.isDebugEnabled()) {
				log.debug("Setting params " + parameters);
			}
			Map tmpMap = new HashMap();
			ActionContext invocationContext = invocation.getInvocationContext();
			try {
				invocationContext.put(XWorkConverter.REPORT_CONVERSION_ERRORS, Boolean.TRUE);
				if (parameters != null) {
					Map fieldMap = HtmlTagParse.getInstance().getFieldNameMap();
					for (Iterator iterator = parameters.keySet().iterator(); iterator.hasNext();) {
						String key = (String) iterator.next();
						String[] value = (String[]) parameters.get(key);
						for (int i = 0; i < value.length; i++) {
							if (parameters.get("postAjax") != null) {
								value[i] = new String(value[i].getBytes("GBK"));
							} else if (parameters.get("getAjax") != null) {
								value[i] = new String(value[i].getBytes("ISO-8859-1"), "utf-8");
							} else {
								value[i] = new String(value[i].getBytes("ISO-8859-1"), "GBK");
							}
							if (fieldMap.size() > 0) {
								if (fieldMap.get(key) == null)
									value[i] = RegexCheck.TagReplace(value[i]);
							}
						}
						tmpMap.put(key, value);
					}
					ActionContext.getContext().setParameters(tmpMap);
				}
			} finally {
				invocationContext.put(XWorkConverter.REPORT_CONVERSION_ERRORS, Boolean.FALSE);
			}
		}
	}
}
