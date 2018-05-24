/** ajax请求 */
function ajax(url, params, suc) {
	jQuery.ajax({
		url : url,
		type : 'post',
		dataType : 'json',
		data : params,
		success : function(data){
			suc(data);
		}
		
	});
}

/**
 * 左侧树点击
 * @param url
 * @param params
 * @param suc
 */
function _go(url,params,suc){
	if(!suc){
		suc = callback;
	}
	if(!params){
		params = null;
	}
	jQuery.ajax({
		url : url,
		type : 'post',
		dataType : 'html',
		data : params,
		success : function(data){
			suc(data);
		}
		
	});
}

/** ajax页面反填 目前仅限input text*/
function ajaxToPage(data){
	if(data.code == "0"){
		jQuery.each(data.json,function(n,v){
			for(i in v){
				if($("#"+i).length>0){
					$("#"+i).val(v[i]);
				}
			}
		});
		other(data);
	}else if(data.code == "1"){
		message(data.msg);
	}else if(data.code == "2"){
		message(data.msg);
	}
}
/**对页面的一些特殊处理 如果需要则具体jsp中覆盖 该方法*/
function other(data){}

//类似 alert的弹窗
function message(msg,title){
	if(!title){
		title = "Basic Dialog";
	}
	jAlert(msg, title);
	return false;
}

function callback(data){
	jQuery("#main_content").html(data);
}