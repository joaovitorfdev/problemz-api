package com.problemz.api.models

import jakarta.persistence.*

@Entity
@Table(name = "tb_products")
class Product(

    @Column(nullable = false)
    val name: String,

    @Column
    val description: String

) : BaseModel()
