package com.rogo.spending.tracker.entity.configuration

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.UUID

@Entity(name = "payday")
data class Payday(
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: UUID? = null,
    val note: String,
    val paydayDate: LocalDate,
)

@Repository
interface PaydayRepository : JpaRepository<Payday, String> {
    fun findFirstByPaydayDate(paydayDate: LocalDate): Payday?

    fun findByPaydayDateBetweenOrderByPaydayDateAsc(
        paydayDateAfter: LocalDate,
        paydayDateBefore: LocalDate,
    ): MutableList<Payday>

    fun findFirstByPaydayDateLessThanOrderByPaydayDateDesc(paydayDate: LocalDate): Payday?
}

// Convenience Queries
fun PaydayRepository.getPaydaysForRange(param: GetPaydaysDateRangeQueryParam): MutableList<Payday> =
    findByPaydayDateBetweenOrderByPaydayDateAsc(param.after, param.before)

// Query Params
data class GetPaydaysDateRangeQueryParam(
    val fromInclusive: LocalDate,
    val toExclusive: LocalDate,
) {
    val after: LocalDate = fromInclusive.minusDays(1)
    val before: LocalDate = toExclusive
}
