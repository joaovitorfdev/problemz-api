package com.problemz.api.controllers

import com.problemz.api.models.Product
import com.problemz.api.repositories.ProductRepository
import com.problemz.api.schemas.ProductDTO
import com.problemz.api.schemas.ProductResponseSchema
import com.problemz.api.services.ProductService
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/products")
class ProductController(
    private val repo: ProductRepository,
    private val service: ProductService
) {

    @GetMapping
    fun listAll(): List<Product> =  repo.findAll()

    @PostMapping
    fun createObject(@RequestBody dto: ProductDTO): ProductResponseSchema {
        val saved = service.create(dto)
        return ProductResponseSchema.from(saved)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): ProductResponseSchema =
        ProductResponseSchema.from(repo.findById(id).orElseThrow { RuntimeException("Not found") })
}