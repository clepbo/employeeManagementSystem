package com.employeeManagement.employeeService.employeeServiceImpl;

import com.employeeManagement.employee.employeeModel.Employee;
import com.employeeManagement.employeeRepository.EmployeeRepository;
import com.employeeManagement.employeeService.EmployeeService;
import com.employeeManagement.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;
    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee", "id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        repo.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee", "id", id));
        repo.deleteById(id);

    }


}
