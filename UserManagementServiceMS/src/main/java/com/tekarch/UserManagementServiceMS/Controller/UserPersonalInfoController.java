package com.tekarch.UserManagementServiceMS.Controller;

import com.tekarch.UserManagementServiceMS.Models.User;
import com.tekarch.UserManagementServiceMS.Services.UserPersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/{userid}/personalinfo")
public class UserPersonalInfoController {

    @Autowired
    private final UserPersonalInfoService userPersonalInfoService;

    public UserPersonalInfoController(UserPersonalInfoService userPersonalInfoService) {
        this.userPersonalInfoService = userPersonalInfoService;
    }
    @GetMapping("/cross-join")
    public ResponseEntity<Object[]> getCrossJoinData(@PathVariable Long userid) {
        return userPersonalInfoService.getCrossJoinData()
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));}
    }

