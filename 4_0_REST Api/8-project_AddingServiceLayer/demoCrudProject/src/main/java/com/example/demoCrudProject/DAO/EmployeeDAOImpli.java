package com.example.demoCrudProject.DAO;

import com.example.demoCrudProject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpli implements EmployeeDAO{

    public EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpli(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee tempEmp = entityManager.find(Employee.class,id);
        return tempEmp;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;

    }


    @Override
    public void deleteById(int id) {
     Employee tempEmp = entityManager.find(Employee.class,id);
     entityManager.remove(tempEmp);
    }
}
