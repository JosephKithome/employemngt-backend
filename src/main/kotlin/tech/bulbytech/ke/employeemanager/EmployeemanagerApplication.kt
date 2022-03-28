package tech.bulbytech.ke.employeemanager

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.util.*


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
class EmployeemanagerApplication

fun main(args: Array<String>) {
	runApplication<EmployeemanagerApplication>(*args)


	@Bean
	fun corsConfigurationSource(): CorsConfigurationSource? {
		val configuration = CorsConfiguration()
		configuration.allowedOrigins = listOf("*")
		configuration.allowedMethods = listOf("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
		configuration.allowedHeaders = listOf("authorization", "content-type", "x-auth-token")
		configuration.exposedHeaders = listOf("x-auth-token")
		val source = UrlBasedCorsConfigurationSource()
		source.registerCorsConfiguration("/**", configuration)
		return source
	}

}


