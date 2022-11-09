package com.snack.snackserver.network

interface ISnackSocketService {
    fun createSocket(port: Int = 9099)
}