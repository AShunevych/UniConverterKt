package ashunevich.uniconverterKT.common

import androidx.test.ext.junit.rules.ActivityScenarioRule
import ashunevich.uniconverterKT.ActivityMain
import org.junit.Rule
import org.junit.rules.RuleChain

open class BasicRule {
    val activityRule = ActivityScenarioRule(ActivityMain::class.java)

    @get:Rule
    val ruleChain: RuleChain = RuleChain
        .outerRule(activityRule)
}