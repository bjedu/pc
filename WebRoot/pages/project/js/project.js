/*
 * 	Additional function for tables.html
 *	Written by ThemePixels	
 *	http://themepixels.com/
 *
 *	Copyright (c) 2012 ThemePixels (http://themepixels.com)
 *	
 *	Built for Amanda Premium Responsive Admin Template
 *  http://themeforest.net/category/site-templates/admin-templates
 */

jQuery(document).ready(function(){
	var url_project_add = "pages/project/addproject.jsp";
	
	function add(){
		_go(url_project_add);
		return false;
	}

	var data = {
			url		:	"listproject.action",
			method	:	"post",
			table	:	"tb_departments",
			toolbar	:	"#toolbar",
			columns	:	[{
		        checkbox: true
		    }, {
		        field: 'projectName',
		        title: '项目名称'
		    }, {
		        field: 'projectManager',
		        title: '项目负责人'
		    }, {
		        field: 'createTime',
		        title: '创建时间'
		    }, {
		        field: 'createUser',
		        title: '创建人'
		    }, ]	
	};
	
	    //1.初始化Table
    var oTable = new TableInit(data);
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    
	
	jQuery("#btn_add").click(function(){
		add();
		return false;
	});
	
	//=======================================================
	
});