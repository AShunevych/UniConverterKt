package ashunevich.uniconverterKT.espresso.helper


import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import com.adevinta.android.barista.interaction.BaristaSleepInteractions
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf

fun clickOn(button: ViewInteraction) = button.perform(click())

fun clickOnSpinnerItem(@IdRes itemText:String) = onData(allOf(`is`(instanceOf(String::class.java)),
    `is`(itemText))).perform(click())

fun idleFor(timeout:Long) = BaristaSleepInteractions.sleep(timeout)

fun swipeLeft(viewPager: ViewInteraction) = viewPager
    .perform(ViewActions.swipeLeft())

fun swipeRight(viewPager: ViewInteraction) = viewPager
    .perform(ViewActions.swipeRight())
