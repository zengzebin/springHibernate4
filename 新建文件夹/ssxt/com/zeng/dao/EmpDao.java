package ssxt.com.zeng.dao;

 
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.LockMode;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import common.dao.GenericDaoImpl;
import common.page.SqlCondGroup;
import ssxt.com.zeng.xml.Emp;
import ssxt.com.zeng.xml.User;
@Repository(value = "empDao")
public class EmpDao  extends GenericDaoImpl<Emp, Integer>{

	public void commonConList(List<SqlCondGroup> conList, Emp bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Emp> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> queryByExample(Emp exampleInstance) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdateAll(Collection<Emp> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Emp entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWithLock(Emp entity, LockMode lock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWithLock(Emp entity, LockMode lock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<Emp> entities) {
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
