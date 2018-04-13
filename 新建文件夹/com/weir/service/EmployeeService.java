
package com.weir.service;
import java.util.List;

import com.weir.entity.Employee;

/**   
* @author itsKaiway   
* @date 2016Äê10ÔÂ2ÈÕ
* @version 1.0
*/
public interface EmployeeService {
	public long createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(long id);	
	public List<Employee> getAllEmployees(String employeeName);
}
