package com.snack.server.web

import com.snack.server.core.SnackSocketServer
import com.snack.server.core.CoreSnackActionInterface
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.concurrent.thread

@Component
class ServerInitializer(
    val snackServerAction: CoreSnackActionInterface
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {

        thread(name = "snack-server-thread") {
            val sn = SnackSocketServer(snackServerAction)
            sn.createSocket()
        }
    }

}