package ashunevich.uniconverterKT.espresso.tests

import androidx.test.espresso.Espresso.pressBackUnconditionally
import ashunevich.uniconverterKT.espresso.BasicRule
import ashunevich.uniconverterKT.espresso.robots.calculatorRobot
import ashunevich.uniconverterKT.espresso.robots.converterRobot
import ashunevich.uniconverterKT.espresso.robots.helper.clickOn
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import org.junit.After
import org.junit.Before
import org.junit.Test

class CalculatorTests : BasicRule() {

    @Before
    fun start() {
        converterRobot {
            verify()
            accessCalculator()
        }
    }

    @After
    fun closeApp() {
        pressBackUnconditionally()
        activityRule.scenario.close()
    }

    @Test
    fun testVerifyEnteredValuesAreDisplayedCorrectly() {
        calculatorRobot {
            verify()
            clickOn(buttonEight)
            clickOn(buttonFour)
            clickOn(buttonMinus)
            clickOn(buttonTwo)
            verifyEnteredText(expectedText = "84-2")
        }
    }

    @Test
    fun testVerifyCalculatorSymbolsDisplay() {
        calculatorRobot {
            verify()

            val basicOperations = listOf(
                Pair(buttonDivide, "/"),
                Pair(buttonMultiply, "*"),
                Pair(buttonMinus, "-"),
                Pair(buttonPlus, "+"),
                Pair(buttonPercent, "%"),
                Pair(buttonDecimal, ".")
            )


            for (enterSymbol in basicOperations) {
                clickOn(enterSymbol.first)
                verifyEnteredText(enterSymbol.second)
                clickOn(buttonClear)
                verifyCalculatorResultIsCleared()
                Thread.sleep(5000)
            }

            //"(",")","()" symbols
            clickOn(buttonDuzhky)
            verifyEnteredText(expectedText = "(")
            clickOn(buttonDuzhky)
            verifyEnteredText(expectedText = "()")
        }
    }

    @Test
    fun testSolveSimpleCalculations() {
        calculatorRobot {
            verify()
            createSimpleCalc()
            clickOn(buttonSolve)
            verifyResult(result = "42.0")
            clickOn(buttonClear)
            BaristaSleepInteractions.sleep(500)

            createSimpleCalcWithSymbols()
            clickOn(buttonSolve)
            verifyResult(result = "21.0")
        }
    }

    @Test
    fun testClickEveryButton() {
        val textToCheck = "123456789000"

        calculatorRobot {
            verify()
            pressEveryButton()

            verifyEnteredText(expectedText = textToCheck)
        }
    }
}