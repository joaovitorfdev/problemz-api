package com.problemz.api.controllers

import com.problemz.api.models.Category
import com.problemz.api.repositories.CategoryRepository
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/categories")
class CategoryController(private val repo: CategoryRepository) {

    @GetMapping
    fun listAll(): List<Category> =  repo.findAll()

//    @PostMapping
//    fun createObject(@RequestBody dto: ProductCreateSchema): ProductResponseSchema {
//        val saved = repo.save(dto.toEntity())
//        return ProductResponseSchema.from(saved)
//    }
//
//    @GetMapping("/{id}")
//    fun getById(@PathVariable id: UUID): Product =
//        repo.findById(id).orElseThrow { RuntimeException("Not found") }
}