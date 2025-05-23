package com.wise.buddy.wiseBuddy.dto;

import java.time.LocalDate;

public class RecommendationResponseDTO {
    private Long recommendationId;
    private Long userId;
    private Long sessionId;
    private Long suitabilityId;
    private String inputJson;
    private String outputJson;
    private LocalDate requestDate;

    public RecommendationResponseDTO() {}

    public RecommendationResponseDTO(Long recommendationId, Long userId, Long sessionId, Long suitabilityId,
                                     String inputJson, String outputJson, LocalDate requestDate) {
        this.recommendationId = recommendationId;
        this.userId = userId;
        this.sessionId = sessionId;
        this.suitabilityId = suitabilityId;
        this.inputJson = inputJson;
        this.outputJson = outputJson;
        this.requestDate = requestDate;
    }

    public Long getRecommendationId() { return recommendationId; }
    public void setRecommendationId(Long recommendationId) { this.recommendationId = recommendationId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public Long getSuitabilityId() { return suitabilityId; }
    public void setSuitabilityId(Long suitabilityId) { this.suitabilityId = suitabilityId; }

    public String getInputJson() { return inputJson; }
    public void setInputJson(String inputJson) { this.inputJson = inputJson; }

    public String getOutputJson() { return outputJson; }
    public void setOutputJson(String outputJson) { this.outputJson = outputJson; }

    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
}