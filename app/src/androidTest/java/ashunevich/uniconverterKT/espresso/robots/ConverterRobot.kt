package ashunevich.uniconverterKT.espresso.robots

import androidx.test.espresso.assertion.ViewAssertions.matches
import ashunevich.uniconverterKT.R
import ashunevich.uniconverterKT.espresso.robots.BaseRobot.BaseConstants.defaultLoadTime
import ashunevich.uniconverterKT.espresso.robots.helper.*


fun converterRobot(func: ConverterRobot.() -> Unit) = ConverterRobot().apply { func() }

class ConverterRobot: BaseRobot(){

    val calculatorButton = onViewWithId(R.id.calculator_button)
    val viewPagerView = onViewWithId(R.id.viewPager)

    val valueView =onViewWithId(R.id.valueEdit)
    val resultView =onViewWithId(R.id.resultView)

    val spinnerValue = onViewWithId(R.id.spinner_value)
    val spinnerResult = onViewWithId(R.id.spinner_result)

    val valueUnit = onViewWithId(R.id.valueUnit)
    val resultUnit = onViewWithId(R.id.resultUnit)

    fun verify(){
        viewPagerView.idleUntilVisible(defaultLoadTime)
        calculatorButton.isVisible()
        valueView.isVisible()
        resultView.isVisible()
        spinnerValue.isVisible()
        spinnerResult.isVisible()
        valueUnit.isVisible()
        resultUnit.isVisible()
    }

    fun accessCalculator(){
        clickOnButton(calculatorButton)
    }

    fun swipeViewPagerLeft(){
        swipeLeft(viewPagerView)
        idleFor(500)
    }

    fun swipeViewPagerRight(){
        swipeRight(viewPagerView)
        idleFor(500)
    }

    fun verifyViewPagerIsOnPage(page:Int) = viewPagerView.check(matches(withSelectedPage(page)))
}