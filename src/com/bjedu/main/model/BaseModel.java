package com.bjedu.main.model;

public interface BaseModel {
	String getHQLTable();
	String getPK();
	String getSQLTable();
	String getUuid();
	Integer getFid();
	
	void setCommonP1(String p1);
	void setCommonP2(String p2);
	String getCommonP1();
	String getCommonP2();
}
