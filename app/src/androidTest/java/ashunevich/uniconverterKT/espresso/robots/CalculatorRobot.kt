package ashunevich.uniconverterKT.espresso.robots

fun calculatorRobot(func: CalculatorRobot.() -> Unit) = CalculatorRobot().apply { func() }

class CalculatorRobot :BaseRobot() {

}