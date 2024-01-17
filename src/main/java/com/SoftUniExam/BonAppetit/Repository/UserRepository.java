package com.SoftUniExam.BonAppetit.Repository;

import com.SoftUniExam.BonAppetit.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{


    Optional<User> findByUsernameAndPassword(String username, String password);






    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String name);

    Optional<User> findById(Long id);


}
