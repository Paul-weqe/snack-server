package com.snack.server.web.machineresource

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MachineResourceController(
    val machinesRepository: MachineResourceRepository
) {
    @GetMapping("/home/")
    fun homeMapping(model: Model) : String{
        val all_machines_repositories = machinesRepository.findAll()
        model["all_machines"] = all_machines_repositories
        return "home"
    }

}