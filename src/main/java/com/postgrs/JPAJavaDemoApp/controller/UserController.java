package com.postgrs.JPAJavaDemoApp.controller;

import com.postgrs.JPAJavaDemoApp.entity.Person;
import com.postgrs.JPAJavaDemoApp.model.RegisterModel;
import com.postgrs.JPAJavaDemoApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("register")

    public HttpStatus registerUer(@RequestBody RegisterModel registerModel) {
        ModelMapper modelMapper = new ModelMapper();
        Person userDTO = modelMapper.map(registerModel, Person.class);
        //userService.addPerson(userDTO);
        return userService.addPerson(userDTO) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }
}
