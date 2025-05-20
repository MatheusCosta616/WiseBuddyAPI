package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.PlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanModel, Long> {
}
