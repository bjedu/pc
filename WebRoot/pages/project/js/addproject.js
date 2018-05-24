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
		source: availableTags
	});
});