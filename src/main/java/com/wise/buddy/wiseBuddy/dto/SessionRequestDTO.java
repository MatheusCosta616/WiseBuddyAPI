package com.wise.buddy.wiseBuddy.dto;

import java.time.LocalDateTime;

public class SessionRequestDTO {
    private Long userId;
    private String sessionCompiled;
    private LocalDateTime sessionDate;
    private Long recommendationId;

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