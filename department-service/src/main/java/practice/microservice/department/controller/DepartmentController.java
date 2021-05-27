package practice.microservice.department.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.microservice.department.entity.Department;
import practice.microservice.department.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Entered saveDepartment");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId){
        log.info("Entered Get department with id {}", departmentId);
        return departmentService.getDepartment(departmentId);

    }
}
