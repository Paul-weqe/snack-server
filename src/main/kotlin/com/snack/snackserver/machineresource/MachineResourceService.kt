package com.snack.snackserver.machineresource

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service


@Service
class MachineResourceService(
    val machineResourceRepository: MachineResourceRepository
): IMachineService {

    override fun createMachineResource(ip_address: String, ram: Float, storage: Float, cpu: Float): MachineResource {
        val machineResource = MachineResource(
            ip_address = ip_address, ram = ram, storage = storage, cpu = cpu
        )
        machineResourceRepository.save(machineResource)
        return machineResource
    }

    override fun interprateMachineNetworkData(networkData: String) {
        val mapper = ObjectMapper()

        val data = mapper.readValue(networkData, MachineResourceMapper::class.java)
        createMachineResource(
            ip_address = data.ip_address,
            ram = data.ram,
            storage = data.storage,
            cpu = data.cpu
        )
    }

}

class MachineResourceMapper{
    var ip_address: String = ""
    var ram: Float = Float.MIN_VALUE
    var storage: Float = Float.MIN_VALUE
    var cpu: Float = Float.MIN_VALUE
}