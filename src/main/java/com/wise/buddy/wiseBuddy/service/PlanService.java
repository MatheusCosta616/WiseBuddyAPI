package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.PlanResponseDTO;
import java.util.List;

public interface PlanService {
    List<PlanResponseDTO> getAllPlans();
}