package ashunevich.uniconverter20.currencyapi;

import android.util.Log;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyInteractorImpl implements CurrencyContract.currencyInteractor {

    @Override
    public void getCurrencyData(OnFinishedListener onFinishedListener) {
        CurrencyInternetService.getInstance().getJSONApi().getRates().enqueue(new Callback<CurrencyResponseObject> () {
            @Override
            public void onResponse(@NonNull Call<CurrencyResponseObject> call, @NonNull Response<CurrencyResponseObject> response) {
                Log.d("CALLBACK","OK");
                CurrencyResponseObject pojo = response.body ();

                onFinishedListener.onFinished (pojo);

            }
            @Override
            public void onFailure(@NonNull Call<CurrencyResponseObject> call, @NonNull Throwable t) {
                Log.d("CALLBACK","FAILED");
               onFinishedListener.onFailure (t);
            }
        });
    }
}
