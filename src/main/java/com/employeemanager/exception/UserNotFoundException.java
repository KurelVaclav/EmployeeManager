package com.employeemanager.exception;

/**
 * Class UserNotFoundException indicate thath user could not be found in the system
 * this exception is thrown in EmployeeService when could not findEmployeeById
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
