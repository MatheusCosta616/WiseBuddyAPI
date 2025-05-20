package com.wise.buddy.wiseBuddy.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class PaymentModel implements Serializable {

    @Id
    @Column(name = "payment_id", length = 10)
    private Long paymentId;

    @Column(name = "user_id", length = 10, nullable = false)
    private Long userId;

    @Column(name = "plan_id", length = 3, nullable = false)
    private Long planId;

    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "payment_method", length = 30, nullable = false)
    private String paymentMethod;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public PaymentModel() {}

    public PaymentModel(Long paymentId, Long userId, Long planId, BigDecimal amount, LocalDate paymentDate, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.planId = planId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}