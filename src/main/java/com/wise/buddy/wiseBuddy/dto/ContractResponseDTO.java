package com.wise.buddy.wiseBuddy.dto;

import java.time.LocalDate;

public class ContractResponseDTO {
    private Long contractId;
    private Long userId;
    private Long planId;
    private LocalDate contractDate;

    public ContractResponseDTO() {}

    public ContractResponseDTO(Long contractId, Long userId, Long planId, LocalDate contractDate) {
        this.contractId = contractId;
        this.userId = userId;
        this.planId = planId;
        this.contractDate = contractDate;
    }

    public Long getContractId() {
        return contractId;
    }
    public void setContractId(Long contractId) {
        this.contractId = contractId;
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
    public LocalDate getContractDate() {
        return contractDate;
    }
    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }
}