package com.example.demoCrudProject.DAO;

import com.example.demoCrudProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") //change the mapping to members from employee
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
                                                        //Entity type, PK

    //No need to write any code thats the magicccc
}
