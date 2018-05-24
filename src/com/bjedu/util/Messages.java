/*
 * Created on 2005-7-16
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bjedu.util;

import java.text.MessageFormat;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Administrator TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */
public class Messages {
  private static final String BUNDLE_NAME = "com/bjedu/util/messages";//$NON-NLS-1$
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

  private Messages() {}

  public static String getString(String key) {
    // TODO Auto-generated method stub
    try {
      return RESOURCE_BUNDLE.getString(key);
    }
    catch (MissingResourceException e) {
    	e.printStackTrace();
      return '!' + key + '!';
    }
  }

  public static String getString(String key, String[] paras) {
    // TODO Auto-generated method stub
    try {
      String message = RESOURCE_BUNDLE.getString(key);
      return MessageFormat.format(message, paras);
    }
    catch (MissingResourceException e) {
      return '!' + key + '!';
    }
  }

  public static String getString(String key, List arg) {
    // TODO Auto-generated method stub
    try {
      if (!arg.isEmpty()) {
        String[] paras = new String[arg.size()];
        for (int i = 0; i < arg.size(); i++)
          paras[i] = (String) arg.get(i);
        return getString(key, paras);
      }
      return "";
    }
    catch (MissingResourceException e) {
      return '!' + key + '!';
    }
  }
}
