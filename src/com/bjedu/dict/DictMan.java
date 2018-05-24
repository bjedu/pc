/*
 * Created on 2006-1-25
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bjedu.dict;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bjedu.common.exception.DatabaseException;
import com.bjedu.util.StringHelper;
import com.bjedu.util.hibernate.HibernateUtil;


import edu.emory.mathcs.backport.java.util.Collections;

/**
 * @author Administrator TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */

@SuppressWarnings("all")
public class DictMan {
	
	private static Log log = LogFactory.getLog(DictMan.class);
	
	public static final String CahceName = "DictionaryCache";
	/**
	 * 用于查询某个字典中全部的数据。如果需要提交时不带条件的查询方法请查找--getDictListSel
	 * @param table
	 * @return list lstRes
	 */
	public static List getDictType(String table) {
		List listRes = null;
		if (StringHelper.isNotEmpty(table)) {
			listRes = (List) DictCache.getInstance().getMapDict().get(CahceName + table);
			if (listRes == null) {
				listRes = getDictList(table);
				DictCache.getInstance().getMapDict().put(CahceName + table, listRes);
			}
		}
		return listRes;
	}
	
	//added by mengqw=============当前审核情况时使用==================
	/**
	 * 用于查询区县字典表中各区县的数据，按orderid进行排序---20151228
	 * @param table
	 * @return list lstRes
	 */
	public static List getShqy(String table) {
		List listRes = null;
		if (StringHelper.isNotEmpty(table)) {
			listRes = getDictListShqy(table);
			DictCache.getInstance().getMapDict().put(CahceName + table, listRes);
		}
		return listRes;
	}
	public static List getDictListShqy(String table) {
		Session s = HibernateUtil.currentSession();
		try {
			String sql = "select {type.*}  from " + table + " type where type.remark<>'0' order by type.orderid"; 			
			List listRes = s.createSQLQuery(sql).addEntity(
					"type", DictType.class).list();
			return listRes;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	//====================end added by mengqw==========================================
	
	public static List getDictList(String table) {
		Session s = HibernateUtil.currentSession();
		try {
			String sql = "select {type.*}  from " + table + " type order by type.code"; 			
			List listRes = s.createSQLQuery(sql).addEntity(
					"type", DictType.class).list();
			return listRes;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public static List getDictListDesc(String table) {
		Session s = HibernateUtil.currentSession();
		try {
			List listRes = s.createSQLQuery("select {type.*}  from " + table + " type order by type.code desc").addEntity(
					"type", DictType.class).list();
			return listRes;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public static Map getDictMap(String table) {
		Map mapDict = new HashMap();
		try {
			Iterator iter = getDictType(table).iterator();
			while (iter.hasNext()) {
				DictType dictType = (DictType) iter.next();
				mapDict.put(dictType.getCode(), dictType);
			}
			return mapDict;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return null;
		}
	}
	
	public static DictType getDictType(String table, int iValue) {
		String value = iValue + "";
		return getDictType(table, value);
	}

	public static DictType getDictType(String table, String value) {
		DictType dictType = null;
		if (StringHelper.isNotEmpty(value)) {
			Map mapDict = (Map) DictCache.getInstance().getMapDict().get(table);
			if (mapDict == null) {
				mapDict = getDictMap(table);
				DictCache.getInstance().getMapDict().put(table, mapDict);
			}
			dictType = (DictType) mapDict.get(value);
		}
		if (dictType == null) 
			dictType = new DictType();
		return dictType;
	}
	
	public static DictType getDictTypeNull(String table, String value) {
		DictType dictType = null;
		if (StringHelper.isNotEmpty(value)) {
			Map mapDict = (Map) DictCache.getInstance().getMapDict().get(table);
			if (mapDict == null) {
				mapDict = getDictMap(table);
				DictCache.getInstance().getMapDict().put(table, mapDict);
			}
			dictType = (DictType) mapDict.get(value);
		}
		return dictType;
	}
	
	public static void clearAll() {
		DictCache.getInstance().getMapDict().clear();
	}
	/**
	 * 在getDictType(string table)上添加一个“请选择”条目，该条目中没有任何数据，在jsp中使用可以避免每次提交表单带有数据的情况。
	 * @param table
	 * @return list lstRes
	 */
	public static List getDictListSel(String table) {
		List dict = getDictType(table);
		List lstRes = new ArrayList();
		DictType dictType = new DictType();
		dictType.setName("请选择");
		lstRes.add(dictType);
		lstRes.addAll(dict);
		return lstRes;
	}
	
	
	public static void clearUserAll() {
		DictCache.getInstance().getMapDict().remove("D_USER");
		DictCache.getInstance().getMapDict().remove(CahceName+"D_USER");
		DictCache.getInstance().getMapDict().remove("d_user");
		DictCache.getInstance().getMapDict().remove(CahceName+"d_user");
	}
	
	
	public static List<DictType> listCopy(List<DictType> src){
		List desc = new ArrayList<DictType>();
		for(DictType dict:src){
			desc.add(dict);
		}
		return desc;
	}

	public static DictType getDictDescType(String table, String value) {
		DictType dictType = null;
		table = "dsc"+table;
		if (StringHelper.isNotEmpty(value)) {
			Map mapDict = (Map) DictCache.getInstance().getMapDict().get(table);
			if (mapDict == null) {
				mapDict = getMapFromDescList(table.substring(3, table.length()));
				DictCache.getInstance().getMapDict().put(table, mapDict);
			}
			dictType = (DictType) mapDict.get(value);
		}
		if (dictType == null) 
			dictType = new DictType();
		return dictType;
	}
	
	public static Map getMapFromDescList(String table) {
		Map mapDict = new HashMap();
		try {
			Iterator iter = getDictType(table).iterator();
			while (iter.hasNext()) {
				DictType dictType = (DictType) iter.next();
				mapDict.put(dictType.getName(), dictType);
			}
			return mapDict;
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return null;
		}
	}
	
	public static boolean resetUserList(String table,DictType dictType){
		if(dictType == null)
			return false;
		DictType type = getDictTypeNull(table,dictType.getCode());
		if(type == null){
			List listRes = null;
			listRes = getDictType(table);
			listRes.add(dictType);
			DictCache.getInstance().getMapDict().put(CahceName + table, listRes);
			Map mapDict = getDictMap(table);
			mapDict.put(dictType.getCode(), dictType);
			DictCache.getInstance().getMapDict().put(table, mapDict);
		}
		return true;
	}
	
	public static boolean resetDUser(){
		clearUserAll();
		List listRes = null;
		listRes = getDictType("d_user");
		DictCache.getInstance().getMapDict().put(CahceName + "d_user", listRes);
		Map mapDict = getDictMap("d_user");
		DictCache.getInstance().getMapDict().put("d_user", mapDict);
		return true;
	}
	/**
	 * 用来查询有字典表，有条件的方法。如果需要提交时不带参数的方法请查找--getUserListSlDq
	 * @param table
	 * @param localid
	 * @return list lstRes
	 */
	public static List getUserListDqlocalid(String table,String localid) {
		List<DictType> dictList = getDictType(table);
		List<DictType> lstRes = new ArrayList<DictType>();
		//modified by wbb 20140709 为了查询审核人时按客户要求的北京市就选市级
		if (table.trim().toLowerCase().equals("d_user")){
			for (DictType dict : dictList) {
				if (dict.getRemark().equals(localid)) {
					lstRes.add(dict);
				}
			}
			
		}else{
			if (localid.equals("110000")) {
				lstRes = listCopy(dictList);
				return lstRes;
			}else {
				for (DictType dict : dictList) {
					if (dict.getRemark().equals(localid)) {
						lstRes.add(dict);
					}
				}
			}
		}
		//end
		return lstRes;
	}
	
	/**
	 * 在getUserListDqlocalid基础上添加了一个“请选择”条目，该条目中没有任何值，在jsp中使用避免每次提交表单带有数据。
	 * @param table
	 * @param localid
	 * @return list lstRes
	 */
	public static List getUserListSlDq(String table,String localid) {
		List<DictType>  dict = getUserListDqlocalid(table,localid);
		if(dict.size() ==1){
			return dict;
		}
		List<DictType>  lstRes  = new ArrayList<DictType>();
		DictType dictType = new DictType();
		dictType.setName("请选择");
		lstRes.add(dictType);
		lstRes.addAll(dict);
		return lstRes;
	}
	
	
	
	public static DictType getUser(String table, String value) {
		DictType dictType = null;
		if (StringHelper.isNotEmpty(value)) {
			Map mapDict = (Map) DictCache.getInstance().getMapDict().get(table);
			if (mapDict == null) {
				mapDict = getDictMap(table);
				DictCache.getInstance().getMapDict().put(table, mapDict);
			}
			dictType = (DictType) mapDict.get(value);
		}
		if (dictType == null) 
			dictType = new DictType(value,value);
		return dictType;
	}
	
}
