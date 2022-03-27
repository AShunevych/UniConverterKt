package ashunevich.uniconverterKT.espresso.robots

import androidx.test.espresso.ViewInteraction
import ashunevich.uniconverterKT.R
import ashunevich.uniconverterKT.espresso.robots.BaseRobot.BaseConstants.defaultLoadTime
import ashunevich.uniconverterKT.espresso.robots.helper.*

fun calculatorRobot(func: CalculatorRobot.() -> Unit) = CalculatorRobot().apply { func() }

@SuppressWarnings
class CalculatorRobot :BaseRobot() {

    val buttonOne : ViewInteraction = onViewWithId(R.id.but_one)
    val buttonTwo: ViewInteraction = onViewWithId(R.id.but_two)
    val buttonThree : ViewInteraction  = onViewWithId(R.id.but_three)
    val buttonFour : ViewInteraction  = onViewWithId(R.id.but_four)
    val buttonFive: ViewInteraction  = onViewWithId(R.id.but_five)
    val buttonSix : ViewInteraction  = onViewWithId(R.id.but_six)
    val buttonSeven : ViewInteraction  = onViewWithId(R.id.but_seven)
    val buttonEight : ViewInteraction  = onViewWithId(R.id.button_eight)
    val buttonNine : ViewInteraction  = onViewWithId(R.id.but_nine)
    val buttonZero : ViewInteraction  = onViewWithId(R.id.button_zero)
    val buttonDzero : ViewInteraction  = onViewWithId(R.id.button_dzero)
    val buttonDecimal : ViewInteraction  = onViewWithId(R.id.button_decimal)
    val buttonClear : ViewInteraction  = onViewWithId(R.id.but_clearView)
    val buttonPercent : ViewInteraction = onViewWithId(R.id.but_percent)
    val buttonDivide : ViewInteraction  = onViewWithId(R.id.but_divide)
    val buttonMultiply : ViewInteraction  = onViewWithId(R.id.but_multiply)
    val buttonMinus : ViewInteraction  = onViewWithId(R.id.but_minus)
    val buttonSolve : ViewInteraction = onViewWithId(R.id.but_solve)
    val buttonPlus : ViewInteraction  = onViewWithId(R.id.but_plus)
    val buttonDuzhky : ViewInteraction  = onViewWithId(R.id.but_duzhky)

    val calucaltorValueView : ViewInteraction = onViewWithId(R.id.calcValue)
    val calucaltorResult : ViewInteraction  = onViewWithId(R.id.calcResult)


    fun verify(){
        calucaltorValueView.idleUntilVisible(defaultLoadTime)
        calucaltorResult.isVisible()
        buttonOne.isVisible()
        buttonTwo.isVisible()
        buttonThree.isVisible()
        buttonFour.isVisible()
        buttonFive.isVisible()
        buttonSix.isVisible()
        buttonSeven.isVisible()
        buttonEight.isVisible()
        buttonNine.isVisible()
        buttonZero.isVisible()
        buttonDzero.isVisible()
        buttonDecimal.isVisible()
        buttonClear.isVisible()
        buttonPercent.isVisible()
        buttonDivide.isVisible()
        buttonMultiply.isVisible()
        buttonMinus.isVisible()
        buttonSolve.isVisible()
        buttonDuzhky.isVisible()
        buttonPlus.isVisible()
    }


    fun verifyEnteredText(expectedText:String) = calucaltorValueView.haveText(expectedText)

    fun verifyCalculatorResultIsCleared() = calucaltorResult.haveText("")

    fun verifyResult(result:String) = calucaltorResult.haveText(result)

    fun createSimpleCalc(){
        clickOn(buttonEight)
        clickOn(buttonFour)
        clickOn(buttonDivide)
        clickOn(buttonTwo)
        verifyEnteredText("84/2")
    }

    fun createSimpleCalcWithSymbols(){
        clickOn(buttonEight)
        clickOn(buttonFour)
        clickOn(buttonDivide)
        clickOn(buttonDuzhky)
        clickOn(buttonTwo)
        clickOn(buttonPlus)
        clickOn(buttonTwo)
        clickOn(buttonDuzhky)
        verifyEnteredText("84/(2+2)")
    }

    fun pressEveryButton(){
        val buttonList = listOf(buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,
                                buttonSix,buttonSeven,buttonEight,buttonNine,buttonZero,buttonDzero)

        for (button in buttonList){
            clickOn(button)
            idleFor(500)
        }
    }
}