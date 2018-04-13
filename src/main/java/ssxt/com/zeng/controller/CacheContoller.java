package ssxt.com.zeng.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import common.annotation.SystemControllerLog;
import common.cache.RedisCacheConfig;
import common.exception.DataAccessException;
import common.page.PageControl;
import common.page.SqlBuffer;
import common.util.AccData;
import common.util.CtxHelper;
import common.util.CtxHelper1;
import common.util.SpringBeanUtil;
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
@RequestMapping(value = "/api/cache/")
public class CacheContoller {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CacheContoller.class);

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


	 
	
	
	@RequestMapping(value = "cache", method = RequestMethod.GET)
	public void cache(HttpServletRequest request, HttpServletResponse response) throws Exception
        {
		  AccData ad=CtxHelper1.createFailAccData();
		  SqlBuffer sbf = SqlBuffer.begin();
		 PageControl pageControl = PageControl.getPageEnableInstance();
     	 pageControl.setPageSize(20);
     	 pageControl.setPageNo(1); 
        // List <?>lsit=	cacheService.getPage(pageControl, sbf, "select device_sn sn from bas_device_info",Map.class);
		 ad.setData(null);
		 ad.setTotalCount(38);
		 ad.setMsg("缓存成功");
		 ad.setSuccess(true); 
		
		CtxHelper1.writeToJson(response, ad);
	}
	
	
	
	@RequestMapping(value = "getUserCach", method = RequestMethod.GET)
	public void getUserCach(HttpServletRequest request, HttpServletResponse response) throws Exception
        {
		 AccData ad=CtxHelper1.createFailAccData();
		 SqlBuffer sbf = SqlBuffer.begin();
		 //RedisCacheConfig config=new RedisCacheConfig();
		// config.cacheManager().getCache("getUserId~keys");
		// RedisTemplate redisTemplate=config.getRedisTemplate();
	//	 RedisCacheConfig	 config= SpringBeanUtil.getBean("RedisCacheConfig",RedisCacheConfig.class);
		// config.getRedisTemplate().opsForValue().set("111", "你好动画");
		//String value= (String) config.getRedisTemplate().opsForValue().get("111");
		 //User user=cacheService.getUserId(1);
		 
 		 ad.setData(cacheService.getUserId(2));
		 ad.setTotalCount(38);
		 ad.setMsg("缓存成功");
		 ad.setSuccess(true);
		
		CtxHelper1.writeToJson(response, ad);
	}
	
	
	
	
	
}
