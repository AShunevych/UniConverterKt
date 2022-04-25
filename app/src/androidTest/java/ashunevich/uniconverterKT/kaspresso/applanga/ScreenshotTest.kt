package ashunevich.uniconverterKT.kaspresso.applanga

import androidx.test.ext.junit.rules.ActivityScenarioRule
import ashunevich.uniconverterKT.ActivityMain
import ashunevich.uniconverterKT.kaspresso.robots.kConverterRobot
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ScreenshotTest : TestCase()  {
    @get:Rule
    val activityRule = ActivityScenarioRule(ActivityMain::class.java)

    @Before
    fun start() {
        kConverterRobot {
            verify()
        }
    }

    @Test
    fun ukrLocalizationScreen(){

    }

    @Test
    fun engLocalizationScreen(){

    }

}