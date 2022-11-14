package com.snack.server.web.device

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "devices")
class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = Int.MIN_VALUE

    @Column(name = "machine_id")
    var machineId: String = ""

    @Column(name = "operating_system")
    var operatingSystem: String = ""

    @Column(name = "hostname")
    var hostname: String = ""

    constructor(machineId: String, operatingSystem: String, hostname: String){
        this.machineId = machineId
        this.operatingSystem = operatingSystem
        this.hostname = hostname
    }

    constructor(){

    }

}