package ashunevich.uniconverterKT.espresso.robots

import android.view.View
import ashunevich.uniconverterKT.R
import org.hamcrest.Matcher

fun calculatorRobot(func: CalculatorRobot.() -> Unit) = CalculatorRobot().apply { func() }

class CalculatorRobot :BaseRobot() {


    val buttonOne = onViewWithId(R.id.but_one)
    val buttonTwo = onViewWithId(R.id.but_two)
    val buttonThree = onViewWithId(R.id.but_three)
    val buttonFour = onViewWithId(R.id.but_four)
    val buttonFive = onViewWithId(R.id.but_five)
    val buttonSix = onViewWithId(R.id.but_six)
    val buttonSeven = onViewWithId(R.id.but_seven)
    val buttonEight = onViewWithId(R.id.button_eight)
    val buttonNine = onViewWithId(R.id.but_nine)
    val buttonZero = onViewWithId(R.id.button_zero)
    val buttonDzero = onViewWithId(R.id.button_dzero)
    val buttonDecimal = onViewWithId(R.id.button_decimal)
    val buttonClear = onViewWithId(R.id.but_clearView)
    val buttonPercent = onViewWithId(R.id.but_percent)
    val buttonDivide = onViewWithId(R.id.but_divide)
    val buttonMultiply = onViewWithId(R.id.but_multiply)
    val buttonMinus = onViewWithId(R.id.but_minus)
    val buttonSolve = onViewWithId(R.id.but_solve)
    val buttonPlus = onViewWithId(R.id.but_plus)
    val buttonDuzhky = onViewWithId(R.id.but_duzhky)

    val calucaltorValueView = onViewWithId(R.id.calcValue)
    val calucaltorResult = onViewWithId(R.id.calcResult)


    fun verify(){
        calucaltorValueView.matches(idleUntilVisible(defaultLoadTime))
        calucaltorResult.matches(isVisible())
        buttonOne.matches(isVisible())
        buttonTwo.matches(isVisible())
        buttonThree.matches(isVisible())
        buttonFour.matches(isVisible())
        buttonFive.matches(isVisible())
        buttonSix.matches(isVisible())
        buttonSeven.matches(isVisible())
        buttonEight.matches(isVisible())
        buttonNine.matches(isVisible())
        buttonZero.matches(isVisible())
        buttonDzero.matches(isVisible())
        buttonDecimal.matches(isVisible())
        buttonClear.matches(isVisible())
        buttonPercent.matches(isVisible())
        buttonDivide.matches(isVisible())
        buttonMultiply.matches(isVisible())
        buttonMinus.matches(isVisible())
        buttonSolve.matches(isVisible())
        buttonDuzhky.matches(isVisible())
        buttonPlus.matches(isVisible())
    }

    fun tapCalcButton(matcher: Matcher<View>){
        clickOnButton(matcher)
    }

    fun verifyEnteredText(expectedText:String){
        viewHaveText(calucaltorValueView,expectedText)
    }

    fun verifyTextViewHaveNoText(){
        viewHaveText(calucaltorResult,"")
    }

    fun verifyResult(result:String){
        viewHaveText(calucaltorResult,result)
    }

    fun createSimpleCalc(){
        tapCalcButton(buttonEight)
        tapCalcButton(buttonFour)
        tapCalcButton(buttonDivide)
        tapCalcButton(buttonTwo)
        verifyEnteredText("84/2")
    }

    fun createSimpleCalcWithSymbols(){
        tapCalcButton(buttonEight)
        tapCalcButton(buttonFour)
        tapCalcButton(buttonDivide)
        tapCalcButton(buttonDuzhky)
        tapCalcButton(buttonTwo)
        tapCalcButton(buttonPlus)
        tapCalcButton(buttonTwo)
        tapCalcButton(buttonDuzhky)
        verifyEnteredText("84/(2+2)")
    }
}