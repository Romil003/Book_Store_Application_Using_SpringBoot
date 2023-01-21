package com.bridgelabz.bookstoreapplication.DTO;


import lombok.ToString;

import javax.validation.constraints.*;

@ToString
public class UserLoginDTO {

    @Pattern(regexp="^[A-Z]{1}[a-zA-z\\s]{2,}$",message = "firstname is Invalid")
    @NotNull(message = "Firstname cannot be empty")
    public String firstName;

    @Pattern(regexp="^[A-Z]{1}[a-zA-z\\s]{2,}$",message = "Lastname is Invalid")
    @NotNull(message = "Lastname cannot be empty")
    public String lastName;

    @Email(message = "Email Id cannot be empty")
    public String email;

    @NotEmpty(message = "Address cannot be empty")
    public String address;

    @NotEmpty(message = "Password cannot be empty")
    public String password;

    @NotEmpty(message = "Mobile Number cannot be empty")
    public String mobileNumber;

}
