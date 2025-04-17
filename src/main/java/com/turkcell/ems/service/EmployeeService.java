package com.turkcell.ems.service;

import com.turkcell.ems.dto.EmployeeDto;
import com.turkcell.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getEmployeesByName(String name);

    List<EmployeeDto> getEmployeesByLastName(String lastName);

    EmployeeDto getEmployeeByEmail(String email);

    List<EmployeeDto> getEmployeesByPhoneNumber(String phoneNumber);

    List<EmployeeDto> getEmployeesByGender(String gender);

    List<EmployeeDto> getAllEmployee();

    void deleteEmployeeById(Long employeeId);
}
