package ashunevich.uniconverterKT.kaspresso.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import ashunevich.uniconverterKT.ActivityMain
import ashunevich.uniconverterKT.kaspresso.robots.kCalculatorRobot
import ashunevich.uniconverterKT.kaspresso.robots.kConverterRobot
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorTests : TestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(ActivityMain::class.java)

    @Before
    fun start() {
        kConverterRobot {
            verify()
            calculatorButton{
                click()
            }
        }
    }

    @After
    fun closeApp() {
        activityRule.scenario.close()
    }

    @Test
    fun testVerifyEnteredValuesAreDisplayedCorrectly() {
        run {
            step("1 Verify screen and click on Buttons") {
                kCalculatorRobot {
                    verify()
                    buttonEight.click()
                    buttonFour.click()
                    buttonMinus.click()
                    buttonTwo.click()
                }
            }
            step("2 Verify entered text") {
                kCalculatorRobot {
                    verifyEnteredText(expectedText = "84-2")
                }
            }
        }
    }

    @Test
    fun testVerifyCalculatorSymbolsDisplay() {
        kCalculatorRobot {
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
                enterSymbol.first.click()
                verifyEnteredText(enterSymbol.second)
                buttonClear.click()
                verifyCalculatorResultIsCleared()
            }

            //"(",")","()" symbols
            buttonDuzhky.click()
            verifyEnteredText(expectedText = "(")
            buttonDuzhky.click()
            verifyEnteredText(expectedText = "()")
        }
    }

    @Test
    fun testSolveSimpleCalculations() {
          kCalculatorRobot {
            verify()
            createSimpleCalc()
            buttonSolve.click()
            verifyResultText(result = "42.0")
            buttonClear.click()

            createSimpleCalcWithSymbols()
            buttonSolve.click()
            verifyResultText(result = "21.0")
        }
    }

    @Test
    fun testClickEveryButton() {
        val textToCheck = "123456789000"

        kCalculatorRobot {
            verify()
            pressEveryButton()

            verifyEnteredText(expectedText = textToCheck)
        }
    }
}