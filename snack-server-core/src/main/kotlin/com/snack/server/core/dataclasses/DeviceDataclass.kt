package com.snack.server.core.dataclasses

class DeviceDataclass {
    var machineId: String = ""
    var operatingSystem: String = ""
    var hostname: String = ""
    var resources: DeviceResourceDataclass = DeviceResourceDataclass()

    override fun toString(): String {
        return "<machine-id: $machineId, " +
                "operating-system: $operatingSystem, " +
                "hostname: $hostname, " +
                "resources: $resources>"
    }
}