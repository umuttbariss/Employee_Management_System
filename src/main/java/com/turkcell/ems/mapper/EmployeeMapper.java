package com.turkcell.ems.mapper;

import com.turkcell.ems.dto.EmployeeDto;
import com.turkcell.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getSalary(),
                employee.getEmail(),
                employee.getPhoneNumber()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getGender(),
                employeeDto.getSalary(),
                employeeDto.getEmail(),
                employeeDto.getPhoneNumber()
        );
    }
}
