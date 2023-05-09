package com.employeemanager.repo;

import com.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Interface EmployeeRepo extends JpaRepository<Employee, Long(id)> for performing CRUD operations on Employee
 * and define own methods deleteEmployeeById and findEmployeeById from the database
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    //TODO: this in JPA is deleteById
    void deleteEmployeeById(Long id);

    //TODO: this in JPA is findById
    Optional<Employee> findEmployeeById(Long id);
}
