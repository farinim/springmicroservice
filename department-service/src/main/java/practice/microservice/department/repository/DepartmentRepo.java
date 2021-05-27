package practice.microservice.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.microservice.department.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

    Department findByDepartmentId(Long departmentId);
}
