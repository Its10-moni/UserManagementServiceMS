package com.tekarch.UserManagementServiceMS.Controller;

import com.tekarch.UserManagementServiceMS.DTO.AccountDTO;
import com.tekarch.UserManagementServiceMS.Models.User;
import com.tekarch.UserManagementServiceMS.Services.Interfaces.UserManageServices;
import com.tekarch.UserManagementServiceMS.Services.UserManageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserServiceController {
    @Autowired
    private final UserManageServiceImpl userManageServices;

    public UserServiceController(UserManageServiceImpl userManageServices) {
        this.userManageServices = userManageServices;
    }



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = userManageServices.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
    @GetMapping
    public Iterable<User> getAllUser() {
        return userManageServices.getAllUser();
    }
    @GetMapping("/{userid}")
    public ResponseEntity<User> getuserById(@PathVariable Long userid) {
        return userManageServices.getuserById(userid)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{userid}")
    public User updateUserById(@PathVariable Long userid,@RequestBody AccountDTO userDetails) {
        return userManageServices.updateUserByAccountId(userid,userDetails);

    }


    @DeleteMapping("/{userid}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userid) {
        userManageServices.deleteUser(userid);
        return ResponseEntity.noContent().build();

    }
}
