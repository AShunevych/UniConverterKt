package ashunevich.uniconverterKT.espresso.tests

import androidx.test.espresso.Espresso.pressBackUnconditionally
import ashunevich.uniconverterKT.common.BasicRule
import ashunevich.uniconverterKT.espresso.helper.idleFor
import ashunevich.uniconverterKT.espresso.robots.BaseRobot.BaseConstants.defaultTimeoutTime
import ashunevich.uniconverterKT.espresso.robots.calculatorRobot
import ashunevich.uniconverterKT.espresso.robots.converterRobot
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
            createSimpleCalc()
            verifyEnteredText(enteredText = "84-2")
        }
    }

    @Test
    fun testVerifyCalculatorSymbolsDisplay() {
        calculatorRobot {
            verify()
            enterAndVerifySymbols()
        }
    }

    @Test
    fun testSolveSimpleCalculations() {
        calculatorRobot {
            verify()

            createSimpleCalc()
            verifyEnteredText(enteredText = "84/2")
            solveValue()
            verifyResult(result = "42.0")

            clearText()
            idleFor(defaultTimeoutTime)

            createSimpleCalcWithSymbols()
            verifyEnteredText("84/(2+2)")

            solveValue()
            verifyResult(result = "21.0")
        }
    }

    @Test
    fun testClickEveryButton() {
        calculatorRobot {
            verify()
            pressEveryButton()

            verifyEnteredText(enteredText = "123456789000")
        }
    }
}