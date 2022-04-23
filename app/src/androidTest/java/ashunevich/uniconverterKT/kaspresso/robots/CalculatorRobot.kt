package ashunevich.uniconverterKT.kaspresso.robots

import ashunevich.uniconverterKT.ActivityCalculator
import ashunevich.uniconverterKT.R
import ashunevich.uniconverterKT.espresso.helper.idleFor
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import java.util.concurrent.TimeUnit


fun kCalculatorRobot(func: CalculatorRobot.() -> Unit) = CalculatorRobot().apply { func() }

class CalculatorRobot : KScreen<CalculatorRobot>() {
    override val layoutId: Int = R.layout.calculator_activity
    override val viewClass: Class<*> = ActivityCalculator::class.java

    val buttonOne  = KButton{withId(R.id.but_one)}
    val buttonTwo= KButton{withId(R.id.but_two)}
    val buttonThree = KButton{withId(R.id.but_three)}
    val buttonFour = KButton{withId(R.id.but_four)}
    val buttonFive= KButton{withId(R.id.but_five)}
    val buttonSix = KButton{withId(R.id.but_six)}
    val buttonSeven = KButton{withId(R.id.but_seven)}
    val buttonEight = KButton{withId(R.id.button_eight)}
    val buttonNine = KButton{withId(R.id.but_nine)}
    val buttonZero = KButton{withId(R.id.button_zero)}
    val buttonDzero = KButton{withId(R.id.button_dzero)}
    val buttonDecimal = KButton{withId(R.id.button_decimal)}
    val buttonClear = KButton{withId(R.id.but_clearView)}
    val buttonPercent = KButton{withId(R.id.but_percent)}
    val buttonDivide = KButton{withId(R.id.but_divide)}
    val buttonMultiply = KButton{withId(R.id.but_multiply)}
    val buttonMinus = KButton{withId(R.id.but_minus)}
    val buttonSolve = KButton{withId(R.id.but_solve)}
    val buttonPlus = KButton{withId(R.id.but_plus)}
    val buttonDuzhky = KButton{withId(R.id.but_duzhky)}

    val calucaltorValueView = KEditText{withId(R.id.calcValue)}
    val calucaltorResult = KEditText{withId(R.id.calcResult)}

    fun verify(){
        BaristaSleepInteractions.sleep(2,TimeUnit.SECONDS)
        calucaltorValueView.isVisible()
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

    fun verifyEnteredText(expectedText:String) = calucaltorValueView.hasText(expectedText)
    fun verifyCalculatorResultIsCleared() = calucaltorResult.hasText("")
    fun verifyResultText(result:String) = calucaltorResult.hasText(result)


    fun createSimpleCalc(){
        buttonEight.click()
        buttonFour.click()
        buttonDivide.click()
        buttonTwo.click()
        verifyEnteredText("84/2")
    }

    fun createSimpleCalcWithSymbols(){
        buttonEight.click()
        buttonFour.click()
        buttonDivide.click()
        buttonDuzhky.click()
        buttonTwo.click()
        buttonPlus.click()
        buttonTwo.click()
        buttonDuzhky.click()
        verifyEnteredText("84/(2+2)")
    }

    fun pressEveryButton(){
        val buttonList = listOf(buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,
            buttonSix,buttonSeven,buttonEight,buttonNine,buttonZero,buttonDzero)

        for (button in buttonList){
            button{
                isVisible()
                click()
            }
        }
    }
}