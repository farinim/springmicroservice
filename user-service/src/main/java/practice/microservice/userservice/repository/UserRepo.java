package practice.microservice.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.microservice.userservice.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByUserId( Long userId );
}
