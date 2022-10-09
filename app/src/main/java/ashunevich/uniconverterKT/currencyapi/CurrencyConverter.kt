package ashunevich.uniconverterKT.currencyapi

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import ashunevich.uniconverterKT.R
import ashunevich.uniconverterKT.Utils
import ashunevich.uniconverterKT.Utils.SYMBOL_BRACKETS
import ashunevich.uniconverterKT.Utils.SYMBOL_CLEAR
import ashunevich.uniconverterKT.Utils.SYMBOL_SOLVE
import ashunevich.uniconverterKT.Utils.checkBrackets
import ashunevich.uniconverterKT.Utils.clearView
import ashunevich.uniconverterKT.Utils.currencyConverter
import ashunevich.uniconverterKT.Utils.currencyUnitHandler
import ashunevich.uniconverterKT.Utils.getSpinnerValueString
import ashunevich.uniconverterKT.Utils.isNetworkAvailable
import ashunevich.uniconverterKT.Utils.snackBarFabric
import ashunevich.uniconverterKT.Utils.textIsEmpty
import ashunevich.uniconverterKT.currencyapi.backend.CurrencyResponseObject
import ashunevich.uniconverterKT.databinding.CurrencyActivityBinding
import ashunevich.uniconverterKT.ui.AppViewModel
import com.google.android.material.snackbar.Snackbar
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import java.text.NumberFormat

open class CurrencyConverter : AppCompatActivity() {
    private var binding: CurrencyActivityBinding? = null
    protected var getEnteredValue: Double = 0.0
    protected var hm: HashMap<String?, Double>? = null
    public override fun onStart() {
        super.onStart()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString(
            Utils.SAVED_VALUE,
            binding!!.valueCurrency.text.toString()
        )
        savedInstanceState.putString(
            Utils.SAVED_RESULT,
            binding!!.resultCurrency.text.toString()
        )
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CurrencyActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        // setButtonBindings_ConverterCurrency()
        setAdapter(array = resources.getStringArray(R.array.currency))
        setUnitMeasurements()
        setSpinnersListeners(spinner = binding!!.spinnerFromCurrency)
        setSpinnersListeners(spinner = binding!!.spinnerToCurrency)
        if (textIsEmpty(binding!!.dateView)) {
            checkConnection()
        }
        val model: AppViewModel = Utils.generateViewModel(this)
        model.postedNumber.observe(this) { event: String? -> this.getText(event) }
        addTextWatcher()
        binding!!.valueCurrency.inputType = InputType.TYPE_NULL
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding!!.valueCurrency.setText(savedInstanceState.getString(Utils.SAVED_VALUE))
        binding!!.resultCurrency.text = savedInstanceState.getString(Utils.SAVED_RESULT)
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun checkConnection() {
        if (isNetworkAvailable(applicationContext)) {
            makeSnackBar(snackText = resources.getString(R.string.NoInternetConnection))
        } else {
            makeSnackBar(snackText = resources.getString(R.string.PostitiveInternetConnection))
            /* val presenter: Presenter = PresenterImp(this, InteractorImpl())
             presenter.requestDataFromServer()*/
        }
    }

    protected fun getText(event: String?) {
        if ((event == SYMBOL_BRACKETS) || (event == SYMBOL_SOLVE) || (event == SYMBOL_CLEAR)) {
            when (event) {
                SYMBOL_BRACKETS -> checkBrackets(
                    valueEdit = binding!!.valueCurrency
                )
                SYMBOL_SOLVE -> convertOnDemand()
                SYMBOL_CLEAR -> clearView(
                    valueEdit = binding!!.valueCurrency,
                    resultView = binding!!.resultCurrency
                )
            }
        } else {
            binding!!.valueCurrency.append(event)
        }
    }

    // app Listeners
    /* private fun setButtonBindings_ConverterCurrency() {
         binding!!.refreshJSONData.setOnClickListener(View.OnClickListener({ v: View? -> checkConnection() }))
         binding!!.correction.setOnClickListener(View.OnClickListener({ v: View? ->
             Utils.correctValue(
                 binding!!.valueCurrency, binding!!.resultCurrency
             )
         }))
     }*/

    // if user changes unit - it will change measurements and will automatically recalculate result
    private fun setSpinnersListeners(spinner: Spinner) {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                setUnitMeasurements()
                convertOnDemand()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }
    }

    // Auto conversion  when user add number to value for convert
    private fun addTextWatcher() {
        binding!!.valueCurrency.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                if (!valueCurrencyContainsSymbols()) {
                    convertOnTextChange()
                }
            }
        })
    }

    private fun valueCurrencyContainsSymbols(): Boolean {
        var bool = true
        val valueCurrencyText = binding!!.valueCurrency.text.toString()
        val symbolList = listOf("-", "/", "*", "(", ")")

        for (symbol in symbolList) {
            bool = valueCurrencyText.contains(symbol)
        }
        return bool
    }

    // set units of measurements for value
    private fun setUnitMeasurements() {
        currencyUnitHandler(
            spinnerTextValue = getSpinnerValueString(
                spinner = binding!!.spinnerFromCurrency
            ),
            measurementUnit = binding!!.currencyFROMShort
        )
        currencyUnitHandler(
            spinnerTextValue = getSpinnerValueString(
                spinner = binding!!.spinnerToCurrency
            ),
            measurementUnit = binding!!.currencyToShort
        )
    }

    private fun setAdapter(array: Array<String>) {
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.custom_spinner_item, array
        )
        binding!!.spinnerFromCurrency.adapter = adapter
        binding!!.spinnerToCurrency.adapter = adapter
    }

    private fun setStringFormat(resultDouble: Double) {
        val formatter: NumberFormat = DecimalFormat("###.####")
        binding!!.resultCurrency.text = (formatter.format(resultDouble))
    }

    // app conversion work
    private fun convertOnTextChange() {
        getEnteredValue = binding!!.valueCurrency.text.toString().toDouble()
        try {
            if (hm != null) {
                val initRate: Double? = stringFromSpinner(spinner = binding!!.spinnerFromCurrency)
                val targetRate: Double? = stringFromSpinner(spinner = binding!!.spinnerToCurrency)

                setStringFormat(
                    resultDouble = currencyConverter(
                        value = getEnteredValue,
                        targetRate = targetRate,
                        initRate = initRate)
                )
            }
        } catch (e: Exception) {
            Log.d(" Exception", "Exception cached")
        }
    }

    private fun stringFromSpinner(spinner: Spinner): Double? {
        return hm!![getSpinnerValueString(spinner)]
    }

    private fun convertOnDemand() {
        if (textIsEmpty(textview = binding!!.valueCurrency)) {
            binding!!.resultCurrency.text = ""
        } else {
            try { // get JSON received values
                val initRate: Double? = stringFromSpinner(spinner = binding!!.spinnerFromCurrency)
                val targetRate: Double? = stringFromSpinner(spinner = binding!!.spinnerToCurrency)

                // use MathParser to calculate value
                val value = Expression(
                    binding!!.valueCurrency.text.toString()
                )
                // use calculated value
                setStringFormat(
                    resultDouble = currencyConverter(
                        value = value.calculate(),
                        targetRate = targetRate,
                        initRate = initRate)
                )
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d(" Exception", "Exception cached")
            }
        }
    }

    fun makeSnackBar(snackText: String) {
        snackBarFabric(
            layout = binding!!.currencyLayout,
            snackText = snackText,
            duration = Snackbar.LENGTH_SHORT)
            .show()
    }

    fun parseDataFromResponseToHashmap(`object`: CurrencyResponseObject?) {
        binding!!.dateView.text = `object`!!.date
        hm = HashMap()
        hm!![resources.getString(R.string.USD)] = `object`.`object`.getRate("USD")
        hm!![resources.getString(R.string.GBP)] = `object`.`object`.getRate("GBP")
        hm!![resources.getString(R.string.IDR)] = `object`.`object`.getRate("IDR")
        hm!![resources.getString(R.string.PLN)] = `object`.`object`.getRate("PLN")
        hm!![resources.getString(R.string.NZD)] = `object`.`object`.getRate("NZD")
        if (hm!!.isEmpty()) {
            makeSnackBar(snackText = "Fail!")
        } else {
            makeSnackBar(snackText = "Success!")
        }
    }
}
