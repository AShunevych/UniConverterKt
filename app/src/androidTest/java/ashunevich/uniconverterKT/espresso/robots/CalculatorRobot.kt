package ashunevich.uniconverterKT.espresso.robots

import androidx.test.espresso.ViewInteraction
import ashunevich.uniconverterKT.R
import ashunevich.uniconverterKT.espresso.helper.*
import ashunevich.uniconverterKT.espresso.robots.BaseRobot.BaseConstants.defaultLoadTime
import ashunevich.uniconverterKT.espresso.robots.BaseRobot.BaseConstants.defaultTimeoutTime

fun calculatorRobot(func: CalculatorRobot.() -> Unit) = CalculatorRobot().apply { func() }

@SuppressWarnings
class CalculatorRobot : BaseRobot() {
    val buttonOne: ViewInteraction = onViewWithId(R.id.but_one)
    val buttonTwo: ViewInteraction = onViewWithId(R.id.but_two)
    val buttonThree: ViewInteraction = onViewWithId(R.id.but_three)
    val buttonFour: ViewInteraction = onViewWithId(R.id.but_four)
    val buttonFive: ViewInteraction = onViewWithId(R.id.but_five)
    val buttonSix: ViewInteraction = onViewWithId(R.id.but_six)
    val buttonSeven: ViewInteraction = onViewWithId(R.id.but_seven)
    val buttonEight: ViewInteraction = onViewWithId(R.id.button_eight)
    val buttonNine: ViewInteraction = onViewWithId(R.id.but_nine)
    val buttonZero: ViewInteraction = onViewWithId(R.id.button_zero)
    val buttonDzero: ViewInteraction = onViewWithId(R.id.button_dzero)
    val buttonDecimal: ViewInteraction = onViewWithId(R.id.button_decimal)
    val buttonClear: ViewInteraction = onViewWithId(R.id.but_clearView)
    val buttonPercent: ViewInteraction = onViewWithId(R.id.but_percent)
    val buttonDivide: ViewInteraction = onViewWithId(R.id.but_divide)
    val buttonMultiply: ViewInteraction = onViewWithId(R.id.but_multiply)
    val buttonMinus: ViewInteraction = onViewWithId(R.id.but_minus)
    val buttonSolve: ViewInteraction = onViewWithId(R.id.but_solve)
    val buttonPlus: ViewInteraction = onViewWithId(R.id.but_plus)
    val buttonDuzhky: ViewInteraction = onViewWithId(R.id.but_duzhky)

    private val calculatorValueView: ViewInteraction = onViewWithId(R.id.calcValue)
    private val calculatorResult: ViewInteraction = onViewWithId(R.id.calcResult)

    private val basicOperations = listOf(
        Pair(buttonDivide, "/"),
        Pair(buttonMultiply, "*"),
        Pair(buttonMinus, "-"),
        Pair(buttonPlus, "+"),
        Pair(buttonPercent, "%"),
        Pair(buttonDecimal, ".")
    )

    fun verify() {
        calculatorValueView.idleUntilVisible(defaultLoadTime)
        calculatorResult.isVisible()
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

    fun verifyEnteredText(enteredText: String) = calculatorValueView.haveText(text = enteredText)

    fun verifyCalculatorResultIsCleared() = calculatorResult.haveText(text = "")

    fun verifyResult(result: String) = calculatorResult.haveText(text = result)

    fun createSimpleCalc() {
        val buttonList = listOf(
            buttonEight, buttonFour, buttonDivide, buttonTwo
        )
        clickButtonsInList(list = buttonList)
    }

    fun createSimpleCalcWithSymbols() {
        val buttonList = listOf(
            buttonEight, buttonFour, buttonDivide, buttonDuzhky, buttonTwo,
            buttonPlus, buttonTwo, buttonDuzhky
        )
        clickButtonsInList(list = buttonList)
    }

    fun pressEveryButton() {
        val buttonList = listOf(
            buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive,
            buttonSix, buttonSeven, buttonEight, buttonNine, buttonZero, buttonDzero
        )

        clickButtonsInList(list = buttonList)
    }

    fun enterAndVerifySymbols(){
        for (enterSymbol in basicOperations) {
            clickOn(enterSymbol.first)
            verifyEnteredText(enterSymbol.second)
            clickOn(buttonClear)
            verifyCalculatorResultIsCleared()
            idleFor(timeout = 1000)
        }

        //"(",")","()" symbols
        clickOn(buttonDuzhky)
        verifyEnteredText(enteredText = "(")
        clickOn(buttonDuzhky)
        verifyEnteredText(enteredText = "()")
    }

    fun solveValue(){
        clickOn(buttonSolve)
    }

    fun clearText(){
        clickOn(buttonClear)
    }

    private fun clickButtonsInList(list: List<ViewInteraction>){
        for (calcButton in list) {
            clickOn(button = calcButton)
            idleFor(timeout = defaultTimeoutTime)
        }
    }
}
