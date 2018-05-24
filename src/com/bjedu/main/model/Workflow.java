package com.bjedu.main.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Workflow implements Serializable,BaseModel{
	private String uuid;//主键
	private String nameW;//流程名称
	private String describe;//流程描述
	private String owner;//创建人
	private String onFlag;//启用标志
	private Integer nodeNum;//节点数量
	private String states;//流程状态（公开/私有）
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getNameW() {
		return nameW;
	}
	public void setNameW(String nameW) {
		this.nameW = nameW;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOnFlag() {
		return onFlag;
	}
	public void setOnFlag(String onFlag) {
		this.onFlag = onFlag;
	}
	public Integer getNodeNum() {
		return nodeNum;
	}
	public void setNodeNum(Integer nodeNum) {
		this.nodeNum = nodeNum;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String getHQLTable() {
		// TODO Auto-generated method stub
		return "Workflow";
	}
	@Override
	public String getPK() {
		// TODO Auto-generated method stub
		return "uuid";
	}
	@Override
	public String getSQLTable() {
		// TODO Auto-generated method stub
		return "edu_workflow";
	}
	@Override
	public Integer getFid() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCommonP1(String p1) {
		// TODO Auto-generated method stub
		this.onFlag = p1;
	}
	@Override
	public void setCommonP2(String p2) {
		// TODO Auto-generated method stub
		this.states = p2;
	}
	@Override
	public String getCommonP1() {
		// TODO Auto-generated method stub
		return this.onFlag;
	}
	@Override
	public String getCommonP2() {
		// TODO Auto-generated method stub
		return this.states;
	}

}
