package ashunevich.uniconverter20.currencyapi;


import retrofit2.Call;
import retrofit2.http.GET;

interface CurrencyRatesAPI {
    @GET("latest")
    Call<CurrencyResponseObject> getRates();


}
