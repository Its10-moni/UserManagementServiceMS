package com.tekarch.UserManagementServiceMS.Services;

import com.tekarch.UserManagementServiceMS.Models.PersonalInfo;
import com.tekarch.UserManagementServiceMS.Models.User;
import com.tekarch.UserManagementServiceMS.Repositories.PersonalInfoRepository;
import com.tekarch.UserManagementServiceMS.Repositories.UserRepository;
import com.tekarch.UserManagementServiceMS.Services.Interfaces.PersonalInfoServices;
import com.tekarch.UserManagementServiceMS.Services.Interfaces.UserManageServices;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PersonalInfoServiceImpl implements PersonalInfoServices {
    private final PersonalInfoRepository personalInfoRepository;

    public PersonalInfoServiceImpl(PersonalInfoRepository personalInfoRepository) {
        this.personalInfoRepository = personalInfoRepository;
    }


    @Override
    public PersonalInfo createpersonalInfo(PersonalInfo personalInfo) {
        return personalInfoRepository.save(personalInfo);
    }

    @Override
    public Iterable<PersonalInfo> getAllPersonalInfo() {
        return personalInfoRepository.findAll();
    }



    @Override
    public Optional<PersonalInfo> updatePersonalInfo(Long userid, PersonalInfo userDetails) {
        Optional<PersonalInfo> existingUserOpt =  personalInfoRepository.findById(userid);
        if (existingUserOpt.isPresent()) {
            PersonalInfo existingUser = existingUserOpt.get();

            existingUser.setEmail(userDetails.getEmail());
            existingUser.setAddress(userDetails.getAddress());
            existingUser.setMobileNumber(userDetails.getMobileNumber());

            return Optional.of(personalInfoRepository.save(existingUser));
        }
        return null;
    }
}
