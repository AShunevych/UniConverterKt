package ashunevich.uniconverterKT.currencyapi

import ashunevich.uniconverterKT.ui.AppViewModel
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import ashunevich.uniconverterKT.R
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import android.text.TextWatcher
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import ashunevich.uniconverterKT.Utils
import ashunevich.uniconverterKT.databinding.CurrencyActivityBinding
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.HashMap

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
            binding!!.valueCurrency.getText().toString()
        )
        savedInstanceState.putString(
            Utils.SAVED_RESULT,
            binding!!.resultCurrency.getText().toString()
        )
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CurrencyActivityBinding.inflate(getLayoutInflater())
        setContentView(binding!!.getRoot())
       //setButtonBindings_ConverterCurrency()
        setAdapter((getResources().getStringArray(R.array.currency)))
        setUnitMeasurements()
        setSpinnersListeners(binding!!.spinnerFromCurrency)
        setSpinnersListeners(binding!!.spinnerToCurrency)
        if (TextUtils.isEmpty(Utils.returnDateString(binding!!.dateView))) {
          //  checkConnection()
        }
        val model: AppViewModel = Utils.generateViewModel(this)
        model.postedNumber.observe(this, Observer({ event: String? -> this.getText(event) }))
        addTextWatcher()
        binding!!.valueCurrency.setInputType(InputType.TYPE_NULL)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding!!.valueCurrency.setText(savedInstanceState.getString(Utils.SAVED_VALUE))
        binding!!.resultCurrency.text = savedInstanceState.getString(Utils.SAVED_RESULT)
        super.onRestoreInstanceState(savedInstanceState)
    }

   /* private fun checkConnection() {
        if (!CurrencyInternetService.Companion.checkConnection(this)) {
            Snackbar.make(
                binding!!.currencyLayout,
                getResources().getString(R.string.NoInternetConnection),
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            Snackbar.make(
                binding!!.currencyLayout,
                getResources().getString(R.string.PostitiveInternetConnection),
                Snackbar.LENGTH_SHORT
            ).show()
            val presenter: Presenter = PresenterImp(this, InteractorImpl())
            presenter.requestDataFromServer()
        }
    }*/

    protected fun getText(event: String?) {
        if ((event == Utils.SYMBOL_BRACKETS) || (event == Utils.SYMBOL_SOLVE) || (event == Utils.SYMBOL_CLEAR)) {
            when (event) {
                Utils.SYMBOL_BRACKETS -> Utils.checkBrackets(
                    binding!!.valueCurrency
                )
                Utils.SYMBOL_SOLVE -> convertOnDemand()
                Utils.SYMBOL_CLEAR -> Utils.clearView(
                    binding!!.valueCurrency, binding!!.resultCurrency
                )
            }
        } else {
            binding!!.valueCurrency.append(event)
        }
    }

    //app Listeners
   /* private fun setButtonBindings_ConverterCurrency() {
        binding!!.refreshJSONData.setOnClickListener(View.OnClickListener({ v: View? -> checkConnection() }))
        binding!!.correction.setOnClickListener(View.OnClickListener({ v: View? ->
            Utils.correctValue(
                binding!!.valueCurrency, binding!!.resultCurrency
            )
        }))
    }*/

    //if user changes unit - it will change measurements and will automatically recalculate result
    private fun setSpinnersListeners(spinner: Spinner) {
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            public override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                setUnitMeasurements()
                convertOnDemand()
            }

            public override fun onNothingSelected(parentView: AdapterView<*>?) {}
        })
    }

    //Auto conversion  when user add number to value for convert
    private fun addTextWatcher() {
        binding!!.valueCurrency.addTextChangedListener(object : TextWatcher {
            public override fun afterTextChanged(s: Editable) {
                if ((binding!!.valueCurrency.getText().toString().contains("+") or
                            binding!!.valueCurrency.getText().toString().contains("-") or
                            binding!!.valueCurrency.getText().toString().contains("/") or
                            binding!!.valueCurrency.getText().toString().contains("*") or
                            binding!!.valueCurrency.getText().toString().contains("(") or
                            binding!!.valueCurrency.getText().toString().contains(")") or
                            TextUtils.isEmpty(binding!!.valueCurrency.getText().toString()))
                ) {
                    Log.d("valueCurrency ", "occurred exception")
                } else {
                    convertOnTextChange()
                }
            }

             override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

             override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
            }
        })
    }

    //set units of measurements for value
    private fun setUnitMeasurements() {
        Utils.currencyUnitHandler(
            Utils.getSpinnerValueString(
                binding!!.spinnerFromCurrency
            ), binding!!.currencyFROMShort
        )
        Utils.currencyUnitHandler(
            Utils.getSpinnerValueString(
                binding!!.spinnerToCurrency
            ), binding!!.currencyToShort
        )
    }

    private fun setAdapter(array: Array<String>) {
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.custom_spinner_item, array
        )
        binding!!.spinnerFromCurrency.setAdapter(adapter)
        binding!!.spinnerToCurrency.setAdapter(adapter)
    }

    private fun setStringFormat(resultDouble: Double) {
        val formatter: NumberFormat = DecimalFormat("###.####")
        binding!!.resultCurrency.setText((formatter.format(resultDouble)))
    }

    // app conversion work
    private fun convertOnTextChange() {
        getEnteredValue = binding!!.valueCurrency.getText().toString().toDouble()
        try {
            if (hm != null) {
                val initRate: Double? = hm!!.get(
                    Utils.getSpinnerValueString(
                        binding!!.spinnerFromCurrency
                    )
                )
                val targetRate: Double? = hm!!.get(
                    Utils.getSpinnerValueString(
                        binding!!.spinnerToCurrency
                    )
                )
                setStringFormat(Utils.currencyConverter(getEnteredValue, targetRate, initRate))
            }
        } catch (e: Exception) {
            Log.d(" Exception", "Exception cached")
        }
    }

    private fun convertOnDemand() {
        if (TextUtils.isEmpty(binding!!.valueCurrency.text.toString())) {
            binding!!.resultCurrency.text = ""
        } else {
            try { //get JSON received values
                val initRate: Double? = hm!![Utils.getSpinnerValueString(
                    binding!!.spinnerFromCurrency
                )]
                val targetRate: Double? = hm!![Utils.getSpinnerValueString(
                    binding!!.spinnerToCurrency
                )]
                //use MathParser to calculate value
                val value = Expression(
                    binding!!.valueCurrency.text.toString()
                )
                //use calculated value
                setStringFormat(Utils.currencyConverter(value.calculate(), targetRate, initRate))
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d(" Exception", "Exception cached")
            }
        }
    }

    private fun makeSnackBar(snackText: String) {
        Snackbar.make(binding!!.currencyLayout, snackText, Snackbar.LENGTH_SHORT).show()
    }


    fun parseDataFromResponseToHashmap(`object`: CurrencyResponseObject?) {
         binding!!.dateView.text = `object`!!.date
        hm = HashMap()
         hm!![resources.getString(R.string.USD)] = `object`.`object`.getRate("USD")
         hm!![resources.getString(R.string.GBP)] = `object`.`object`.getRate("GBP")
         hm!![resources.getString(R.string.IDR)] = `object`.`object`.getRate("IDR")
         hm!![resources.getString(R.string.PLN)] = `object`.`object`.getRate("PLN")
         hm!![resources.getString(R.string.NZD)] = `object`.`object`.getRate("NZD")
         hm!![resources.getString(R.string.RUB)] = `object`.`object`.getRate("RUB")
        if (hm!!.isEmpty()) {
            makeSnackBar("Fail!")
        } else {
            makeSnackBar("Success!")
        }
    }
}