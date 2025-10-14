package com.example.demoCrudProject.rest;

import com.example.demoCrudProject.entity.Employee;
import com.example.demoCrudProject.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //using for patch request
    private ObjectMapper objectMapper;

    //addint to constructor
    @Autowired
    public EmployeeRestController(EmployeeService employeeService,ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee= employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not Found: " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //so we are sending employee object from postaman thats why this
        theEmployee.setId(0); //if id=0 then it will save else merge will update at primarykey
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        //so we are sending employee object from postaman thats why this
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee dosnt Exist : "+employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id: "+employeeId;
    }

    //add mapping for patch/employees/{employee} - patch employee ...partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String,Object> patchPayLoad){
        Employee tempEmloyee = employeeService.findById(employeeId);

        if(tempEmloyee == null){
            throw new RuntimeException("Employee id not Found : " +employeeId);
        }

        //throw exception if id is in body for integrity
        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body : " + employeeId);
        }
        Employee patchedEmployee = apply(patchPayLoad,tempEmloyee);

        Employee dbEmployee =employeeService.save(patchedEmployee);
        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee tempEmloyee) {
        //converting employee object to a json object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmloyee, ObjectNode.class);

        //convert the patchpaylode map to a json object node
        ObjectNode patchNode =objectMapper.convertValue(patchPayLoad, ObjectNode.class);

        //merge the patch update into the employee node
        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }
}
