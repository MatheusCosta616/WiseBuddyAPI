package com.wise.buddy.wiseBuddy.controller;

import com.wise.buddy.wiseBuddy.dto.LoginRequestDTO;
import com.wise.buddy.wiseBuddy.dto.LoginResponseDTO;
import com.wise.buddy.wiseBuddy.dto.RegisterRequestDTO;
import com.wise.buddy.wiseBuddy.model.UserModel;
import com.wise.buddy.wiseBuddy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/wise-buddy/v1/users")
@Tag(name = "Users", description = "Endpoints for user management")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Register a new user",
            description = "Registers a new user in the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User successfully registered")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDTO request) {
        UserModel registered = userService.registerUser(request);
        return ResponseEntity.ok(registered);
    }

    @Operation(
            summary = "Login an user",
            description = "Authenticates a user with email and password.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login successful"),
                    @ApiResponse(responseCode = "401", description = "Invalid credentials")
            }
    )
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO request) {
        Optional<LoginResponseDTO> response = userService.authenticateUser(request);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas!");
        }
    }

    @Operation(
            summary = "Get user by ID",
            description = "Returns a user by their ID.",
            parameters = {
                    @Parameter(name = "id", description = "ID of the user", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        UserModel user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Update user by ID",
            description = "Updates a user by their ID.",
            parameters = {
                    @Parameter(name = "id", description = "ID of the user", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "User updated"),
                    @ApiResponse(responseCode = "404", description = "User not found")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody RegisterRequestDTO request) {
        UserModel updated = userService.updateUser(id, request);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}