package com.wise.buddy.wiseBuddy.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class ContractModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "user_id", length = 10, nullable = false)
    private Long userId;

    @Column(name = "plan_id", length = 3, nullable = false)
    private Long planId;

    @Column(name = "contract_date", nullable = false)
    private LocalDate contractDate;

    public ContractModel() {}

    public ContractModel(Long userId, Long planId, LocalDate contractDate) {
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