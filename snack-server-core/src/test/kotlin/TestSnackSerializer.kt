import com.fasterxml.jackson.core.JsonParseException
import com.snack.server.core.SnackSerializer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.invoke.SerializedLambda
import kotlin.math.roundToInt

class TestSnackSerializer {
    val validXmlString = "<SnackResourceData>" +
            "<ip_address>10.10.10.10</ip_address>" +
            "<ram>10.0</ram>" +
            "<storage>20.0</storage>" +
            "<cpu>30.0</cpu>" +
            "</SnackResourceData>"


    val validJsonString = "{" +
            "\"ip_address\": \"10.10.10.10\"," +
            "\"ram\": 10.0," +
            "\"storage\": 20.0," +
            "\"cpu\": 30.0" +
            "}"

    val invalidJson = "thisismine"

    fun Float.roundTo(n: Int): Float{
        return "%.${n}f".format(this).toFloat()
    }

    @Test
    fun testXmlSerialization(){
        val serializedResourceData = SnackSerializer.serializeXml(validXmlString)
        assertEquals(serializedResourceData?.cpu?.roundTo(5) , 30.0F.roundTo(5))
        assertEquals(serializedResourceData?.ram?.roundTo(5) , 10.0F.roundTo(5))
        assertEquals(serializedResourceData?.storage?.roundTo(5) , 20.0F.roundTo(5))
        assertEquals(serializedResourceData?.ip_address , "10.10.10.10")
    }

    @Test
    fun testJsonSerialization(){
        val serializedResourceData = SnackSerializer.serializeJson(validJsonString);
        assertEquals(serializedResourceData?.cpu?.roundTo(5) , 30.0F.roundTo(5))
        assertEquals(serializedResourceData?.ram?.roundTo(5) , 10.0F.roundTo(5))
        assertEquals(serializedResourceData?.storage?.roundTo(5) , 20.0F.roundTo(5))
        assertEquals(serializedResourceData?.ip_address , "10.10.10.10")
    }

    @Test
    fun testInvalidJson(){
        val serializedXml = SnackSerializer.serialize(validXmlString)
        val serializedJson = SnackSerializer.serialize(validJsonString)
        val serializedInvalid = SnackSerializer.serialize(invalidJson)

        assertEquals(serializedXml?.cpu, serializedJson?.cpu)
        assertEquals(serializedXml?.ram, serializedJson?.ram)
        assertEquals(serializedXml?.storage, serializedJson?.storage)
        assertEquals(serializedXml?.ip_address, serializedJson?.ip_address)
        assertEquals(serializedInvalid, null)
    }
}