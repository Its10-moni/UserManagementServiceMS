package com.tekarch.UserManagementServiceMS.Repositories;

import com.tekarch.UserManagementServiceMS.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   // User findByUsername(String username);
   Optional<User> findByUserid(Long userid);
}
