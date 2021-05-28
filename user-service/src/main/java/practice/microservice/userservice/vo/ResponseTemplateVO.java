package practice.microservice.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.microservice.userservice.entity.Department;
import practice.microservice.userservice.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private User user;
    private Department department;

}
