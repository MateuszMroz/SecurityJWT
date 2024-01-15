package com.mrozm.securityjwt.auth.model

data class AuthenticationRequest (
        val email: String,
        val password: String
)
