package com.tekarch.UserManagementServiceMS.Services;

import com.tekarch.UserManagementServiceMS.Repositories.UserPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPersonalInfoService {
    @Autowired
    private final UserPersonalRepository userPersonalRepository;

    public UserPersonalInfoService(UserPersonalRepository userPersonalRepository) {
        this.userPersonalRepository = userPersonalRepository;
    }
    // Method to fetch the cross join data
    public Optional<Object[]> getCrossJoinData() {
        return userPersonalRepository.getUsersWithPersonalinfoCrossJoin();

    }
}
