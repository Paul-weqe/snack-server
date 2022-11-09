package com.snack.snackserver.controller

import com.snack.snackserver.machineresource.IMachineService
import com.snack.snackserver.machineresource.MachineResource
import com.snack.snackserver.machineresource.MachineResourceService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
    val machineService: IMachineService
) {

    @GetMapping("/home/")
    fun getHome(model: Model): String{
        val machine = machineService.createMachineResource(
            ip_address = "192.168.100.20",
            ram = 10.0F,
            storage = 20.0F,
            cpu = 30.0F
        )
        model["machine"] = machine
        return "home"
    }

}
