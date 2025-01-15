package com.tekarch.UserManagementServiceMS.Models;


import com.tekarch.UserManagementServiceMS.DTO.AccountDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column(name = "username", nullable = false, unique = true)
    @NotEmpty(message = "Name should not be empty")
    private String username;
   // private AccountDTO accountDetails;






    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PersonalInfo personalInfo;


}



