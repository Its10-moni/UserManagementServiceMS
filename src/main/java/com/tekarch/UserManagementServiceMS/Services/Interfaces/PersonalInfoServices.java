package com.tekarch.UserManagementServiceMS.Services.Interfaces;

import com.tekarch.UserManagementServiceMS.Models.PersonalInfo;
import com.tekarch.UserManagementServiceMS.Models.User;

import java.util.Optional;

public interface PersonalInfoServices {
    PersonalInfo createpersonalInfo(PersonalInfo personalInfo);
    Iterable<PersonalInfo> getAllPersonalInfo();
    Optional<PersonalInfo> updatePersonalInfo(Long userid, PersonalInfo userDetails);
}
