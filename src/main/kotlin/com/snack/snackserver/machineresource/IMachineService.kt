package com.snack.snackserver.machineresource

interface IMachineService {

    fun createMachineResource(ip_address: String, ram: Float, storage: Float, cpu: Float): MachineResource
    fun interprateMachineNetworkData(networkData: String)
}