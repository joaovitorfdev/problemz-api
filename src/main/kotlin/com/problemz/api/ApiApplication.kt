package com.problemz.api

import com.problemz.api.models.Category
import com.problemz.api.repositories.CategoryRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}

@Component
class DataLoader(private val categoryRepository: CategoryRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
		val categories = listOf(
			Category(name = "t-shirts"),
			Category(name = "hoodies"),
			Category(name = "01-01-2026"),
		)
		categoryRepository.saveAll(categories)
	}
}
