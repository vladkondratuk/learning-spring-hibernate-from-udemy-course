package com.rest.crud.api.dao;

import com.rest.crud.api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee getById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
