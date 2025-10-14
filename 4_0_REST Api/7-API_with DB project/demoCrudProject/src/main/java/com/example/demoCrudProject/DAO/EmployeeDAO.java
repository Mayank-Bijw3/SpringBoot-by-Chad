package com.example.demoCrudProject.DAO;

import com.example.demoCrudProject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
