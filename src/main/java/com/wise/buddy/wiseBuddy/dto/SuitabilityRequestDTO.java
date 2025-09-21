package com.wise.buddy.wiseBuddy.dto;

import java.time.LocalDate;

public class SuitabilityRequestDTO {
    private Long userId;
    private Integer score;
    private String profile;
    private LocalDate evaluationDate;
    private String json;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public String getProfile() { return profile; }
    public void setProfile(String profile) { this.profile = profile; }

    public LocalDate getEvaluationDate() { return evaluationDate; }
    public void setEvaluationDate(LocalDate evaluationDate) { this.evaluationDate = evaluationDate; }

    public String getJson() { return json; }
    public void setJson(String json) { this.json = json; }
}