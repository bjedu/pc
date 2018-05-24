<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
var url_iwf_edit = "editworkflow.action";
function edit(id){
	var params = {"uuid":id};
	_go(url_iwf_edit,params);
	return false;
}
</script>
<script type="text/javascript" src="<%=path%>/pages/workflow/js/workflow.js"></script>
<div class="pageheader notab">
            <h1 class="pagetitle">工作流程</h1>
            <span class="pagedesc">订单执行的先后顺序</span>
            
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
          <div class="contenttitle2">
                	<h3>Workflow Table with Checkbox Column</h3>
                </div><!--contenttitle-->
                
                	<ul class="buttonlist">
                   		<li><a href="" class="btn btn_search radius50"><span>Search</span></a></li>
                   		<li><a href="" class="btn btn_trash"><span>Trash</span></a></li>
                   		<li><a href="" class="btn btn_flag"><span>Flag</span></a></li>
                   		<li><a href="" class="btn btn_note"><span>新建</span></a></li>
                   		<li><a href="" class="btn btn_link"><span>Link</span></a></li>
                    </ul>
                
                <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable2">
                    <colgroup>
                        <col class="con0" style="width: 4%" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                    </colgroup>
                    <thead>
                        <tr>
                          <th class="head0 nosort"><input type="checkbox" /></th>
                          	<th class="head0 nosort">操作</th>
                            <th class="head0 nosort">流程名称</th>
                            <th class="head0 nosort">流程描述</th>
                            <th class="head1 nosort">是否发布</th>
                            <th class="head0 nosort">流程状态</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                    </tbody>
                </table>
        
        </div>