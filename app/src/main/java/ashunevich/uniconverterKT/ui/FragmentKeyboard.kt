package ashunevich.uniconverterKT.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import android.view.View
import androidx.fragment.app.Fragment
import ashunevich.uniconverterKT.Utils
import ashunevich.uniconverterKT.databinding.CalculatorKeyboardBinding

class FragmentKeyboard : Fragment() {
    private var binding: CalculatorKeyboardBinding? = null
    var model: AppViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = CalculatorKeyboardBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model = ViewModelProvider(requireActivity()).get(AppViewModel::class.java)
        setButtonBindingsCalcKeyboard()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setButtonBindingsCalcKeyboard() {
        Utils.postTextOnClick(model, binding!!.butOne)
        Utils.postTextOnClick(model, binding!!.butTwo)
        Utils.postTextOnClick(model, binding!!.butThree)
        Utils.postTextOnClick(model, binding!!.butFour)
        Utils.postTextOnClick(model, binding!!.butFive)
        Utils.postTextOnClick(model, binding!!.butSix)
        Utils.postTextOnClick(model, binding!!.butSeven)
        Utils.postTextOnClick(model, binding!!.buttonEight)
        Utils.postTextOnClick(model, binding!!.butNine)
        Utils.postTextOnClick(model, binding!!.buttonZero)
        Utils.postTextOnClick(model, binding!!.buttonDzero)
        Utils.postTextOnClick(model, binding!!.buttonDecimal)
        Utils.postTextOnClick(model, binding!!.butDuzhky)
        Utils.postTextOnClick(model, binding!!.butPercent)
        Utils.postTextOnClick(model, binding!!.butDivide)
        Utils.postTextOnClick(model, binding!!.butMultiply)
        Utils.postTextOnClick(model, binding!!.butMinus)
        Utils.postTextOnClick(model, binding!!.butPlus)
        Utils.postTextOnClick(model, binding!!.butSolve)
        Utils.postTextOnClick(model, binding!!.butClearView)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}