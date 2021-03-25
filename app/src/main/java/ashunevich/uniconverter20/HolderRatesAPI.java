package ashunevich.uniconverter20;


import retrofit2.Call;
;
import retrofit2.http.GET;

public interface HolderRatesAPI {
    @GET("latest")
    Call<DatePojo> getRates();


}
