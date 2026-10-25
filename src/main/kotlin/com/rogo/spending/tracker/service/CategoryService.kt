package com.rogo.spending.tracker.service

import com.rogo.spending.tracker.entity.Category
import com.rogo.spending.tracker.entity.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository,
) {
    fun getAll(): List<Category> = categoryRepository.findAll()
}
