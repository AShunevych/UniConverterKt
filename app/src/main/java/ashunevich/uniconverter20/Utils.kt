package ashunevich.uniconverter20


import ashunevich.uniconverter20.ui.AppViewModel
import androidx.lifecycle.ViewModelProvider
import android.text.InputType
import android.text.TextUtils
import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelStoreOwner
import android.util.Log
import android.widget.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.StringBuilder
import java.util.*

object Utils {
    private const val TAG = "ERROR-"
    const val SAVED_VALUE = "savedValue"
    const val SAVED_RESULT = "saveResult"
    const val SYMBOL_CORRECT = "⇽"
    const val SYMBOL_CLEAR = "C"
    const val SYMBOL_BRACKETS = "( )"
    const val SYMBOL_SOLVE = "="
    const val SYMBOL_CHECK = "-/+"
    fun blockInput(resultView: EditText, valueEdit: EditText) {
        resultView.inputType = InputType.TYPE_NULL
        valueEdit.inputType = InputType.TYPE_NULL
    }

    fun clearView(valueEdit: EditText, resultView: TextView) {
        resultView.text = ""
        valueEdit.setText("")
    }

    fun getSpinnerValueString(spinner: Spinner): String {
        return spinner.selectedItem.toString()
    }

    fun readAndSolve(valueEdit: EditText, resultView: TextView) {
        if (!TextUtils.isEmpty(valueEdit.text.toString())) {
            val getValue = valueEdit.text.toString()
            val value = Expression(getValue)
            val getResult = value.calculate().toString()
            resultView.text = getResult
        } else {
            resultView.text = ""
        }
    }

    fun checkBrackets(valueEdit: EditText) {
        if (valueEdit.text.toString().contains("(")) {
            valueEdit.append(")")
        } else {
            valueEdit.append("(")
        }
    }

    fun postTextOnClick(model: AppViewModel?, button: Button) {
        val buttonText = button.text.toString()
        button.setOnClickListener { model!!.setPostNumber(buttonText) }
    }

    fun returnLocale(): String {
        return Locale.getDefault().displayLanguage
    }

    @SuppressLint("SetTextI18n")
    fun appendMinusPlus(valueEdit: EditText) {
        val x = valueEdit.text.length
        if (x != 15 || valueEdit.text.toString().contains("-")) {
            val sb = StringBuilder()
            if (valueEdit.text.toString().contains("-")) {
                sb.append(valueEdit.text.toString())
                sb.deleteCharAt(0)
                valueEdit.setText(sb.toString())
            } else {
                valueEdit.setText("-" + valueEdit.text)
            }
        }
    }

    fun correctValue(valueEdit: EditText, resultEdit: TextView) {
        val x = valueEdit.text.length
        if (x > 0) {
            valueEdit.setText(removeLastChar(valueEdit.text.toString()))
        } else {
            Log.d(TAG, "INVALID INPUT")
            clearView(valueEdit, resultEdit)
        }
    }

    private fun removeLastChar(str: String): String {
        return removeLastChars(str)
    }

    private fun removeLastChars(str: String): String {
        return str.substring(0, str.length - 1)
    }

    fun measurementUnitsHandler(
        spinnerTextValue: String?,
        measurementUnit: TextView
    ) {
        val resources = measurementUnit.resources
        when (spinnerTextValue) {
            "Milligram", "Міліграм" -> measurementUnit.text = resources.getString(R.string.unit_Mg)
            "Gram" -> measurementUnit.text = resources.getString(R.string.unit_G)
            "Kilogram" -> measurementUnit.text = resources.getString(R.string.unit_Kg)
            "Tonne" -> measurementUnit.text = resources.getString(R.string.unit_T)
            "Grain" -> measurementUnit.text = resources.getString(R.string.unit_Gr)
            "Ounce" -> measurementUnit.text = resources.getString(R.string.unit_Oz)
            "Pound" -> measurementUnit.text = resources.getString(R.string.unit_Lb)
            "Hundredweight" -> measurementUnit.text = resources.getString(R.string.unit_Hw)
            "Ton(long)" -> measurementUnit.text = resources.getString(R.string.unit_Tl)
            "Millimetre" -> measurementUnit.text = resources.getString(R.string.unit_Mm)
            "Centimetre" -> measurementUnit.text = resources.getString(R.string.unit_Sm)
            "Metre" -> measurementUnit.text = resources.getString(R.string.unit_M)
            "Kilometre" -> measurementUnit.text = resources.getString(R.string.unit_Km)
            "Inch" -> measurementUnit.text = resources.getString(R.string.unit_In)
            "Foot" -> measurementUnit.text = resources.getString(R.string.unit_Ft)
            "Yard" -> measurementUnit.text = resources.getString(R.string.unit_Yd)
            "Mile" -> measurementUnit.text = resources.getString(R.string.unit_Mi)
            "Celsius" -> measurementUnit.text = resources.getString(R.string.unit_c)
            "Kelvin" -> measurementUnit.text = resources.getString(R.string.unit_k)
            "Rankine" -> measurementUnit.text = resources.getString(R.string.unit_r)
            "Fahrenheit" -> measurementUnit.text = resources.getString(R.string.unit_f)
            "Square millimeter" -> measurementUnit.text =
                resources.getString(R.string.unit_Mm_Square)
            "Square centimeter" -> measurementUnit.text =
                resources.getString(R.string.unit_Cm_Square)
            "Square meter" -> measurementUnit.text = resources.getString(R.string.unit_М_Square)
            "Square kilometer" -> measurementUnit.text =
                resources.getString(R.string.unit_Km_Square)
            "Hectare" -> measurementUnit.text = resources.getString(R.string.unit_Ha)
            "Square mile" -> measurementUnit.text = resources.getString(R.string.unit_Mi_Square)
            "Square yard" -> measurementUnit.text = resources.getString(R.string.unit_Yd_Square)
            "Square feet" -> measurementUnit.text = resources.getString(R.string.unit_Ft_Square)
            "Square inch" -> measurementUnit.text = resources.getString(R.string.unit_In_Square)
            "Acre" -> measurementUnit.text = resources.getString(R.string.unit_Ac)
            "Seconds" -> measurementUnit.text = resources.getString(R.string.unit_Seconds)
            "Minutes" -> measurementUnit.text = resources.getString(R.string.unit_Minutes)
            "Hour" -> measurementUnit.text = resources.getString(R.string.unit_Hour)
            "Day" -> measurementUnit.text = resources.getString(R.string.unit_Day)
            "Week" -> measurementUnit.text = resources.getString(R.string.unit_Week)
            "Month" -> measurementUnit.text = resources.getString(R.string.unit_Month)
            "Year" -> measurementUnit.text = resources.getString(R.string.unit_Year)
            "Cubic millimetre" -> measurementUnit.text = resources.getString(R.string.unit_Mm_Cubic)
            "Cubic centimetre" -> measurementUnit.text = resources.getString(R.string.unit_Cm_Cubic)
            "Cubic metre" -> measurementUnit.text = resources.getString(R.string.unit_M_Cubic)
            "Milliliter" -> measurementUnit.text = resources.getString(R.string.unit_Ml)
            "Liter" -> measurementUnit.text = resources.getString(R.string.unit_L)
            "Fluid ounce" -> measurementUnit.text = resources.getString(R.string.unit_Fl_oz)
            "Barrel(UK)" -> measurementUnit.text = resources.getString(R.string.unit_Bbl_uk)
            "Gill" -> measurementUnit.text = resources.getString(R.string.unit_Gi)
            "Pint" -> measurementUnit.text = resources.getString(R.string.unit_Pt)
            "Quart" -> measurementUnit.text = resources.getString(R.string.unit_Qt)
            "Gallon" -> measurementUnit.text = resources.getString(R.string.unit_Gal)
            "Mlilinewton" -> measurementUnit.text = resources.getString(R.string.unit_Mn)
            "Newton" -> measurementUnit.text = resources.getString(R.string.unit_N)
            "Kilonewton" -> measurementUnit.text = resources.getString(R.string.unit_Kn)
            "Ton-force(metric)" -> measurementUnit.text = resources.getString(R.string.unit_Tf)
            "Gram-force" -> measurementUnit.text = resources.getString(R.string.unit_Gf)
            "Kilogram-force" -> measurementUnit.text = resources.getString(R.string.unit_Kgf)
            "Pond" -> measurementUnit.text = resources.getString(R.string.unit_P)
            "Pound-force" -> measurementUnit.text = resources.getString(R.string.unit_Lbf)
            "Ounce-force" -> measurementUnit.text = resources.getString(R.string.unit_Ozf)
            "Ton-force (long)" -> measurementUnit.text = resources.getString(R.string.unit_Tonf)
            "Poundal" -> measurementUnit.text = resources.getString(R.string.unit_Pdl)
            "Meter/second" -> measurementUnit.text = resources.getString(R.string.unit_M_s)
            "Meter/hour" -> measurementUnit.text = resources.getString(R.string.unit_M_h)
            "Kilometer/second" -> measurementUnit.text = resources.getString(R.string.unit_Km_s)
            "Kilometer/hour" -> measurementUnit.text = resources.getString(R.string.unit_Km_h)
            "Foot/second" -> measurementUnit.text = resources.getString(R.string.unit_F_s)
            "Foot/hour" -> measurementUnit.text = resources.getString(R.string.unit_F_h)
            "Mile/hour" -> measurementUnit.text = resources.getString(R.string.unit_Mi)
            "Knot" -> measurementUnit.text = resources.getString(R.string.unit_Kt)
            "Грам" -> measurementUnit.text = resources.getString(R.string.unit_G)
            "Кілограм" -> measurementUnit.text = resources.getString(R.string.unit_Kg)
            "Тонна" -> measurementUnit.text = resources.getString(R.string.unit_T)
            "Гран" -> measurementUnit.text = resources.getString(R.string.unit_Gr)
            "Унція" -> measurementUnit.text = resources.getString(R.string.unit_Oz)
            "Фунт" -> measurementUnit.text = resources.getString(R.string.unit_Lb)
            "Хандредвейт" -> measurementUnit.text = resources.getString(R.string.unit_Hw)
            "Тонна(довга)" -> measurementUnit.text = resources.getString(R.string.unit_Tl)
            "Міліметр" -> measurementUnit.text = resources.getString(R.string.unit_Mm)
            "Сантіметр" -> measurementUnit.text = resources.getString(R.string.unit_Sm)
            "Метр" -> measurementUnit.text = resources.getString(R.string.unit_M)
            "Кілометр" -> measurementUnit.text = resources.getString(R.string.unit_Km)
            "Дюйм" -> measurementUnit.text = resources.getString(R.string.unit_In)
            "Фут" -> measurementUnit.text = resources.getString(R.string.unit_Ft)
            "Ярд" -> measurementUnit.text = resources.getString(R.string.unit_Yd)
            "Міля" -> measurementUnit.text = resources.getString(R.string.unit_Mi)
            "Цельсій" -> measurementUnit.text = resources.getString(R.string.unit_c)
            "Кельвін" -> measurementUnit.text = resources.getString(R.string.unit_k)
            "Ранкін" -> measurementUnit.text = resources.getString(R.string.unit_r)
            "Фаренгейт" -> measurementUnit.text = resources.getString(R.string.unit_f)
            "Міліметр квадратний" -> measurementUnit.text =
                resources.getString(R.string.unit_Mm_Square)
            "Сантіметр квадратний" -> measurementUnit.text =
                resources.getString(R.string.unit_Cm_Square)
            "Метр квадратний" -> measurementUnit.text = resources.getString(R.string.unit_М_Square)
            "Кілометр квадратний" -> measurementUnit.text =
                resources.getString(R.string.unit_Km_Square)
            "Гектар" -> measurementUnit.text = resources.getString(R.string.unit_Ha)
            "Міля квадратна" -> measurementUnit.text = resources.getString(R.string.unit_Mi_Square)
            "Ярд квадратний" -> measurementUnit.text = resources.getString(R.string.unit_Yd_Square)
            "Фут квадратний" -> measurementUnit.text = resources.getString(R.string.unit_Ft_Square)
            "Дюйм квадратний" -> measurementUnit.text = resources.getString(R.string.unit_In_Square)
            "Акр" -> measurementUnit.text = resources.getString(R.string.unit_Ac)
            "Секунди" -> measurementUnit.text = resources.getString(R.string.unit_Seconds)
            "Хвилини" -> measurementUnit.text = resources.getString(R.string.unit_Minutes)
            "Година" -> measurementUnit.text = resources.getString(R.string.unit_Hour)
            "День" -> measurementUnit.text = resources.getString(R.string.unit_Day)
            "Тиждень" -> measurementUnit.text = resources.getString(R.string.unit_Week)
            "Місяц" -> measurementUnit.text = resources.getString(R.string.unit_Month)
            "Рік" -> measurementUnit.text = resources.getString(R.string.unit_Year)
            "Міліметр кубічний" -> measurementUnit.text =
                resources.getString(R.string.unit_Mm_Cubic)
            "Сантіметр кубічний" -> measurementUnit.text =
                resources.getString(R.string.unit_Cm_Cubic)
            "Метр кубічний" -> measurementUnit.text = resources.getString(R.string.unit_M_Cubic)
            "Мілілітр" -> measurementUnit.text = resources.getString(R.string.unit_Ml)
            "Літр" -> measurementUnit.text = resources.getString(R.string.unit_L)
            "Унція рідка" -> measurementUnit.text = resources.getString(R.string.unit_Fl_oz)
            "Баррель(UK)" -> measurementUnit.text = resources.getString(R.string.unit_Bbl_uk)
            "Джил" -> measurementUnit.text = resources.getString(R.string.unit_Gi)
            "Пінта" -> measurementUnit.text = resources.getString(R.string.unit_Pt)
            "Кварт" -> measurementUnit.text = resources.getString(R.string.unit_Qt)
            "Галлон" -> measurementUnit.text = resources.getString(R.string.unit_Gal)
            "Міліньютон " -> measurementUnit.text = resources.getString(R.string.unit_Mn)
            "Ньютон" -> measurementUnit.text = resources.getString(R.string.unit_N)
            "Кілоньютон" -> measurementUnit.text = resources.getString(R.string.unit_Kn)
            "Тонна-сила(метрична)" -> measurementUnit.text = resources.getString(R.string.unit_Tf)
            "Грам-сила" -> measurementUnit.text = resources.getString(R.string.unit_Gf)
            "Кілограм-сила" -> measurementUnit.text = resources.getString(R.string.unit_Kgf)
            "Понд" -> measurementUnit.text = resources.getString(R.string.unit_P)
            "Фунт-сила" -> measurementUnit.text = resources.getString(R.string.unit_Lbf)
            "Унція-сила" -> measurementUnit.text = resources.getString(R.string.unit_Ozf)
            "Тонна-сила(довга)" -> measurementUnit.text = resources.getString(R.string.unit_Tonf)
            "Паундаль" -> measurementUnit.text = resources.getString(R.string.unit_Pdl)
            "Метрів/секунда" -> measurementUnit.text = resources.getString(R.string.unit_M_s)
            "Метрів/година" -> measurementUnit.text = resources.getString(R.string.unit_M_h)
            "Кілометр/секунда" -> measurementUnit.text = resources.getString(R.string.unit_Km_s)
            "Кілометр/година" -> measurementUnit.text = resources.getString(R.string.unit_Km_h)
            "Фут/секунда" -> measurementUnit.text = resources.getString(R.string.unit_F_s)
            "Фут/година" -> measurementUnit.text = resources.getString(R.string.unit_F_h)
            "Міль/година" -> measurementUnit.text = resources.getString(R.string.unit_Mi)
            "Вузол" -> measurementUnit.text = resources.getString(R.string.unit_Kt)
        }
    }

    fun currencyUnitHandler(
        spinnerTextValue: String?,
        measurementUnit: TextView
    ) {
        val resources = measurementUnit.resources
        when (spinnerTextValue) {
            "United States Dollar", "Доллар США" -> measurementUnit.text =
                resources.getString(R.string.unit_Usd)
            "Great Britain Pound", "Великобританський фунт" -> measurementUnit.text =
                resources.getString(R.string.unit_Gbp)
            "Indonesian rupiah", "Індозенійська Рупія" -> measurementUnit.text =
                resources.getString(R.string.unit_Ipr)
            "Polish złoty", "Польский Злотий" -> measurementUnit.text =
                resources.getString(R.string.unit_Pln)
            "New Zealand dollar", "Доллар НЗ" -> measurementUnit.text =
                resources.getString(R.string.unit_Nzd)
            "Russian Ruble", "Рубль" -> measurementUnit.text =
                resources.getString(R.string.unit_Rub)
        }
    }

    fun currencyConverter(value: Double, targetRate: Double?, initRate: Double?): Double {
        return targetRate!! * value / initRate!!
    }

    fun returnDateString(dateTextView: TextView): String {
        return dateTextView.text.toString()
    }

    fun generateViewModel(owner: ViewModelStoreOwner?): AppViewModel {
        return ViewModelProvider(owner!!).get(AppViewModel::class.java)
    }
}