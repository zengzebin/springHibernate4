package ssxt.com.zeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.dao.GenericDao;
import common.service.GenericServiceImpl;
import ssxt.com.zeng.dao.DeptDao;
import ssxt.com.zeng.dao.UserDao;
import ssxt.com.zeng.xml.Dept;
import ssxt.com.zeng.xml.User;


@Service(value="deptService")
public class DeptService  extends GenericServiceImpl<Dept, Integer>{

	
	@Resource(name = "deptDao")
	private DeptDao deptDao;
	@Override
	public GenericDao<Dept, Integer> getDao() {
		// TODO Auto-generated method stub
		return deptDao;
	}

}
