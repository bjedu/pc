package com.bjedu.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class MapUtil {
	public static Map<String, String> getModuleMap(String s) {
		Map<String, String>  modMap = null;
		if (StringHelper.isNotEmpty(s)) {
			modMap = new LinkedHashMap<String, String>();
			String[] mod = s.split(",");
			for (int i = 0; i < mod.length; i++) {
				mod[i] = mod[i].trim();
				modMap.put(mod[i], mod[i]);
			}
		}
		return modMap;
	}
	public static Map.Entry<String, String> getMaxDis(String s) {
		Map<String, String>  modMap = null;
		Map.Entry<String, String> entry = null;
		if (StringHelper.isNotEmpty(s)) {
			modMap = new LinkedHashMap<String, String>();
			String[] mod = s.split(",");
			for (int i = 0; i < mod.length; i+=2) {
				mod[i] = mod[i].trim();
				mod[i+1] = mod[i+1].trim();
				modMap.put(mod[i], mod[i+1]);
			}
			List<Map.Entry<String, String>> lstAdapt = new ArrayList<Map.Entry<String, String>>(modMap.entrySet()); 

			Collections.sort(lstAdapt, new Comparator<Map.Entry<String, String>>() { 
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) { 
					return (o1.getKey().compareTo(o2.getKey())); 
				} 
			}); 
			Collections.sort(lstAdapt, new Comparator<Map.Entry<String, String>>() { 
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) { 
				return (o1.getValue().compareTo(o2.getValue())); 
				} 
			}); 
			entry = lstAdapt.get(0);
		}
		return entry;
	}
	
	public static Map<String, String> getStringMap(String s,String split1,String split2) {
		Map<String, String> modMap = null;
		if (StringHelper.isNotEmpty(s)) {
			modMap = new LinkedHashMap<String, String>();
			String[] mod = s.split(split1);
			for (int i = 0; i < mod.length; i++) {
				mod[i] = mod[i].trim();
				String[] tmp=mod[i].split(split2);
				modMap.put(tmp[0], tmp[1]);
			}
		}
		return modMap;
	}
	
	public static boolean isInMap(Map<String, String> map, String code){
		String[] codes = code.split(",");
		if (codes != null)
			for (String s : codes){
				if (map.containsKey(s)){
					return true;
				}
			}
		return false;
	}

	public static String checkModule(Map<String, String> m, Object key) {
		if (key == null || m == null)
			return null;
		return m.get(key);
	}
}

