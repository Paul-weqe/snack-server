package com.snack.server.core.dataclasses

class Device {
    var machineId: String = ""
    var operatingSystem: String = ""
    var hostname: String = ""
    var resources: DeviceResource = DeviceResource()

    override fun toString(): String {
        return "<machine-id: $machineId, " +
                "operating-system: $operatingSystem, " +
                "hostname: $hostname, " +
                "resources: $resources>"
    }
}