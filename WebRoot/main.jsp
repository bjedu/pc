<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
    <title>Flat Admin V.2 - Free Bootstrap Admin Templates</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/css/bootstrap-table.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/lib/css/select2.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/common/css/themes/flat-blue.css">
</head>

<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <%@include file="top.jsp" %>
            <%@include file="leftmenu.jsp" %>
            <!-- Main Content -->
            <div id="main_content" class="container-fluid">
            	
            </div>
        </div>
        <footer class="app-footer">
            <div class="wrapper">
                <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span> © 2015 Copyright. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
            </div>
        </footer>
        <div>
            <!-- Javascript Libs -->
            <script type="text/javascript" src="<%=path %>/common/lib/js/jquery.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/jquery-ui.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/bootstrap-table.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/Chart.min.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/bootstrap-switch.min.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/jquery.matchHeight-min.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/jquery.dataTables.min.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/dataTables.bootstrap.min.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/select2.full.min.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/ace/ace.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/ace/mode-html.js"></script>
            <script type="text/javascript" src="<%=path %>/common/lib/js/ace/theme-github.js"></script>
            <!-- Javascript -->
            <script type="text/javascript" src="<%=path %>/common/js/app.js"></script>
            
            <script type="text/javascript" src="<%=path %>/common/js/util/util.js"></script>
            <script type="text/javascript" src="<%=path %>/common/js/util/tableutil.js"></script>
            <script type="text/javascript" src="<%=path %>/common/js/init_main.js"></script>
            
            <%-- <script type="text/javascript" src="<%=path %>/common/js/index.js"></script> --%>
</body>

</html>
