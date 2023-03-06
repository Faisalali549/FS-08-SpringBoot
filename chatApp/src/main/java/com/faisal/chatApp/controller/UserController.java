package com.faisal.chatApp.controller;

import com.faisal.chatApp.Utils.CommonUtils;
import com.faisal.chatApp.dao.StatusRepository;
import com.faisal.chatApp.dao.UserRepository;
import com.faisal.chatApp.model.Status;
import com.faisal.chatApp.model.Users;
import com.faisal.chatApp.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    UserService userService;
    @PostMapping(value = "/create-user")
    public ResponseEntity<String> createUser(@RequestBody String userData) {
        JSONObject isValid = validateUserRequest(userData);
        Users user = null;
        if (isValid.isEmpty()) {
            user = setUser(userData);
            userService.saveUser(user);
        } else {
            return new ResponseEntity<String>(isValid.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
    }

    private JSONObject validateUserRequest(String userData) {
        JSONObject userJson = new JSONObject(userData);
        JSONObject errorList = new JSONObject();
        if (userJson.has("username")) {
            String username = userJson.getString("username");
        } else {
            errorList.put("username", "Missing parameter");
        }

        if (userJson.has("password")) {
            String password = userJson.getString("password");
            if(!CommonUtils.isValidPassword(password)) {
                errorList.put("password", "Please enter valid password eg: Faisalali@549");
            }
        } else {
            errorList.put("password", "Missing parameter");
        }

        if (userJson.has("firstName")) {
            String firstName = userJson.getString("firstName");
        } else {
            errorList.put("firstName", "Missing parameter");
        }

        if (userJson.has("email")) {
            String email = userJson.getString("email");
            if (!CommonUtils.isValidEmail(email)) {
                errorList.put("email", "Please enter valid email eg: mdfaisalali549@gmail.com");
            }
        } else {
            errorList.put("email", "Missing parameter");
        }

        if (userJson.has("phoneNumber")) {
            String phoneNumber = userJson.getString("phoneNumber");
            if (!CommonUtils.isValidPhoneNumber(phoneNumber)) {
                errorList.put("phoneNumber", "Please enter valid phone number");
            }
        } else {
            errorList.put("phoneNumber", "Missing parameter");
        }

        if (userJson.has("lastName")) {
            String lastName = userJson.getString("lastName");
        }

        if (userJson.has("age")) {
            String age = userJson.getString("age");
        }

        return errorList;
    }

    private Users setUser(String userData) {
        JSONObject obj = new JSONObject(userData);
        Users user = new Users();
        user.setUsername(obj.getString("username"));
        user.setPassword(obj.getString("password"));
        user.setEmail(obj.getString("email"));
        user.setFirstName(obj.getString("firstName"));
        user.setPhoneNumber(obj.getString("phoneNumber"));
        if (obj.has("lastName")) {
            user.setLastName(obj.getString("lastName"));
        }
        if (obj.has("age")) {
            user.setAge(obj.getInt("age"));
        }
        if (obj.has("gender")) {
            user.setGender(obj.getString("gender"));
        }
        Timestamp createdTime = new Timestamp(System.currentTimeMillis());
        user.setCreatedDate(createdTime);

        Status status = statusRepository.findById(1).get();
        user.setStatusId(status);

        return user;
    }
}
