package ashunevich.uniconverterKT.espresso.tests

import ashunevich.uniconverterKT.espresso.BasicRule
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
    fun verifyUiChangeOnScroll() {

    }
}

