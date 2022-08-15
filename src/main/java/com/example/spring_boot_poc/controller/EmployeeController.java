package com.example.spring_boot_poc.controller;

import com.example.spring_boot_poc.entity.Employee;
import com.example.spring_boot_poc.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MPI2COB
 * @Date 7/8/2022
 */
@RestController
@RequestMapping("/employees")
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping("/")
  public ResponseEntity<List<Employee>> findAllEmployees() {
    log.info("Inside findAllEmployees method of Employee Controller");
    return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long employeeId) {
    log.info("Inside findEmployeeById method of Employee Controller");
    return new ResponseEntity<>(employeeService.findEmployeeById(employeeId), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
    log.info("Inside saveEmployee method of Employee Controller");
    return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable("id") long employeeId) {
    log.info("Inside deleteEmployee method of Employee Controller");
    employeeService.deleteEmployee(employeeId);
  }

}
