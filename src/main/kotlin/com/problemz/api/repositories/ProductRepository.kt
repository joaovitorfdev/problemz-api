package com.problemz.api.repositories

import com.problemz.api.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepository : JpaRepository<Product, UUID>
