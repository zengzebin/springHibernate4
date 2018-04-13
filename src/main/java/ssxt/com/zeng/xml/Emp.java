package ssxt.com.zeng.xml;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
	private int empNo;
	private String empName;
	private Date empBirthday;
	private Dept dept;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getEmpBirthday() {
		return empBirthday;
	}
	public void setEmpBirthday(Date empBirthday) {
		this.empBirthday = empBirthday;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
