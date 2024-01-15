package com.mrozm.securityjwt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecurityJwtApplication

fun main(args: Array<String>) {
	runApplication<SecurityJwtApplication>(*args)
}
