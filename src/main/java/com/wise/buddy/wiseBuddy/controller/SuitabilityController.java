package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.SuitabilityJsonResponseDTO;
import com.wise.buddy.wiseBuddy.dto.SuitabilityRequestDTO;
import com.wise.buddy.wiseBuddy.model.SuitabilityModel;
import com.wise.buddy.wiseBuddy.service.SuitabilityService;
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
@RequestMapping("/wise-buddy/v1/suitabilities")
@Tag(name = "Suitabilities", description = "Endpoints for managing suitabilities")
public class SuitabilityController {

    private final SuitabilityService suitabilityService;

    public SuitabilityController(SuitabilityService suitabilityService) {
        this.suitabilityService = suitabilityService;
    }

    @Operation(
            summary = "Create a new suitability",
            description = "Registers a new suitability for a user.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Suitability successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid request or user does not exist")
            }
    )
    @PostMapping
    public ResponseEntity<?> createSuitability(@RequestBody SuitabilityRequestDTO dto) {
        try {
            SuitabilityModel created = suitabilityService.cadastrarSuitability(dto);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @Operation(
            summary = "Get suitability history by user ID",
            description = "Returns suitability history as JSON for a specific user.",
            parameters = {
                    @Parameter(name = "userId", description = "ID of the user", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Suitability history returned"),
                    @ApiResponse(responseCode = "404", description = "User or history not found")
            }
    )
    @GetMapping("/history/{userId}")
    public ResponseEntity<?> getSuitabilityJsonByUserId(@PathVariable Long userId) {
        try {
            List<SuitabilityJsonResponseDTO> response = suitabilityService.getSuitabilityJsonByUserId(userId);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(404).body(error);
        }
    }
}