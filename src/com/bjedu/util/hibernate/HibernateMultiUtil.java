/*
 * Created on 2005-8-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bjedu.util.hibernate;

/**
 * @author Administrator TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("all")
public class HibernateMultiUtil {
	
	private static Log log = LogFactory.getLog(HibernateMultiUtil.class);
	
	private static final Map mapSessionFactory = new HashMap();
	
	public static final ThreadLocal session = new ThreadLocal();
	
	public static synchronized Session currentSession(String mapping) {
		try {
			SessionFactory sessionFactory = (SessionFactory) mapSessionFactory.get(mapping);
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure(mapping).buildSessionFactory();
				if (sessionFactory != null)
					mapSessionFactory.put(mapping, sessionFactory);
			}
			Session s = sessionFactory.openSession();
			if (s == null) {
				sessionFactory.close();
				mapSessionFactory.remove(mapping);
			}
			return s;
		} catch (Throwable ex) {
			log.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void closeSession(Session s) {
		if (s != null) {
			s.close();
			s = null;
		}
	}
	
}
