package com.tekarch.UserManagementServiceMS.Controller;

import com.tekarch.UserManagementServiceMS.Models.PersonalInfo;
import com.tekarch.UserManagementServiceMS.Models.User;
import com.tekarch.UserManagementServiceMS.Services.Interfaces.PersonalInfoServices;
import com.tekarch.UserManagementServiceMS.Services.Interfaces.UserManageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/{userid}/personalinfo")
public class PersonalInfoController {


    private final PersonalInfoServices personalInfoServices;

    @Autowired
    public PersonalInfoController(PersonalInfoServices personalInfoServices) {
        this.personalInfoServices = personalInfoServices;
    }
    @PostMapping
    public ResponseEntity<PersonalInfo> createpersonalInfo(@RequestBody PersonalInfo personalInfo) {
        PersonalInfo createpersonalInfo = personalInfoServices.createpersonalInfo(personalInfo);
        return new ResponseEntity<>(createpersonalInfo, HttpStatus.CREATED);
    }


    @GetMapping
    public Iterable<PersonalInfo> getAllPersonalInfo(@PathVariable Long userid) {
        return personalInfoServices.getAllPersonalInfo();

    }

    @PutMapping
    public ResponseEntity<PersonalInfo> updatePersonalInfo(@PathVariable Long userid, @RequestBody PersonalInfo userDetails) {
        return personalInfoServices.updatePersonalInfo(userid, userDetails)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}