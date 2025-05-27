package com.wise.buddy.wiseBuddy.service;

import com.wise.buddy.wiseBuddy.dto.LoginRequestDTO;
import com.wise.buddy.wiseBuddy.dto.LoginResponseDTO;
import com.wise.buddy.wiseBuddy.dto.RegisterRequestDTO;
import com.wise.buddy.wiseBuddy.model.UserModel;

import java.util.Optional;

public interface UserService {
    UserModel registerUser(RegisterRequestDTO request);
    Optional<LoginResponseDTO> authenticateUser(LoginRequestDTO request);
    UserModel getUserById(Long id);
    UserModel updateUser(Long id, RegisterRequestDTO request);
}