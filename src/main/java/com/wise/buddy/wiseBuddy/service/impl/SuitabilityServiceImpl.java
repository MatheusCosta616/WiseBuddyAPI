package com.wise.buddy.wiseBuddy.service.impl;

import com.wise.buddy.wiseBuddy.dto.SuitabilityJsonResponseDTO;
import com.wise.buddy.wiseBuddy.dto.SuitabilityRequestDTO;
import com.wise.buddy.wiseBuddy.model.SuitabilityModel;
import com.wise.buddy.wiseBuddy.model.UserModel;
import com.wise.buddy.wiseBuddy.repository.SuitabilityRepository;
import com.wise.buddy.wiseBuddy.repository.UserRepository;
import com.wise.buddy.wiseBuddy.service.SuitabilityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuitabilityServiceImpl implements SuitabilityService {

    private final SuitabilityRepository suitabilityRepository;
    private final UserRepository userRepository;

    public SuitabilityServiceImpl(SuitabilityRepository suitabilityRepository, UserRepository userRepository) {
        this.suitabilityRepository = suitabilityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SuitabilityModel cadastrarSuitability(SuitabilityRequestDTO dto) {
        Optional<UserModel> userOpt = userRepository.findById(dto.getUserId());
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado com ID: " + dto.getUserId());
        }

        SuitabilityModel suitability = new SuitabilityModel();
        suitability.setUser(userOpt.get());
        suitability.setScore(dto.getScore());
        suitability.setProfile(dto.getProfile());
        suitability.setEvaluationDate(dto.getEvaluationDate());
        suitability.setJson(dto.getJson());

        return suitabilityRepository.save(suitability);
    }

    @Override
    public SuitabilityJsonResponseDTO getSuitabilityJsonByUserId(Long userId) {
        SuitabilityModel suitability = suitabilityRepository.findFirstByUser_Id(userId)
                .orElseThrow(() -> new IllegalArgumentException("Suitability não encontrado para userId: " + userId));
        return new SuitabilityJsonResponseDTO(suitability.getJson());
    }
}