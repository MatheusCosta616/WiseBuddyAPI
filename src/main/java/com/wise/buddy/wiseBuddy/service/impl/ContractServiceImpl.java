package com.wise.buddy.wiseBuddy.service.impl;

import com.wise.buddy.wiseBuddy.dto.ContractRequestDTO;
import com.wise.buddy.wiseBuddy.dto.ContractResponseDTO;
import com.wise.buddy.wiseBuddy.model.ContractModel;
import com.wise.buddy.wiseBuddy.model.PlanModel;
import com.wise.buddy.wiseBuddy.model.UserModel;
import com.wise.buddy.wiseBuddy.repository.ContractRepository;
import com.wise.buddy.wiseBuddy.repository.PlanRepository;
import com.wise.buddy.wiseBuddy.repository.UserRepository;
import com.wise.buddy.wiseBuddy.service.ContractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    public ContractServiceImpl(ContractRepository contractRepository, UserRepository userRepository, PlanRepository planRepository) {
        this.contractRepository = contractRepository;
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    @Override
    public ContractResponseDTO saveContract(ContractRequestDTO dto) {
        UserModel user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + dto.getUserId()));
        PlanModel plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new IllegalArgumentException("Plano não encontrado: " + dto.getPlanId()));

        ContractModel contract = new ContractModel();
        contract.setUser(user);
        contract.setPlan(plan);
        contract.setContractDate(dto.getContractDate());

        ContractModel saved = contractRepository.save(contract);

        return new ContractResponseDTO(
                saved.getContractId(),
                saved.getUser().getId(),
                saved.getPlan().getPlanId(),
                saved.getContractDate()
        );
    }

    @Override
    public List<ContractResponseDTO> getContractsByUserId(Long userId) {
        List<ContractModel> contracts = contractRepository.findAllByUser_Id(userId);
        return contracts.stream()
                .map(c -> new ContractResponseDTO(
                        c.getContractId(),
                        c.getUser().getId(),
                        c.getPlan().getPlanId(),
                        c.getContractDate()))
                .collect(Collectors.toList());
    }
}