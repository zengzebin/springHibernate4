package ssxt.com.zeng.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.LockMode;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import common.dao.GenericDaoImpl;
 
import common.page.SqlCondGroup;
import ssxt.com.zeng.xml.BasDeviceInfo;

@Repository(value = "deviceDao")
public class DeviceDao extends GenericDaoImpl<BasDeviceInfo, Long> {
	// public class DeviceDao extends GenericDaoImpl2<BasDeviceInfo, Long> {

	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DeviceDao.class);

	public void commonConList(List<SqlCondGroup> conList, BasDeviceInfo bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BasDeviceInfo> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasDeviceInfo> queryByExample(BasDeviceInfo exampleInstance) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdateAll(Collection<BasDeviceInfo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BasDeviceInfo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWithLock(BasDeviceInfo entity, LockMode lock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWithLock(BasDeviceInfo entity, LockMode lock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<BasDeviceInfo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator iterate(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterate(String queryString, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeIterator(Iterator it) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int bulkUpdate(String queryString) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bulkUpdate(String queryString, Object[] values) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void initialize(Object proxy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByNativeCondition(String updateSql, List<SqlCondGroup> conList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByCondition(String updateSql, List<SqlCondGroup> conList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByCondition(List<SqlCondGroup> setList, List<SqlCondGroup> conList) {
		// TODO Auto-generated method stub
		return 0;
	}

}
