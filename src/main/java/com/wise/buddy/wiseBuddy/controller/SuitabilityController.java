package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.SuitabilityRequestDTO;
import com.wise.buddy.wiseBuddy.model.SuitabilityModel;
import com.wise.buddy.wiseBuddy.service.SuitabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wise-buddy/v1/suitabilities")
public class SuitabilityController {

    private final SuitabilityService suitabilityService;

    public SuitabilityController(SuitabilityService suitabilityService) {
        this.suitabilityService = suitabilityService;
    }

    @PostMapping
    public ResponseEntity<?> createSuitability(@RequestBody SuitabilityRequestDTO dto) {
        try {
            SuitabilityModel created = suitabilityService.cadastrarSuitability(dto);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}