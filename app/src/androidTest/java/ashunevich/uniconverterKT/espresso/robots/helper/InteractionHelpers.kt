package ashunevich.uniconverterKT.espresso.robots.helper

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import org.hamcrest.Matcher

fun clickOnButton(matcher: ViewInteraction) = matcher
    .perform(ViewActions.click())

fun idleFor(timeout:Long) = BaristaSleepInteractions.sleep(timeout)

