jQuery(document).ready(function(){
								
	
	///// LOGIN FORM SUBMIT /////
	jQuery('#login').submit(function(){
	
		if(jQuery('#loginname').val() == '' && jQuery('#password').val() == '') {
			jQuery('.nousername').fadeIn();
			jQuery('.nopassword').hide();
			return false;	
		}
		if(jQuery('#loginname').val() != '' && jQuery('#password').val() == '') {
			jQuery('.nopassword').fadeIn().find('.userlogged h4, .userlogged a span').text(jQuery('#loginname').val());
			jQuery('.nousername,.username').hide();
			return false;;
		}
		var url = 'login.action';
		var params = jQuery('#login').serialize();
		var success = callback;
		ajax(url,params,success);
		return false;
	});
	
	
	function callback(data){
		if(data.code == "0"){
			document.location = "main.jsp";
		}else if(data.code == "1"){
			message(data.msg);
		}else if(data.code =="2"){
			message(data.msg);
			
		}
	}
	///// ADD PLACEHOLDER /////
	jQuery('#loginname').attr('placeholder','Username');
	jQuery('#password').attr('placeholder','Password');
});
