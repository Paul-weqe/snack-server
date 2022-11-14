package com.snack.server.web.deviceresource.controller

import com.snack.server.web.deviceresource.IMachineService
import com.snack.server.web.deviceresource.MachineResourceEntity
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController()
class ApiMachineResourceController(
    val machineResourceService: IMachineService
) {
    @GetMapping("/api/all-machine-resources", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllMachines(): List<MachineResourceEntity> = machineResourceService.findMachinesResources()
}