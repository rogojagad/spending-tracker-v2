package com.rogo.spending.tracker.web

import com.rogo.spending.tracker.entity.Source
import com.rogo.spending.tracker.service.SourceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sources")
class SourceController(
    private val sourceService: SourceService,
) {
    @GetMapping
    fun getAllSources(): List<Source> = sourceService.getAll()
}
