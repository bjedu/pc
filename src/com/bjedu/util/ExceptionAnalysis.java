package com.bjedu.util;

import com.bjedu.configuration.Constants;
import com.bjedu.configuration.ReturnMessage;
import com.bjedu.util.exceptions.ExceptionCollectCenter;
import com.bjedu.util.exceptions.ExceptionModel;


public class ExceptionAnalysis {
	public static ReturnMessage analysisMsg(Exception e){
		ExceptionCollectCenter.add(new ExceptionModel(e));
		ReturnMessage msg = new ReturnMessage();
		msg.setCode(Constants.R_ERROR);
		msg.setMsg(Messages.getString("systemMsg.failed"));
		return msg;
	}

	public static String analysisStr(Exception e){
		ExceptionCollectCenter.add(new ExceptionModel(e));
		return "操作异常！";
	}
}
