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
    public ResponseEntity<ContractResponseDTO> createContract(@RequestBody ContractRequestDTO dto) {
        try {
            ContractResponseDTO response = contractService.saveContract(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
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
    public ResponseEntity<List<ContractResponseDTO>> getContractsByUserId(@PathVariable Long userId) {
        List<ContractResponseDTO> contracts = contractService.getContractsByUserId(userId);
        return ResponseEntity.ok(contracts);
    }
}