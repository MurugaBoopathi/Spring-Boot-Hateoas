package com.example.spring_boot_poc.service;

import com.example.spring_boot_poc.entity.Department;
import com.example.spring_boot_poc.repository.DepartmentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author MPI2COB
 * @Date 7/11/2022
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentService {

  private final DepartmentRepository departmentRepository;

  public List<Department> findAllDepartments() {
    log.info("Inside findAllDepartments of Department Service");
    return departmentRepository.findAll();
  }

  public Department findDepartmentByName(String departmentName) {
    log.info("Inside findDepartmentByName of Department Service");
    return departmentRepository.findDepartmentByDepartmentName(departmentName);
  }

  public Department saveDepartment(Department department) {
    log.info("Inside saveDepartment of Department Service = ");
    return departmentRepository.save(department);
  }
}
