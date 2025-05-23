package com.wise.buddy.wiseBuddy.service.impl;

import com.wise.buddy.wiseBuddy.dto.PlanResponseDTO;
import com.wise.buddy.wiseBuddy.model.PlanModel;
import com.wise.buddy.wiseBuddy.repository.PlanRepository;
import com.wise.buddy.wiseBuddy.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public List<PlanResponseDTO> getAllPlans() {
        List<PlanModel> plans = planRepository.findAll();
        return plans.stream()
                .map(plan -> new PlanResponseDTO(plan.getPlanId(), plan.getPlanName()))
                .collect(Collectors.toList());
    }
}