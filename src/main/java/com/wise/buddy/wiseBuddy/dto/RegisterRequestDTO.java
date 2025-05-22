package com.wise.buddy.wiseBuddy.dto;

import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String incomeRange;

    public RegisterRequestDTO() {}

    public RegisterRequestDTO(String name, String surname, String email, String password, String incomeRange) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.incomeRange = incomeRange;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getIncomeRange() { return incomeRange; }
    public void setIncomeRange(String incomeRange) { this.incomeRange = incomeRange; }
}