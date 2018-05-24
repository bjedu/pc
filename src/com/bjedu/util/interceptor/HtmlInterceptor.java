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

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.AroundInterceptor;
import com.opensymphony.xwork.util.XWorkConverter;

/**
 * @author WangWeidong TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */
public class HtmlInterceptor extends AroundInterceptor {
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
//						System.out.println("key:"+key+";value:"+value);
						for (int i = 0; i < value.length; i++) {
							if (parameters.get("postAjax") != null || parameters.get("getAjax") != null || "BJCA_TICKET".equals(key) ) {
//								if ("BJCA_TICKET".equals(key)) {
//									String fromCAString = value[i];
//									String chulihouStr = new String(value[i].getBytes("ISO-8859-1"), "UTF-8");
//									String chulihouStr2 = new String(value[i].getBytes("ISO-8859-1"), "GBK");
//									String chulihouStr3 = new String(value[i].getBytes("GBK"), "UTF-8");
//									System.out.println("fromCAString-------------------------->>" + fromCAString);
//									System.out.println("chulihouStr---------iso->utf8----------------->>" + chulihouStr);
//									System.out.println("chulihouStr2---------iso->gbk----------------->>" + chulihouStr2);
//									System.out.println("chulihouStr3---------gbk->utf----------------->>" + chulihouStr3);
//								}
								value[i] = new String(value[i].getBytes("ISO-8859-1"), "UTF-8");
							} else {
								if ("BJCA_TICKET".equals(key)) {
								}else{
								value[i] = new String(value[i].getBytes("ISO-8859-1"), "UTF-8");
								}
							}
//							if (fieldMap.size() > 0) {
//								if (fieldMap.get(key) == null)
//									value[i] = RegexCheck.TagReplace(value[i]);
////								System.out.println("key:"+key+";TagReplacevalue:"+value[i]);
//							}
//							
//							if(!CheckCode.checkStr(value[i])){
//								value[i] = RegexCheck.sqltonohtml(value[i]);
//							}
							value[i] = value[i].trim();
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
