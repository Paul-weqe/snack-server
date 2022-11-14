package com.snack.server.web.services

import com.snack.server.core.serializer.CoreSnackSerializerActionInterface
import com.snack.server.core.serializer.SnackResourceData
import com.snack.server.web.machineresource.IMachineService
import org.springframework.stereotype.Service

@Service
class SnackServerAction(
    val machineService: IMachineService
): CoreSnackSerializerActionInterface{

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