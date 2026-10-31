package com.rogo.spending.tracker

import com.rogo.spending.tracker.config.ApplicationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties::class)
class SpendingTrackerV2Application

fun main(args: Array<String>) {
    runApplication<SpendingTrackerV2Application>(*args)
}
