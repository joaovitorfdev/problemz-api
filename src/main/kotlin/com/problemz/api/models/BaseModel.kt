package com.problemz.api.models


import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import java.util.UUID

@MappedSuperclass
abstract class BaseModel(
    @Id
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @field:CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    val createdAt: Instant = Instant.now(),

)
