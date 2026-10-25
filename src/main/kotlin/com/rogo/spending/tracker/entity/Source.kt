package com.rogo.spending.tracker.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Entity(name = "source")
data class Source(
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: UUID? = null,
    val name: String,
    val isSettlementNeeded: Boolean,
    val isActive: Boolean,
)

@Repository
interface SourceRepository : JpaRepository<Source, String>
