package com.snack.server.web.machineresource

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

    override fun findMachinesResources(): List<MachineResource> {
        val machines_resources = machineResourceRepository.findAll()
        val response: MutableList<MachineResource> = ArrayList()
        for (x in machines_resources){
            response.add(x)
        }
        return response
    }

}