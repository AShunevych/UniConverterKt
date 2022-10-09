package ashunevich.uniconverterKT.currencyapi.backend

import retrofit2.http.GET
import retrofit2.Call

interface RatesApi {
    @get:GET("latest")
    val rates: Call<CurrencyResponseObject?>
}