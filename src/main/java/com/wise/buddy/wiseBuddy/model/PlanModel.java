package com.wise.buddy.wiseBuddy.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plan")
public class PlanModel implements Serializable {

    @Id
    @Column(name = "plan_id", length = 3)
    private Long planId;

    @Column(name = "plan_name", length = 50, nullable = false)
    private String planName;

    public PlanModel() {
    }

    public PlanModel(Long planId, String planName) {
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