package ashunevich.uniconverterKT.espresso.robots

import ashunevich.uniconverterKT.R
import ashunevich.uniconverterKT.espresso.robots.BaseRobot.BaseConstants.defaultLoadTime
import ashunevich.uniconverterKT.espresso.robots.helper.clickOnButton
import ashunevich.uniconverterKT.espresso.robots.helper.idleUntilVisible
import ashunevich.uniconverterKT.espresso.robots.helper.isVisible


fun converterRobot(func: ConverterRobot.() -> Unit) = ConverterRobot().apply { func() }

class ConverterRobot: BaseRobot(){

    val calculatorButton = onViewWithId(R.id.calculator_button)
    val viewPagerView = onViewWithId(R.id.viewPager)

    fun verify(){
        viewPagerView.idleUntilVisible(defaultLoadTime)
        calculatorButton.isVisible()
    }

    fun accessCalculator(){
        clickOnButton(calculatorButton)
    }
}