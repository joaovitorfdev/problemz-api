package com.problemz.api.models

import jakarta.persistence.*

@Entity
@Table(name = "tb_categories")
class Category (

    @Column(nullable = false)
    val name: String,

): BaseModel()