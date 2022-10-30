package ashunevich.uniconverterKT.espresso.robots

import androidx.annotation.IdRes
import androidx.test.espresso.assertion.ViewAssertions.matches
import ashunevich.uniconverterKT.R
import ashunevich.uniconverterKT.espresso.helper.*
import ashunevich.uniconverterKT.espresso.robots.BaseRobot.BaseConstants.defaultLoadTime
import ashunevich.uniconverterKT.espresso.robots.BaseRobot.BaseConstants.defaultTimeoutTime

fun converterRobot(func: ConverterRobot.() -> Unit) = ConverterRobot().apply { func() }

class ConverterRobot : BaseRobot() {
    val calculatorButton = onViewWithId(R.id.calculator_button)
    val viewPagerView = onViewWithId(R.id.viewPager)

    val valueView = onViewWithId(R.id.valueEdit)
    val resultView = onViewWithId(R.id.resultView)

    val spinnerValue = onViewWithId(R.id.spinner_value)
    val spinnerResult = onViewWithId(R.id.spinner_result)

    val valueUnit = onViewWithId(R.id.valueUnit)
    val resultUnit = onViewWithId(R.id.resultUnit)

    fun verify() {
        viewPagerView.idleUntilVisible(defaultLoadTime)
        calculatorButton.isVisible()
        valueView.isVisible()
        resultView.isVisible()
        spinnerValue.isVisible()
        spinnerResult.isVisible()
        valueUnit.isVisible()
        resultUnit.isVisible()
    }

    fun accessCalculator() {
        clickOn(button = calculatorButton)
    }

    fun swipeViewPagerLeft() {
        swipeLeft(viewPager = viewPagerView)
        idleFor(timeout = defaultTimeoutTime)
    }

    fun swipeViewPagerRight() {
        swipeRight(viewPager = viewPagerView)
        idleFor(timeout = defaultTimeoutTime)
    }

    fun verifyViewPagerIsOnPage(page: Int) =
        viewPagerView
            .check(matches
                (isOnSelectedPage(selectedPage = page)))

    fun valueUnitWithText(@IdRes result: String) =
        valueUnit.haveText(text = result)

    fun resultUnitWithText(@IdRes result: String) =
        resultUnit.haveText(text = result)
}
