package com.snack.server.web.device

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping


@Controller
class DeviceController(
    val deviceService: DeviceService
) {

    @GetMapping("/devices")
    fun getDevices(model: Model): String{
        val devices = deviceService.getAllDevices()
        model["devices"] = devices
        return "devices"
    }

}