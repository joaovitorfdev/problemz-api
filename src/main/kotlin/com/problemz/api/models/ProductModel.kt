package com.problemz.api.models

import jakarta.persistence.*

@Entity
@Table(name = "tb_products")
class Product(

    @Column(nullable = false)
    val name: String,

    @Column
    val description: String?,

    @ManyToMany
    @JoinTable(
        name = "product_category", // Nome da tabela de junção
        joinColumns = [JoinColumn(name = "product_id")], // Chave estrangeira para o Produto
        inverseJoinColumns = [JoinColumn(name = "category_id")] // Chave estrangeira para a Categoria
    )
    val categories: Set<Category> = HashSet()

) : BaseModel()
