jQuery(document).ready(function(){
	var url_init = "hello.action";
	var url_project = "pages/project/listproject.jsp"
	//主页初始化
	function init(){
		_go(url_init);
	}
	
	jQuery("#project_ls").click(function(){
		_go(url_project);
	});
	init();
});
