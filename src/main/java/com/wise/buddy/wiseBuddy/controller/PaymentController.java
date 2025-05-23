package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.PaymentRequestDTO;
import com.wise.buddy.wiseBuddy.dto.PaymentResponseDTO;
import com.wise.buddy.wiseBuddy.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wise-buddy/v1/payments")
@Tag(name = "Payments", description = "Endpoints for managing payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(
            summary = "Create a new payment",
            description = "Registers a new payment for a user and plan.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Payment successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid request or user/plan does not exist")
            }
    )
    @PostMapping
    public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentRequestDTO dto) {
        try {
            PaymentResponseDTO response = paymentService.savePayment(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Get payments by user ID",
            description = "Returns all payments registered for a specific user.",
            parameters = {
                    @Parameter(name = "userId", description = "ID of the user", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of payments for the user")
            }
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentResponseDTO>> getPaymentsByUserId(@PathVariable Long userId) {
        List<PaymentResponseDTO> payments = paymentService.getPaymentsByUserId(userId);
        return ResponseEntity.ok(payments);
    }
}