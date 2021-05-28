package practice.microservice.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import practice.microservice.userservice.entity.Department;
import practice.microservice.userservice.entity.User;
import practice.microservice.userservice.repository.UserRepo;
import practice.microservice.userservice.vo.ResponseTemplateVO;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser( User user ) {
        return userRepo.save(user);
    }

    public User findByUserId( Long userId ) {
        return userRepo.findByUserId(userId);
    }
    public ResponseTemplateVO getUserWithDepartment(Long userId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepo.findByUserId(userId);
        Department departmet =
                restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(departmet);
        return vo;
    }
}
