package com.wise.buddy.wiseBuddy.dto;

import java.time.LocalDate;

public class ContractRequestDTO {
    private Long userId;
    private Long planId;
    private LocalDate contractDate;

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
    public LocalDate getContractDate() {
        return contractDate;
    }
    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }
}