package ashunevich.uniconverterKT.espresso.tests.screenshot

import ashunevich.uniconverterKT.common.BasicRule
import ashunevich.uniconverterKT.espresso.robots.converterRobot
import org.junit.Test

class ScreenshotTests : BasicRule() {

    @Test
    fun mainActivitySnapshot() {
        converterRobot {
            verify()
        }
    }
}