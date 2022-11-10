package com.snack.server.web.network

interface ISnackSocketService {
    fun createSocket(port: Int = 9099)
}