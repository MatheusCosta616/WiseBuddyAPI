package com.wise.buddy.wiseBuddy.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "RECOMMENDATION")
public class RecommendationModel implements Serializable {

    @Id
    @Column(name = "recommendation_id", nullable = false, unique = true)
    private Long recommendationId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "session_id", nullable = false)
    private Long sessionId;

    @Column(name = "suitability_id", nullable = false)
    private Long suitabilityId;

    @Column(name = "input_json", length = 4000, nullable = false)
    private String inputJson;

    @Column(name = "output_json", length = 4000, nullable = false)
    private String outputJson;

    @Column(name = "request_date", nullable = false)
    private LocalDate requestDate;

    public RecommendationModel() {}

    public Long getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSuitabilityId() {
        return suitabilityId;
    }

    public void setSuitabilityId(Long suitabilityId) {
        this.suitabilityId = suitabilityId;
    }

    public String getInputJson() {
        return inputJson;
    }

    public void setInputJson(String inputJson) {
        this.inputJson = inputJson;
    }

    public String getOutputJson() {
        return outputJson;
    }

    public void setOutputJson(String outputJson) {
        this.outputJson = outputJson;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecommendationModel that)) return false;
        return recommendationId != null && recommendationId.equals(that.recommendationId);
    }

    @Override
    public int hashCode() {
        return recommendationId != null ? recommendationId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "recommendationId=" + recommendationId +
                ", userId=" + userId +
                ", sessionId=" + sessionId +
                ", suitabilityId=" + suitabilityId +
                ", inputJson='" + inputJson + '\'' +
                ", outputJson='" + outputJson + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}