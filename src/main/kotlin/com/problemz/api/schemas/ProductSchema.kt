package com.problemz.api.schemas

import com.problemz.api.models.Product
import java.time.Instant
import java.util.UUID

data class ProductCreateSchema(
    val name: String,
    val description: String?
) {
    fun toEntity() = Product(name, description)
}

data class ProductResponseSchema(
    val id: UUID,
    val name: String,
    val description: String?,
    val createdAt: Instant,
) {
    companion object {
        fun from(entity: Product) = ProductResponseSchema(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            createdAt = entity.createdAt
        )
    }
}
