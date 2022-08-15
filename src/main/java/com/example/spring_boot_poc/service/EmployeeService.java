package com.example.spring_boot_poc.service;

import com.example.spring_boot_poc.entity.Employee;
import com.example.spring_boot_poc.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author MPI2COB
 * @Date 7/8/2022
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public List<Employee> findAllEmployees() {
    log.info("Inside findAllEmployees of Employee Service");
    return employeeRepository.findAll();
  }

  public Employee findEmployeeById(Long employeeId) {
    log.info("Inside findEmployeeById of Employee Service");
    return employeeRepository.findByEmployeeId(employeeId);
  }

  public Employee saveEmployee(Employee employee) {
    log.info("Inside saveEmployee of Employee Service = "+employee);
    return employeeRepository.save(employee);
  }

  public void deleteEmployee(long employeeId) {
    log.info("Inside deleteEmployee of Employee Service");
    employeeRepository.deleteById(employeeId);
  }
}
