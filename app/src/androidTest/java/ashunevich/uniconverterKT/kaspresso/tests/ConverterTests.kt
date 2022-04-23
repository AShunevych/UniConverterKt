package ashunevich.uniconverterKT.kaspresso.tests

import ashunevich.uniconverterKT.common.BasicRule
import ashunevich.uniconverterKT.kaspresso.robots.kConverterRobot
import org.junit.After
import org.junit.Before
import org.junit.Test

class ConverterTests : BasicRule() {

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
    fun verifyCorrectSwipe() {
       /* converterRobot {
            var page = 0

            repeat(5) {
                verifyViewPagerIsOnPage(page = page)
                swipeViewPagerLeft()
                page++
                verifyViewPagerIsOnPage(page = page)
            }

            repeat(5) {
                verifyViewPagerIsOnPage(page = page)
                swipeViewPagerRight()
                page--
                verifyViewPagerIsOnPage(page = page)
            }

            verifyViewPagerIsOnPage(0)
        }*/
    }

    @Test
    fun verifyValueChangeOnSpinerChange() {
       /* converterRobot {
            for(item in weightArray){
                clickOn(spinnerValue)
                clickOnSpinnerItem(item.toString())
                for(value in weightValues){
                    valueUnitWithText(value.toString())
                }
            }


            for(item in weightArray){
                clickOn(spinnerResult)
                clickOnSpinnerItem(item.toString())
                for(value in weightValues){
                    resultUnitWithText(value.toString())
                }
            }
        }*/
    }
}

