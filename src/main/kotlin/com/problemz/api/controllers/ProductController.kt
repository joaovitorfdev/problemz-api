package com.problemz.api.controllers

import com.problemz.api.models.Product
import com.problemz.api.repositories.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val repo: ProductRepository) {

    @GetMapping
    fun listAll(): List<Product> =  repo.findAll()
}