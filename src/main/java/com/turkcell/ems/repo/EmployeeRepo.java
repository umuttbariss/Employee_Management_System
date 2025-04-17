package com.turkcell.ems.repo;

import com.turkcell.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.firstName = :name")
    List<Employee> findAllByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.lastName = :lastName")
    List<Employee> findAllByLastName(@Param("lastName") String lastName);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);

    @Query("SELECT e FROM Employee e WHERE e.phoneNumber = :phoneNumber")
    List<Employee> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT e FROM Employee e WHERE e.gender = :gender")
    List<Employee> findByGender(@Param("gender") String gender);
}
