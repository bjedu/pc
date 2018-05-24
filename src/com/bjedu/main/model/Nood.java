package com.bjedu.main.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Nood implements Serializable,BaseModel {
	private String uuid;//主键
	private String nameN;//节点名称
	private String iwfId;//流程id
	private Integer noodNo;//节点编号
	private String nextId;//下个节点id
	private String perId;//上个节点id
	private String noodType;//节点类型
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getNameN() {
		return nameN;
	}
	public void setNameN(String nameN) {
		this.nameN = nameN;
	}
	public Integer getNoodNo() {
		return noodNo;
	}
	public void setNoodNo(Integer noodNo) {
		this.noodNo = noodNo;
	}
	public String getNextId() {
		return nextId;
	}
	public void setNextId(String nextId) {
		this.nextId = nextId;
	}
	public String getPerId() {
		return perId;
	}
	public void setPerId(String perId) {
		this.perId = perId;
	}
	public String getIwfId() {
		return iwfId;
	}
	public void setIwfId(String iwfId) {
		this.iwfId = iwfId;
	}
	@Override
	public String getHQLTable() {
		// TODO Auto-generated method stub
		return "Nood";
	}
	@Override
	public String getPK() {
		// TODO Auto-generated method stub
		return "uuid";
	}
	@Override
	public String getSQLTable() {
		// TODO Auto-generated method stub
		return "edu_nood";
	}
	@Override
	public Integer getFid() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCommonP1(String p1) {
		// TODO Auto-generated method stub
		this.iwfId = p1;
	}
	@Override
	public void setCommonP2(String p2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getCommonP1() {
		// TODO Auto-generated method stub
		return this.iwfId;
	}
	@Override
	public String getCommonP2() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getNoodType() {
		return noodType;
	}
	public void setNoodType(String noodType) {
		this.noodType = noodType;
	}
}
