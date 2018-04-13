package ssxt.com.zeng.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import common.annotation.SystemServiceLog;
import common.dao.GenericDao;
import common.page.PageControl;
import common.page.SqlBuffer;
import common.service.GenericServiceImpl;
import ssxt.com.zeng.dao.UserDao;
import ssxt.com.zeng.xml.User;

@Service(value = "aopService")
public class AopService extends GenericServiceImpl<User, Integer> {

	@Resource(name = "userDao")
	private UserDao userDao;

	@Override
	public GenericDao<User, Integer> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

	
	public String apoTest(String name,User user) {

		return name;

	}

	@SystemServiceLog(description = "apo测试异常apoServiceError")
	public String apoServiceError(String name) {
		System.out.println(3 / 0);
		return name;
     }

}
