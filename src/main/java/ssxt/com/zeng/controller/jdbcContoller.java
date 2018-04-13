package ssxt.com.zeng.controller;

import java.sql.Connection;
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
@RequestMapping(value = "/api/jdbc/")
public class jdbcContoller {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(jdbcContoller.class);

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


	
	 
 
}
