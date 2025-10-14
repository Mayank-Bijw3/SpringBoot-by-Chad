package com.example.demoCrudProject.service;

import com.example.demoCrudProject.DAO.EmployeeRepository;
import com.example.demoCrudProject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpli implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpli(EmployeeRepository employeeDAO) {
        this.employeeRepository = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //this is new but easy to understand
    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            //in case cannot find employee
            throw new RuntimeException("Didnt find Employee id: " + id);
        }

        return theEmployee;
    }

    //@Transactional  no need to list as jpaRepo provide it
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    //@Transactional  no need to list as jpaRepo provide it
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }


}
