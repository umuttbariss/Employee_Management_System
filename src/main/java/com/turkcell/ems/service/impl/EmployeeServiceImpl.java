package com.turkcell.ems.service.impl;

import com.turkcell.ems.dto.EmployeeDto;
import com.turkcell.ems.entity.Employee;
import com.turkcell.ems.mapper.EmployeeMapper;
import com.turkcell.ems.repo.EmployeeRepo;
import com.turkcell.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());
        employee.setPhoneNumber(updatedEmployeeDto.getPhoneNumber());

        Employee updatedEmployee = employeeRepo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeesByName(String name) {
        List<Employee> employees = employeeRepo.findAllByName(name);

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found with name: " + name);
        }

        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByLastName(String lastName) {
        List<Employee> employees = employeeRepo.findAllByLastName(lastName);

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found with lastName: " + lastName);
        }
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Employee employee = employeeRepo.findByEmail(email);
        if (employee == null) {
            throw new RuntimeException("No employees found with email: " + email);
        }

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeesByPhoneNumber(String phoneNumber) {

        List<Employee> employees = employeeRepo.findByPhoneNumber(phoneNumber);

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found with phone number: " + phoneNumber);
        }

        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getEmployeesByGender(String gender) {
        List<Employee> employees = employeeRepo.findByGender(gender);

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found with gender: " + gender);
        }

        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {

        List<Employee> employees = employeeRepo.findAll();

        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList()); // buna bi bak
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        employeeRepo.deleteById(employeeId);

    }
}
