jQuery(document).ready(function(){
	var url_project_save_ajax = "saveproject.action";
	
	var availableTags = [
		   { value: 'AndorraD', data: 'AD' },
		   { value: 'AndorraX', data: 'AX' },
		   { value: 'AndorraE', data: 'AE' },
		   { value: 'AndorraQ', data: 'AQ' },
		   // ...
		   { value: 'Zimbabwe', data: 'ZZ' }
		];
	
	$("#j_autocomplete").autocomplete({
		source: availableTags,
		select: function(event, ui){
			$("#projectManager").val(ui.item.data);
		}
	});
	
	$("#save_button").click(function(){
		var params = $("#form1").serialize();
		alert(params);
		ajax(url_project_save_ajax,params,r_message);
	});
});