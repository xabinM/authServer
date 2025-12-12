package com.temp.backend.auth.presentation;

import com.temp.backend.auth.application.AuthService;
import com.temp.backend.auth.dto.AuthenticationRequest;
import com.temp.backend.auth.dto.AuthenticationResponse;
import com.temp.backend.auth.dto.RegisterRequest;
import com.temp.backend.auth.dto.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request
    ) {
        String jwtToken = authService.register(request);
        return ResponseEntity.ok(RegisterResponse.of(jwtToken, "회원가입이 성공적으로 완료되었습니다."));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        String jwtToken = authService.authenticate(request);
        return ResponseEntity.ok(AuthenticationResponse.of(jwtToken, "로그인이 성공적으로 완료되었습니다."));
    }
}
