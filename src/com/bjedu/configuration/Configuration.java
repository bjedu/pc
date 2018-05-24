/*
 * Copyright (c) Css Team
 * All rights reserved.
 *
 * This file DataAccessDriver.java creation date: [2009-3-26 上午11:24:05] by jiadawei
 * http://www.css.com.cn
 **/
package com.bjedu.configuration;

import java.io.InputStream;
import java.util.Properties;

import com.bjedu.util.PropertiesHelper;

/**
 * <p>
 * sysmgr config operation class
 * </p>
 * 
 * @author jiadawei
 * @version $Id: Configuration.java,v 1.1 2010/01/12 02:22:46 sunxp Exp $
 */
public class Configuration {
	private static Configuration instance;
	private String confPath, cacheObj, rolesCache,funcsCache,cacheableObjects,extension;
	private int sys_pageSize, cacheUpdateTime, sys_weblogic, nciicPublic;
	private boolean cacheUpdate, debug;
	static{
		if (instance == null) {
			instance = new Configuration("/config.properties");
		}
	}
	
	public static Configuration getInstance() {
		return instance;
	}
	
	protected Configuration(String propertiesFile) {
		InputStream fin = getClass().getResourceAsStream(propertiesFile);
		Properties dbProps = new Properties();
		try {
			dbProps.load(fin);
			//缓存配置文件路径
			this.confPath = PropertiesHelper.getString("cache.conf.path", dbProps, "");
			//缓存实现对象
			this.cacheObj = PropertiesHelper.getString("cache.cacheObj", dbProps, "");
			//角色缓存关键字
			this.rolesCache = PropertiesHelper.getString("cache.rolesCache", dbProps, "");
			//功能缓存关键字			
			this.funcsCache = PropertiesHelper.getString("cache.funcsCache", dbProps, "");
			//缓存定时更新是否启用			
			this.cacheUpdate = PropertiesHelper.getBoolean("cache.cacheUpdate", dbProps, false);
			//缓存更新时间			
			this.cacheUpdateTime = PropertiesHelper.getInt("cache.cacheUpdateTime", dbProps, 10);
			//对象缓存实现类
			this.cacheableObjects = PropertiesHelper.getString("cache.objects", dbProps, "");
			//对象是否为调试状态		
			this.debug = PropertiesHelper.getBoolean("cache.debug", dbProps, false);
			//系统默认每页显示条数
			this.sys_pageSize = PropertiesHelper.getInt("sys.pageSize", dbProps, 10);
			//系统是否使用Weblogic
			this.sys_weblogic = PropertiesHelper.getInt("sys.weblogic", dbProps, 1);
			//系统使用扩展名
			this.extension = PropertiesHelper.getString("sys.extension", dbProps, ".action");
			this.nciicPublic = PropertiesHelper.getInt("sys.nciicPublic", dbProps, 0);
			fin.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/**
	 * @return the rolesCache
	 */
	public String getRolesCache() {
		return rolesCache;
	}
	/**
	 * @return the funcsCache
	 */
	public String getFuncsCache() {
		return funcsCache;
	}

	/**
	 * @return the cacheObj
	 */
	public String getCacheObj() {
		return cacheObj;
	}

	public int getSys_pageSize() {
		return sys_pageSize;
	}
	public boolean isCacheUpdate() {
		return cacheUpdate;
	}
	public int getCacheUpdateTime() {
		return cacheUpdateTime;
	}
	public boolean isDebug() {
		return debug;
	}
	public int getSys_weblogic() {
		return sys_weblogic;
	}
	/**
	 * @return the cacheableObjects
	 */
	public String getCacheableObjects() {
		return cacheableObjects;
	}
	/**
	 * @param cacheableObjects the cacheableObjects to set
	 */
	public void setCacheableObjects(String cacheableObjects) {
		this.cacheableObjects = cacheableObjects;
	}
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * @return the confPath
	 */
	public String getConfPath() {
		return confPath;
	}

	/**
	 * @return the nciicPublic
	 */
	public int getNciicPublic() {
		return nciicPublic;
	}
}