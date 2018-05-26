package com.bjedu.main.user.action;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.common.dao.CommonDAO;
import com.bjedu.configuration.Constants;
import com.bjedu.main.model.GUser;
import com.bjedu.main.model.TProject;
import com.bjedu.util.ExceptionAnalysis;
import com.bjedu.util.StringHelper;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class UserEditAction extends AbstractAction {
	private String uuid;
	private TProject project;

	public UserEditAction() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String go() {
		// TODO Auto-generated method stub
		GUser gUser = (GUser)get(Constants.SESSION_USER);
		if(gUser==null){
			return Action.LOGIN;
		}
		try {
			CommonDAO dao = new CommonDAO();
			if(StringHelper.isNotEmpty(uuid))
				project = dao.getObjByPK(uuid, TProject.class);
			else 
				project = new TProject();
			return Action.SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			msg = ExceptionAnalysis.analysisMsg(e);
			return Action.ERROR;
		}
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public TProject getProject() {
		return project;
	}

	public void setProject(TProject project) {
		this.project = project;
	}

	
}
