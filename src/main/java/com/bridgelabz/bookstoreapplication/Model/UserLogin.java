package com.bridgelabz.bookstoreapplication.Model;

import com.bridgelabz.bookstoreapplication.DTO.UserLoginDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "UserLoginTable")
@Data
public class UserLogin {

    @Id
    @GeneratedValue
    private int userId;
    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column
    private String password;

    @Column(name = "MobileNumber")
    private String mobileNumber;

    public UserLogin() {

    }

    public UserLogin(UserLoginDTO userLoginDTO){
        this.firstName = userLoginDTO.firstName;
        this.lastName = userLoginDTO.lastName;
        this.email = userLoginDTO.email;
        this.address=userLoginDTO.address;
        this.password=userLoginDTO.password;
        this.mobileNumber=userLoginDTO.mobileNumber;

    }

    public void updateUser(UserLoginDTO userLoginDTO){
        this.firstName = userLoginDTO.firstName;
        this.lastName = userLoginDTO.lastName;
        this.email = userLoginDTO.email;
        this.address=userLoginDTO.address;
        this.password=userLoginDTO.password;
        this.mobileNumber=userLoginDTO.mobileNumber;
    }
}
