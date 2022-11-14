package com.snack.server.web.machineresource.controller

import com.snack.server.web.machineresource.IMachineService
import com.snack.server.web.machineresource.MachineResourceRepository
import com.snack.server.web.machineresource.MachineResourceService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MachineResourceController(
    val machineResourceService: IMachineService
) {
    @GetMapping("/machine-resources/")
    fun allMachineResources(model: Model) : String{
        model["all_machines"] = machineResourceService.findMachinesResources()
        return "home"
    }

}