package ashunevich.uniconverterKT.espresso.robots

import android.view.View
import android.widget.TextView
import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import ashunevich.uniconverterKT.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher


open class BaseRobot  {
    val defaultLoadTime:Long = 10000

    fun onViewWithId(id:Int) = withId(id)

    fun onViewWithIdAndText(id:Int,text:String) = onView(allOf(withId(id),withText(text)))

    fun viewHaveText(matcher: Matcher<View>, text: String) = onView(matcher).check(matches(withText(text)))

    fun idleUntilVisible(timeout:Long): ViewAssertion? {
        Thread.sleep(timeout)
        return matches(withEffectiveVisibility(Visibility.VISIBLE))
    }

    fun isVisible(): ViewAssertion? {
        return matches(withEffectiveVisibility(Visibility.VISIBLE))
    }

    fun clickOnButton(matcher: Matcher<View>) = tapBy(matcher)

    private fun tapBy(matcher: Matcher<View>) = onView(matcher)
        .perform(ViewActions.click())

    fun viewIsDisplayed(matcher: Matcher<View>): ViewInteraction? = onView(matcher).check(
        matches(
            isDisplayed()
        )
    )

}