package ashunevich.uniconverterKT.currencyapi.backend

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class InternetService {

    private var instance: InternetService? = null

    private val RATES_URL = "https://www.frankfurter.app/"
    private var mRetrofit: Retrofit? = null

    private fun currencyInternetService() {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        mRetrofit = Retrofit.Builder()
            .baseUrl(RATES_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    fun getInstance(): InternetService? {
        if (instance == null) {
            currencyInternetService()
        }
        return instance
    }

    fun getJSONApi(): RatesApi? {
        return mRetrofit!!.create(RatesApi::class.java)
    }


    // CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT
    protected fun checkConnection(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connMgr != null) {
            val activeNetworkInfo = connMgr.activeNetworkInfo
            if (activeNetworkInfo != null) { // connected to the internet
                // connected to the mobile provider's data plan
                return if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    true
                } else activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE
            }
        }
        return false
    }
}