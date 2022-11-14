package com.snack.server.core.dataclasses

class DeviceResource {
    var ram: Float = Float.MIN_VALUE
    var storage: Float = Float.MIN_VALUE
    var cpu: Float = Float.MIN_VALUE

    override fun toString(): String {
        return "<ram: $ram, storage: $storage, cpu: $cpu>"
    }
}
