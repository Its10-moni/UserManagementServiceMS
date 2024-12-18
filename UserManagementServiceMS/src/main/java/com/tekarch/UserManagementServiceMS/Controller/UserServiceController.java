package com.tekarch.UserManagementServiceMS.Controller;

import com.tekarch.UserManagementServiceMS.Models.User;
import com.tekarch.UserManagementServiceMS.Services.Interfaces.UserManageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserServiceController {
    private final UserManageServices userManageServices;
    @Autowired
    public UserServiceController(UserManageServices userManageServices) {
        this.userManageServices = userManageServices;
    }

    @PostMapping
    public ResponseEntity<User> createAccount(@RequestBody User user) {
        User createUser = userManageServices.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
    @GetMapping
    public Iterable<User> getAllAccounts() {
        return userManageServices.getAllUser();
    }
    @GetMapping("/{userid}")
    public ResponseEntity<User> getAccount(@PathVariable Long userid) {
        return userManageServices.getuserById(userid)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{userid}")
    public ResponseEntity<User> updateUserById(@PathVariable Long userid,@RequestBody User userDetails) {
        return userManageServices.updateUserById(userid,userDetails)
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{userid}")
    public ResponseEntity<User> deleteAccount(@PathVariable Long userid) {
        userManageServices.deleteUser(userid);
        return ResponseEntity.noContent().build();

    }
}
