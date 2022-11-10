package com.snack.snackserver.network

import com.snack.snackserver.machineresource.IMachineService
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors

//@Service
@Service
class SnackSocketService(
    val machineResourceService: IMachineService
): ISnackSocketService{

    override fun createSocket(port: Int){

        val serverSocket = ServerSocket(port)
        while(true)
        {
            val socket: Socket = serverSocket.accept()
            val inputStream = socket.getInputStream()
            val incomingClientData: String = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"))
            machineResourceService.interprateMachineNetworkData(incomingClientData)
         }
    }

}