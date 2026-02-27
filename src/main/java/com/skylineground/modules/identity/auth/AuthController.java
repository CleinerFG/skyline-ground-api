package com.skylineground.modules.identity.auth;

import com.skylineground.modules.identity.auth.dto.LoginRequest;
import com.skylineground.modules.identity.auth.dto.TokenResponse;
import com.skylineground.modules.identity.user.UserService;
import com.skylineground.modules.identity.user.dto.UserRequest;
import com.skylineground.modules.identity.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest dto) {
        UserResponse response = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest dto) {
        TokenResponse response = loginService.authenticate(dto);
        return ResponseEntity.ok(response);
    }
}
