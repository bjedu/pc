package com.bjedu.main.login.action;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.configuration.Constants;
import com.bjedu.configuration.ReturnMessage;
import com.bjedu.main.login.dao.LoginDAO;
import com.bjedu.main.model.GUser;
import com.bjedu.util.Messages;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class LoginAction extends AbstractAction {
	private String loginname;
	private String password;

	@Override
	protected String go() {
		// TODO Auto-generated method stub
		msg = new ReturnMessage();
		LoginDAO dao = new LoginDAO();
		GUser gUser = dao.getObjByModelSig(loginname, password, GUser.class);
		if(gUser==null){
			msg.setCode(Constants.R_NOLOG);
			msg.setMsg(Messages.getString("systemMsg.loginFaild"));
			return Action.ERROR;
		}
		msg.setCode(Constants.R_SUCCESS);
		set(Constants.SESSION_USER,gUser);
		return Action.SUCCESS;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
