package com.snack.server.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SnackServerApplication


@Autowired
fun main(args: Array<String>) {
	runApplication<SnackServerApplication>(*args)
}
