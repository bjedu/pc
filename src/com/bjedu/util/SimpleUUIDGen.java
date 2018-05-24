package com.bjedu.util;
/**
 *@create data: Sep 6, 2007
 *@version: 1.0.2
 *@creator: shenhc 
 */
public class SimpleUUIDGen implements UUIDGen {
	public SimpleUUIDGen() {
		super();
	}
	public void init() {

	}

	public void destroy() {
	}

	public String nextUUID() {
		UUID src=UUID.randomUUID();
		String uuid=src.toString();		
		return uuid.replaceAll("-","");
	}


}
