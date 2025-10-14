package com.example.demoCrudProject.DAO;

import com.example.demoCrudProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
                                                        //Entity type, PK

    //No need to write any code thats the magicccc
}
