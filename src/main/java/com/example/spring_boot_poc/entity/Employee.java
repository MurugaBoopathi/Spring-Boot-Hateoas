package com.example.spring_boot_poc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

/**
 * @author MPI2COB
 * @Date 7/8/2022
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//public class Employee extends RepresentationModel<Employee> {
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long employeeId;
  private String employeeName;
  private String employeeAddress;
  private String employeeDepartment;
  private String employeeBUCode;

}
