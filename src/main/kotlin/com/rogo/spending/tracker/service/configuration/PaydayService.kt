package com.rogo.spending.tracker.service.configuration

import com.rogo.spending.tracker.entity.configuration.GetPaydaysDateRangeQueryParam
import com.rogo.spending.tracker.entity.configuration.Payday
import com.rogo.spending.tracker.entity.configuration.PaydayRepository
import com.rogo.spending.tracker.entity.configuration.getPaydaysForRange
import com.rogo.spending.tracker.util.firstDayOfYear
import com.rogo.spending.tracker.util.lastDayOfYear
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PaydayService(
    private val paydayRepository: PaydayRepository,
) {
    fun checkIsTodayPayday(): Boolean =
        when (paydayRepository.findFirstByPaydayDate(LocalDate.now())) {
            null -> false
            else -> true
        }

    fun getAllForThisYear(): MutableList<Payday> {
        val now = LocalDate.now()

        return paydayRepository.getPaydaysForRange(GetPaydaysDateRangeQueryParam(now.firstDayOfYear(), now.lastDayOfYear()))
    }

    fun getLatest(): Payday =
        paydayRepository.findFirstByPaydayDateLessThanOrderByPaydayDateDesc(LocalDate.now()) ?: throw IllegalStateException() // TODO: throw appropriate standardized error
}
