package com.rogo.spending.tracker.service

import com.rogo.spending.tracker.entity.Source
import com.rogo.spending.tracker.entity.SourceRepository
import org.springframework.stereotype.Service

@Service
class SourceService(
    private val sourceRepository: SourceRepository,
) {
    fun getAll(): List<Source> = sourceRepository.findAll()
}
