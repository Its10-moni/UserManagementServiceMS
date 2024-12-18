package com.tekarch.UserManagementServiceMS.Services.Interfaces;

import com.tekarch.UserManagementServiceMS.Models.User;

import java.util.Optional;

public interface UserManageServices {
    User createUser(User user);
    Optional<User> getuserById(Long userid);
    Iterable<User> getAllUser();
    Optional<User> updateUserById(Long userid, User userDetails);
    // List<User> getAccountsByAccountTypes(List<String> accountType);

    default void deleteUser(Long userid) {

    }
}
