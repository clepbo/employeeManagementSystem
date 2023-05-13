package com.employeeManagement.employeeService;

import com.employeeManagement.employee.employeeModel.Employee;
import com.employeeManagement.employeeRepository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {
     Employee saveEmployee(Employee employee);
     List<Employee> findAllEmployee();
     Employee findEmployeeById(long id);
     Employee updateEmployee (Employee employee, long id);
     void deleteEmployee (long id);
}
