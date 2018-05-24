<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="ww" uri="webwork" %>
<ww:bean name="'com.bjedu.dict.DictMan'" id="dictID" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=path%>/pages/workflow/js/addworkflow.js"></script>
<div class="pageheader">
            <h1 class="pagetitle">流程详情</h1>
            <span class="pagedesc">定义详细的流程信息</span>
            
            <ul class="hornav">
            </ul>
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
            
            <div id="validation" class="subcontent" >
            	
                    <form id="form1" class="stdform" method="post" action="">
                    	<input type="hidden" name="uuid" id="uuid" value="<ww:property value="workflow.uuid"/>">
                    	<p>
                        	<label>流程名称：</label>
                            <span class="field"><input type="text" name="workflow.nameW" id="nameW" class="longinput" value="<ww:property value="workflow.nameW"/>" /></span>
                        </p>
                        
                       
                        
                        <p>
                        	<label>节点数量：</label>
                            <span class="field"><input type="text" name="workflow.nodeNum" id="nodeNum" readonly="readonly" value="<ww:property value="workflow.nodeNum"/>" class="longinput" /></span>
                            <span class="field"><span id="slider4" style="width: 85%"></span></span>
                        </p>
                        
                        <p>
                        	<label>流程描述：</label>
                            <span class="field"><textarea cols="80" rows="5" name="workflow.describe" class="mediuminput" id="describe"><ww:property value="workflow.describe"/></textarea></span> 
                        </p>
                        
                        <p>
                        	<label>流程状态：</label>
                            <span class="field">
                            <select name="workflow.states" id="states">
                            	<ww:iterator value="#dictID.getDictList('d_iwf_states')">
                            		<option 
                            		<ww:if test="workflow.states==code">selected="selected"</ww:if>
                            		 value="<ww:property value="code"/>"><ww:property value="name"/></option>
                            	</ww:iterator>
                            </select>
                            </span>
                        </p>
                        
                        <br />
                        
                        <p class="stdformbutton">
                        	<button id="save_iwf" class="submit radius2">保&nbsp存</button>
                        	<button id="publish_iwf" class="submit radius2">发布流程</button>
                        </p>
                    </form>

            </div><!--subcontent-->
        
        </div><!--contentwrapper-->