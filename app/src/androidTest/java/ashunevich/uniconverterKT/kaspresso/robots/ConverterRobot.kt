package ashunevich.uniconverterKT.kaspresso.robots

import android.view.View
import ashunevich.uniconverterKT.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.spinner.KSpinner
import io.github.kakaocup.kakao.spinner.KSpinnerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

fun kConverterRobot(func: ConverterRobot.() -> Unit) = ConverterRobot().apply { func() }

open class ConverterRobot : KScreen<CalculatorRobot>() {
    override val layoutId: Int = R.layout.converter_activity
    override val viewClass: Class<*> = ConverterRobot::class.java

    val calculatorButton = KButton{withId(R.id.calculator_button)}
    val plusMinusButton = KButton{withId(R.id.button_plus_minus)}
    val viewPagerView = KViewPager2(
        builder = { withId(R.id.viewPager) },
        itemTypeBuilder = {
            itemType(ConverterRobot::ViewPagerItem) })

    class ViewPagerItem(parent: Matcher<View>) : KViewPagerItem<ViewPagerItem>(parent) {
        val text: KTextView = KTextView(parent) { withId(R.id.text)}
    }

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
        plusMinusButton.isVisible()
    }

}



