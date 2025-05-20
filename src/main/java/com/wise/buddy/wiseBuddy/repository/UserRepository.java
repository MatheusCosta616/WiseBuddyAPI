package com.wise.buddy.wiseBuddy.repository;

import com.wise.buddy.wiseBuddy.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
