package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.CardRequestDTO;
import com.wise.buddy.wiseBuddy.dto.CardResponseDTO;

import java.util.List;

public interface CardService {
    CardResponseDTO saveCard(CardRequestDTO dto);
    List<CardResponseDTO> getAllCards();
    List<CardResponseDTO> getCardsByUserId(Long userId);
    void deleteCardById(Long cardId);
}