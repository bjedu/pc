jQuery(document).ready(function(){
	// Smart Wizard 	
	jQuery('#wizard3').smartWizard({
		onFinish: onFinishCallback
	});
	
	function onFinishCallback(){
		message('Finish Clicked');
	}
	
	jQuery("[name='nameN']").on("blur",function(){
		//alert(this.id);
		var id1 = "h" + this.id;
		var id2 = "span"+ this.id;
		var html1 = jQuery("#"+id1).html()+this.value;
		var html2 = jQuery("#"+id2).html()+this.value;
		jQuery("#"+id1).html(html1);
		jQuery("#"+id2).html(html2);
	});
	
	jQuery('select, input:checkbox').uniform();
});