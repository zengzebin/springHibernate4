package ssxt.com.zeng.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import common.dao.GenericDao;
import common.service.GenericServiceImpl;
import ssxt.com.zeng.dao.EmpDao;
import ssxt.com.zeng.dao.UserDao;
import ssxt.com.zeng.xml.Emp;
import ssxt.com.zeng.xml.User;


@Service(value="empService")
public class EmpService  extends GenericServiceImpl<Emp, Integer>{

	
	@Resource(name = "empDao")
	private EmpDao empDao;
	@Override
	public GenericDao<Emp, Integer> getDao() {
		// TODO Auto-generated method stub
		return empDao;
	}

}
