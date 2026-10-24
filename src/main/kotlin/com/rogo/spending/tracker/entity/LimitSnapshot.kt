package com.rogo.spending.tracker.entity

import com.rogo.spending.tracker.entity.Limit.ApplicationPeriod
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Entity(name = "spending_limit_snapshot")
data class LimitSnapshot(
    // OG Fields
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: String? = null,
    val name: String,
    val value: BigDecimal,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
    val category: Category,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_id", nullable = true)
    val source: Source,
    val descriptionKeywords: List<String>,
    val applicationPeriod: ApplicationPeriod,
    // Snapshot Fields
    val usedValue: BigDecimal,
    val usedPercentage: Double,
)

@Repository
interface LimitSnapshotRepository : JpaRepository<LimitSnapshot, String>
