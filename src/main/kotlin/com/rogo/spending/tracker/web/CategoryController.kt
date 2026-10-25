package com.rogo.spending.tracker.web

import com.rogo.spending.tracker.entity.Category
import com.rogo.spending.tracker.service.CategoryService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {
    fun getAllCategories(): List<Category> = categoryService.getAll()
}