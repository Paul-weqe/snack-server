package com.snack.server.core.serializer

interface CoreSnackSerializerActionInterface {
    fun runAction(resourceData: SnackResourceData): Int?
}