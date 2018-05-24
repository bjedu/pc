/*
 * Created on 2005-6-18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.bjedu.util;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.bjedu.configuration.Configuration;

/**
 * @author Administrator TODO To change the template for this generated type
 *         comment go to Window - Preferences - Java - Code Style - Code
 *         Templates
 */
public class Page implements Serializable {
	private static Log log = LogFactory.getLog(Page.class);
	private int pageSize = Configuration.getInstance().getSys_pageSize();
	private int currentPage = 1;
	private int totalRows;
	private int totalPages;
	private List results;
	private long startTime;
	private long endTime;
	private int orderFlag;
	private String orderString;
	public void finalize() throws Throwable {
		gc();
		super.finalize();
	}
	public void gc() {
		if (this.results != null) {
			this.results.clear();
			this.results = null;
		}
		this.orderString = null;
	}
	public void initPage(int totalRows, int pageSize) {
		this.totalRows = totalRows;
		this.pageSize = pageSize;
		initPageInfo();
	}
	public void initPage(Query query, Query queryRows) {
		if(this.pageSize==0){
			this.pageSize= Configuration.getInstance().getSys_pageSize();
		}
		getQueryRows(queryRows);
		this.startTime = System.currentTimeMillis();
		this.results = getQueryResult(query);
		this.endTime = System.currentTimeMillis();
	}
	public void initPage(Query query) {
		this.startTime = System.currentTimeMillis();
		this.pageSize = -1;
		this.results = getQueryResult(query);
		this.endTime = System.currentTimeMillis();
	}
	public void initPage(Criteria criteria) {
		try {
			this.startTime = System.currentTimeMillis();
			if (this.pageSize != -1) {
				getQueryRows(criteria);
				criteria.setProjection(null);
			}
			this.results = getQueryResult(criteria);
			this.endTime = System.currentTimeMillis();
		} catch (Exception e) {
			log.error("Page::initPage(Criteria):" + e.getMessage());
		}
	}
	private List getQueryResult(Query query) {
		List listResult;
		if (this.pageSize == -1) {
			listResult = query.list();
			this.totalRows = listResult.size();
			this.totalPages = 1;
			this.currentPage = 1;
		} else {
			if (currentPage < 1)
				currentPage = 1;
			listResult = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
		}
		return listResult;
	}
	private List getQueryResult(Criteria criteria) {
		String sRet = "";
		if (this.orderString != null && !this.orderString.equals("")) {
			if (this.orderFlag == 0)
				criteria.addOrder(Order.asc(this.orderString));
			else
				criteria.addOrder(Order.desc(this.orderString));
		}
		List listResult;
		if (this.pageSize == -1) {
			listResult = criteria.list();
			this.totalRows = listResult.size();
			this.totalPages = 1;
			this.currentPage = 1;
		} else
			listResult = criteria.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
		return listResult;
	}
	private void getQueryRows(Criteria criteria) {
		this.totalRows = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}
	private void getQueryRows(Query query) {
		try {
			this.startTime = System.currentTimeMillis();
			Object obj = query.list().get(0);
			if((obj) instanceof java.math.BigDecimal){
				java.math.BigDecimal bigint = ((java.math.BigDecimal) obj);
				this.totalRows =  Integer.parseInt(bigint.toString().trim());
			}else{
				this.totalRows = ((Integer) obj).intValue();
			}
			
			this.endTime = System.currentTimeMillis();
		} catch (Exception ex) {
			log.error(ex.getMessage());
			this.totalRows = 0;
		}
		initPageInfo();
	}
	public void initPageInfo() {
		this.totalPages = (this.totalRows + this.pageSize - 1) / this.pageSize;
		this.totalPages = this.totalPages < 1 ? 1 : this.totalPages;
		this.currentPage = this.currentPage > this.totalPages ? this.totalPages : this.currentPage;
	}
	public boolean isNextPage() {
		return currentPage < totalPages;
	}
	public boolean isPreviousPage() {
		return currentPage > 1;
	}
	public long getDiffTime() {
		return this.endTime - this.startTime;
	}
	/**
	 * @return Returns the currentPage.
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage
	 *            The currentPage to set.
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return Returns the pageSize.
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize
	 *            The pageSize to set.
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return Returns the results.
	 */
	public List getResults() {
		return results;
	}
	/**
	 * @param results
	 *            The results to set.
	 */
	public void setResults(List results) {
		this.results = results;
	}
	/**
	 * @return Returns the totalRows.
	 */
	public int getTotalRows() {
		return totalRows;
	}
	/**
	 * @param totalRows
	 *            The totalRows to set.
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	/**
	 * @return Returns the totalPages.
	 */
	public int getTotalPages() {
		return totalPages;
	}
	/**
	 * @return Returns the orderFlag.
	 */
	public int getOrderFlag() {
		return orderFlag;
	}
	/**
	 * @param orderFlag
	 *            The orderFlag to set.
	 */
	public void setOrderFlag(int orderFlag) {
		this.orderFlag = orderFlag;
	}
	/**
	 * @return Returns the orderString.
	 */
	public String getOrderString() {
		return orderString;
	}
	/**
	 * @param orderString
	 *            The orderString to set.
	 */
	public void setOrderString(String orderString) {
		this.orderString = orderString;
	}
	public String getOrderByString() {
		String sRet = "";
		if (this.orderString != null && !this.orderString.equals("")) {
			sRet = " order by " + this.orderString + (this.orderFlag == 1 ? " " : " desc ");
		}
		return sRet;
	}
	public String getOrderByString2() {
		String sRet = "";
		if (this.orderString != null && !this.orderString.equals("")) {
			sRet = ", " + this.orderString + (this.orderFlag == 1 ? " " : " desc ");
		}
		return sRet;
	}
	public String getPageSplit() {
		StringBuffer sb = new StringBuffer();
		if (this.pageSize == -1 || this.totalPages == 1)
			sb.append("共1页 记录总数： <b>" + totalRows + " </b>条");
		else {
			sb.append("<a href='javascript:skipToPage(1)'>首页</a>　");
			if (this.isPreviousPage())
				sb.append("<a href=\"javascript:skipToPage(" + (this.currentPage - 1) + ")\">上一页</a>　");
			if (this.isNextPage())
				sb.append("<a href=\"javascript:skipToPage(" + (this.currentPage + 1) + ")\">下一页</a>　");
			sb.append("<a href=\"javascript:skipToPage(" + this.totalPages + ")\">尾页</a>　");
			sb.append("第<input size=\"3\" maxlength=\"6\" onkeyup=\"value=value.replace(/[^\\d]/g,'')\"");
			sb
					.append(" onbeforepaste=\"clipboardData.setData('text',clipboardData.getData('text').replace(/[^\\d]/g,''))\"");
			sb.append(" name=\"page.currentPage\" id=\"page.currentPage\" value=\"" + currentPage + "\"/>");
			sb.append("页 <input class=buttonJump type=button onclick=commonJump() name=goto value=跳转> 共" + totalPages
					+ "页 每页");
			sb.append("<input size=\"3\" maxlength=\"6\" onkeyup=\"value=value.replace(/[^\\d]/g,'')\"");
			sb
					.append(" onbeforepaste=\"clipboardData.setData('text',clipboardData.getData('text').replace(/[^\\d]/g,''))\"");
			sb.append(" name=\"page.pageSize\" id=\"page.pageSize\" value=\"" + pageSize + "\"/>");
			sb.append("条 记录总数：<b>" + totalRows + "</b>条");
		}
		return sb.toString();
	}
	public String getPageInfo(int type, String fun) {
		return getPageInfo(type, fun, "");
	}
	public String getPageInfo(int type, String fun, String objName) {
		if (StringHelper.isEmpty(fun))
			fun = "jump";
		StringBuffer sb = new StringBuffer();
		sb.append("<div id=pageTop>");
		if (this.totalPages == 1) {
			sb.append("共1页　总计<b>" + this.totalRows + "</b>条");
		} else {
			if (this.currentPage > 1)
				sb.append("<a href=javascript:" + fun + "ToPage(1)>首页</a>　<a href=javascript:" + fun + "ToPage("
						+ (this.currentPage - 1) + ")>上一页</a>　");
			if (this.currentPage < this.totalPages)
				sb.append("<a href=javascript:" + fun + "ToPage(" + (this.currentPage + 1)
						+ ")>下一页</a>　<a href=javascript:" + fun + "ToPage(" + this.totalPages + ")>尾页</a>　");
			sb.append("第<input size=3 maxlength=6 name=cp" + type + " id=" + objName + "cp" + type + " value="
					+ this.currentPage + ">页　<input class=buttonJump type=button onclick=" + fun + "(" + type + ",'"
					+ objName + "') name=goto" + type + " value=Go>");
			sb.append("　共" + this.totalPages + "页 每页" + this.pageSize + "条 总计<b>" + this.totalRows + "</b>条");
		}
		sb.append("</div>");
		return sb.toString();
	}
	public String getPageTop(String fun) {
		return getPageInfo(1, fun);
	}
	public String getPageBottom(String fun) {
		return getPageInfo(2, fun);
	}
	public String getObjPageTop(String fun, String objName) {
		return getPageInfo(1, fun, objName);
	}
	public String getObjPageBottom(String fun, String objName) {
		return getPageInfo(2, fun, objName);
	}
}
