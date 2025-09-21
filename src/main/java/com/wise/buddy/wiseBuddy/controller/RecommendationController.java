package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.RecommendationRequestDTO;
import com.wise.buddy.wiseBuddy.dto.RecommendationResponseDTO;
import com.wise.buddy.wiseBuddy.service.RecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wise-buddy/v1/recommendations")
@Tag(name = "Recommendations", description = "Endpoints for managing recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @Operation(
            summary = "Create a new recommendation",
            description = "Registers a new recommendation for a user, session, and suitability.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recommendation successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid request or referenced entities do not exist")
            }
    )
    @PostMapping("/request")
    public ResponseEntity<?> createRecommendation(@RequestBody RecommendationRequestDTO dto) {
        try {
            RecommendationResponseDTO response = recommendationService.createRecommendation(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @Operation(
            summary = "Get recommendations by user ID",
            description = "Returns all recommendations registered for a specific user.",
            parameters = {
                    @Parameter(name = "userId", description = "ID of the user", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of recommendations for the user")
            }
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getRecommendationsByUserId(@PathVariable Long userId) {
        try {
            List<RecommendationResponseDTO> responses = recommendationService.getRecommendationsByUserId(userId);
            return ResponseEntity.ok(responses);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(404).body(error);
        }
    }

    @Operation(
            summary = "Get recommendation by ID",
            description = "Returns a recommendation by its ID.",
            parameters = {
                    @Parameter(name = "id", description = "ID of the recommendation", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recommendation found"),
                    @ApiResponse(responseCode = "404", description = "Recommendation not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getRecommendationById(@PathVariable Long id) {
        try {
            RecommendationResponseDTO response = recommendationService.getRecommendationById(id);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(404).body(error);
        }
    }
}