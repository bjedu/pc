package com.bjedu.configuration;

import java.io.Serializable;
import java.util.List;

import com.bjedu.main.model.BaseModel;

@SuppressWarnings("serial")
public class PageResult implements Serializable {
	private Integer pageNumber;
	private Integer pageSize;
	private Integer total;
	private List<BaseModel> rows;
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<BaseModel> getRows() {
		return rows;
	}
	public void setRows(List<BaseModel> rows) {
		this.rows = rows;
	} 
}
