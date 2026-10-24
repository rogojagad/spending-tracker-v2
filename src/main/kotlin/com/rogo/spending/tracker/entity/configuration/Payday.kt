package com.rogo.spending.tracker.entity.configuration

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Entity(name = "payday")
data class Payday(
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: String? = null,
    val note: String,
    val paydayDate: LocalDate,
)

@Repository
interface PaydayRepository : JpaRepository<Payday, String>
