package ashunevich.uniconverterKT

import com.ashunevich.conversionlibrary.UnitConverter.ConvertValues
import org.junit.Assert
import org.junit.Test

class ConverterTests {

    @Test
    fun convertSomeUnit(){
        val firstUnit = "Kilogram"
        val secondUnit = "Gram"

        Assert.assertEquals(ConvertValues(firstUnit,secondUnit,1.00)
            ,"1000")
    }
}