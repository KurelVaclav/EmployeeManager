package com.employeemanager.service;

import com.employeemanager.utils.UUIDGenerator;
import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;
import com.employeemanager.exception.UserNotFoundException;
import com.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeemanager.model.Employee;
import java.util.List;

/**
 * Class EmployeeService define methods for actions with Employees to handle his business logic
 */
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    /**
     * Constructor EmployeeService with injected instance of interface EmployeeRepo
     * @param employeeRepo - injected to interact with database and perform CRUD operations on Employee
     */
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmplyoee(@NotNull Employee employee) {
        //employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setEmployeeCode(UUIDGenerator.getNextUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

}
