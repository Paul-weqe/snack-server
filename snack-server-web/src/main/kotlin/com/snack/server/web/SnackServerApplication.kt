package com.snack.server.web

import com.snack.server.web.network.ISnackSocketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import kotlin.concurrent.thread


@SpringBootApplication
class SnackServerApplication


@Autowired
fun main(args: Array<String>) {
	runApplication<SnackServerApplication>(*args)
}

@Component
class ServerInitializer(
	val snackSocketService: ISnackSocketService
): ApplicationRunner {
	override fun run(args: ApplicationArguments?) {
		thread(name = "server-socket-thread") {
			snackSocketService.createSocket(9099)
		}
	}

}