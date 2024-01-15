package com.mrozm.securityjwt.auth

import com.mrozm.securityjwt.auth.model.AuthenticationRequest
import com.mrozm.securityjwt.auth.model.AuthenticationResponse
import com.mrozm.securityjwt.auth.model.RegisterRequest
import com.mrozm.securityjwt.auth.service.AuthenticateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthenticationController(
        private val service: AuthenticateService
) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(service.register(request))
    }

    @PostMapping("/authenticate")
    fun register(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(service.authenticate(request))
    }

}