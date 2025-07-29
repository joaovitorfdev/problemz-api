package com.problemz.api.models

import jakarta.persistence.*

@Entity
@Table(name = "tb_products")
class Product(

    @Column(nullable = false)
    var name: String,

    @Column
    var description: String?,

    @ManyToMany
    @JoinTable(
        name = "product_category",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: MutableSet<Category> = mutableSetOf()

) : BaseModel()
