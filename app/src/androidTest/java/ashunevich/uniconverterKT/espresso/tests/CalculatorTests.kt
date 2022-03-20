package ashunevich.uniconverterKT.espresso.tests

import androidx.test.espresso.Espresso.pressBackUnconditionally
import ashunevich.uniconverterKT.espresso.BasicRule
import ashunevich.uniconverterKT.espresso.robots.calculatorRobot
import ashunevich.uniconverterKT.espresso.robots.converterRobot
import ashunevich.uniconverterKT.espresso.robots.helper.clickOnButton
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CalculatorTests :BasicRule() {

    @Before
    fun start(){
        converterRobot {
            verify()
            accessCalculator()
        }
    }

    @After
    fun closeApp(){
        pressBackUnconditionally()
        activityRule.scenario.close()
    }

    @Test
    fun testVerifyEnteredValuesAreDisplayedCorrectly(){
        calculatorRobot {
            verify()
            clickOnButton(buttonEight)
            clickOnButton(buttonFour)
            clickOnButton(buttonMinus)
            clickOnButton(buttonTwo)
            verifyEnteredText("84-2")
        }
    }

    @Test
    fun testVerifyCalculatorSymbolsDisplay(){
        calculatorRobot {
            verify()

            val basicOperations = listOf(
                Pair(buttonDivide,"/"),
                Pair(buttonMultiply,"*"),
                Pair(buttonMinus,"-"),
                Pair(buttonPlus,"+"),
                Pair(buttonPercent,"%"),
                Pair(buttonDecimal,"."))


            for (enterSymbol in basicOperations){
                clickOnButton(enterSymbol.first)
                verifyEnteredText(enterSymbol.second)
                clickOnButton(buttonClear)
                verifyCalculatorResultIsCleared()
                Thread.sleep(5000)
            }

            //"(",")","()" symbols
            clickOnButton(buttonDuzhky)
            verifyEnteredText("(")
            clickOnButton(buttonDuzhky)
            verifyEnteredText("()")
        }
    }

    @Test
    fun testSolveSimpleCalculations(){
        calculatorRobot {
            verify()
            createSimpleCalc()
            clickOnButton(buttonSolve)
            verifyResult("42.0")
            clickOnButton(buttonClear)
            BaristaSleepInteractions.sleep(500)

            createSimpleCalcWithSymbols()
            clickOnButton(buttonSolve)
            verifyResult("21.0")
        }
    }

    @Test
    fun testClickEveryButton(){
        val textToCheck = "123456789000"

        calculatorRobot {
            verify()
            pressEveryButton()

            verifyEnteredText(textToCheck)
        }
    }
}