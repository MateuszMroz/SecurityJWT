package com.mrozm.securityjwt.user.repository

import com.mrozm.securityjwt.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
    fun findUserByEmail(email: String): User?
}