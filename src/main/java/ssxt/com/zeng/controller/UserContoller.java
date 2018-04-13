package ssxt.com.zeng.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.annotation.SystemControllerLog;
 
import common.exception.DataAccessException;
import common.page.PageControl;
import common.page.SqlBuffer;
import common.util.AccData;
import common.util.CtxHelper;
import common.util.CtxHelper1;
 
 
import ssxt.com.zeng.service.AopService;
import ssxt.com.zeng.service.CacheService;
import ssxt.com.zeng.service.DeptService;
import ssxt.com.zeng.service.DeviceService;
import ssxt.com.zeng.service.EmpService;
import ssxt.com.zeng.service.UserService;
import ssxt.com.zeng.xml.Dept;
import ssxt.com.zeng.xml.Emp;
import ssxt.com.zeng.xml.Role;
import ssxt.com.zeng.xml.User;

@Controller
@RequestMapping(value = "/api/user/")
public class UserContoller {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserContoller.class);

	@Resource
	private UserService userService;

	@Resource
	private DeptService deptService;

	@Resource
	private EmpService empService;
	
	@Resource
	private CacheService  cacheService ;
	
	@Resource
	private AopService  aopService ;
	
	@Resource
	private DeviceService  deviceService ;


	
	@RequestMapping(value = "select", method = RequestMethod.GET)
	@SystemControllerLog(description = "查询用户")     
	public void select(HttpServletRequest request, HttpServletResponse response) throws Exception
        {
	 
		
		 
		AccData ad = CtxHelper1.createFailAccData();
	    ad.setData(userService.select());
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true);
		
		CtxHelper1.writeToJson(response, ad);
	}

	@RequestMapping(value = "emp", method = RequestMethod.GET)
	public void emp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//DataSourceHolder.setDataSource(DataSourceHolder);
		Emp emp = empService.get(1);
		//System.out.println(3/0);
		AccData ad = CtxHelper1.createFailAccData();
		ad.setData(emp);
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true);
		CtxHelper1.writeToJson(response, ad);
	}

	@RequestMapping(value = "dept", method = RequestMethod.GET)
	public void dept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Dept dept= deptService.get(62);
		SqlBuffer sbf = SqlBuffer.begin();
		// deptService.deleteByKey(62);

		List<?> dataList = deptService.findByCondition(PageControl.getQueryOnlyInstance(), sbf.end());

		// List<?> dataList =
		// deptService.findByNativeCondition(PageControl.getQueryOnlyInstance(),
		// sbf.end(), "select deptName from test_dept", Map.class);
		AccData ad = CtxHelper1.createFailAccData();
		ad.setData(dataList);
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true);
		CtxHelper1.writeToJson(response, ad);
	}
	
	 
	
	
	
	
}
