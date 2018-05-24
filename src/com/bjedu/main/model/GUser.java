package com.bjedu.main.model;


@SuppressWarnings("serial")
public class GUser implements java.io.Serializable,BaseModel {
	private String uuid; 
	private String loginName;
	private String realName;
	private String password;
	private String roleId;
	private Integer dataLevel;
	private Integer userLevel;
	private Integer userGroup;
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public String getHQLTable() {
		// TODO Auto-generated method stub
		return "GUser";
	}
	@Override
	public String getPK() {
		// TODO Auto-generated method stub
		return "uuid";
	}
	@Override
	public String getSQLTable() {
		// TODO Auto-generated method stub
		return "g_user";
	}
	@Override
	public Integer getFid() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCommonP1(String p1) {
		// TODO Auto-generated method stub
		this.loginName = p1;
	}
	@Override
	public void setCommonP2(String p2) {
		// TODO Auto-generated method stub
		this.password = p2;
	}
	@Override
	public String getCommonP1() {
		// TODO Auto-generated method stub
		return this.loginName;
	}
	@Override
	public String getCommonP2() {
		// TODO Auto-generated method stub
		return this.password;
	}
	public Integer getDataLevel() {
		return dataLevel;
	}
	public void setDataLevel(Integer dataLevel) {
		this.dataLevel = dataLevel;
	}
	public Integer getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	public Integer getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(Integer userGroup) {
		this.userGroup = userGroup;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
