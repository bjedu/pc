package com.bjedu.util.result;

import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.Result;

public class ImageResult implements Result {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(ImageResult.class);
	private String filename = null;
	private String inputStreamName = null;
	private int bufferSize = 1024;
	private String contenttype;
	public void execute(ActionInvocation invocation) throws Exception {
		ServletOutputStream oOutput = null;
		HttpServletResponse response = null;
		InputStream is = null;
		try {
			if (contenttype == null)
				contenttype = "image/jpeg";
			is = (InputStream) invocation.getStack().findValue(inputStreamName);
			response = ServletActionContext.getResponse();
			response.reset();
			response.setContentType(contenttype);
			response.setHeader("Content-Disposition", "attachment;Filename=" + filename);
			oOutput = response.getOutputStream();
			// Copy input to output
			byte[] oBuff = new byte[bufferSize];
			int iSize = 0;
			while (-1 != (iSize = is.read(oBuff))) {
				oOutput.write(oBuff, 0, iSize);
			}
			// Flush
			oOutput.flush();
		} catch (Exception ex) {
			log.error(ex.getMessage());
		} finally {
			if (oOutput != null) {
				oOutput.close();
				oOutput = null;
			}
			if (is != null) {
				is.close();
				is = null;
			}
		}
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getInputStreamName() {
		return inputStreamName;
	}
	public void setInputStreamName(String inputStreamName) {
		this.inputStreamName = inputStreamName;
	}
	public int getBufferSize() {
		return bufferSize;
	}
	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
}
