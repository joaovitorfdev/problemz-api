package com.problemz.api.schemas

import com.problemz.api.models.Category
import com.problemz.api.models.Product
import java.time.Instant
import java.util.UUID

data class ProductDTO(
    val name: String,
    val description: String?,
    val categories: Set<UUID>?
)

data class ProductResponseSchema(
    val id: UUID,
    val name: String,
    val categories: Set<CategoryResponseSchema>?,
    val description: String?,
    val createdAt: Instant,
) {
    companion object {
        fun from(entity: Product) = ProductResponseSchema(
            id = entity.id,
            name = entity.name,
            categories = entity.categories.map { CategoryResponseSchema(it.id, it.name) }.toSet(),
            description = entity.description,
            createdAt = entity.createdAt
        )
    }
}
