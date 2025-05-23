package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
    List<PaymentModel> findAllByUser_Id(Long userId);
}
