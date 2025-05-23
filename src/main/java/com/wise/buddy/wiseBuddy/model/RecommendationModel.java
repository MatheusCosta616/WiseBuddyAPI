package com.wise.buddy.wiseBuddy.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "RECOMMENDATION")
public class RecommendationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommendation_id", nullable = false, unique = true)
    private Long recommendationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    private SessionModel session;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "suitability_id", nullable = false)
    private SuitabilityModel suitability;

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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public SessionModel getSession() {
        return session;
    }

    public void setSession(SessionModel session) {
        this.session = session;
    }

    public SuitabilityModel getSuitability() {
        return suitability;
    }

    public void setSuitability(SuitabilityModel suitability) {
        this.suitability = suitability;
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
        return "RecommendationModel{" +
                "recommendationId=" + recommendationId +
                ", user=" + (user != null ? user.getId() : null) +
                ", session=" + (session != null ? session.getSessionId() : null) +
                ", suitability=" + (suitability != null ? suitability.getSuitabilityId() : null) +
                ", inputJson='" + inputJson + '\'' +
                ", outputJson='" + outputJson + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}