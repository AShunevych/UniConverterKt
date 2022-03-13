package ashunevich.uniconverterKT.espresso.robots

import ashunevich.uniconverterKT.R


fun converterRobot(func: ConverterRobot.() -> Unit) = ConverterRobot().apply { func() }

class ConverterRobot: BaseRobot(){

    val calculatorButton = onViewWithId(R.id.calculator_button)
    val viewPagerView = onViewWithId(R.id.viewPager)

    fun verify(){
        viewPagerView.matches(idleUntilVisible(defaultLoadTime))
        calculatorButton.matches(isVisible())
    }

    fun accessCalculator(){
        clickOnButton(calculatorButton)
    }
}