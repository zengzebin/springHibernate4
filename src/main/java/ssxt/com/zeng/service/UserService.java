package ssxt.com.zeng.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import common.dao.GenericDao;
import common.service.GenericServiceImpl;
import ssxt.com.zeng.dao.UserDao;
import ssxt.com.zeng.xml.User;

@Service(value = "userService")
public class UserService extends GenericServiceImpl<User, Integer> {

	@Resource(name = "userDao")
	private UserDao userDao;

	@Override
	public GenericDao<User, Integer> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

	/*
	 * @Cacheable ：应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调用方法获取数据，然后把数据添加到缓存中
	 * 
	 * @CacheEvict ：即应用到移除数据的方法上，如删除方法，调用方法时会从缓存中移除相应的数据
	 * 
	 * @CachePut ：应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
	 * 
	 * @Caching ：上面三种注解配置方法时，一个方法只能使用三者之一。如果要使用多个，则需要使用@Caching
	 */
	@Cacheable(value = "myCache", key = "#id")
	public User getUser(int id) {

		User user = userDao.get(id);
		return user;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<User> getAll() {
	//	DataSourceHolder.setDataSource(DataSourceHolder.local);
		return userDao.loadAll();
	}

	public List<User> select() {
		try {
			System.out.println("select");

			Thread.sleep(500);

			List<User> u = userDao.loadAll();
			Thread.sleep(500);
			System.out.println("select");
			return u;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
