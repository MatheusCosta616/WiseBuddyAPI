package com.wise.buddy.wiseBuddy.service.impl;

import com.wise.buddy.wiseBuddy.dto.LoginRequestDTO;
import com.wise.buddy.wiseBuddy.dto.LoginResponseDTO;
import com.wise.buddy.wiseBuddy.dto.RegisterRequestDTO;
import com.wise.buddy.wiseBuddy.model.UserModel;
import com.wise.buddy.wiseBuddy.repository.UserRepository;
import com.wise.buddy.wiseBuddy.service.UserService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao hashear a senha", e);
        }
    }

    @Override
    public UserModel registerUser(RegisterRequestDTO request) {
        UserModel user = new UserModel();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPasswordHash(hashPassword(request.getPassword()));
        user.setIncomeRange(request.getIncomeRange());
        user.setSignOnDate(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<LoginResponseDTO> authenticateUser(LoginRequestDTO request) {
        Optional<UserModel> userOptional = userRepository.findByEmail(request.getEmail());
        String hashedInput = hashPassword(request.getPassword());
        return userOptional
                .filter(user -> hashedInput.equals(user.getPasswordHash()))
                .map(user -> new LoginResponseDTO(user.getId(), user.getEmail(), user.getPasswordHash()));
    }

    @Override
    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel updateUser(Long id, RegisterRequestDTO request) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            if (request.getName() != null && !request.getName().isBlank()) {
                user.setName(request.getName());
            }
            if (request.getSurname() != null && !request.getSurname().isBlank()) {
                user.setSurname(request.getSurname());
            }
            if (request.getEmail() != null && !request.getEmail().isBlank()) {
                user.setEmail(request.getEmail());
            }
            if (request.getPassword() != null && !request.getPassword().isBlank()) {
                user.setPasswordHash(hashPassword(request.getPassword()));
            }
            if (request.getIncomeRange() != null && !request.getIncomeRange().isBlank()) {
                user.setIncomeRange(request.getIncomeRange());
            }

            return userRepository.save(user);
        }
        return null;
    }
}