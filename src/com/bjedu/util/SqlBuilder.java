package com.bjedu.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.bjedu.common.exception.ActionException;
import com.bjedu.main.model.BaseModel;



public class SqlBuilder<T extends BaseModel> {
	private StringBuffer sb ;
	private Map<String, Object> map ;
	private T model;
	private Boolean init = false;
	private String order;
	private Long startTime;
	private Long endTime;
	private Integer id;
	

	public SqlBuilder(T model) {
		this.model = model;
	}
	
	/**
	 * 初始化这个Util的方法 必须首先调用，不然会有空指针异常
	 * @param model 对象里存了查询条件
	 * @return
	 */
	public SqlBuilder<T> init(){
		try{
			sb = new StringBuffer();
			map = new HashMap<String, Object>();
			sb.append(" from "+model.getHQLTable()+" where 1=1 ");
			Class<? extends BaseModel> clazz = model.getClass();
			Method[] methods = clazz.getDeclaredMethods();
			Field[] fields = clazz.getDeclaredFields();
			for(Method method:methods){
				if(method.getName().startsWith("get")){
					try{
						Object obj = method.invoke(model, new Object[]{});
						if(obj != null){
							for(Field f:fields){
								if(f.getName().equalsIgnoreCase(method.getName().substring(3))){
									sb.append(" and "+f.getName()+" = :"+f.getName());
									map.put(f.getName(), method.getReturnType().cast(obj));
								}
							}
						}
					}catch (Exception e) {
						continue;
					}
				}
			}
			init = true;
			startTime = System.currentTimeMillis();
			return this;
		}catch(Exception e){
			throw new ActionException(e);
		}
	}
	
	public SqlBuilder<T> appendIn(String str,Object obj,Boolean and){
		if(!init){
			init();
		}
		if(and){
			sb.append(" and ");
		}
		sb.append(" "+str+" in ( :" + str + " ) ");
		map.put(str, obj);
		return this;
	}
	
	public SqlBuilder<T> appendIn(String str,Object obj){
		return this.appendIn(str, obj, true);
	}
	
	public SqlBuilder<T> appendLess(String str,Object obj){
		return this.appendLess(str, obj, true);
	}
	
	public SqlBuilder<T> appendLess(String str,Object obj,Boolean and){
		if(!init){
			init();
		}
		if(and){
			sb.append(" and ");
		}
		sb.append(" "+str+" < :"+ str + " ");
		map.put(str, obj);
		return this;
	}
	
	public SqlBuilder<T> appendMore(String str,Object obj){
		return this.appendMore(str, obj, true);
	}
	
	public SqlBuilder<T> appendMore(String str,Object obj,Boolean and){
		if(!init){
			init();
		}
		if(and){
			sb.append(" and ");
		}
		sb.append(" "+str+" > :" + str + " ");
		map.put(str, obj);
		return this;
	}
	
	public SqlBuilder<T> appendNotNull(String str){
		return this.appendNotNull(str, true);
	}
	
	public SqlBuilder<T> appendNotNull(String str,Boolean and){
		if(!init){
			init();
		}
		if(and){
			sb.append(" and ");
		}
		sb.append(" "+str+" is not null ");
		return this;
	}
	
	public SqlBuilder<T> appendBracketStart(){
		if(!init){
			init();
		}
		sb.append(" and ( ");
		return this;
	}
	
	public SqlBuilder<T> appendBracketEnd(){
		if(!init){
			init();
		}
		sb.append(" ) ");
		return this;
	}
	
	public SqlBuilder<T> appendNotEqual(String str,Object obj){
		return this.appendNotEqual(str, obj, true);
	}
	
	public SqlBuilder<T> appendNotEqual(String str,Object obj,Boolean and){
		if(!init){
			init();
		}
		if(and){
			sb.append(" and ");
		}
		sb.append(" "+str+" <> :" + str + " ");
		map.put(str, obj);
		return this;
	}

	public StringBuffer getSb() {
		if(!init){
			init();
		}
		return sb;
	}

	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}

	public Map<String, Object> getMap() {
		if(!init){
			init();
		}
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public void setOrder(String order){
		this.order = " order by " + order;
	}

	public String getOrder() {
		if(StringHelper.isEmpty(order)){
			return "";
		}
		return order;
	}
	
	public void finish(){
//		endTime = System.currentTimeMillis();
//		Long time = endTime - startTime;
//		DictType dict = DictMan.getDictType("d_sys", "16");
//		Integer i = Integer.parseInt(dict.getName());
//		if(time>i*1000){
//			ProblemCenter.getInstance().push(getId(), getSb().toString());
//		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	
}
