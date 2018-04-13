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
import ssxt.com.zeng.service.EmpService;
import ssxt.com.zeng.service.UserService;
import ssxt.com.zeng.xml.Dept;
import ssxt.com.zeng.xml.Emp;
import ssxt.com.zeng.xml.Role;
import ssxt.com.zeng.xml.User;

@Controller
@RequestMapping(value = "/api/aop/")
public class AopContoller {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AopContoller.class);

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



	@SystemControllerLog(description = "apo测试")  
	@RequestMapping(value = "aopTest", method = RequestMethod.GET)
	public void aopTest(@ModelAttribute("bean") User bean ,String id,
			HttpServletRequest request, HttpServletResponse response) throws Exception
        {
		User user=new User();
		user.setPassword("12346");
		user.setUsername("曾泽斌");
		 AccData ad=CtxHelper1.createFailAccData();
		 ad.setMsg(aopService.apoTest("apo测试",user));
		 ad.setSuccess(true);
		
		CtxHelper1.writeToJson(response, ad);
	}
	
	
	@SystemControllerLog(description = "apo测试异常Controller")  
	@RequestMapping(value = "aopError", method = RequestMethod.GET)
	public void aopError(HttpServletRequest request, HttpServletResponse response) throws Exception
        {
		 AccData ad=CtxHelper1.createFailAccData();
		 ad.setMsg(aopService.apoServiceError("测试异常"));
		 ad.setSuccess(true);
		
		CtxHelper1.writeToJson(response, ad);
	}


}
