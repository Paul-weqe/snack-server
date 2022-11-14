package com.snack.server.web.initializers


import com.snack.server.core.SnackSocketServer
import com.snack.server.core.serializer.CoreSnackSerializerActionInterface
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.concurrent.thread

@Component
class ServerInitializer(
    val snackServerAction: CoreSnackSerializerActionInterface
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        thread(name="snack-serializer-thread") {
            val sn = SnackSocketServer(snackServerAction)
            sn.createSocket()
        }
    }
}