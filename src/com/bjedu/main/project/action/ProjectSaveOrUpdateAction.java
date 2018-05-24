package com.bjedu.main.project.action;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.common.dao.CommonDAO;
import com.bjedu.configuration.Constants;
import com.bjedu.configuration.ReturnMessage;
import com.bjedu.main.model.GUser;
import com.bjedu.main.model.TProject;
import com.bjedu.util.ExceptionAnalysis;
import com.bjedu.util.Messages;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class ProjectSaveOrUpdateAction extends AbstractAction {
	private TProject project;
	
	@Override
	protected String go() {
		// TODO Auto-generated method stub
		msg = new ReturnMessage();
		GUser gUser = (GUser)get(Constants.SESSION_USER);
		if(gUser==null){
			msg.setCode(Constants.R_NOLOG);
			msg.setMsg(Messages.getString("systemMsg.loginFaild"));
			return Action.LOGIN;
		}
		try {
			CommonDAO dao = new CommonDAO();
			dao.saveOrUpdate(project);
			msg.setCode(Constants.R_SUCCESS);
			set(Constants.SESSION_USER,gUser);
		}catch(Exception e) {
			e.printStackTrace();
			msg = ExceptionAnalysis.analysisMsg(e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public TProject getProject() {
		return project;
	}

	public void setProject(TProject project) {
		this.project = project;
	}

}
