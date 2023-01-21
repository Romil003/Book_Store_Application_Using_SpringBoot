package com.bridgelabz.bookstoreapplication.Repository;

import com.bridgelabz.bookstoreapplication.Model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin,Integer> {
    Optional<UserLogin> findByEmailAndPassword(String email , String password);

    @Query(value = "select * from user_login_table where email = :email" ,nativeQuery = true)
    UserLogin findByEmailId(String email);
}
