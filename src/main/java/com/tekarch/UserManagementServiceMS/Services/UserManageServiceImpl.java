package com.tekarch.UserManagementServiceMS.Services;

import com.tekarch.UserManagementServiceMS.DTO.AccountDTO;
import com.tekarch.UserManagementServiceMS.Models.User;
import com.tekarch.UserManagementServiceMS.Repositories.UserRepository;
import com.tekarch.UserManagementServiceMS.Services.Interfaces.UserManageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service
public class UserManageServiceImpl implements UserManageServices {
    private final UserRepository userRepository;

   private final String ACCOUNT_URL = "http://localhost:8082/accounts/";
   @Autowired
   private RestTemplate restTemplate;
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
    public User updateUserByAccountId(Long userid, AccountDTO userDetails) {
        String url = ACCOUNT_URL + "/{userid}";
        AccountDTO existingUser = restTemplate.getForObject(url ,AccountDTO.class,userid);
        if (existingUser != null) {
            //AccountDTO existingUser = existingUserOpt.get();

           existingUser.setAccountId(userDetails.getAccountId());
            //existingUser.setUsername(userDetails.getUsername());
            existingUser.setBalance(userDetails.getBalance());
           existingUser.setCurrency(userDetails.getCurrency());
           existingUser.setAccountType(userDetails.getAccountType());

            Optional<User> userOptional = userRepository.findByUserid(userid);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
               // user.setAccountDetails(existingUser); // Updating user with new AccountDTO
                return userRepository.save(user); // Save the updated user
            }
        }
        return null;

    }

public void deleteUser(Long userid) {
    userRepository.deleteById(userid);
}
}