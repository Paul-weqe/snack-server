package com.snack.server.core

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.StandardCharsets
import java.util.logging.Logger
import java.util.stream.Collectors
import kotlin.concurrent.thread

class SnackSocketServer {
    var LOG = Logger.getLogger(this.javaClass::class.java.name)

    fun createSocket(port: Int = 9099){
        val serverSocket = ServerSocket(port)

        try {
            LOG.info("SNACK SERVER LISTENING ON PORT: ${port}")
            while (true) {

                val socket: Socket = serverSocket.accept()
                val inputStream = socket.getInputStream()
                val incomingClientData: String = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n\n"))
                val snackResourceData = SnackSerializer.serialize(incomingClientData)
                println(snackResourceData)
            }
        } finally {
            serverSocket.close()
        }

    }
}

