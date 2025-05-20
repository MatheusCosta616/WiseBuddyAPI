package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.SuitabilityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuitabilityRepository extends JpaRepository<SuitabilityModel, Long> {
}
