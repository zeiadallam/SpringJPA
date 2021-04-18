package com.postgrs.JPAJavaDemoApp.controller;

import com.postgrs.JPAJavaDemoApp.entity.Person;
import com.postgrs.JPAJavaDemoApp.entity.ResponseCallBack;
import com.postgrs.JPAJavaDemoApp.model.RegisterModel;
import com.postgrs.JPAJavaDemoApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("register")

    public ResponseEntity<ResponseCallBack> registerUer(@RequestBody RegisterModel registerModel) {
        ModelMapper modelMapper = new ModelMapper();
        Person userDTO = modelMapper.map(registerModel, Person.class);
        if (userService.addPerson(userDTO))
            return new ResponseEntity<ResponseCallBack>(new ResponseCallBack(HttpStatus.CREATED.value(), "user register", ""), HttpStatus.CREATED);
        else
            return new ResponseEntity<ResponseCallBack>(new ResponseCallBack(HttpStatus.BAD_REQUEST.value(), "user register failed", "email found "), HttpStatus.BAD_REQUEST);

    }
}
