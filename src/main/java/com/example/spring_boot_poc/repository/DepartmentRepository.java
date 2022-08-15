package com.example.spring_boot_poc.repository;

import com.example.spring_boot_poc.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MPI2COB
 * @Date 7/11/2022
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Department findDepartmentByDepartmentName(String departmentName);
}
