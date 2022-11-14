package com.snack.server.core.serializer

interface CoreSnackActionInterface {
    fun runAction(resourceData: SnackResourceData): Int?
}