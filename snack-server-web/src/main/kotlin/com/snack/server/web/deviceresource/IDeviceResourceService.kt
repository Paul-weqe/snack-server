package com.snack.server.web.deviceresource

import com.snack.server.core.dataclasses.DeviceDataclass

interface IDeviceResourceService {
    fun addResource(deviceData: DeviceDataclass): DeviceResource?
}