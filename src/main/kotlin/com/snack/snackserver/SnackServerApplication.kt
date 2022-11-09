package com.snack.snackserver

import com.snack.snackserver.network.ISnackSocketService
import com.snack.snackserver.network.SnackSocketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import kotlin.concurrent.thread

@SpringBootApplication
class SnackServerApplication

@Autowired
fun main(args: Array<String>) {
	runApplication<SnackServerApplication>(*args)
}

@EventListener(SnackServerApplication::class)
fun runSocketListener(){
}

