package com.rogo.spending.tracker.util

import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

fun LocalDate.firstDayOfYear(): LocalDate = this.with(TemporalAdjusters.firstDayOfYear())

fun LocalDate.lastDayOfYear(): LocalDate = this.with(TemporalAdjusters.lastDayOfYear())
