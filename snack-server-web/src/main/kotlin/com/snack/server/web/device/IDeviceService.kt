package com.snack.server.web.device

import com.snack.server.core.dataclasses.DeviceDataclass


interface IDeviceService {
    fun createDevice(deviceData: DeviceDataclass): Device?
    fun getDeviceUsingMachineId(machineId: String): Device?
    fun getAllDevices(): List<Device>
}