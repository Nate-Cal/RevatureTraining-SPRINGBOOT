package com.revature.services;

//Remember that Service classes are for business logic -
    //data formatting, input validation, etc
    //It makes sure everything looks good before going to the DB or back to the user

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //1 of the 4 stereotype annotations - makes this Class a bean
public class AuthService {

    //The controllers call services, which call the DAOs (data access objects)

    //The Service needs the DAO. They're both beans, so lets CONSTRUCTOR INJECT
    private final UserDAO userDAO;
    // We also need the UserService to find users by username
    private final UserService userService;

    @Autowired
    public AuthService(UserDAO userDAO, UserService userService) {

        this.userDAO = userDAO;
        this.userService = userService;
    }

    // Login - calls the UserDAO's findByUsernameAndPassword
    public User login(LoginDTO loginDTO) {
        // TODO: yes we should probably do some input validation

        return userDAO.findByUsernameAndPassword(
                loginDTO.getUsername(), loginDTO.getPassword()
        ).orElseThrow(()-> new IllegalArgumentException("Login Credentials Invalid"));
    }

    //Insert User - calls the UserDAO's save() method
    public User insertUser(User newUser){

        //TODO: input validation, etc

        //save() is used for inserts AND updates
            //if the ID doesn't exist, it inserts a new record
            //if the ID DOES exist, it updates it
        return userDAO.save(newUser);

        //TODO: maybe strip or obscure the password before sending it back

    }


}
