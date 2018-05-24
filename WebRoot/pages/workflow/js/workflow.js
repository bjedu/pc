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
	var url_iwf_add = "pages/workflow/addworkflow.jsp";
	
	function add(){
		_go(url_iwf_add);
		return false;
	}
	
	jQuery('#dyntable2').dataTable({
		"sPaginationType": "full_numbers",
		"processing": true,
        "serverSide": true,
		"ajax":"workflow.action",
		"columns": [
		            {
		                 "sClass": "text-center",
		                 "data": "uuid",
		                 "render": function (data, type, full, meta) {
		                     return '<input type="checkbox"  class="checkchild"  value="' + data + '" />';
		                 },
		                 "bSortable": false
		            },
		            {
		                 "sClass": "text-center",
		                 "data": "uuid",
		                 "render": function (data, type, full, meta) {
		                     return '<a class="" href="javascript:edit(\''+data+'\');">编辑</a>';
		                 },
		                 "bSortable": false
		            },
		            { "data": "nameW" },
		            { "data": "describe" },
		            { "data": "onFlag" },
		            { "data": "states" }
		        ],
		"aaSortingFixed": [[0,'asc']],
		"fnDrawCallback": function(oSettings) {
            jQuery('input:checkbox,input:radio').uniform();
			//jQuery.uniform.update();
        }
	});
	
	
	
	jQuery(".btn_note").click(function(){
		add();
		return false;
	});
	
	//=======================================================
	

	///// TRANSFORM CHECKBOX AND RADIO BOX USING UNIFORM PLUGIN /////
	jQuery('input:checkbox,input:radio').uniform();
	
	
});