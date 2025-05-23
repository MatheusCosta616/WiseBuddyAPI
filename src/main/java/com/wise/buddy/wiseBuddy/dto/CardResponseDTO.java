package com.wise.buddy.wiseBuddy.dto;

public class CardResponseDTO {
    private Long cardId;
    private Long userId;
    private String maskedNumber;
    private String token;
    private String brand;
    private String expirationDate;

    public CardResponseDTO() {}

    public CardResponseDTO(Long cardId, Long userId, String maskedNumber, String token, String brand, String expirationDate) {
        this.cardId = cardId;
        this.userId = userId;
        this.maskedNumber = maskedNumber;
        this.token = token;
        this.brand = brand;
        this.expirationDate = expirationDate;
    }

    public Long getCardId() { return cardId; }
    public void setCardId(Long cardId) { this.cardId = cardId; }

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