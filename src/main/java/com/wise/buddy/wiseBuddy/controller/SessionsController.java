package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.SessionRequestDTO;
import com.wise.buddy.wiseBuddy.dto.SessionResponseDTO;
import com.wise.buddy.wiseBuddy.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wise-buddy/v1/sessions")
public class SessionsController {

    private final SessionService sessionService;

    public SessionsController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<SessionResponseDTO> createSession(@RequestBody SessionRequestDTO dto) {
        try {
            SessionResponseDTO response = sessionService.saveSession(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SessionResponseDTO>> getSessionsByUserId(@PathVariable Long userId) {
        List<SessionResponseDTO> sessions = sessionService.getSessionsByUserId(userId);
        return ResponseEntity.ok(sessions);
    }
}