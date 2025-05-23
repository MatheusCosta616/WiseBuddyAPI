package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.SuitabilityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuitabilityRepository extends JpaRepository<SuitabilityModel, Long> {
    Optional<SuitabilityModel> findFirstByUser_Id(Long userId);
}
