package com.bjedu.main.workflow.action;

import java.util.List;

import com.bjedu.common.action.AbstractAction;
import com.bjedu.configuration.Constants;
import com.bjedu.main.model.GUser;
import com.bjedu.main.model.Workflow;
import com.bjedu.main.workflow.dao.WorkflowDAO;
import com.bjedu.util.Page;
import com.bjedu.util.PageNew;
import com.opensymphony.xwork.Action;

@SuppressWarnings("serial")
public class WorkflowAction extends AbstractAction {
	private Integer start;
	private Integer length;
	private PageNew<Workflow> pn;
	private Page page;
	private Integer draw;
	
	
	public WorkflowAction() {
		// TODO Auto-generated constructor stub
		pn = new PageNew<Workflow>();
		page = new Page();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected String go() {
		GUser gUser = (GUser)get(Constants.SESSION_USER);
		if(gUser==null){
			return Action.LOGIN;
		}
		if(start==null){
			start = 0;
			length = 10;
		}
		try{
			//这里不设置条件查询
			WorkflowDAO dao = new WorkflowDAO();
			dao.getobjByModel(new Workflow(),page);
			List<Workflow> lss = page.getResults();
			pn.setDraw(draw);
			pn.setData(lss);
			pn.setRecordsTotal(page.getTotalRows());
			pn.setRecordsFiltered(page.getTotalRows());
		}catch(Exception e){
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public PageNew<Workflow> getPn() {
		return pn;
	}

	public void setPn(PageNew<Workflow> pn) {
		this.pn = pn;
	}
}
