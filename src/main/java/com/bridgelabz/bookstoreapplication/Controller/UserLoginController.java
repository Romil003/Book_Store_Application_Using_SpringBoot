package com.bridgelabz.bookstoreapplication.Controller;

import com.bridgelabz.bookstoreapplication.DTO.LogInDTO;
import com.bridgelabz.bookstoreapplication.DTO.ResponseDTO;
import com.bridgelabz.bookstoreapplication.DTO.UserLoginDTO;
import com.bridgelabz.bookstoreapplication.Model.LogIn;
import com.bridgelabz.bookstoreapplication.Model.UserLogin;
import com.bridgelabz.bookstoreapplication.Service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userlogin")
public class UserLoginController {

    @Autowired
    private IUserLoginService iUserLoginService;

    @GetMapping("/allData")
    public ResponseEntity<ResponseDTO> getUserLoginData(){
        List<UserLogin> userLoginList = iUserLoginService.getUserLoginDetails();
        ResponseDTO responseDTO = new ResponseDTO("Get all data of User Login",userLoginList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{Id}")
    public ResponseEntity<ResponseDTO> getUserLoginDataById(@PathVariable int Id){
        UserLogin userLogin = iUserLoginService.getUserLoginDataById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get all data of Id : ",userLogin);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping ("/getbyemailandpwd")
    public ResponseEntity<ResponseDTO> getUserLoginDataById(@RequestBody LogInDTO logInDTO){
        Optional<UserLogin> userLogin = iUserLoginService.findByEmailIdAndPassword(logInDTO);
        ResponseDTO responseDTO;
        if (userLogin.isPresent()){
            responseDTO = new ResponseDTO("Successfully Login for user : "+userLogin.get().getFirstName()+" with user details =>"+userLogin);
        } else {
            responseDTO = new ResponseDTO("Login Failed !!!");
        }
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/createData")
    public ResponseEntity<ResponseDTO> createUserLoginData(@Valid @RequestBody UserLoginDTO userLoginDTO){
        String token = iUserLoginService.createUserLoginData(userLoginDTO);
        ResponseDTO responseDTO = new ResponseDTO("Creating data of User",token);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/updateData/{Id}")
    public ResponseEntity<ResponseDTO> updateUserLoginData(@PathVariable int Id,@Valid @RequestBody UserLoginDTO userLoginDTO){
        UserLogin userLogin = iUserLoginService.updateUserLoginData(Id,userLoginDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating data of User ",userLogin);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping("/deletebyid/{Id}")
    public ResponseEntity<ResponseDTO> deleteUserLoginDataById(@PathVariable int Id){
        iUserLoginService.deleteUserLoginData(Id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully","Deleted data of given token => ");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<ResponseDTO> deleteAllUserLoginData(){
        iUserLoginService.deleteAll();
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully","Deleted All data !!");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


}
