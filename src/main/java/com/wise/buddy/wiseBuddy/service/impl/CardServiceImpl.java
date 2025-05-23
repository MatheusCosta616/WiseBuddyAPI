package com.wise.buddy.wiseBuddy.service.impl;

import com.wise.buddy.wiseBuddy.dto.CardRequestDTO;
import com.wise.buddy.wiseBuddy.dto.CardResponseDTO;
import com.wise.buddy.wiseBuddy.model.CardModel;
import com.wise.buddy.wiseBuddy.model.UserModel;
import com.wise.buddy.wiseBuddy.repository.CardRepository;
import com.wise.buddy.wiseBuddy.repository.UserRepository;
import com.wise.buddy.wiseBuddy.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public CardServiceImpl(CardRepository cardRepository, UserRepository userRepository) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CardResponseDTO saveCard(CardRequestDTO dto) {
        UserModel user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + dto.getUserId()));

        CardModel card = new CardModel();
        card.setUser(user);
        card.setMaskedNumber(dto.getMaskedNumber());
        card.setToken(dto.getToken());
        card.setBrand(dto.getBrand());
        card.setExpirationDate(dto.getExpirationDate());

        CardModel saved = cardRepository.save(card);

        return new CardResponseDTO(
                saved.getCardId(),
                saved.getUser().getId(),
                saved.getMaskedNumber(),
                saved.getToken(),
                saved.getBrand(),
                saved.getExpirationDate()
        );
    }

    @Override
    public List<CardResponseDTO> getAllCards() {
        return cardRepository.findAll().stream()
                .map(c -> new CardResponseDTO(
                        c.getCardId(),
                        c.getUser().getId(),
                        c.getMaskedNumber(),
                        c.getToken(),
                        c.getBrand(),
                        c.getExpirationDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CardResponseDTO> getCardsByUserId(Long userId) {
        return cardRepository.findAllByUser_Id(userId).stream()
                .map(c -> new CardResponseDTO(
                        c.getCardId(),
                        c.getUser().getId(),
                        c.getMaskedNumber(),
                        c.getToken(),
                        c.getBrand(),
                        c.getExpirationDate()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCardById(Long cardId) {
        cardRepository.deleteById(cardId);
    }
}