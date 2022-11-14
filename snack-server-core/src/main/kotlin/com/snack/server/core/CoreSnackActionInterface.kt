package com.snack.server.core

import com.snack.server.core.dataclasses.Device

interface CoreSnackActionInterface {
    fun runAction(resourceData: Device): Int?
}