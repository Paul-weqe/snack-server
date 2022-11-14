package com.snack.server.core

import com.snack.server.core.serializer.CoreSnackSerializerActionInterface
import com.snack.server.core.serializer.SnackSerializer
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.StandardCharsets
import java.util.logging.Logger
import java.util.stream.Collectors

class SnackSocketServer(
    private val snackAction: CoreSnackSerializerActionInterface
) {
    private var LOG = Logger.getLogger(this.javaClass::class.java.name)
     fun createSocket(port: Int = 9099){
        val serverSocket = ServerSocket(port)
         while (true){
             try{
                 LOG.info("Bringing up server socket port ${port}")

                 while (true){
                     val socket: Socket = serverSocket.accept()
                     val inputStream = socket.getInputStream()
                     val incomingClientData = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))
                         .lines()
                         .collect(Collectors.joining("\n\n"))
                     val clientData = SnackSerializer.serialize(incomingClientData)
                     clientData?.let{ snackAction.runAction(it) }
                 }
             } finally {
                 LOG.warning("closing snack server socket on port ${port}")
                 serverSocket.close()
             }
         }
    }
}

