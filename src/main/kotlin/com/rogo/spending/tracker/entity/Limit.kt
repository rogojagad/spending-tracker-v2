package com.rogo.spending.tracker.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Entity(name = "spending_limit")
data class Limit(
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
) {
    enum class ApplicationPeriod {
        DATE2DATE,
        MONTHLY,
        PAYDAY,
        WEEKLY,
    }
}

@Repository
interface LimitRepository : JpaRepository<Limit, String>
