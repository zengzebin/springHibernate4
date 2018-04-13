package ssxt.com.zeng.service;

import java.util.List;

import javax.annotation.Resource;

 
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import common.dao.GenericDao;
import common.page.PageControl;
import common.page.SqlBuffer;
import common.service.GenericServiceImpl;
import ssxt.com.zeng.dao.UserDao;
import ssxt.com.zeng.xml.User;


@Service(value="cacheService")
public class CacheService  extends GenericServiceImpl<User, Integer>{

	
	@Resource(name = "userDao")
	private UserDao userDao;
	@Override
	public GenericDao<User, Integer> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
	
	
	/*@Cacheable  ：应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调用方法获取数据，然后把数据添加到缓存中
	@CacheEvict ：即应用到移除数据的方法上，如删除方法，调用方法时会从缓存中移除相应的数据
	@CachePut   ：应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
	@Caching    ：上面三种注解配置方法时，一个方法只能使用三者之一。如果要使用多个，则需要使用@Caching*/
	
	@Cacheable("getUserId")  
	public User  getUserId(int id){
	  User	user=userDao.get(id);
	  return user;
	}
 
	
	@Cacheable(value="myCache",key="#page.pageNo")
	public List <?>  getPage(PageControl page,SqlBuffer sbf,String sql, Class returnType){
		 List <?>lsit =userDao.findByNativeCondition(page, sbf.end(), sql, returnType);
		  return lsit;
	 }

	
	@Cacheable("getString")  
	public String  getString(int id){
	   
	  return "abcjahiohdiowhdoih";
	}

}

 