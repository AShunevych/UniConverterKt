package ashunevich.uniconverter20;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class InternetUtils {
    private static InternetUtils instance;

    private static final String RATES_URL = "https://api.exchangeratesapi.io/";
    private final Retrofit mRetrofit;

    private InternetUtils() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(RATES_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static InternetUtils getInstance() {
        if (instance == null) {
            instance = new InternetUtils();
        }
        return instance;
    }

    public HolderRatesAPI getJSONApi() {
        return mRetrofit.create(HolderRatesAPI.class);
    }


    // CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT
        public static boolean checkConnection(Context context) {
            final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connMgr != null) {
                NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

                if (activeNetworkInfo != null) { // connected to the internet
                    // connected to the mobile provider's data plan
                    if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                        // connected to wifi
                        return true;
                    } else return activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
                }
            }
            return false;
        }



    }



