package com.snack.server.web.deviceresource

import com.snack.server.core.CoreSnackActionInterface
import com.snack.server.core.dataclasses.DeviceDataclass
import com.snack.server.web.device.IDeviceService
import org.springframework.stereotype.Service

@Service
class SnackServerAction(
    val deviceService: IDeviceService,
    val deviceResourceService: IDeviceResourceService
): CoreSnackActionInterface {

    override fun openSnackListenerPort(resourceData: DeviceDataclass): Int? {
        val device = deviceService.getDeviceUsingMachineId(resourceData.machineId)
        if (device == null)
            deviceService.createDevice(resourceData)

        val resources = deviceResourceService.addResource(resourceData)
        return resources!!.id
    }

}