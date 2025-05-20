package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.RecommendationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationModel, Long> {
}
