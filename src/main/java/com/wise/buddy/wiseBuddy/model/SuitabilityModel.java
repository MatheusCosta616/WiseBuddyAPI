package com.wise.buddy.wiseBuddy.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "SUITABILITY")
public class SuitabilityModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suitability_id", nullable = false, unique = true)
    private Long suitabilityId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "profile", length = 20, nullable = false)
    private String profile;

    @Column(name = "evaluation_date", nullable = false)
    private LocalDate evaluationDate; // Data em que o teste foi finalizado

    @Column(name = "json", length = 2000, nullable = false)
    private String json;

    public SuitabilityModel() {}

    public Long getSuitabilityId() {
        return suitabilityId;
    }

    public void setSuitabilityId(Long suitabilityId) {
        this.suitabilityId = suitabilityId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public LocalDate getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDate evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}