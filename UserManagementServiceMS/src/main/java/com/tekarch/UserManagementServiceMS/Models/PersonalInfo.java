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

    @Column(name = "Email", nullable = false)
    private String Email;

    @Column(name = "MobileNumber", nullable = false)
    private Long MobileNumber;

    @Column(name = "Address", nullable = false)
    private String Address;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userid")
    private User user;


}