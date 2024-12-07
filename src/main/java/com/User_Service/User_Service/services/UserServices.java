package com.User_Service.User_Service.services;


import com.User_Service.User_Service.entities.User;

import java.util.List;

public interface UserServices {


//    TODO  create user method
    User saveUser(User user);

//   TODO get all users method
    List<User> getAllUsers();


//    TODO get user by Id method
    User getUser(String userId);

}
