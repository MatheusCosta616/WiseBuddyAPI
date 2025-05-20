package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}
