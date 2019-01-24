package com.grayash.manage.user.response;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ManagerUserResponse extends Status implements Serializable{

    private String firstName;
    private String lastName;
    private String address;
    private String userId;
    private String phoneNumber;
    private String emailId;
    private String phoneNumberCountryCode;
    private AccountStatus accountStatus;
    private Verify verifyStatus;
    private String customerId;
    private OauthToken token;
}
