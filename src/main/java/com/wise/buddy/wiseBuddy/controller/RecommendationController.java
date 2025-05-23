package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.RecommendationRequestDTO;
import com.wise.buddy.wiseBuddy.dto.RecommendationResponseDTO;
import com.wise.buddy.wiseBuddy.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wise-buddy/v1/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/request")
    public ResponseEntity<RecommendationResponseDTO> createRecommendation(@RequestBody RecommendationRequestDTO dto) {
        try {
            RecommendationResponseDTO response = recommendationService.createRecommendation(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationResponseDTO>> getRecommendationsByUserId(@PathVariable Long userId) {
        List<RecommendationResponseDTO> responses = recommendationService.getRecommendationsByUserId(userId);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecommendationResponseDTO> getRecommendationById(@PathVariable Long id) {
        try {
            RecommendationResponseDTO response = recommendationService.getRecommendationById(id);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}