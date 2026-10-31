package com.rogo.spending.tracker.service

import com.rogo.spending.tracker.config.ApplicationProperties
import com.rogo.spending.tracker.entity.Limit
import com.rogo.spending.tracker.entity.LimitRepository
import com.rogo.spending.tracker.service.configuration.PaydayService
import com.rogo.spending.tracker.util.isEndOfMonth
import com.rogo.spending.tracker.util.isTodayDateEquals
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class LimitService(
    private val limitRepository: LimitRepository,
    private val paydayService: PaydayService,
    private val applicationProperties: ApplicationProperties
) {
    fun getAll(isDueOnly: Boolean = false): List<Limit?> {
        val limits = limitRepository.findAll()
        return when (isDueOnly) {
            false -> limits
            true -> limits.filter { it.isDue() }
        }
    }

    private fun Limit.isDue(): Boolean {
        return when (this.applicationPeriod) {
            Limit.ApplicationPeriod.PAYDAY -> paydayService.checkIsTodayPayday()
            Limit.ApplicationPeriod.MONTHLY -> LocalDate.now().isEndOfMonth()
            Limit.ApplicationPeriod.DATE2DATE -> LocalDate.now().isTodayDateEquals(applicationProperties.creditCardSettlementDate)
            Limit.ApplicationPeriod.WEEKLY -> TODO()
        }
    }
}