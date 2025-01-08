package com.tekarch.UserManagementServiceMS.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Table(name = "user")
@Data
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(name = "Email", nullable = true)
    private String Email;

   @Column(name = "MobileNumber", nullable = true)
    private Long MobileNumber;



    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userid")
    private User user;


}