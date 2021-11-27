package ashunevich.uniconverter20.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import ashunevich.uniconverter20.ui.AppViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import android.widget.EditText
import android.text.InputType
import android.widget.TextView
import android.text.TextUtils
import android.annotation.SuppressLint
import ashunevich.uniconverter20.R
import androidx.lifecycle.ViewModelStoreOwner
import ashunevich.uniconverter20.currencyapi.CurrencyContractor.Interactor
import ashunevich.uniconverter20.currencyapi.CurrencyContractor.Presenter
import ashunevich.uniconverter20.currencyapi.CurrencyContractor.Interactor.OnFinishedListener
import ashunevich.uniconverter20.currencyapi.CurrencyResponseObject
import ashunevich.uniconverter20.currencyapi.CurrencyInternetService
import retrofit2.http.GET
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ashunevich.uniconverter20.currencyapi.PresenterImp
import ashunevich.uniconverter20.currencyapi.InteractorImpl
import android.widget.AdapterView
import android.text.TextWatcher
import android.text.Editable
import android.widget.ArrayAdapter
import ashunevich.uniconverter20.currencyapi.CurrencyRateObject
import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import ashunevich.uniconverter20.currencyapi.CurrencyRatesAPI
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import ashunevich.uniconverter20.ActivityMain.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.google.android.material.tabs.TabLayout
import android.content.Intent
import ashunevich.uniconverter20.ActivityCalculator
import android.app.ActivityOptions
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AppViewModel : ViewModel() {
    private val selected = MutableLiveData<Int>()
    private val postNumber = MutableLiveData<String?>()
    fun setPostNumber(textNumber: String?) {
        postNumber.value = textNumber
    }

    val postedNumber: LiveData<String?>
        get() = postNumber

    fun select(pos: Int) {
        selected.value = pos
    }

    fun getSelected(): LiveData<Int> {
        return selected
    }
}