package com.SoftUniExam.BonAppetit.Model.Binding;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserLoginBindingModel {
    @Size(min=3, max=20, message = "Username length must be between 3 and 20 characters." )
    @NotBlank(message = "Username could not be blank.")
    private String username;
    @Size(min=3, max=20, message = "Password length must be between 3 and 20 characters.")
    @NotBlank(message = "Password could not be blank.")
    private String password;

    public UserLoginBindingModel() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
