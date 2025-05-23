package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.RecommendationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationModel, Long> {
    List<RecommendationModel> findAllByUser_Id(Long userId);
}