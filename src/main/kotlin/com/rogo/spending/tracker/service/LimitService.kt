package com.rogo.spending.tracker.service

import com.rogo.spending.tracker.entity.Limit
import com.rogo.spending.tracker.entity.LimitRepository
import org.springframework.stereotype.Service

@Service
class LimitService(
    private val limitRepository: LimitRepository,
) {
    fun getAll(isDueOnly: Boolean = false): MutableList<Limit> {
        val limits = limitRepository.findAll()
        return limits

        // TODO: implement return due only
    }
}
