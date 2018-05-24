package com.bjedu.main.workflow.action;

import java.util.ArrayList;
import java.util.List;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.configuration.Constants;
import com.bjedu.main.model.BaseModel;
import com.bjedu.main.model.GUser;
import com.bjedu.main.model.Nood;
import com.bjedu.main.model.Workflow;
import com.bjedu.main.workflow.dao.WorkflowDAO;
import com.bjedu.util.ExceptionAnalysis;
import com.bjedu.util.UUID;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class PublishWorkflowAction extends AbstractAction {
	private String uuid;
	private List<String> nameN;
	private List<String> noodType;
	
	public PublishWorkflowAction() {
		
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
			Workflow workflow = dao.getObjByPK(uuid, Workflow.class);
			workflow.setOnFlag("1");
			List<Nood> ns = new ArrayList<Nood>();
			List<BaseModel> bs = new ArrayList<BaseModel>();
			for(int i=0;i<nameN.size();i++){
				Nood n = new Nood();
				n.setNameN(nameN.get(i));
				n.setUuid(UUID.randomUUID().toString());
				n.setNoodNo(i);
				n.setIwfId(uuid);
				n.setNoodType(noodType.get(i));
				ns.add(n);
				
			}
			for(int i=0;i<ns.size();i++){
				if(i==0&&i<ns.size()-1){
					ns.get(i).setNextId(ns.get(i+1).getUuid());
				}else if(i==ns.size()-1){
					ns.get(i).setPerId(ns.get(i-1).getUuid());
				}else{
					ns.get(i).setNextId(ns.get(i+1).getUuid());
					ns.get(i).setPerId(ns.get(i-1).getUuid());
				}
				bs.add(ns.get(i));
			}
			bs.add(workflow);
			dao.update(bs);
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

	public List<String> getNameN() {
		return nameN;
	}

	public void setNameN(List<String> nameN) {
		this.nameN = nameN;
	}

	public List<String> getNoodType() {
		return noodType;
	}

	public void setNoodType(List<String> noodType) {
		this.noodType = noodType;
	}

}
