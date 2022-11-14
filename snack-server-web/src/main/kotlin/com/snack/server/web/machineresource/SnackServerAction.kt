package com.snack.server.web.machineresource

import com.snack.server.core.serializer.CoreSnackActionInterface
import com.snack.server.core.serializer.SnackResourceData
import org.springframework.stereotype.Service

@Service
class SnackServerAction(
    val machineService: IMachineService
): CoreSnackActionInterface{

    override fun runAction(resourceData: SnackResourceData): Int {
        val machineResource = machineService.createMachineResource(
            resourceData.ip_address,
            resourceData.ram,
            resourceData.storage,
            resourceData.cpu
        )
        return machineResource.id
    }

}