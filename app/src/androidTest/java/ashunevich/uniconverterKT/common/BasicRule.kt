package ashunevich.uniconverterKT.common

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import ashunevich.uniconverterKT.ActivityMain
import com.emergetools.snapshots.EmergeSnapshots
import org.junit.Rule
import org.junit.rules.RuleChain
import org.junit.runner.RunWith

open class BasicRule {
    val snapshots = EmergeSnapshots()
    val activityRule = ActivityScenarioRule(ActivityMain::class.java)

    @get:Rule
    val ruleChain: RuleChain = RuleChain
        .outerRule(snapshots)
        .around(activityRule);
}