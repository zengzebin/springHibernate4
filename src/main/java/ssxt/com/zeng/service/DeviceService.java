package ssxt.com.zeng.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 
import common.dao.GenericDao;
import common.page.PageControl;
import common.service.GenericServiceImpl;
import ssxt.com.zeng.dao.DeviceDao;
import ssxt.com.zeng.dao.UserDao;
import ssxt.com.zeng.xml.BasDeviceInfo;
import ssxt.com.zeng.xml.User;

@Service(value = "deviceService")
public class DeviceService extends GenericServiceImpl<BasDeviceInfo, Long> {

	public GenericDao<BasDeviceInfo, Long> getDao() {
		return deviceDao;
	}

	@Resource(name = "deviceDao")
	private DeviceDao deviceDao;

	@Resource(name = "userService")
	private UserService userService;

	@Resource
	private DeviceService deviceService;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public BasDeviceInfo getload() {
		//DataSourceHolder.setDataSource(DataSourceHolder.remote);
		deviceDao.get(new Long(587));
		/*
		 * DataSourceHolder.setDataSource(DataSourceHolder.local);
		 * userService.loadAll();
		 */
		return null;
	}

	@Transactional
	public void addTransactional() {
		User user = new User();
		user.setPassword("123465");
		user.setUsername("测试的让菲菲");
		userService.save(user);
		BasDeviceInfo device = new BasDeviceInfo();
		device.setAddress("111");

		deviceService.save(device);
		System.out.println(5 / 0);

	}

}
