package com.snack.server.core

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper

class SnackSerializer {
    companion object{

        fun serialize(unserializedInputData: String): SnackResourceData? {
            var result: SnackResourceData?
            try {
                result = serializeXml(unserializedInputData)
            }
            catch(exception: JsonParseException){
                result = null
            }

            if (result == null){
                try{
                    result = serializeJson(unserializedInputData)
                } catch(exception: JsonParseException){
                    result = null
                }
            }

            return result
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
        fun serializeXml(unserializedInputData: String): SnackResourceData? {
            val mapper = XmlMapper()
            val snackResource = mapper.readValue(unserializedInputData, SnackResourceData::class.java)
            return snackResource
        }

        /**
         * Sample unserializedInputData is:
         * {
         *  ""
         * }
         */
        fun serializeJson(unserializedInputData: String): SnackResourceData? {
            val snackResource = ObjectMapper().readValue(unserializedInputData, SnackResourceData::class.java)
            return snackResource
        }
    }
}

class SnackResourceData{
    var ip_address: String = ""
    var ram: Float = Float.MIN_VALUE
    var storage: Float = Float.MIN_VALUE
    var cpu: Float = Float.MIN_VALUE

    override fun toString(): String {
        return "<ip-address: ${this.ip_address}, ram: ${this.ram}, storage: ${this.storage}, cpu: ${this.cpu}>"
    }
}

