package com.makarevich.dao;

import com.makarevich.model.Employee;

import java.util.List;

/**
 * Created by j on 19.3.16.
 */
public interface EmployeeDao {
    Employee findById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployeeBySsn(String ssn);
    List<Employee> findAllEmployees();
    Employee findEmployeeBySsn(String ssn);
}
