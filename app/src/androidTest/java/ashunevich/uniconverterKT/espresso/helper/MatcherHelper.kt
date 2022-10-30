package ashunevich.uniconverterKT.espresso.helper

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.viewpager2.widget.ViewPager2
import org.hamcrest.Description
import org.hamcrest.Matcher


fun isOnSelectedPage(selectedPage: Int): Matcher<View> {
    return object : BoundedMatcher<View, ViewPager2>(ViewPager2::class.java) {
        private var actualSelection = -1

        override fun describeTo(description: Description) {
            if (actualSelection != -1) {
                description.appendText("with $selectedPage page selected")
                description.appendText("\n But page $actualSelection was selected")
            }
        }

        override fun matchesSafely(viewPager: ViewPager2): Boolean {
            actualSelection = viewPager.currentItem
            return selectedPage == actualSelection
        }
    }
}

fun getText(matcher: Matcher<View?>?): String? {
    val stringHolder = arrayOf<String?>(null)
    onView(matcher).perform(object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return isAssignableFrom(TextView::class.java)
        }

        override fun getDescription(): String {
            return "getting text from a TextView"
        }

        override fun perform(uiController: UiController?, view: View) {
            val tv = view as TextView //Save, because of check in getConstraints()
            stringHolder[0] = tv.text.toString()
        }
    })
    return stringHolder[0]
}