package com.wise.buddy.wiseBuddy.dto;

public class CardRequestDTO {
    private Long userId;
    private String maskedNumber;
    private String token;
    private String brand;
    private String expirationDate;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMaskedNumber() { return maskedNumber; }
    public void setMaskedNumber(String maskedNumber) { this.maskedNumber = maskedNumber; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
}