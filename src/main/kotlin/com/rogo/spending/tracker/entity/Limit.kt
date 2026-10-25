package com.rogo.spending.tracker.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.util.UUID

@Entity(name = "spending_limit")
data class Limit(
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: UUID? = null,
    val name: String,
    val value: Int, // TODO: fix this to use BigDecimal, I used wrong type in DDL, should use `numeric` instead of `int4`
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
    val category: Category,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_id", nullable = true)
    val source: Source,
    val descriptionKeywords: List<String>,
    @Enumerated(EnumType.STRING)
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
