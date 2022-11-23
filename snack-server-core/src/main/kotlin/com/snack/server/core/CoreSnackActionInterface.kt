package com.snack.server.core

import com.snack.server.core.dataclasses.DeviceDataclass

interface CoreSnackActionInterface {
    fun openSnackListenerPort(resourceData: DeviceDataclass): Int?
}