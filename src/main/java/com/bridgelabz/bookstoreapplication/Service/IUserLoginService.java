package com.bridgelabz.bookstoreapplication.Service;

import com.bridgelabz.bookstoreapplication.DTO.LogInDTO;
import com.bridgelabz.bookstoreapplication.DTO.UserLoginDTO;
import com.bridgelabz.bookstoreapplication.Model.LogIn;
import com.bridgelabz.bookstoreapplication.Model.UserLogin;

import java.util.List;
import java.util.Optional;

public interface IUserLoginService {

    List<UserLogin> getUserLoginDetails();

    UserLogin getUserLoginDataById(int Id);

    String createUserLoginData(UserLoginDTO userLoginDTO);

    UserLogin updateUserLoginData(int Id,UserLoginDTO userLoginDTO);

    void deleteUserLoginData(int Id);

    Optional<UserLogin> findByEmailIdAndPassword(LogInDTO logInDTO);

    String deleteAll();
}
