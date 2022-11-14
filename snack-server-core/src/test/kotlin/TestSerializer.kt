import com.snack.server.core.dataclasses.Device
import com.snack.server.core.serializer.InputSerializer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class TestSerializer {
    val validXmlString = "<Device>" +
            "<machineId>machineId</machineId>" +
            "<operatingSystem>linux</operatingSystem>" +
            "<hostname>waswa</hostname>" +
            "<resources>" +
                "<ram>10.10</ram>" +
                "<storage>20.20</storage>" +
                "<cpu>30.30</cpu>" +
            "</resources>" +
        "</Device>"

    val validJsonString = "{" +
            "\"machineId\":\"machineId\"," +
            "\"operatingSystem\":\"linux\"," +
            "\"hostname\":\"waswa\"," +
            "\"resources\":{" +
            "\"ram\":10.10," +
            "\"storage\": 20.20," +
            "\"cpu\": 30.30" +
            "}" +
            "}"

    fun Float.roundTo(n: Int): Float {
        return "%.${n}f".format(this).toFloat()
    }

    @Test
    fun testValidXmlSerialization(){
        val serializedData = InputSerializer.serializeXml(validXmlString)
        runSerializerAssertions(serializedData)
    }

    @Test
    fun testValidJsonSerialization(){
        val serializedData = InputSerializer.serializeJson(validJsonString)
        runSerializerAssertions(serializedData)
    }

    private fun runSerializerAssertions(serializedData: Device?){
        assertEquals(serializedData?.hostname, "waswa")
        assertEquals(serializedData?.operatingSystem, "linux")
        assertEquals(serializedData?.machineId, "machineId")
        assertEquals(serializedData?.resources?.ram?.roundTo(5), 10.10F.roundTo(5))
        assertEquals(serializedData?.resources?.storage?.roundTo(5), 20.20F.roundTo(5))
        assertEquals(serializedData?.resources?.cpu?.roundTo(5), 30.30F.roundTo(5))

    }

}