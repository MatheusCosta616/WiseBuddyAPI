package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.PlanResponseDTO;
import com.wise.buddy.wiseBuddy.service.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wise-buddy/v1/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public ResponseEntity<List<PlanResponseDTO>> getAllPlans() {
        List<PlanResponseDTO> plans = planService.getAllPlans();
        return ResponseEntity.ok(plans);
    }
}