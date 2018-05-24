package com.bjedu.util;

import java.lang.reflect.Method;
import java.util.Date;

public class CopyUtil {
	/**
	 * 
	 * @param o1
	 * @param o2
	 */
	@SuppressWarnings("unchecked")
	public static void copy(Object newObj,Object oldObj) throws Exception{
		Class c = newObj.getClass();
		Method[] ms = c.getMethods();
		for(int i=0;i<ms.length;i++){
			Method m = ms[i];
			if(m.getName().startsWith("set")){
				Class[] ccs = m.getParameterTypes();
				String strN = "get"+m.getName().substring(3,m.getName().length());
				Method getP = oldObj.getClass().getMethod(strN, null);
				Object o = getP.invoke(oldObj, null);
				if(o!=null){
					m.invoke(newObj, ccs[0].cast(o));
				}
			}
		}
	}
}
