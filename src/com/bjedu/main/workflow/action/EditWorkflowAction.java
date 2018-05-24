package com.bjedu.main.workflow.action;

import java.util.ArrayList;
import java.util.List;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.configuration.Constants;
import com.bjedu.main.model.GUser;
import com.bjedu.main.model.Nood;
import com.bjedu.main.model.Workflow;
import com.bjedu.main.workflow.dao.WorkflowDAO;
import com.bjedu.util.ExceptionAnalysis;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class EditWorkflowAction extends AbstractAction {
	private String uuid;
	private Workflow workflow;
	private List<Nood> ls = new ArrayList<Nood>();
	
	public EditWorkflowAction() {
		
	}
	
	@Override
	protected String go() {
		// TODO Auto-generated method stub
		GUser gUser = (GUser)get(Constants.SESSION_USER);
		if(gUser==null){
			return Action.LOGIN;
		}
		try{
			WorkflowDAO dao = new WorkflowDAO();
			workflow = dao.getObjByPK(uuid, Workflow.class);
			for(int i=0;i<workflow.getNodeNum();i++){
				Nood n = new Nood();
				n.setNoodNo(i+1);
				ls.add(n);
			}
		}catch(Exception e){
			e.printStackTrace();
			msg = ExceptionAnalysis.analysisMsg(e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public List<Nood> getLs() {
		return ls;
	}

	public void setLs(List<Nood> ls) {
		this.ls = ls;
	}
}
