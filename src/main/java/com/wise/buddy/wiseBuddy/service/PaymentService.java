package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.PaymentRequestDTO;
import com.wise.buddy.wiseBuddy.dto.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {
    PaymentResponseDTO savePayment(PaymentRequestDTO dto);
    List<PaymentResponseDTO> getPaymentsByUserId(Long userId);
}