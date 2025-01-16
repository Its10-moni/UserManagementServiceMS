package com.tekarch.UserManagementServiceMS.DTO;

import lombok.Data;

@Data
public class AccountDTO {
    private Integer accountId;
    private String accountNumber;
    private String accountType;
    private Double balance;
    private String currency;
}
