package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.ContractRequestDTO;
import com.wise.buddy.wiseBuddy.dto.ContractResponseDTO;

import java.util.List;

public interface ContractService {
    ContractResponseDTO saveContract(ContractRequestDTO dto);
    List<ContractResponseDTO> getContractsByUserId(Long userId);
}