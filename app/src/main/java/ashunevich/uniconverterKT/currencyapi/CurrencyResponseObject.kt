package ashunevich.uniconverterKT.currencyapi

import com.google.gson.annotations.SerializedName

open class CurrencyResponseObject protected constructor(
    @field:SerializedName("rates") var `object`: CurrencyRateObject, @field:SerializedName(
        "date"
    ) var date: String
)

class CurrencyRateObject {
    @SerializedName("USD")
    var USD: Double = 0.0

    @SerializedName("GBP")
    var GBP: Double = 0.0

    @SerializedName("IDR")
    var IDR: Double = 0.0

    @SerializedName("PLN")
    var PLN: Double = 0.0

    @SerializedName("RUB")
    var RUB: Double = 0.0
    fun getRate(currency: String?): Double {
        when (currency) {
            "USD" -> return USD
            "GBP" -> return GBP
            "IDR" -> return IDR
            "PLN" -> return PLN
            "RUB" -> return RUB
            else -> return 0.0
        }
    }
}