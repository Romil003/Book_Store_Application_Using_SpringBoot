package com.bridgelabz.bookstoreapplication.Service;

import com.bridgelabz.bookstoreapplication.DTO.LogInDTO;
import com.bridgelabz.bookstoreapplication.DTO.UserLoginDTO;
import com.bridgelabz.bookstoreapplication.Exception.UserRegistrationException;
import com.bridgelabz.bookstoreapplication.Model.LogIn;
import com.bridgelabz.bookstoreapplication.Model.UserLogin;
import com.bridgelabz.bookstoreapplication.Repository.UserLoginRepository;
import com.bridgelabz.bookstoreapplication.Util.EmailSenderService;
import com.bridgelabz.bookstoreapplication.Util.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserLoginService implements IUserLoginService{

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private EmailSenderService sender;
    @Override
    public List<UserLogin> getUserLoginDetails() {
        return userLoginRepository.findAll();
    }

    @Override
    public UserLogin getUserLoginDataById(int Id) {
        return userLoginRepository.findById(Id).orElseThrow(() -> new UserRegistrationException("Data Not Found"));
    }

    @Override
    public String createUserLoginData(UserLoginDTO userLoginDTO) {
        UserLogin userLogin = userLoginRepository.findByEmailId(userLoginDTO.email);
        if(userLogin != null){
            return ("User already exists !!!!");
        } else {
            userLogin = new UserLogin(userLoginDTO);
            userLoginRepository.save(userLogin);
            sender.sendEmail(userLogin.getEmail(), "Test Email", "Registered successfully,hii: " + userLogin.getFirstName() + " Registerd User Data->" + userLogin);
            return jwtToken.encodeToken(userLogin.getUserId());
        }
    }

    @Override
    public UserLogin updateUserLoginData(int Id, UserLoginDTO userLoginDTO) {
        UserLogin userLogin = this.getUserLoginDataById(Id);
        if(userLogin != null){
            userLogin.updateUser(userLoginDTO);
            userLoginRepository.save(userLogin);
            sender.sendEmail(userLogin.getEmail(),"Test Email","Updated successfully,hii: "+userLogin.getFirstName()+ "Updated User Data->"+userLogin);
            return userLogin;
        }
        return null;
    }

    @Override
    public void deleteUserLoginData(int Id) {
        UserLogin userLogin = this.getUserLoginDataById(Id);
        userLoginRepository.deleteById(Id);
        sender.sendEmail(userLogin.getEmail(),"Test Email","Deleted successfully !!!");
    }

    @Override
    public Optional<UserLogin> findByEmailIdAndPassword(LogInDTO logInDTO) {
        Optional<UserLogin> userLogin = userLoginRepository.findByEmailAndPassword(logInDTO.email,logInDTO.password);
        if(userLogin.isPresent()){
            log.info("User login successful");
            return userLogin;
        }
        log.info("User login failed");
        return null;
    }

    @Override
    public String deleteAll() {
        userLoginRepository.deleteAll();
        return "All data deleted successfully !!!" ;
    }
}
