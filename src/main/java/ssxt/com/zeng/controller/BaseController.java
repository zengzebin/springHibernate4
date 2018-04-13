package ssxt.com.zeng.controller;

 

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import common.page.PageControl;
import common.page.SqlBuffer;
import common.service.GenericServiceImpl;
import common.util.AccData;
import common.util.CtxHelper;

 

public abstract class BaseController<T extends Serializable, PK extends Serializable> {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BaseController.class);

	/**
	 * 获得当前bean的Service
	 * 
	 * @return GenericServiceImpl<T,PK>
	 */
	public abstract GenericServiceImpl<T, PK> getService();
 
	public abstract String getTypeName();

	@RequestMapping("/select")
	public void select(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AccData ad = CtxHelper.createFailAccData();

		/*PageControl pageControl = PageControl.getPageEnableInstance();
     	pageControl.setPageSize(20);
     	pageControl.setPageNo(1);*/
		
		PageControl pageControl = PageControl.getQueryOnlyInstance();
		SqlBuffer sbf = SqlBuffer.begin();

		sbf.add("createtm", request.getParameter("startTime"), ">=", "and");
		sbf.add("createtm", request.getParameter("endTime"), "<=", "and");
		sbf.add("STID", request.getParameter("STID"), "=", "and");
		int error = 1;
		StringBuffer sql = new StringBuffer();
		String typeName = getTypeName();

		 
		CtxHelper.writeToJson(response, ad);

	}

}
