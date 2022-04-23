package ashunevich.uniconverterKT.espresso.helper

import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.adevinta.android.barista.interaction.BaristaSleepInteractions


fun ViewInteraction.isGone() = getViewAssertion(ViewMatchers.Visibility.GONE)

fun ViewInteraction.isVisible() = getViewAssertion(ViewMatchers.Visibility.VISIBLE)

fun ViewInteraction.isInvisible() = getViewAssertion(ViewMatchers.Visibility.INVISIBLE)

fun ViewInteraction.idleUntilVisible(timeout: Long) = getViewAssertion(timeout,ViewMatchers.Visibility.VISIBLE)

fun ViewInteraction.idleUntilGone(timeout: Long) = getViewAssertion(timeout,ViewMatchers.Visibility.GONE)

fun ViewInteraction.haveText(text:String): ViewAssertion = ViewAssertions.matches(ViewMatchers.withText(text))

private fun getViewAssertion(visibility: ViewMatchers.Visibility): ViewAssertion? {
    return ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility))
}

private fun getViewAssertion(timeout:Long,visibility: ViewMatchers.Visibility): ViewAssertion? {
    BaristaSleepInteractions.sleep(timeout)
    return ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility))
}




