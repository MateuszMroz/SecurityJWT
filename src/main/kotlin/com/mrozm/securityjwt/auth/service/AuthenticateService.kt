package com.mrozm.securityjwt.auth.service

import com.mrozm.securityjwt.auth.model.AuthenticationRequest
import com.mrozm.securityjwt.auth.model.AuthenticationResponse
import com.mrozm.securityjwt.auth.model.RegisterRequest
import com.mrozm.securityjwt.config.service.JwtService
import com.mrozm.securityjwt.user.model.Role.USER
import com.mrozm.securityjwt.user.model.User
import com.mrozm.securityjwt.user.repository.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticateService(
        private val repository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val service: JwtService,
        private val authenticationManager: AuthenticationManager
) {

    fun register(request: RegisterRequest): AuthenticationResponse {
        val user = User(
                firstname = request.firstname,
                lastname = request.lastname,
                email = request.email,
                pass = passwordEncoder.encode(request.password),
                role = USER
        )
        repository.save(user)
        return AuthenticationResponse(service.generateToken(user))
    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse? {
        authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        request.email,
                        request.password
                )
        )

        val user = repository.findUserByEmail(request.email) ?: throw UsernameNotFoundException("User not found")
        return AuthenticationResponse(service.generateToken(user))
    }

}