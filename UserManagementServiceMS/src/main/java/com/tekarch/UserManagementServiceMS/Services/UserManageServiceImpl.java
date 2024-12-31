package com.tekarch.UserManagementServiceMS.Services;

import com.tekarch.UserManagementServiceMS.Models.User;
import com.tekarch.UserManagementServiceMS.Repositories.UserRepository;
import com.tekarch.UserManagementServiceMS.Services.Interfaces.UserManageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserManageServiceImpl implements UserManageServices {
    private final UserRepository userRepository;

    @Autowired
    public UserManageServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getuserById(Long userid) {
        return userRepository.findById(userid);
    }

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> updateUserById(Long userid, User userDetails) {
        Optional<User> existingUserOpt =  userRepository.findById(userid);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            existingUser.setAccountId(userDetails.getAccountId());
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setBalance(userDetails.getBalance());
            existingUser.setCurrency(userDetails.getCurrency());
            existingUser.setAccountType(userDetails.getAccountType());

            return Optional.of(userRepository.save(existingUser));
        }
        return null;
    }

public void deleteUser(Long userid) {
    userRepository.deleteById(userid);
}
}