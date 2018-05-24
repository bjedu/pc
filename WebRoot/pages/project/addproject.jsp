<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="ww" uri="webwork" %>
<ww:bean name="'com.bjedu.dict.DictMan'" id="dictID" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<<style>
<!--
.autocomplete-suggestions { border: 1px solid #999; background: #FFF; overflow: auto; }
.autocomplete-suggestion { padding: 2px 5px; white-space: nowrap; overflow: hidden; }
.autocomplete-selected { background: #F0F0F0; }
.autocomplete-suggestions strong { font-weight: normal; color: #3399FF; }
-->
</style>
<script type="text/javascript" src="<%=path%>/pages/project/js/addproject.js"></script>
<div class="side-body">
<div class="page-title">
    <span class="title">项目详情</span>
    <div class="description">项目的添加与修改页面.</div>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="card">
            <div class="card-header">
                <div class="card-title">
                    <div class="title">项目</div>
                </div>
            </div>
            <div class="card-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">项目名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="project.projectName" name="project.projectName" placeholder="项目名称">
                            <input type="hidden" name="project.uuid" value="<ww:property value="project.uuid"/>">
                            <input type="hidden" name="project.createTime" value="<ww:property value="project.createTime"/>">
                            <input type="hidden" name="project.createUser" value="<ww:property value="project.createUser"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">项目负责人</label>
                        <div class="col-sm-10">
                        	<input type="text" class="form-control" id="j_autocomplete" placeholder="项目负责人">
                            <input type="hidden" class="form-control" id="project.projectManager" name="project.projectManager" placeholder="项目负责人">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Sign in</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>