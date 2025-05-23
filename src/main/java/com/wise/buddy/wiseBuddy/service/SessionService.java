package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.SessionRequestDTO;
import com.wise.buddy.wiseBuddy.dto.SessionResponseDTO;

import java.util.List;

public interface SessionService {
    SessionResponseDTO saveSession(SessionRequestDTO dto);
    List<SessionResponseDTO> getSessionsByUserId(Long userId);
}