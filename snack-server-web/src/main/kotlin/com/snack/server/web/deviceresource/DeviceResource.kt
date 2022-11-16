package com.snack.server.web.deviceresource

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "devices_resources")
class DeviceResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int = Int.MIN_VALUE

    @Column(name = "device_id")
    var deviceId: Int = Int.MIN_VALUE

    @Column(name = "ram")
    var ram: Float = Float.MIN_VALUE

    @Column(name = "storage")
    var storage: Float = Float.MIN_VALUE

    @Column(name = "cpu")
    var cpu: Float = Float.MIN_VALUE

    @Column(name = "time_s")
    @CreationTimestamp
    lateinit var timeS: LocalDateTime

    constructor(deviceId: Int, ram: Float, storage: Float, cpu: Float){
        this.deviceId = deviceId
        this.ram = ram
        this.storage = storage
        this.cpu = cpu
    }

    constructor()
}