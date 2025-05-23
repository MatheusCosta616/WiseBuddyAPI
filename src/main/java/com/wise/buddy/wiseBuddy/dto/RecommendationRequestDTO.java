package com.wise.buddy.wiseBuddy.dto;

import java.time.LocalDate;

public class RecommendationRequestDTO {
    private Long userId;
    private Long sessionId;
    private Long suitabilityId;
    private String inputJson;
    private String outputJson;
    private LocalDate requestDate;

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