package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.SuitabilityRequestDTO;
import com.wise.buddy.wiseBuddy.model.SuitabilityModel;

public interface SuitabilityService {
    SuitabilityModel cadastrarSuitability(SuitabilityRequestDTO dto);
}