package com.wise.buddy.wiseBuddy.dto;

public class PlanResponseDTO {
    private Long planId;
    private String planName;

    public PlanResponseDTO() {}

    public PlanResponseDTO(Long planId, String planName) {
        this.planId = planId;
        this.planName = planName;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
}