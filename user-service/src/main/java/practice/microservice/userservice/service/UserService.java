package practice.microservice.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    DiscoveryClient discoveryClient;

    public User saveUser( User user ) {
        return userRepo.save(user);
    }

    public User findByUserId( Long userId ) {
        return userRepo.findByUserId(userId);
    }
    public ResponseTemplateVO getUserWithDepartment(Long userId){
        //discoveryClient.getInstances("DEPARTMENT-SERVICE").forEach(s -> System.out.println(s.getUri()));
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepo.findByUserId(userId);
        Department departmet =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(departmet);
        return vo;
    }
}
