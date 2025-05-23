package com.wise.buddy.wiseBuddy.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "SESSION")
public class SessionModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id", nullable = false, unique = true)
    private Long sessionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "session_compiled", length = 4000, nullable = false)
    private String sessionCompiled;

    @Column(name = "session_date", nullable = false)
    private LocalDateTime sessionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recommendation_id")
    private RecommendationModel recommendation;

    public SessionModel() {}

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
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

    public RecommendationModel getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(RecommendationModel recommendation) {
        this.recommendation = recommendation;
    }
}
