package com.snack.snackserver.machineresource

import org.springframework.beans.factory.annotation.Autowired

interface IMachineService {

    fun createMachineResource(ip_address: String, ram: Float, storage: Float, cpu: Float): MachineResource
    fun interprateMachineNetworkData(networkData: String)
}