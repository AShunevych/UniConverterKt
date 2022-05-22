package ashunevich.uniconverterKT.kaspresso.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import ashunevich.uniconverterKT.ActivityMain
import ashunevich.uniconverterKT.common.data.weightArray
import ashunevich.uniconverterKT.common.data.weightValues
import ashunevich.uniconverterKT.kaspresso.robots.kConverterRobot
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ConverterTests : TestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(ActivityMain::class.java)

    @Before
    fun start() {
        kConverterRobot {
            verify()
        }
    }

    @After
    fun closeApp() {
        activityRule.scenario.close()
    }

    @Test
    fun verifyTempScreenReflectedCorrectly() {
        run {
            step("1 Swipe to temperature list page") {
                kConverterRobot {
                    viewPagerView {
                        isVisible()
                        scrollTo(5)

                    }
                    plusMinusButton{
                        isVisible()
                        isEnabled()
                    }
                }
            }
            step("2 Swipe to previous  page") {
                kConverterRobot {
                    viewPagerView {
                        isVisible()
                        scrollTo(4)

                    }
                    plusMinusButton{
                        isVisible()
                        isDisabled()
                    }
                }
            }
        }
    }

    @Test
    fun verifyValueChangeOnSpinnerChange() {
        run {
            kConverterRobot {
                step("Verify spinner value change") {
                    for ((pos, item) in weightArray.withIndex()) {
                        spinnerValue {
                            open()
                            emptyChildAt(pos) {
                                isDisplayed()
                                hasText(item.toString())
                                click()
                            }
                        }
                        valueUnit.hasText(weightValues[pos])
                    }
                }
            }
            kConverterRobot {
                step("Verify spinner result change") {
                    for ((pos, item) in weightArray.withIndex()) {
                        spinnerResult {
                            open()
                            emptyChildAt(pos) {
                                isDisplayed()
                                hasText(item.toString())
                                click()
                            }
                        }
                        resultUnit.hasText(weightValues[pos])
                    }
                }
            }
        }
    }
}
