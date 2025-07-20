package com.problemz.api.controllers

import com.problemz.api.models.Product
import com.problemz.api.repositories.ProductRepository
import com.problemz.api.schemas.ProductCreateSchema
import com.problemz.api.schemas.ProductResponseSchema
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/products")
class ProductController(private val repo: ProductRepository) {

    @GetMapping
    fun listAll(): List<Product> =  repo.findAll()

    @PostMapping
    fun createObject(@RequestBody dto: ProductCreateSchema): ProductResponseSchema {
        val saved = repo.save(dto.toEntity())
        return ProductResponseSchema.from(saved)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Product =
        repo.findById(id).orElseThrow { RuntimeException("Not found") }
}