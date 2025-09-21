package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.ContractRequestDTO;
import com.wise.buddy.wiseBuddy.dto.ContractResponseDTO;
import com.wise.buddy.wiseBuddy.service.ContractService;
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
@RequestMapping("/wise-buddy/v1/contracts")
@Tag(name = "Contracts", description = "Endpoints for managing contracts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @Operation(
            summary = "Create a new contract",
            description = "Registers a new contract for a user and plan.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Contract successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid request or user/plan does not exist")
            }
    )
    @PostMapping
    public ResponseEntity<?> createContract(@RequestBody ContractRequestDTO dto) {
        try {
            ContractResponseDTO response = contractService.saveContract(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @Operation(
            summary = "Get contracts by user ID",
            description = "Returns all contracts registered for a specific user.",
            parameters = {
                    @Parameter(name = "userId", description = "ID of the user", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of contracts for the user")
            }
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getContractsByUserId(@PathVariable Long userId) {
        try {
            List<ContractResponseDTO> contracts = contractService.getContractsByUserId(userId);
            return ResponseEntity.ok(contracts);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(404).body(error);
        }
    }
}