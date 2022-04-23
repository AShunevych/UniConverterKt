package ashunevich.uniconverterKT.kaspresso.robots

import ashunevich.uniconverterKT.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.pager.KViewPager
import io.github.kakaocup.kakao.spinner.KSpinner
import io.github.kakaocup.kakao.spinner.KSpinnerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView


fun kConverterRobot(func: ConverterRobot.() -> Unit) = ConverterRobot().apply { func() }

class ConverterRobot : KScreen<CalculatorRobot>() {
    override val layoutId: Int = R.layout.converter_activity
    override val viewClass: Class<*> = ConverterRobot::class.java

    val calculatorButton = KButton{withId(R.id.calculator_button)}
    val viewPagerView = KViewPager{withId(R.id.viewPager)}

    val valueView = KEditText{withId(R.id.valueEdit)}
    val resultView = KEditText{withId(R.id.resultView)}

    val spinnerValue = KSpinner(
        builder = { withId(R.id.spinner_value) },
        itemTypeBuilder = { itemType(::KSpinnerItem) })

    val spinnerResult = KSpinner(
        builder = { withId(R.id.spinner_result) },
        itemTypeBuilder = { itemType(::KSpinnerItem) })

    val valueUnit = KTextView {(withId(R.id.valueUnit)) }
    val resultUnit = KTextView {(withId(R.id.resultUnit)) }

    fun verify() {
        viewPagerView.isVisible()
        calculatorButton.isVisible()
        valueView.isVisible()
        resultView.isVisible()
        spinnerValue.isVisible()
        spinnerResult.isVisible()
        valueUnit.isVisible()
        resultUnit.isVisible()
    }
}
