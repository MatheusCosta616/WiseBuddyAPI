package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.CardRequestDTO;
import com.wise.buddy.wiseBuddy.dto.CardResponseDTO;
import com.wise.buddy.wiseBuddy.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wise-buddy/v1/cards")
@Tag(name = "Cards", description = "Endpoints for managing credit/debit cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @Operation(
            summary = "Create a new card",
            description = "Registers a new card for a user.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Card successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid request or user does not exist")
            }
    )
    @PostMapping
    public ResponseEntity<CardResponseDTO> createCard(
            @RequestBody CardRequestDTO dto
    ) {
        try {
            CardResponseDTO response = cardService.saveCard(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Get all cards",
            description = "Returns a list with all cards registered in the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of all cards")
            }
    )
    @GetMapping
    public ResponseEntity<List<CardResponseDTO>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @Operation(
            summary = "Get cards by user ID",
            description = "Returns all cards registered for a specific user.",
            parameters = {
                    @Parameter(name = "userId", description = "ID of the user", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of cards for the user")
            }
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CardResponseDTO>> getCardsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(cardService.getCardsByUserId(userId));
    }

    @Operation(
            summary = "Delete a card by ID",
            description = "Deletes a specific card by its ID.",
            parameters = {
                    @Parameter(name = "cardId", description = "ID of the card to delete", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Card successfully deleted")
            }
    )
    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCardById(@PathVariable Long cardId) {
        cardService.deleteCardById(cardId);
        return ResponseEntity.noContent().build();
    }
}