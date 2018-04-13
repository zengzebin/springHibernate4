package ssxt.com.zeng.controller;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.annotation.SystemControllerLog;
import common.util.AccData;
import common.util.CtxHelper1;
 
import ssxt.com.zeng.service.DeviceService;

@Controller
@RequestMapping(value = "/api/transaction/")
public class TransactionController {

	@Resource
	DeviceService deviceService;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@SystemControllerLog(description = "添加用户")
	public void getConnection(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccData ad = CtxHelper1.createFailAccData();
		
		deviceService.addTransactional();
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true);
		
		CtxHelper1.writeToJson(response, ad);
	}

}
