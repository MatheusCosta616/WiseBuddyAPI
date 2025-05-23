package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.SessionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionsRepository extends JpaRepository<SessionModel, Long> {
    List<SessionModel> findAllByUser_Id(Long userId);
}