package com.bjedu.main.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TProject implements Serializable,BaseModel {
	private String uuid;
	private String projectName;
	private Date createTime;
	private String projectManager;
	private String createUser;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	@Override
	public String getHQLTable() {
		// TODO Auto-generated method stub
		return "TProject";
	}
	@Override
	public String getPK() {
		// TODO Auto-generated method stub
		return "uuid";
	}
	@Override
	public String getSQLTable() {
		// TODO Auto-generated method stub
		return "t_project";
	}
	@Override
	public Integer getFid() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCommonP1(String p1) {
		// TODO Auto-generated method stub
		this.projectName = p1;
	}
	@Override
	public void setCommonP2(String p2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getCommonP1() {
		// TODO Auto-generated method stub
		return this.projectName;
	}
	@Override
	public String getCommonP2() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
}
