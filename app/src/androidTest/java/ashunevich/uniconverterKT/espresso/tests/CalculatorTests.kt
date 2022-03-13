package ashunevich.uniconverterKT.espresso.tests

import androidx.test.espresso.Espresso.pressBackUnconditionally
import ashunevich.uniconverterKT.espresso.BasicRule
import ashunevich.uniconverterKT.espresso.robots.calculatorRobot
import ashunevich.uniconverterKT.espresso.robots.converterRobot
import org.junit.After
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
            tapCalcButton(buttonEight)
            tapCalcButton(buttonFour)
            tapCalcButton(buttonMinus)
            tapCalcButton(buttonTwo)
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
                tapCalcButton(enterSymbol.first)
                verifyEnteredText(enterSymbol.second)
                tapCalcButton(buttonClear)
                verifyTextViewHaveNoText()
                Thread.sleep(5000)
            }

            //"(",")","()" symbols
            tapCalcButton(buttonDuzhky)
            verifyEnteredText("(")
            tapCalcButton(buttonDuzhky)
            verifyEnteredText("()")
        }
    }

    @Test
    fun testSolveSimpleCalculations(){
        calculatorRobot {
            verify()
            createSimpleCalc()
            tapCalcButton(buttonSolve)
            verifyResult("42.0")
            tapCalcButton(buttonClear)
            Thread.sleep(5000)

            createSimpleCalcWithSymbols()
            tapCalcButton(buttonSolve)
            verifyResult("21.0")
        }
    }
}