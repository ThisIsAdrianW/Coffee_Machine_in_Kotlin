//package machine
//
//fun main() {
//    var machine = CoffeMaker("any")
//    println(machine.currentState)
//    machine.changeState()
//    println(machine.currentState)
//}
//enum class MachineState(val state: String) {
//    START("start"),
//    BUY("buy"),
//    FILL("fill"),
//    TAKE("take"),
//    REMAINING("remaining"),
//    EXIT("exit");
//    companion object {
//        fun from(findValue: String): MachineState = MachineState.values().first { it.state == findValue }
//    }
//}
//class CoffeMaker(input : String) {
//    var currentCash = 550
//    var currentWater = 400
//    var currentMilk = 540
//    var currentBeans = 120
//    var currentCups = 9
//    var currentState = MachineState.START
//    fun changeState() {
//        currentState = MachineState.from("buy")
//    }
//}