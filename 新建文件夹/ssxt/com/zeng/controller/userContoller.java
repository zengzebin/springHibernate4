package ssxt.com.zeng.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
import common.page.PageControl;
import common.page.SqlBuffer;
import common.util.AccData;
import common.util.CtxHelper;
import common.util.CtxHelper1;
import ssxt.com.zeng.service.DeptService;
import ssxt.com.zeng.service.EmpService;
import ssxt.com.zeng.service.UserService;
import ssxt.com.zeng.xml.Dept;
import ssxt.com.zeng.xml.Emp;
import ssxt.com.zeng.xml.Role;
import ssxt.com.zeng.xml.User;

@Controller
@RequestMapping(value = "/api/test/")
 public class userContoller {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(userContoller.class);

	
	@Resource
	private UserService userService;

	@Resource
	private DeptService deptService;
	
	
	@Resource
	private EmpService   empService;
	
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
    public void add( HttpServletRequest request,
			HttpServletResponse response) throws  Exception {
		 Role role= new Role();
		 role.setRolename("妹妹");
		 
	   User user=userService.get(1);
	   
	   
		 List list=null;
	 	AccData ad=CtxHelper1.createFailAccData();
		ad.setData(user);
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true); 
		CtxHelper1.writeToJson(response, ad);
	 }
	
	
	@RequestMapping(value = "emp", method = RequestMethod.GET)
    public void emp( HttpServletRequest request,
			HttpServletResponse response) throws  Exception {
		 
	    Emp emp =empService.get(1);
		
	 	AccData ad=CtxHelper1.createFailAccData();
		ad.setData(emp);
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true); 
		CtxHelper1.writeToJson(response, ad);
	 }
	
	
	
	@RequestMapping(value = "dept", method = RequestMethod.GET)
    public void dept( HttpServletRequest request,
			HttpServletResponse response) throws  Exception {
		//Dept dept= deptService.get(62);
		 SqlBuffer sbf = SqlBuffer.begin();
		//deptService.deleteByKey(62);
		 
		 
		 List<?> dataList = deptService.findByCondition(PageControl.getQueryOnlyInstance(), sbf.end());

	//	 List<?> dataList = deptService.findByNativeCondition(PageControl.getQueryOnlyInstance(), sbf.end(), "select  deptName from test_dept", Map.class);
	 	AccData ad=CtxHelper1.createFailAccData();
		ad.setData(dataList);
		ad.setTotalCount(38);
		ad.setMsg("ddd");
		ad.setSuccess(true); 
		CtxHelper1.writeToJson(response, ad);
	 }
	
	
}
