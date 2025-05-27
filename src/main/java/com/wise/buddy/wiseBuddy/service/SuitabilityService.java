package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.SuitabilityJsonResponseDTO;
import com.wise.buddy.wiseBuddy.dto.SuitabilityRequestDTO;
import com.wise.buddy.wiseBuddy.model.SuitabilityModel;

import java.util.List;

public interface SuitabilityService {
    SuitabilityModel cadastrarSuitability(SuitabilityRequestDTO dto);
    List<SuitabilityJsonResponseDTO> getSuitabilityJsonByUserId(Long userId);
}