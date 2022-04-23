package ashunevich.uniconverterKT.espresso.helper


import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.ViewPagerActions
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import org.hamcrest.Matchers.*

fun clickOn(matcher: ViewInteraction) = matcher
    .perform(click())

fun clickOnSpinnerItem(@IdRes itemText:String) = onData(allOf(`is`(instanceOf(String::class.java)),
    `is`(itemText))).perform(click())


fun idleFor(timeout:Long) = BaristaSleepInteractions.sleep(timeout)

fun swipeLeft(matcher: ViewInteraction) = matcher
    .perform(ViewActions.swipeLeft())

fun swipeRight(matcher: ViewInteraction) = matcher
    .perform(ViewActions.swipeRight())

fun scrollTo(matcher: ViewInteraction, page: Int) = matcher
    .perform(ViewPagerActions.scrollToPage(page))

