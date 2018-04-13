package ssxt.com.zeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.dao.GenericDao;
import common.service.GenericServiceImpl;
import ssxt.com.zeng.dao.UserDao;
import ssxt.com.zeng.xml.User;


@Service(value="userService")
public class UserService  extends GenericServiceImpl<User, Integer>{

	
	@Resource(name = "userDao")
	private UserDao userDao;
	@Override
	public GenericDao<User, Integer> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

}
