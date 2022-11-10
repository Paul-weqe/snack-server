package com.snack.server.web.machineresource

import javax.persistence.*

@Entity
@Table(name = "machine_resources")
class MachineResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = Int.MIN_VALUE

    @Column(name = "ip_address")
    var ip_address: String = ""

    @Column(name = "ram")
    var ram: Float = Float.MIN_VALUE

    @Column(name = "storage")
    var storage: Float = Float.MIN_VALUE

    @Column(name = "cpu")
    var cpu: Float = Float.MIN_VALUE

    constructor(ip_address: String, ram: Float, storage: Float, cpu: Float){
        this.ip_address = ip_address
        this.ram = ram
        this.storage = storage
        this.cpu = cpu
    }

    constructor(){}
}