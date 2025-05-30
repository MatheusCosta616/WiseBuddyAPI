package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.PlanResponseDTO;
import com.wise.buddy.wiseBuddy.service.PlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wise-buddy/v1/plans")
@Tag(name = "Plans", description = "Endpoints for retrieving plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @Operation(
            summary = "Get all plans",
            description = "Returns a list with all plans available in the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of all plans")
            }
    )
    @GetMapping
    public ResponseEntity<List<PlanResponseDTO>> getAllPlans() {
        List<PlanResponseDTO> plans = planService.getAllPlans();
        return ResponseEntity.ok(plans);
    }
}