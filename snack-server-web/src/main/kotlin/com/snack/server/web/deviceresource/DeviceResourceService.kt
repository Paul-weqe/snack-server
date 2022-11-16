package com.snack.server.web.deviceresource

import com.snack.server.core.dataclasses.DeviceDataclass
import com.snack.server.web.device.DeviceService
import org.springframework.stereotype.Service


@Service
class DeviceResourceService(
    val deviceResourceRepository: DeviceResourceRepository,
    val deviceService: DeviceService
): IDeviceResourceService {

    override fun addResource(deviceData: DeviceDataclass): DeviceResource? {
        val device = deviceService.getDeviceUsingMachineId(deviceData.machineId)

        // check if device exists first
        val deviceResource = DeviceResource(
            deviceId = device!!.id,
            ram = deviceData.resources.ram,
            storage = deviceData.resources.storage,
            cpu = deviceData.resources.cpu
        )
        return deviceResourceRepository.save(deviceResource)
    }

}