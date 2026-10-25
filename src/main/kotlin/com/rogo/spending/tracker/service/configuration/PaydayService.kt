package com.rogo.spending.tracker.service.configuration

import com.rogo.spending.tracker.entity.configuration.PaydayRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PaydayService(private val paydayRepository: PaydayRepository) {
    fun checkIsTodayPayday(): Boolean = when (paydayRepository.findFirstByPaydayDate(LocalDate.now())) {
        null -> false
        else -> true
    }
}