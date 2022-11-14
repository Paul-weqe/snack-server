package com.snack.server.web.device

import org.springframework.data.repository.CrudRepository

interface DeviceRepository : CrudRepository<Device, Int> {
    fun findByMachineId(machineId: String): Device?
}