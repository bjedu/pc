<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="ww" uri="webwork" %>
<ww:bean name="'com.bjedu.dict.DictMan'" id="dictID" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=path%>/pages/workflow/js/noods.js"></script>
<div class="pageheader">
            <h1 class="pagetitle">设置流程节点</h1>
            <span class="pagedesc">定义流程中节点的详细信息</span>
            
            <ul class="hornav">
               
            </ul>
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
        
            <div id="vertical" class="subcontent">
            
                    <!-- START OF VERTICAL WIZARD -->
                    <form class="stdform" method="post" action="">
                    <div id="wizard3" class="wizard verwizard">
                    	
                        <ul class="verticalmenu">
                        	<ww:iterator value="ls">
                        		<li>
	                            	<a href="#wiz1step3_<ww:property value="noodNo"/>">
	                                    <span id="span<ww:property value="noodNo"/>" class="label">Step <ww:property value="noodNo"/>: </span>
	                                </a>
	                            </li>
                        	</ww:iterator>
                        </ul>
                        <ww:iterator value="ls">
                        	<div id="wiz1step3_<ww:property value="noodNo"/>" class="formwiz">
                        		
	                        	<h4 id="h<ww:property value="noodNo"/>">Step <ww:property value="noodNo"/>: </h4> 
	                        	
	                                <p>
	                                    <label>节点名称</label>
	                                    <span class="field"><input type="text" name="nameN" id="<ww:property value="noodNo"/>" class="longinput" /></span>
	                                </p>
	                                
	                                <p>
	                                    <label>节点类型</label>
	                                    <span class="field"><select name="noodType">
	                                        <ww:iterator value="#dictID.getDictList('d_nood_noodtype')">
			                            		<option 
			                            		<ww:if test="nood.noodType==code">selected="selected"</ww:if>
			                            		 value="<ww:property value="code"/>"><ww:property value="name"/></option>
			                            	</ww:iterator>
	                                    </select></span>
	                                </p>
	                                
	                        	
	                            
	                        </div><!--#wiz1step3_1-->
                        </ww:iterator>                        	
                    </div><!--#wizard-->
                    </form>
                    
                    <br clear="all" /><br />
                    
                    <!-- END OF VERTICAL WIZARD -->
                    
            </div><!--#vertical-->
            
        </div><!--contentwrapper-->