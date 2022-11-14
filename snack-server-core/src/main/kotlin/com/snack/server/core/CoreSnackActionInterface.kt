package com.snack.server.core

import com.snack.server.core.dataclasses.DeviceDataclass

interface CoreSnackActionInterface {
    fun runAction(resourceData: DeviceDataclass): Int?
}