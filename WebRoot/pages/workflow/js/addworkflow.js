jQuery(document).ready(function(){
	var url_iwf_setnoods = "beforepubworkflow.action";
	var url_iwf_save_ajax = "saveworkflow.action";
	var defult_num = jQuery("#nodeNum").val();
	
	function set_noods(){
		var params = jQuery('#form1').serialize();
		_go(url_iwf_setnoods,params);
		return false;
	}
	
	function add_workflow(){
		var params = jQuery('#form1').serialize();
		var success = callback_add;
		ajax(url_iwf_save_ajax,params,success);
		return false;
	}
	
	function callback_add(data){
		alert(data.json[0].uuid);
		jQuery("#uuid").val(data.json[0].uuid);
		jQuery.jGrowl(data.msg);
		jQuery("#save_iwf").attr("disabled",false);
	}
	
	
	//alert(defult_num);
	jQuery("#slider4").slider({
		range: "min",
		value: defult_num,
		min: 1,
		max: 10,
		slide: function( event, ui ) {
			jQuery("#nodeNum").val(ui.value);
		}
	});
	//jQuery("#slider4").slider("value",4)
	jQuery("#nodeNum").val(jQuery("#slider4").slider("value"));
	
	jQuery("#save_iwf").click(function (){
		jQuery("#save_iwf").attr("disabled",true);
		add_workflow();
		return false;
	});
	
	jQuery("#publish_iwf").click(function(){
		set_noods();
		return false;
	});
});