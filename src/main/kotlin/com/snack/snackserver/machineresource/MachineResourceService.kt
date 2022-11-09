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

data class MachineResourceMapper(
    val ip_address: String,
    val ram: Float,
    val storage: Float,
    val cpu: Float
)