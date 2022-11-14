package com.snack.server.web.device
import com.snack.server.core.dataclasses.DeviceDataclass
import org.springframework.stereotype.Service

@Service
class DeviceService(
    val deviceRepository: DeviceRepository
): IDeviceService {

    override fun createDevice(deviceData: DeviceDataclass): Device {
        val d = Device(
            deviceData.machineId,
            deviceData.operatingSystem,
            deviceData.hostname
        )
        return deviceRepository.save(d)
    }

    override fun getDeviceUsingMachineId(machineId: String): Device? {
        return deviceRepository.findByMachineId(machineId)
    }


}