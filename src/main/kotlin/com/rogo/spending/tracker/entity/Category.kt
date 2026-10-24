package com.rogo.spending.tracker.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.Instant

@Entity(name = "category")
data class Category(
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: String? = null,
    val name: String,
    val priority: Int,
    val isActive: Boolean,
    val description: String,
    @CreationTimestamp val createdAt: Instant? = null,
)

@Repository
interface CategoryRepository : JpaRepository<Category, String>
