package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
    List<CardModel> findAllByUser_Id(Long userId);
}