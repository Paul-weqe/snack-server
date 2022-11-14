package com.snack.server.web.machineresource

interface IMachineService {
    fun createMachineResource(ip_address: String, ram: Float, storage: Float, cpu: Float): MachineResourceEntity
    fun findMachinesResources(): List<MachineResourceEntity>
}