package com.example.spring_boot_poc.repository;

import com.example.spring_boot_poc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MPI2COB
 * @Date 7/8/2022
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  Employee findByEmployeeId(Long employeeId);
}
