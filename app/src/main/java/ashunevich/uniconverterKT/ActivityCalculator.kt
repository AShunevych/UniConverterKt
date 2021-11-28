package ashunevich.uniconverterKT

import ashunevich.uniconverterKT.ui.AppViewModel
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import ashunevich.uniconverterKT.Utils.checkBrackets
import ashunevich.uniconverterKT.Utils.clearView
import ashunevich.uniconverterKT.Utils.readAndSolve
import ashunevich.uniconverterKT.databinding.CalculatorActivityBinding

class ActivityCalculator : AppCompatActivity() {
    private var binding: CalculatorActivityBinding? = null
    private val value = "valueString"
    private val result = "resultString"

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString(value, binding!!.calcValue.text.toString())
        savedInstanceState.putString(result, binding!!.calcResult.text.toString())
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
        binding!!.calcValue.setText(savedInstanceState.getString(value))
        binding!!.calcResult.text = savedInstanceState.getString(result)
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun getText(event: String?) {
        if ((event == Utils.SYMBOL_BRACKETS) || (event == Utils.SYMBOL_SOLVE) || (event == Utils.SYMBOL_CLEAR)) {
            when (event) {
                Utils.SYMBOL_BRACKETS -> checkBrackets(
                    binding!!.calcValue
                )
                Utils.SYMBOL_SOLVE -> readAndSolve(
                    binding!!.calcValue, binding!!.calcResult
                )
                Utils.SYMBOL_CLEAR -> clearView(
                    binding!!.calcValue, binding!!.calcResult
                )
            }
        } else {
            binding!!.calcValue.append(event)
        }
    }
}