package ashunevich.uniconverterKT.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import ashunevich.uniconverterKT.ActivityMain
import org.junit.Rule

open class BasicRule {

    @get:Rule
    val activityRule = ActivityScenarioRule(ActivityMain::class.java)
}