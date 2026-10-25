package com.rogo.spending.tracker.web

import com.rogo.spending.tracker.entity.configuration.Payday
import com.rogo.spending.tracker.service.configuration.PaydayService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/configs/paydays")
class PaydayController(
    private val paydayService: PaydayService,
) {
    @GetMapping("/yearly")
    fun getAllForThisYear(): MutableList<Payday> = paydayService.getAllForThisYear()

    @GetMapping("/latest")
    fun getLatestPayday(): Payday = paydayService.getLatest()
}
