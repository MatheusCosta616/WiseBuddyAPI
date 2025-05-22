package com.wise.buddy.wiseBuddy.service.impl;

import com.wise.buddy.wiseBuddy.dto.LoginRequestDTO;
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
            // converte para hex string
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
        user.setPasswordHash(hashPassword(request.getPassword())); // hash simples
        user.setIncomeRange(request.getIncomeRange());
        user.setSignOnDate(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public boolean authenticateUser(LoginRequestDTO request) {
        Optional<UserModel> userOptional = userRepository.findByEmail(request.getEmail());
        String hashedInput = hashPassword(request.getPassword());
        return userOptional.filter(user ->
                hashedInput.equals(user.getPasswordHash())
        ).isPresent();
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
            user.setName(request.getName());
            user.setSurname(request.getSurname());
            user.setEmail(request.getEmail());
            if (request.getPassword() != null && !request.getPassword().isBlank()) {
                user.setPasswordHash(hashPassword(request.getPassword()));
            }
            user.setIncomeRange(request.getIncomeRange());
            return userRepository.save(user);
        }
        return null;
    }
}