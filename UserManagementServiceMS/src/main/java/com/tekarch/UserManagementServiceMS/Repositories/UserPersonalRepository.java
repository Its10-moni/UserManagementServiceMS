package com.tekarch.UserManagementServiceMS.Repositories;

import com.tekarch.UserManagementServiceMS.Models.PersonalInfo;
import com.tekarch.UserManagementServiceMS.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPersonalRepository extends JpaRepository<PersonalInfo,Long> {

   // @Query(value = "SELECT * FROM user u CROSS JOIN account a", nativeQuery = true)
    @Query(value = "SELECT * FROM user",nativeQuery = true)

    //@Query(value = "SELECT * FROM user JSON_OBJECT( ) AS account_json FROM accounts", nativeQuery = true)
    Optional<Object[]> getUsersWithPersonalinfoCrossJoin();
}
