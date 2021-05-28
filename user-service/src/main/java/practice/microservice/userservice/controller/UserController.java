package practice.microservice.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.microservice.userservice.entity.User;
import practice.microservice.userservice.service.UserService;
import practice.microservice.userservice.vo.ResponseTemplateVO;

@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser( @RequestBody User user){
        log.info("Entered saveUser");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        log.info("Find user by id {}", userId);
        return userService.findByUserId(userId);
    }
    @GetMapping("/userdepartment/{id}")
    public ResponseTemplateVO findUserWithDepartmentById( @PathVariable("id") Long userId){
        log.info("Find user and department by userId {}", userId);
        return userService.getUserWithDepartment(userId);
    }
}
