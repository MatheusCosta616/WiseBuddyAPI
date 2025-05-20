package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.ContractModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractModel, Long> {
}
