package com.wise.buddy.wiseBuddy.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentResponseDTO {
    private Long paymentId;
    private Long userId;
    private Long planId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;

    public PaymentResponseDTO() {}

    public PaymentResponseDTO(Long paymentId, Long userId, Long planId, BigDecimal amount,
                              LocalDate paymentDate, String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.planId = planId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getPlanId() { return planId; }
    public void setPlanId(Long planId) { this.planId = planId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}