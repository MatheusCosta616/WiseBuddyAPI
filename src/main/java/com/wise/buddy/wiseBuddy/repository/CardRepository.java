package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
}
