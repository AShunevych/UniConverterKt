package ashunevich.uniconverterKT.espresso.robots.helper

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.ViewPagerActions
import com.adevinta.android.barista.interaction.BaristaScrollInteractions.scrollTo
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import org.hamcrest.Matcher

fun clickOnButton(matcher: ViewInteraction) = matcher
    .perform(ViewActions.click())

fun idleFor(timeout:Long) = BaristaSleepInteractions.sleep(timeout)

fun swipeLeft(matcher: ViewInteraction) = matcher
    .perform(ViewActions.swipeLeft())

fun swipeRight(matcher: ViewInteraction) = matcher
    .perform(ViewActions.swipeRight())

fun scrollTo(matcher: ViewInteraction, page: Int) = matcher
    .perform(ViewPagerActions.scrollToPage(page))

