package com.myBudget.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterForm {

    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String confirmPassword;

}
