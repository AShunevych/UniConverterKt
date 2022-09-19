package ashunevich.uniconverterKT

import com.ashunevich.conversionlibrary.UnitConverter.ConvertValues
import org.junit.Assert
import org.junit.Test

class ConverterTests {

    companion object {
        const val TAG = "ConverterTests"
    }

    @Test
    fun convertSomeUnit() {
        val firstUnit = "Kilogram"
        val secondUnit = "Gram"

        Assert.assertEquals(
            ConvertValues(firstUnit, secondUnit, 1.00), "1000"
        )
    }

    @Test
    fun getPackArgs() {
        val property = System.getProperty("withFeature")
        Assert.assertEquals("default", property)
    }
}
