package com.turkcell.ems.controller;

import com.turkcell.ems.dto.EmployeeDto;
import com.turkcell.ems.entity.Employee;
import com.turkcell.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    //add employee
    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    //get all employees
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployee();

        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    //get employee by id
    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        
        return ResponseEntity.ok(employeeDto);
    }
    
    //get employee(s) by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByName(@PathVariable("name") String name) {
        List<EmployeeDto> dtos = employeeService.getEmployeesByName(name);
        return ResponseEntity.ok(dtos);
    }

    //get employee(s) by last name
    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByLastName(@PathVariable("lastName") String lastName) {
        List<EmployeeDto> dtos = employeeService.getEmployeesByLastName(lastName);
        return ResponseEntity.ok(dtos);
    }

    //get employee(s) by gender
    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByGender(@PathVariable("gender") String gender) {
        List<EmployeeDto> dtos = employeeService.getEmployeesByGender(gender);
        return ResponseEntity.ok(dtos);
    }
    
    //get employee by phone number
    @GetMapping("/phonenumber/{phoneNumber}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        List<EmployeeDto> dtos = employeeService.getEmployeesByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(dtos);
    }

    //get employee by email
    @GetMapping("/email/{email}")
    public ResponseEntity<EmployeeDto> getEmployeesByEmail(@PathVariable("email") String email) {
        EmployeeDto dto = employeeService.getEmployeeByEmail(email);
        return ResponseEntity.ok(dto);
    }
    
    //update employee by id
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto) {
        
        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId, employeeDto);
        
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Successfully deleted.");
    }
    
    

}
