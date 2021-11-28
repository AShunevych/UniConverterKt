package ashunevich.uniconverterKT.currencyapi

import retrofit2.http.GET
import retrofit2.Call

interface CurrencyRatesAPI {
    @get:GET("latest")
    val rates: Call<CurrencyResponseObject?>
}