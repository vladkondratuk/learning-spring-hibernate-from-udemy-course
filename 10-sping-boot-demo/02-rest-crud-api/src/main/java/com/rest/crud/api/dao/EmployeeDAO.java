package com.rest.crud.api.dao;

import com.rest.crud.api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
