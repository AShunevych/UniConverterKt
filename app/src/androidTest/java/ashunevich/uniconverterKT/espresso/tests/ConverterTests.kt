package ashunevich.uniconverterKT.espresso.tests

import ashunevich.uniconverterKT.common.BasicRule
import ashunevich.uniconverterKT.common.data.weightArray
import ashunevich.uniconverterKT.common.data.weightValues
import ashunevich.uniconverterKT.espresso.helper.clickOn
import ashunevich.uniconverterKT.espresso.helper.clickOnSpinnerItem
import ashunevich.uniconverterKT.espresso.robots.converterRobot
import org.junit.After
import org.junit.Before
import org.junit.Test

class ConverterTests : BasicRule() {

    @Before
    fun start() {
        converterRobot {
            verify()
        }
    }

    @After
    fun closeApp() {
        activityRule.scenario.close()
    }

    @Test
    fun verifyCorrectSwipe() {
        converterRobot {
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
        }
    }

    @Test
    fun verifyValueChangeOnSpinnerChange() {
        converterRobot {
            for (item in weightArray) {
                clickOn(spinnerValue)
                clickOnSpinnerItem(item.toString())
                for (value in weightValues) {
                    valueUnitWithText(value.toString())
                }
            }

            for (item in weightArray) {
                clickOn(spinnerResult)
                clickOnSpinnerItem(item.toString())
                for (value in weightValues) {
                    resultUnitWithText(value.toString())
                }
            }
        }
    }
}
