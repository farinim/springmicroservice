package practice.microservice.department.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.microservice.department.entity.Department;
import practice.microservice.department.repository.DepartmentRepo;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment( Department department ) {
        return departmentRepo.save(department);
    }

    public Department getDepartment( Long departmentId) {
        return departmentRepo.findByDepartmentId(departmentId);
    }
}
