/*
 * Created on 2005-7-29
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bjedu.util.interceptor;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author WangWeidong
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class HtmlTagParse {
  private static final Log log = LogFactory.getLog(HtmlTagParse.class);
  private static HtmlTagParse instance;
  private static Map fieldNameMap = new HashMap();

  
  public static synchronized HtmlTagParse getInstance() {
    try {
      if (instance == null) {
        instance = new HtmlTagParse();
        readXmlFile("/htmltag.xml");
      } else {
        return instance;
      }
    } catch (Exception e) {
      log.error("HtmlTagParse::getInstance:" + e.getMessage());
      instance = null;
    }
    return instance;
  }

  protected static void readXmlFile(String fileName) throws Exception {
    Document doc;
    fieldNameMap.clear();
    SAXReader sax = new SAXReader();
    InputStream cfgIn = getConfigurationInputStream(fileName);
    if (cfgIn == null)
      return;
    doc = sax.read(cfgIn);
    Iterator iter = doc.getRootElement().elementIterator("field");
    while (iter.hasNext()) {
      String fieldName = ((Element) iter.next()).attribute("name").getText();
      fieldNameMap.put(fieldName, fieldName);
    }
    if(cfgIn!=null){
    	cfgIn.close();
    }
  }

  public Map getFieldNameMap() {
    return fieldNameMap;
  }

  /**
   * Get the configuration file as an <tt>InputStream</tt>. Might be
   * overridden by subclasses to allow the configuration to be located by some
   * arbitrary mechanism.
   */
  protected static InputStream getConfigurationInputStream(String resource) {
    log.debug("Configuration resource: " + resource);
    InputStream stream = HtmlTagParse.class.getResourceAsStream(resource);
    if (stream == null)
      stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
    return stream;
  }
}
