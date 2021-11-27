package ashunevich.uniconverter20

import ashunevich.uniconverter20.ui.AppViewModel
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import ashunevich.uniconverter20.databinding.CalculatorActivityBinding

class ActivityCalculator : AppCompatActivity() {
    private var binding: CalculatorActivityBinding? = null
    private val VALUE_STRING: String = "valueString"
    private val RESULT_STRING: String = "resultString"

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString(VALUE_STRING, binding!!.calcValue.getText().toString())
        savedInstanceState.putString(RESULT_STRING, binding!!.calcResult.getText().toString())
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setUtils()
        initViewModel()
    }

    private fun setUtils() {
        binding!!.calcValue.isCursorVisible = true
        binding!!.calcValue.inputType = InputType.TYPE_NULL
    }

    private fun initViewModel() {
        val model: AppViewModel = Utils.generateViewModel(this)
        model.postedNumber.observe(this, { event: String? -> this.getText(event) })
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding!!.calcValue.setText(savedInstanceState.getString(VALUE_STRING))
        binding!!.calcResult.text = savedInstanceState.getString(RESULT_STRING)
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun getText(event: String?) {
        if ((event == Utils.SYMBOL_BRACKETS) || (event == Utils.SYMBOL_SOLVE) || (event == Utils.SYMBOL_CLEAR)) {
            when (event) {
                Utils.SYMBOL_BRACKETS -> Utils.checkBrackets(
                    binding!!.calcValue
                )
                Utils.SYMBOL_SOLVE -> Utils.readAndSolve(
                    binding!!.calcValue, binding!!.calcResult
                )
                Utils.SYMBOL_CLEAR -> Utils.clearView(
                    binding!!.calcValue, binding!!.calcResult
                )
            }
        } else {
            binding!!.calcValue.append(event)
        }
    }
}