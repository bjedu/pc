/*
 * Copyright (c) Css Team
 * All rights reserved.
 *
 * This file Permissions.java creation date: [2009-3-24 ����10:12:22] by jiadawei
 * http://www.css.com.cn
 **/
package com.bjedu.configuration;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bjedu.util.PropertiesHelper;

/**
 * <p>
 * 权限判断操作类
 * </p>
 * 
 * @author jiadawei
 * @version $Id: Permissions.java,v 1.1 2010/01/12 02:22:46 sunxp Exp $
 */
public class Permissions {
	private static final Log logger = LogFactory.getLog(Permissions.class);

	private Properties urlProps = null;

	static private Permissions instance;

	static synchronized public Permissions getInstance() {
		if (instance == null) {
			instance = new Permissions("/permissions.properties");
		}
		return instance;
	}

	/**
	 * Loads module mappings for the system.
	 * 
	 * @param propertiesFile
	 *            The path of file <i>permissions.properties</i> is.
	 */
	protected Permissions(String propertiesFile) {
		InputStream is = getClass().getResourceAsStream(propertiesFile);
		urlProps = new Properties();
		try {
			urlProps.load(is);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * <p>
	 * 根据关键字获取配置文件中对应的功能ID
	 * </p>
	 * 
	 * @param key
	 *            关键字
	 * @return String 功能ID
	 */
	public String getFuncValue(String key) {
		return PropertiesHelper.getString(key, urlProps, "");
	}

	/**
	 * <p>
	 * 根据关键字获取配置文件中对应的功能ID
	 * </p>
	 * 
	 * @param key
	 *            关键字
	 * @param defaultValue
	 *            返回默认值
	 * @return String 功能ID
	 */
	public String getFuncValue(String key, String defaultValue) {
		return PropertiesHelper.getString(key, urlProps, defaultValue);
	}

	/**
	 * <p>
	 * 根据URL获取配置文件中对应的功能ID
	 * </p>
	 * 
	 * @param requestUrl
	 *            请求URL
	 * @param contextPath
	 * @param extension
	 *            系统扩展名
	 * @return String 功能ID
	 */
	public String getFuncValueByUrl(String requestUrl, String contextPath,
			String extension) {
		String key = extractRequestUrl(requestUrl, contextPath, extension);
		return getFuncValue(key);
	}

	/**
	 * <p>
	 * 格式化请求URL
	 * </p>
	 * 
	 * @param requestUrl
	 *            请求URL
	 * @param contextPath
	 * @param extension
	 *            系统扩展名
	 * @return String URL关键字
	 */
	public String extractRequestUrl(String requestUrl, String contextPath,
			String extension) {
		if (contextPath != null) {
			if (requestUrl.startsWith(contextPath + "/")) {
				requestUrl = requestUrl.substring(contextPath.length() + 1,
						requestUrl.length()).replace(extension, "");
			}
			requestUrl = requestUrl.replaceAll("/", ".");
		} else {
			if (requestUrl.startsWith("/")) {
				requestUrl = requestUrl.substring(1, requestUrl.length())
						.replace(extension, "");
			}
			requestUrl = requestUrl.replaceAll("/", ".");
		}
		return requestUrl;
	}

	/**
	 * <p>
	 * 进行权限判断
	 * </p>
	 * 
	 * @param request
	 * @param funcValue
	 *            功能ID
	 * @return boolean 是否具有权限，true为是，false为否
	 */
	public boolean getAuth(HttpServletRequest request, String funcValue) {
		boolean flag = false;
		if (funcValue != null && !funcValue.equals("")) {
			if (funcValue.equals("nologin")) {
				return true;
			}
			if (request.getSession()
					.getAttribute(Environment.SESSION_LOGIN_USER) == null) {
				return false;
			}
			if (funcValue.equals("all")) {
				return true;
			} else {
				String roleFuncs = (String) request.getSession().getAttribute(
						Environment.SESSION_ROLE_KEY);
				if (roleFuncs != null && roleFuncs.indexOf(funcValue) != -1) {
					flag = true;
				}
			}
		}
		return flag;
	}
}
