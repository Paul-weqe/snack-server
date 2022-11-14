package com.snack.server.core.serializer

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.snack.server.core.dataclasses.Device

class InputSerializer {
    companion object {

        fun serialize(unserializedInputData: String): Device? {
            var result: Device?
            try{
                result = serializeXml(unserializedInputData)
            } catch(execption: JsonParseException){
                result = null
            }

            if (result == null){
                try{
                    result= serializeJson(unserializedInputData)
                } catch (exception: JsonParseException){
                    result = null
                }
            }
            return result
        }

        /**
         * <Device>
         *     <machineId>thisismachineId</machineId>
         *     <operatingSystem>linux</operatingSystem>
         *     <hostname>waswa</hostname>
         *     <resources>
         *         <ram>10.10</ram>
         *         <storage>20.20</storage>
         *         <cpu>30.30</cpu>
         *     </resources>
         * </Device>
         */
        fun serializeXml(unserializedInputData: String): Device? {
            val mapper = XmlMapper()
            return mapper.readValue(unserializedInputData, Device::class.java)
        }

        /**
         * {
         *  "machineId": "machineId",
         *  "operatingSystem": "linux",
         *  "hostname": "waswa",
         *  "resources": {
         *      "ram": 10.10,
         *      "storage": 20.20,
         *      "cpu": 30.30
         *   }
         * }
         */
        fun serializeJson(unserializedInputData: String): Device? {
            val mapper = ObjectMapper()
            return mapper.readValue(unserializedInputData, Device::class.java)
        }


    }
}