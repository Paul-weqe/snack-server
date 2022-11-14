package com.snack.server.web.deviceresource

import com.snack.server.core.CoreSnackActionInterface
import com.snack.server.core.serializer.Device
import org.springframework.stereotype.Service

@Service
class SnackServerAction(
    val machineService: IMachineService
): CoreSnackActionInterface {

    override fun runAction(resourceData: Device): Int {
        val machineResource = machineService.createMachineResource(
            resourceData.ip_address,
            resourceData.ram,
            resourceData.storage,
            resourceData.cpu
        )
        return machineResource.id
    }

}