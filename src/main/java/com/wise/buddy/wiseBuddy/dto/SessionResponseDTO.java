package com.wise.buddy.wiseBuddy.dto;

import java.time.LocalDateTime;

public class SessionResponseDTO {
    private Long sessionId;
    private Long userId;
    private String sessionCompiled;
    private LocalDateTime sessionDate;
    private Long recommendationId;

    public SessionResponseDTO() {}

    public SessionResponseDTO(Long sessionId, Long userId, String sessionCompiled, LocalDateTime sessionDate, Long recommendationId) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.sessionCompiled = sessionCompiled;
        this.sessionDate = sessionDate;
        this.recommendationId = recommendationId;
    }

    public Long getSessionId() {
        return sessionId;
    }
    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getSessionCompiled() {
        return sessionCompiled;
    }
    public void setSessionCompiled(String sessionCompiled) {
        this.sessionCompiled = sessionCompiled;
    }
    public LocalDateTime getSessionDate() {
        return sessionDate;
    }
    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }
    public Long getRecommendationId() {
        return recommendationId;
    }
    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }
}