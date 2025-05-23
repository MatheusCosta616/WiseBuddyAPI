package com.wise.buddy.wiseBuddy.service.impl;

import com.wise.buddy.wiseBuddy.dto.PaymentRequestDTO;
import com.wise.buddy.wiseBuddy.dto.PaymentResponseDTO;
import com.wise.buddy.wiseBuddy.model.PaymentModel;
import com.wise.buddy.wiseBuddy.model.PlanModel;
import com.wise.buddy.wiseBuddy.model.UserModel;
import com.wise.buddy.wiseBuddy.repository.PaymentRepository;
import com.wise.buddy.wiseBuddy.repository.PlanRepository;
import com.wise.buddy.wiseBuddy.repository.UserRepository;
import com.wise.buddy.wiseBuddy.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, UserRepository userRepository, PlanRepository planRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    @Override
    public PaymentResponseDTO savePayment(PaymentRequestDTO dto) {
        UserModel user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + dto.getUserId()));
        PlanModel plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new IllegalArgumentException("Plano não encontrado: " + dto.getPlanId()));

        PaymentModel payment = new PaymentModel();
        payment.setUser(user);
        payment.setPlan(plan);
        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setStatus(dto.getStatus());

        PaymentModel saved = paymentRepository.save(payment);

        return new PaymentResponseDTO(
                saved.getPaymentId(),
                saved.getUser().getId(),
                saved.getPlan().getPlanId(),
                saved.getAmount(),
                saved.getPaymentDate(),
                saved.getPaymentMethod(),
                saved.getStatus()
        );
    }

    @Override
    public List<PaymentResponseDTO> getPaymentsByUserId(Long userId) {
        List<PaymentModel> payments = paymentRepository.findAllByUser_Id(userId);
        return payments.stream()
                .map(p -> new PaymentResponseDTO(
                        p.getPaymentId(),
                        p.getUser().getId(),
                        p.getPlan().getPlanId(),
                        p.getAmount(),
                        p.getPaymentDate(),
                        p.getPaymentMethod(),
                        p.getStatus()))
                .collect(Collectors.toList());
    }
}