package ashunevich.uniconverterKT.espresso.robots


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf


open class BaseRobot   {

    fun onViewWithId(viewId:Int) = onView(withId(viewId))

    fun onViewWithIdAndText(id:Int,text:String) = onView(allOf(withId(id),withText(text)))

    object BaseConstants{
        const val defaultLoadTime:Long = 5000
        const val defaultTimeoutTime: Long = 500
    }

}