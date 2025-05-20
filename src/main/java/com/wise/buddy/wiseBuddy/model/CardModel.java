package com.wise.buddy.wiseBuddy.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "card")
public class CardModel implements Serializable {

    @Id
    @Column(name = "card_id", length = 10)
    private Long cardId;

    @Column(name = "user_id", length = 10, nullable = false)
    private Long userId;

    @Column(name = "masked_number", length = 20, nullable = false)
    private String maskedNumber;

    @Column(name = "token", length = 255, nullable = false)
    private String token;

    @Column(name = "brand", length = 20, nullable = false)
    private String brand;

    @Column(name = "expiration_date", length = 7, nullable = false)
    private String expirationDate; // formato MM/YYYY

    public CardModel() {}

    public CardModel(Long cardId, Long userId, String maskedNumber, String token, String brand, String expirationDate) {
        this.cardId = cardId;
        this.userId = userId;
        this.maskedNumber = maskedNumber;
        this.token = token;
        this.brand = brand;
        this.expirationDate = expirationDate;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMaskedNumber() {
        return maskedNumber;
    }

    public void setMaskedNumber(String maskedNumber) {
        this.maskedNumber = maskedNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}