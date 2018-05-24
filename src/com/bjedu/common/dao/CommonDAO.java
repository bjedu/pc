package com.bjedu.common.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bjedu.common.exception.DatabaseException;
import com.bjedu.main.model.BaseModel;
import com.bjedu.util.Page;
import com.bjedu.util.SqlBuilder;
import com.bjedu.util.hibernate.HibernateUtil;

public class CommonDAO {

	@SuppressWarnings("rawtypes")
	public <T extends BaseModel> Boolean getObjByModel(SqlBuilder<T> qt,Page page){
		Session s = null;
		try{
			s = HibernateUtil.currentSession();
			StringBuffer sb = qt.getSb();
			Map<String, Object> map = qt.getMap();
			Query query = s.createQuery(sb.toString()+qt.getOrder());
			Query queryRows = s.createQuery("select count(*) "+sb.toString());
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				Object o = map.get(key);
				if(o instanceof List){
					List ls = (List)o;
					query.setParameterList(key, ls);
					queryRows.setParameterList(key, ls);
				}else{
					query.setParameter(key, o);
					queryRows.setParameter(key, o);
				}
			}
			page.initPage(query, queryRows);
			qt.finish();
			return true;
		}catch(Exception e){
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public <T extends BaseModel> List<T> getObjByModel(SqlBuilder<T> qt){
		Session s = null;
		try{
			s = HibernateUtil.currentSession();
			return getObjByModel(qt,s);
		}catch(Exception e){
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public <T extends BaseModel> List<T> getObjByModel(String pkid,String year,Class<T> clazz){
		try{
			T b = clazz.newInstance();
			b.setCommonP1(pkid);
			b.setCommonP2(year);
			SqlBuilder<T> sb = new SqlBuilder<T>(b);
			return getObjByModel(sb);
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> List<T> getObjByModel(String pkid,String year,Class<T> clazz,Session s){
		try{
			T b = clazz.newInstance();
			b.setCommonP1(pkid);
			b.setCommonP2(year);
			SqlBuilder<T> sb = new SqlBuilder<T>(b);
			return getObjByModel(sb,s);
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> T getObjByModelSig(String pkid,String year,Class<T> clazz){
		try{
			T b = clazz.newInstance();
			b.setCommonP1(pkid);
			b.setCommonP2(year);
			SqlBuilder<T> sb = new SqlBuilder<T>(b);
			List<T> ls = getObjByModel(sb);
			return ls.size()>0?ls.get(0):null;
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> List<T> getobjByModel(T t){
		try{
			SqlBuilder<T> sb = new SqlBuilder<T>(t);
			List<T> ls = getObjByModel(sb);
			return ls;
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> Boolean getobjByModel(T t,Page page){
		try{
			SqlBuilder<T> sb = new SqlBuilder<T>(t);
			return getObjByModel(sb,page);
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> List<T> getobjByModel(T t,Session s){
		try{
			SqlBuilder<T> sb = new SqlBuilder<T>(t);
			List<T> ls = getObjByModel(sb,s);
			return ls;
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> T getobjByModelSig(T t,Session s){
		try{
			SqlBuilder<T> sb = new SqlBuilder<T>(t);
			List<T> ls = getObjByModel(sb,s);
			if (ls != null && ls.size() > 0){
				return ls.get(0);
			}else{
				return null;
			}
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> T getobjByModelSig(T t){
		try{
			SqlBuilder<T> sb = new SqlBuilder<T>(t);
			List<T> ls = getObjByModel(sb);
			if (ls != null && ls.size() > 0){
				return ls.get(0);
			}else{
				return null;
			}
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> T getObjByModelSig(String pkid,String year,Class<T> clazz,Session s){
		try{
			T b = clazz.newInstance();
			b.setCommonP1(pkid);
			b.setCommonP2(year);
			SqlBuilder<T> sb = new SqlBuilder<T>(b);
			return getObjByModel(sb,s).get(0);
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseModel> T getObjByPK(String uuid,Class<T> clazz){
		Session s = null;
		try{
			s = HibernateUtil.currentSession();
			T t = clazz.newInstance();
			String hql = " from "+t.getHQLTable()+" where "+t.getPK()+" = :uuid";
			T t1 = (T)s.createQuery(hql).setParameter("uuid", uuid).uniqueResult();
			return t1;
		}catch(Exception e){
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends BaseModel> T getObjByPK(String uuid,Class<T> clazz,Session s){
		try{
			T t = clazz.newInstance();
			String hql = " from "+t.getHQLTable()+" where "+t.getPK()+" = :uuid";
			T t1 = (T)s.createQuery(hql).setParameter("uuid", uuid).uniqueResult();
			return t1;
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T extends BaseModel> List<T> getObjByModel(SqlBuilder<T> qt,Session s){
		try{
			StringBuffer sb = qt.getSb();
			Map<String, Object> map = qt.getMap();
			Query query = s.createQuery(sb.toString()+qt.getOrder());
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				if(map.get(key) instanceof List){
					query.setParameterList(key, (List)map.get(key));
				}else
					query.setParameter(key, map.get(key));
			}
			List<T> t = query.list();
			qt.finish();
			return t;
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	/**
	 * 閫氳繃浼犲叆瀵硅薄鏌ヨ 锛屼紶鍏ュ璞′腑闇�瑕佽缃煡璇㈡潯浠�
	 * @param <T>
	 * @param model
	 * @param baseModel
	 * @return 缁撴灉闆唖ize
	 */
	@SuppressWarnings("rawtypes")
	public <T extends BaseModel> Integer getCountByModel(SqlBuilder<T> qt){
		Session s = null;
		try{
			s = HibernateUtil.currentSession();
			StringBuffer sb = qt.getSb();
			Map<String, Object> map = qt.getMap();
			Query query = s.createQuery("select count(*) "+sb.toString());
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				if(map.get(key) instanceof List){
					query.setParameterList(key, (List)map.get(key));
				}else
					query.setParameter(key, map.get(key));
			}
			Object t = query.list().get(0);
			qt.finish();
			return Integer.parseInt(t.toString());
		}catch(Exception e){
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public <T extends BaseModel> Integer getCountByModel(SqlBuilder<T> qt,Session s){
		try{
			StringBuffer sb = qt.getSb();
			Map<String, Object> map = qt.getMap();
			Query query = s.createQuery("select count(*) "+sb.toString());
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				if(map.get(key) instanceof List){
					query.setParameterList(key, (List)map.get(key));
				}else
					query.setParameter(key, map.get(key));
			}
			Object t = query.list().get(0);
			qt.finish();
			return Integer.parseInt(t.toString());
		}catch(Exception e){
			throw new DatabaseException(e);
		}
	}
	
	public <T extends BaseModel> void save(T... t){
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.currentSession();
			tx = s.beginTransaction();
			for(T tt:t){
				s.save(tt);
			}
			tx.commit();
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
			}
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public <T extends BaseModel> String saveSig(T t){
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.currentSession();
			tx = s.beginTransaction();
			
			String uuid = (String)s.save(t);
			
			tx.commit();
			return uuid;
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
			}
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public <T extends BaseModel> void saveOrUpdate(T t){
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.currentSession();
			tx = s.beginTransaction();
			
			s.saveOrUpdate(t);
			
			tx.commit();
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
			}
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public <T extends BaseModel> void update(T... t){
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.currentSession();
			tx = s.beginTransaction();
			for(T tt:t){
				s.saveOrUpdate(tt);
			}
			tx.commit();
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
			}
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public <T extends BaseModel> void update(List<T> t){
		Session s = null;
		Transaction tx = null;
		try{
			s = HibernateUtil.currentSession();
			tx = s.beginTransaction();
			for(T tt:t){
				s.saveOrUpdate(tt);
			}
			tx.commit();
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
			}
			throw new DatabaseException(e);
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public <T extends BaseModel> void delete(T... t){
		
	}
}
