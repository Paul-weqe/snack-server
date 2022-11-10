package com.snack.server.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper

class SnackSerializer {
    companion object{

        fun serialize(unserializedInputData: String): SnackResourceData? {
            return null
        }

        /*
        * sample unserializedInputData is:
        * <SnackResourceData>
        *   <ip_address>10.10.10.10</ip_address>
        *   <ram>10.0</ram>
        *   <storage>20.0</storage>
        *   <cpu>30.0</cpu>
        * </SnackResourceData>
         */
        fun serializeXml(unserializedInputData: String): SnackResourceData {
            val mapper = XmlMapper()
            println(unserializedInputData)
            val snackResource = mapper.readValue(unserializedInputData, SnackResourceData::class.java)
            return snackResource
        }

        /**
         * Sample unserializedInputData is:
         * {
         *  ""
         * }
         */
        fun serializeJson(unserializedInputData: String): SnackResourceData {
            val mapper = ObjectMapper()
            val snackResource = mapper.readValue(unserializedInputData, SnackResourceData::class.java)
            return snackResource
        }
    }
}

class SnackResourceData{
    var ip_address: String = ""
    var ram: Double = Double.MIN_VALUE
    var storage: Double = Double.MIN_VALUE
    var cpu: Double = Double.MIN_VALUE

    override fun toString(): String {
        return "<ip-address: ${this.ip_address}, ram: ${this.ram}, storage: ${this.storage}, cpu: ${this.cpu}>"
    }
}

