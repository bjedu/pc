package com.bjedu.main.user.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.common.dao.CommonDAO;
import com.bjedu.configuration.Constants;
import com.bjedu.configuration.PageResult;
import com.bjedu.main.model.GUser;
import com.bjedu.main.model.TProject;
import com.bjedu.main.model.Workflow;
import com.bjedu.util.JsonUtil;
import com.bjedu.util.Page;
import com.bjedu.util.PageNew;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class UserListAction extends AbstractAction {
	private Page page;
	private PageResult pn;
	private String projectName;

	public UserListAction() {
		// TODO Auto-generated constructor stub
		page = new Page();
		pn = new PageResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected String go() {
		// TODO Auto-generated method stub
		GUser gUser = (GUser)get(Constants.SESSION_USER);
		if(gUser==null){
			return Action.LOGIN;
		}
		try {
			CommonDAO dao = new CommonDAO();
			GUser user = new GUser();
//			if(gUser.getDataLevel()>Constants.MANAGER) {
//				project.setCreateUser(gUser.getUuid());
//			}
			dao.getobjByModel(user, page);
			pn.setTotal(page.getTotalRows());
			pn.setRows(page.getResults());
			return Action.SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public PageResult getPn() {
		return pn;
	}

	public void setPn(PageResult pn) {
		this.pn = pn;
	}

}
