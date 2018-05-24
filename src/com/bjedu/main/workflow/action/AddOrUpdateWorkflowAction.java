package com.bjedu.main.workflow.action;

import net.sf.json.JSONArray;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.configuration.Constants;
import com.bjedu.configuration.ReturnMessage;
import com.bjedu.main.model.GUser;
import com.bjedu.main.model.Workflow;
import com.bjedu.main.workflow.dao.WorkflowDAO;
import com.bjedu.util.ExceptionAnalysis;
import com.bjedu.util.Messages;
import com.bjedu.util.StringHelper;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class AddOrUpdateWorkflowAction extends AbstractAction {
	private Workflow workflow;

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
		try{
			WorkflowDAO dao = new WorkflowDAO();
			if(workflow!=null&&StringHelper.isNotEmpty(workflow.getUuid())){
				Workflow temp = dao.getObjByPK(workflow.getUuid(), Workflow.class);
				temp.setNameW(workflow.getNameW());
				temp.setDescribe(workflow.getDescribe());
				temp.setOwner(gUser.getUuid());
				temp.setStates(workflow.getStates());
				dao.update(temp);
			}else{
				workflow.setOwner(gUser.getUuid());
				workflow.setOnFlag("0");
				String uuid = dao.saveSig(workflow);
				workflow.setUuid(uuid);
			}
			msg.setCode(Constants.R_SUCCESS);
			msg.setMsg(Messages.getString("systemMsg.success"));
			msg.setJson(JSONArray.fromObject(workflow).toString());
		}catch(Exception e){
			e.printStackTrace();
			msg = ExceptionAnalysis.analysisMsg(e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}
