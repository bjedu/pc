package com.bjedu.util;


public class LocalUtil {
	public static String getLocalid (String Localid,int i){
		String retLocalid ="" ;
		switch(i){
			case 1:
				retLocalid = Localid.substring(0,i*2);
				break;
			case 2:
				retLocalid = Localid.substring(0,i*2);
				break;
			default:
				retLocalid  = Localid;
		}
		return retLocalid;
	}
	
	public static Integer getLocalidLevel (String Localid){
		Integer iLocalid = Integer.valueOf(Localid);
		Integer cityLevel = 1;
		if(iLocalid % 10000 ==0 ){
			cityLevel =0;
		}
		return cityLevel;
	}
}

