package ssxt.com.zeng.controller;

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
import ssxt.com.zeng.service.AopService;
import ssxt.com.zeng.service.CacheService;
import ssxt.com.zeng.service.DeptService;
import ssxt.com.zeng.service.DeviceService;
import ssxt.com.zeng.service.EmpService;
import ssxt.com.zeng.service.UserService;
import ssxt.com.zeng.xml.Role;

@Controller
@RequestMapping(value = "/api/dynamic/")
public class DynamicContoller {

	@Resource
	private UserService userService;

	@Resource
	private DeptService deptService;

	@Resource
	private EmpService empService;

	@Resource
	private CacheService cacheService;

	@Resource
	private AopService aopService;

	@Resource
	DeviceService deviceService;

	@RequestMapping(value = "getDevice", method = RequestMethod.GET)
	@SystemControllerLog(description = "查询设备")
	public void getDevice(HttpServletRequest request, HttpServletResponse response) throws Exception {

		AccData ad = CtxHelper1.createFailAccData();
		
		ad.setData(deviceService.getload());
		//DataSourceHolder.setDataSource(DataSourceHolder.local);
		userService.loadAll();
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true);
		 

		CtxHelper1.writeToJson(response, ad);
	}
	
	
	
	
	@RequestMapping(value = "changeData", method = RequestMethod.GET)
	@SystemControllerLog(description = "切换数据源")
	public void changeData(HttpServletRequest request, HttpServletResponse response) throws Exception {

		AccData ad = CtxHelper1.createFailAccData();
	 
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true);
		 

		CtxHelper1.writeToJson(response, ad);
	}

}
