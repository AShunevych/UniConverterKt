package ashunevich.uniconverterKT.espresso.robots

fun converterRobot(func: ConverterRobot.() -> Unit) = ConverterRobot().apply { func() }

class ConverterRobot {
}