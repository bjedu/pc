package com.bjedu.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConfigurationReader {
	
	private static final String PROPERTY_DOC = "appconfig";
	private static PropertyResourceBundle configBundle;

	public static String readProp(String name) {
		if (configBundle == null)
			configBundle = (PropertyResourceBundle) ResourceBundle
					.getBundle(PROPERTY_DOC);
		return configBundle.getString(name).trim();
	}
	
	public static String readProp(String name, String defaultvalue) {
		if (configBundle == null)
			configBundle = (PropertyResourceBundle) ResourceBundle
					.getBundle(PROPERTY_DOC);
		String res = null;
		try {
			res = configBundle.getString(name);
		} catch (Exception e) {
			res = null;
		}
		if (res == null)
			return defaultvalue;
		else
			return res;
	}
	
	public static String readProp(String name, String name2, String defaultvalue) {
		String res = readProp(name, null);
		if (res != null)
			return res;
		return readProp(name2, defaultvalue);
	}
	
}
