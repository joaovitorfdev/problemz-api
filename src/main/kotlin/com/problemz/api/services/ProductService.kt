package com.problemz.api.services

import com.problemz.api.models.Product
import com.problemz.api.repositories.CategoryRepository
import com.problemz.api.repositories.ProductRepository
import com.problemz.api.schemas.ProductDTO
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
){

fun create(dto: ProductDTO): Product {
    val product = Product(
        name = dto.name,
        description = dto.description,
    )
    if (!dto.categories.isNullOrEmpty()) {
        val categories = categoryRepository.findAllById(dto.categories)
        product.categories = categories.toMutableSet()
    }

    return productRepository.save(product)
}}
