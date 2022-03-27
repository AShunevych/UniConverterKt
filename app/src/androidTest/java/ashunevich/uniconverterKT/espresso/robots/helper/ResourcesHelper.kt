package ashunevich.uniconverterKT.espresso.robots.helper

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry

fun getResourceArray(id: Int): Array<String?> {
    val targetContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
    return targetContext.resources.getStringArray(id)
}