package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.SessionRequestDTO;
import com.wise.buddy.wiseBuddy.dto.SessionResponseDTO;
import com.wise.buddy.wiseBuddy.service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wise-buddy/v1/sessions")
@Tag(name = "Sessions", description = "Endpoints for managing sessions")
public class SessionsController {

    private final SessionService sessionService;

    public SessionsController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Operation(
            summary = "Create a new session",
            description = "Registers a new session for a user.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Session successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid request or user does not exist")
            }
    )
    @PostMapping
    public ResponseEntity<SessionResponseDTO> createSession(@RequestBody SessionRequestDTO dto) {
        try {
            SessionResponseDTO response = sessionService.saveSession(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Get sessions by user ID",
            description = "Returns all sessions registered for a specific user.",
            parameters = {
                    @Parameter(name = "userId", description = "ID of the user", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of sessions for the user")
            }
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SessionResponseDTO>> getSessionsByUserId(@PathVariable Long userId) {
        List<SessionResponseDTO> sessions = sessionService.getSessionsByUserId(userId);
        return ResponseEntity.ok(sessions);
    }
}