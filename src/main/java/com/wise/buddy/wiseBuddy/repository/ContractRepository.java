package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.ContractModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<ContractModel, Long> {
    List<ContractModel> findAllByUser_Id(Long userId);
}
