package com.example.spring_boot_poc.controller;

import com.example.spring_boot_poc.entity.Department;
import com.example.spring_boot_poc.entity.Employee;
import com.example.spring_boot_poc.service.DepartmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MPI2COB
 * @Date 7/11/2022
 */
@RestController
@RequestMapping("/departments")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {

  private final DepartmentService departmentService;

  @GetMapping("/")
  public ResponseEntity<List<Department>> findAllDepartments() {
    log.info("Inside findAllDepartments method of Department Controller");
    return new ResponseEntity<>(departmentService.findAllDepartments(), HttpStatus.OK);
  }

  @GetMapping("/{name}")
  public ResponseEntity<Department> findDepartmentByName(@PathVariable("name") String departmentName) {
    log.info("Inside findDepartmentByName method of Department Controller");
    return new ResponseEntity<>(departmentService.findDepartmentByName(departmentName), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
    log.info("Inside saveDepartment method of Department Controller");
    return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.OK);
  }

}
