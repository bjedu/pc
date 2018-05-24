package com.bjedu.util.result;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.Result;

@SuppressWarnings("serial")
public class ExcelResult implements Result {
	private Log log = LogFactory.getLog(ExcelResult.class);
	private HSSFWorkbook workbook;
	private String filename;
	private String contenttype;
	public void execute(ActionInvocation invocation) throws Exception {
		System.out.println("excelRecult.java  please !!" );
		OutputStream os = null;
		try {
			if (contenttype == null)
				contenttype = "application/msexcel";
			if (workbook == null)
				workbook = (HSSFWorkbook) invocation.getStack().findValue("workbook");
			filename=(String)invocation.getStack().findValue("filename");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.reset();
			response.setContentType(contenttype);
			response.setHeader("Content-Disposition", "attachment;Filename=" + POIExcelNameUtil.toUtf8String(filename) + ".xls");
			os = response.getOutputStream();
			workbook.write(os);
			os.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		} finally {
			if (os != null)
				os.close();
			workbook = null;
		}
	}
	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
}
