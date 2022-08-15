package com.example.spring_boot_poc.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.example.spring_boot_poc.entity.Employee;
import com.example.spring_boot_poc.repository.EmployeeRepository;
import com.example.spring_boot_poc.service.EmployeeService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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
@RequestMapping("/hateoas-employees")
@Slf4j
@RequiredArgsConstructor
public class EmployeeResource {

  private final EmployeeService employeeService;
  private final EmployeeRepository employeeRepository;

  @GetMapping("/")
  public ResponseEntity<CollectionModel<EntityModel<Employee>>> findAllEmployees() {
    log.info("Inside findAllEmployees method of Employee Controller");

    List<EntityModel<Employee>> employees = StreamSupport.stream(employeeService.findAllEmployees().spliterator(), false)
        .map(employee -> EntityModel.of(employee, //
            linkTo(methodOn(this.getClass()).findAllEmployees()).withSelfRel(), //
            linkTo(methodOn(this.getClass()).findEmployeeById(employee.getEmployeeId())).withRel("getEmployee"), //
            linkTo(methodOn(DepartmentController.class).findDepartmentByName(employee.getEmployeeDepartment())).withRel("employeeDepartment")))
        .collect(Collectors.toList());

    return ResponseEntity.ok( //
        CollectionModel.of(employees));
  }

  @GetMapping("/{id}")
  public ResponseEntity findEmployeeById(@PathVariable("id") Long employeeId) {
    log.info("Inside findEmployeeById method of Employee Controller");

//    Employee emp = employeeService.findEmployeeById(employeeId);
//    emp.add(linkTo(methodOn(EmployeeResource.class).findEmployeeById(employeeId)).withSelfRel());
//    emp.add(linkTo(methodOn(EmployeeResource.class).findAllEmployees()).withRel("All-Employees"));
//      emp.add(linkTo(methodOn(DepartmentController.class).findDepartmentByName(emp.getEmployeeDepartment()))
//          .withRel("employeeDepartment"));
//    return new ResponseEntity<>(emp, HttpStatus.OK);

    EntityModel<Employee> resource = EntityModel.of(employeeService.findEmployeeById(employeeId));
    resource.add(linkTo(methodOn(this.getClass()).findEmployeeById(employeeId)).withSelfRel());
    resource.add(linkTo(methodOn(this.getClass()).findAllEmployees()).withRel("get"));
    resource.add(linkTo(methodOn(DepartmentController.class)
        .findDepartmentByName(resource.getContent().getEmployeeDepartment()))
        .withRel("get-department"));

    return ResponseEntity.ok().body(resource);
  }

  @PostMapping("/")
  public ResponseEntity saveEmployee(@RequestBody Employee employee) {
    log.info("Inside saveEmployee method of Employee Controller");
    EntityModel<Employee> resource = EntityModel.of(employeeService.saveEmployee(employee));
    resource.add(linkTo(methodOn(this.getClass()).findAllEmployees()).withRel("employees"));

    return ResponseEntity.ok().body(resource);
  }

  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable long id) {
    employeeRepository.deleteById(id);
  }

}
