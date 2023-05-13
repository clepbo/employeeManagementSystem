package com.employeeManagement.employeeRepository;

import com.employeeManagement.employee.employeeModel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
