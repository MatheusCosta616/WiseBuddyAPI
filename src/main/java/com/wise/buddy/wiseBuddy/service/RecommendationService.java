package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.RecommendationRequestDTO;
import com.wise.buddy.wiseBuddy.dto.RecommendationResponseDTO;

import java.util.List;

public interface RecommendationService {
    RecommendationResponseDTO createRecommendation(RecommendationRequestDTO dto);
    List<RecommendationResponseDTO> getRecommendationsByUserId(Long userId);
    RecommendationResponseDTO getRecommendationById(Long recommendationId);
}