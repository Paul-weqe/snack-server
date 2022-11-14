package com.snack.server.web.deviceresource

import org.springframework.stereotype.Service


@Service
class MachineResourceService(
    val machineResourceRepository: MachineResourceRepository
): IMachineService {

    override fun createMachineResource(ip_address: String, ram: Float, storage: Float, cpu: Float): MachineResourceEntity {
        val machineResourceEntity = MachineResourceEntity(
            ip_address = ip_address, ram = ram, storage = storage, cpu = cpu
        )
        machineResourceRepository.save(machineResourceEntity)
        return machineResourceEntity
    }

    override fun findMachinesResources(): List<MachineResourceEntity> {
        val machines_resources = machineResourceRepository.findAll()
        val response: MutableList<MachineResourceEntity> = ArrayList()
        for (x in machines_resources){
            response.add(x)
        }
        return response
    }

}