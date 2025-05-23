package com.wise.buddy.wiseBuddy.service.impl;

import com.wise.buddy.wiseBuddy.dto.SessionRequestDTO;
import com.wise.buddy.wiseBuddy.dto.SessionResponseDTO;
import com.wise.buddy.wiseBuddy.model.RecommendationModel;
import com.wise.buddy.wiseBuddy.model.SessionModel;
import com.wise.buddy.wiseBuddy.model.UserModel;
import com.wise.buddy.wiseBuddy.repository.RecommendationRepository;
import com.wise.buddy.wiseBuddy.repository.SessionsRepository;
import com.wise.buddy.wiseBuddy.repository.UserRepository;
import com.wise.buddy.wiseBuddy.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionsRepository sessionsRepository;
    private final UserRepository userRepository;
    private final RecommendationRepository recommendationRepository;

    public SessionServiceImpl(SessionsRepository sessionsRepository, UserRepository userRepository, RecommendationRepository recommendationRepository) {
        this.sessionsRepository = sessionsRepository;
        this.userRepository = userRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public SessionResponseDTO saveSession(SessionRequestDTO dto) {
        Optional<UserModel> userOpt = userRepository.findById(dto.getUserId());
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado com ID: " + dto.getUserId());
        }

        RecommendationModel recommendation = null;
        if (dto.getRecommendationId() != null) {
            recommendation = recommendationRepository.findById(dto.getRecommendationId())
                    .orElseThrow(() -> new IllegalArgumentException("Recomendação não encontrada com ID: " + dto.getRecommendationId()));
        }

        SessionModel session = new SessionModel();
        session.setUser(userOpt.get());
        session.setSessionCompiled(dto.getSessionCompiled());
        session.setSessionDate(dto.getSessionDate());
        session.setRecommendation(recommendation);

        SessionModel saved = sessionsRepository.save(session);
        return new SessionResponseDTO(
                saved.getSessionId(),
                saved.getUser().getId(),
                saved.getSessionCompiled(),
                saved.getSessionDate(),
                saved.getRecommendation() != null ? saved.getRecommendation().getRecommendationId() : null
        );
    }

    @Override
    public List<SessionResponseDTO> getSessionsByUserId(Long userId) {
        List<SessionModel> sessions = sessionsRepository.findAllByUser_Id(userId);
        return sessions.stream().map(
                s -> new SessionResponseDTO(
                        s.getSessionId(),
                        s.getUser().getId(),
                        s.getSessionCompiled(),
                        s.getSessionDate(),
                        s.getRecommendation() != null ? s.getRecommendation().getRecommendationId() : null
                )
        ).collect(Collectors.toList());
    }
}