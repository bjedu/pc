package com.bjedu.main.login.action;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.configuration.Constants;
import com.bjedu.main.model.GUser;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class HelloAction extends AbstractAction {
	@Override
	protected String go() {
		// TODO Auto-generated method stub
//		LoginDAO dao = new LoginDAO();
		GUser gUser = (GUser)get(Constants.SESSION_USER);
		if(gUser==null){
			//msg.setCode(Constants.R_NOLOG);
			//msg.setMsg(Messages.getString("systemMsg.loginFaild"));
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

}
